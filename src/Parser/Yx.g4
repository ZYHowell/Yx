grammar Yx;

program: classDef* mainFn;

mainFn: 'int' 'main()' suite EOF;

varDef : type Identifier ('=' expression)? ';';
classDef : 'struct' Identifier '{' varDef* '}'';';

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

type : Int | Identifier;

Int : 'int';
If : 'if';
Else : 'else';
Return : 'return';
Struct: 'struct';

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