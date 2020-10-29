Yx: a simplified smallest grammar. 

#### Grammar

##### Type

It only has int and bool type(but no bool variable)

##### Arithmetic operation

arithmetic operation can only be '+', '-' or '==', '!='. 

##### Statement

A statement can only be:

1. a definition of a variable
2. an expression
3. an 'if-else' 
4. a return

#### Implementation of Naïve Front-End

##### Write the grammar

A native order is: 

program - statement - expression - primary

In Mx, function and class definition is between program and statement. 

The grammar of '.g4' file is known. Only few parts to mention:

1. use of ```#```
2. use of ```<assoc=right>```

```Antlr4
grammar Yx;

program: 'int main()' suite EOF;

varDef : Int Identifier ('=' expression)? ';';

suite : '{' statement* '}';

statement
    : suite                                                 #block
    | varDef                                                #vardefStmt
    | If '(' expression ')' trueStmt=statement 
        (Else falseStmt=statement)?                         #ifStmt
    | Return expression? ';'                                #returnStmt
    | expression ';'                                        #pureExprStmt
    | ';'                                                   #emptyStmt
    ;

expression
    : primary                                               #atomExpr
    | expression op=('+' | '-') expression                  #binaryExpr
    | expression op=('==' | '!=' ) expression               #binaryExpr
    | <assoc=right> expression '=' expression               #assignExpr
    ;

primary
    : '(' expression ')'
    | Identifier 
    | literal 
    ;

literal
    : DecimalInteger
    ;

Int : 'int';
If : 'if';
Else : 'else';
Return : 'return';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';
LeftShift : '<<';
RightShift : '>>';

Plus : '+';
Minus : '-';

And : '&';
Or : '|';
AndAnd : '&&';
OrOr : '||';
Caret : '^';
Not : '!';
Tilde : '~';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';
Equal : '==';
NotEqual : '!=';

Identifier
    : [a-zA-Z] [a-zA-Z_0-9]*
    ;

DecimalInteger
    : [1-9] [0-9]*
    | '0'
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
```

##### The Parse Part in compiler

Build ```YxLexer.java``` and ```YxParser.java```

Then use them in main: 

```java
public static void main(String[] args) throws Exception{
	String name = "test.yx";
    InputStream input = new FileInputStream(name);
    try {
        YxLexer lexer = new YxLexer(CharStreams.fromStream(input));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new YxErrorListener());
        YxParser parser = new YxParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new YxErrorListener());
        ParseTree parseTreeRoot = parser.program();
    } catch (error er) {
        System.err.println(er.toString());
        throw new RuntimeException();
    }
}
```

The ```error``` class is a trivial self-implemented error type. The ```YxErrorListener``` is defined as: 

```java
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class YxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {

        throw new syntaxError(msg, new position(line, charPositionInLine));
    }
}
```

##### Design The AST

Although the parsed program is tree-like, an AST is still required since each node should have some more value. It is designed as: 

```
- ASTNode
	- RootNode		// node as a root
	- StmtNode		// node as a statement
		- varDefStmtNode
		- returnStmtNode
		- blockStmtNode
		- exprStmtNode
		- ifStmtNode
	- ExprNode		// node as an expression
		- assignExprNode
		- binaryExprNode
		- constExprNode
		- cmpExprNode
		- varExprNode
```

As an example, the most naïve implementation of ifStmtNode is: 

```java
package AST;

import Util.position;

public class ifStmtNode extends StmtNode {
    ExprNode condition;
    StmtNode thenStmt, elseStmt;

    public ifStmtNode(ExprNode condition, StmtNode thenStmt, StmtNode elseStmt, position pos) {
        super(pos);
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
```

Notice that, the return value type of AST visitor can be any one rather than void. This is based on your own design. 

##### AST Builder

Build the AST. The AST Builder is a visitor on the parse tree. 

This step is trivial. Here's an example: 

```java
@Override public ASTNode visitVarDef(YxParser.VarDefContext ctx) {
String name = ctx.Identifier().toString();
ExprNode expr = null;
if (ctx.expression() != null) expr = (ExprNode)visit(ctx.expression());

return new varDefStmtNode(name, expr, new position(ctx));
}
```

