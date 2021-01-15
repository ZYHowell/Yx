Yx: a simplified smallest grammar. 

### Grammar

##### Type

It has int and bool type as default(but no bool variable)

It also supports definition of struct just in the way of C++. But ignore this line at first(until [Intro to type](#Brief introduction to type)). 

##### Arithmetic operation

arithmetic operation can only be '+', '-' or '==', '!='. 

##### Statement

A statement can only be:

1. a definition of a variable
2. an expression
3. `if`-`else` statement 
4. `return`

### Implementation of Naïve Front-End

#### Write the grammar

A native order is: 

program - statement - expression - primary

In Mx, function and class definition is between program and statement. 

The grammar of '.g4' file is known. Only few parts to mention:

1. use of `#`
2. use of `<assoc=right>`

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

#### The Parse Part in compiler

Build `YxLexer.java` and `YxParser.java` by ANTLR4. 

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

The `error` class is a trivial self-implemented error type. The `YxErrorListener` is defined as: 

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

#### Design The AST

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

#### AST Builder

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

#### Scope

In global scope, the type system is recorded. But in this language it is not required since we only have `int` and `bool`. 

Every scope records variables defined in it. 

```java
import Util.error.semanticError;
import java.util.HashSet;

public class Scope {

    private HashSet<String> members;
    private Scope parentScope;


    public Scope(Scope parentScope) {
        members = new HashSet<>();
        this.parentScope = parentScope;
    }

    public Scope parentScope() {
        return parentScope;
    }

    public void defineVariable(String name, position pos) {
        if (members.contains(name))
            throw new semanticError("member redefine", pos);
        members.add(name);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        if (members.contains(name)) return true;
        else if (parentScope != null && lookUpon) return parentScope.containsMember(name, true);
        else return false;
    }
}
```

#### Semantic

Now we can do the semantic check. In Yx, We need to consider: 

1. If the type matches. 

   So we introduce attribute `type` for each `ExprNode`. Luckily, in Yx the type of each ```ExprNode``` is known(`int` except for `cmpExprNode`). But in Mx, setting type in semantic check stage is required and in OOP language like C++, type infer is required. 

2. Right-value at left. 

   So we introduce `isAssignable` for each `ExprNode`. 

3. undefined/multi-define variable. 

Is there anything more? In Mx there are of course more to consider, and maybe some more AST visitors are required to do preprocess. 

A fragment of the semantic checker is like: 

```java
@Override
public void visit(varDefStmtNode it) {
    if (it.init != null) {
        it.init.accept(this);
        if (!it.init.type.isInt)
            throw new semanticError("Semantic Error: type not match.",
                                    it.init.pos);
    }
    currentScope.defineVariable(it.name, it.pos);
}
```

Mention that the order is important. In the above example, if we define the variable at the beginning of the function, the case below can not be detected: 

```
int x = x + 1;
```

So you'd better be very careful. 

#### Brief introduction to type

To explain how to do semantic check with type, we introduce the following grammar: 

```Antlr4
classDef : 'struct' Identifier '{' varDef* '}'';';
```

We also modify `varDef` and `program`: 

```Antlr4
program: classDef* mainFn;

mainFn: 'int' 'main()' suite EOF;	// original program

varDef : type Identifier ('=' expression)? ';';
type : Int | Identifier;
```

You can easily add the corresponding `ASTNode` if you read the prior part carefully. So we skip the work. Assume `fnNode`(corresponding to `mainFn`) and `classDefNode` are implemented. 

We now face a problem: how to deal with: 

```
struct a{
    b x;
};
struct b{
    a x;
};
```

Of course, this is not a good design in C/C++ since you can have x.x.x...... However, in Mx and Yx, all variables are in form of reference, so we can have: 

```java
a y;
y.x = null;
```

And the design above is good. 

What is the problem? If you check the correctness of `struct a`, you do not know if `b` is a legal type, vise versa. 

To solve the problem, we use another pass named `SymbolCollector`, which briefly collects all type names into a global scope. A global scope is a class derived from `Scope` by adding a map to collect these types. See `Util/globalScope` for more details. 

```java
@Override public void visit(structDefNode it) {
    Type struct = new Type();
    struct.members = new HashMap<>();
    it.varDefs.forEach(vd -> vd.accept(this));
    gScope.addType(it.name, struct, it.pos);
}
```

After this pass, we already have the name of all available types. So we can check the type of members in a struct: 

```java
if (currentStruct != null) {
    assert (currentStruct.members != null);
    if (currentStruct.members.containsKey(it.name))
        throw new semanticError("redefinition of member " + it.name, it.pos);
    currentStruct.members.put(it.name, gScope.getTypeFromName(it.typeName, it.pos));
    if (it.init != null)
        throw new semanticError("Yx does not support default init of members",
                                it.init.pos);
}
```

Modifications above help check the definition of struct and variable. Then we modify original `Scope` to support variables **in experissions** with type not only `int`: 

```java
public Type getType(String name, boolean lookUpon) {
    if (members.containsKey(name)) return members.get(name);
    else if (parentScope != null && lookUpon)
        return parentScope.getType(name, true);
    return null;
}
```

Now, as the type of `varExprNode` and `assignExprNode` can be not only `intType`, we slightly modify it by adding: 
```java
it.type = it.rhs.type
```
at the end of `visit（assignExprNode it）` and 
```java
it.type = currentScope.getType(it.name, true)
```
at the end of `visit(varExprNode it)`. 

### Codegen

welcome to the next stage! 

Now you have a abstract semantic tree passing semantic check. The next thing to do is to turn it into corresponding assembly code. Generally, you may think about how to turn AST into assembly code directly, but in fact, we have an intermediate stage named IR(Intermediate Representation). 

This is because both AST and assembly code is not convenient for us to do optimization. Hence, we design our own IR and the process of compiling is expected to be: 

```
code ---> AST ---> IR ---> IR ... ---> IR ---> assembly
        frontend        optimization       backend
```

IR is a very personal design, and here we only provide an approach to design one: 

#### IR Design

Consider why we do not use AST. For the case: 

```C++
x = a + b + c + d;
y = a + b + c + e;
```

The result of `a+b+c` can be only calculated once. This shows such a case: In two subtrees, some smaller parts are isomorphic. To detect the case, a pairwise comparison for each parts are required. 

This can be simplified to the following method: we pairwisely compare trees with a height in each iteration, and in the next iteration, compare trees exactly one higher. 

Notice that, actually we do the following: In the first iteration, `a+b` is the same subtree. Then we let `apb = a+b` and in the next iteration `a+b+c` is the same subtree, which can be turned to `apb+c`. If we use such `apb`, we can say that each iteration we actually do the same thing: compare trees with height of two. 

Here we notice a deeper fact: the tree structure is not essential in optimization. Instead, we only need expressions with only one operator and at most two operands. More complex expressions can be turned to this one by splitting them into parts. (**This conclusion is correct only for Yx**, although for Mx and languages like C++ it is almost sure correct)

The idea as another advantage: in assemble code, we only have operations with two operands. 

By this idea, our IR is designed to have grammar: 

```
x = u op v;
```

where `x,u,v` are all constants, variables or intermediate result(for instance, `apb` in the case above). Or, to assume the program runs on a machine, we call them registers storing values of variables or intermediate results(abbreviated as registers). 

What about structs? As we only have assignments for structs, which is actually assignments of pointers, this is nothing different: register of a struct variable is the register storing the value of pointer of the struct variable. 

​	What if we add a grammar to access the member of a struct? First get the pointer of the member using an offset, then introduce load/store instruction to get access to the value of the pointer. 

​	What if we add a grammar to allocate and free the memory of the struct? Add a grammar in IR to call `malloc/free` method. 

What about `if-then`? Notice that by `a op b` operations, value of the boolean expression is stored in a register. So we can introduce branch instructions to deal with it: 

```
br u label1, label2
j label
```

The jump instruction is at the end of true branch and false branch to jump into the same place: the next statement after `if-else`. 

In all, we have grammars of IR: 

```
x = u op v, (op = '+'/'-'/'=='/'!=')
br u label1, label2
j label
ret u
```

The last thing is to define a block: it starts from a label and end at the first branch/jump instruction. The definition of block is important since it is a kind of CFG(control flow graph), and many optimizations are based on CFG, just like many optimizations are about binary operation. 

#### IR Builder

We first define classes for IR grammars: registers, constants, blocks, three kinds of statements. Labels can be represented by blocks. 

Now you must have some knowledge of Java(or the language you use), so we skip the definition of these classes. 

As this is a very trivial one, we let the size of each register be 32bits(that is, a boolean intermediate result still has size of 32 bits)

Now we have prepared everything for `IRBuilder`. Let's do it. Each `exprNode` in AST corresponds to a constant or a register, so we give `exprNode` a new member named `val`. Now we use this member to construct our IR: 

```java
@Override
public void visit(cmpExprNode it) {
	it.lhs.accept(this);
	it.rhs.accept(this);
	register value = new register();
	binary.opType op = it.opCode == cmpExprNode.cmpOpType.eq ? eq : ne;
	currentBlock.push_back(new binary(value, it.lhs.val, it.rhs.val, op));
	it.val = value;
}

@Override
public void visit(varExprNode it) {
	it.val = currentScope.getEntity(it.name, true);
}
```

Other `exprNode` are handled likewise. 

The maintenance of `block` should also be mentioned: 

```java
@Override
public void visit(ifStmtNode it) {
    it.condition.accept(this);
    block trueBranch = new block(), falseBranch = new block();
    currentBlock.push_back(new branch(it.condition.val, trueBranch, falseBranch));

    block destination = new block();
    currentBlock = trueBranch;
    it.thenStmt.accept(this);
    currentBlock.push_back(new jump(destination));
    currentBlock = falseBranch;
    it.elseStmt.accept(this);
    currentBlock.push_back(new jump(destination));
    currentBlock = destination;
}
```

##### IR Printer

To check the correctness of our IR, we can make an IR printer. Here we also introduce the concept of `Pass`. A `Pass` defines how to visit or modify a `program/function/block`, and in optimization stage, each kind of optimization can be regarded as a `Pass`. The program(or part of the program) passes a `Pass`, which may modify the passed part to do optimization or analyze the part for further optimization, and output the modified program. 

IR Printer is a very typical `Pass`. When the program passes the pass, each block is passed. When a block is passing, the `IRPrinter` pass prints each statement in order. 

For simplicity, we only have one kind of `Pass` in `Yx`, which visits the whole program(in `Yx` it equals the main function). 

##### Prune

It is meaningful to prune some cases in `IRBuilder` to release the pressure of later codegen stages. 

##### Other kinds of IR

The IR above can be identified as a graph IR. There is also tree IR very close to AST structure. You can even have a number of different IR, and lower the program from one IR to another. Each time you turn the program into a lower level of IR, there are some information discarded, just like what happens when you ignore the tree structure of AST and turn it into the graph IR.  As a trade-off, you may get access to some information more easily. 

In all, design your own IR. 

#### Instruction selection

Assume that the program is great-optimized in IR level. Now we turn IR into the assembly code. The first step is to select the correct instruction in assembly language. So we create a sets of classes to represent different assembly instructions. This is nothing different from the steps in IR language, and the pressure is released as our graph IR is very close to assembly code grammar. (So for tree IR, although in `IRBuilder` step there is not that much things, it should also consider a translation from tree shape to graph of blocks in the end.)

Notice that, as the output is assembly code, we can have more freedom in this step: instructions like `mv`, `ret`, `li` are more readable. We should also notice that some native operations are not in RISCV assembly instructions. For instance, we do not have `seq` and `sne`, so we need to translate them to `sub`+`seqz/snez`. 

In this step, we still use virtual registers. That is, we assume that there are infinite registers although actually there are 32(actually less, due to the convention of `zero`, `sp`, `gp`, `tp `etc.). 

When you are at this stage, I believe you have enough knowledge to write your own instruction selection, since all you need is to be careful and consider all cases. 

##### Asm Printer

Although our registers are still virtual register, we implement the assembly code printer first, in order to help the process of debug for instruction selection. This is nothing different from the IR printer. 

#### Register Allocation

This is the final step! We now focus on the problem that registers are limited in RISCV architecture. As the calling convention defines, some of them are caller-save, which means after calling a function, values in the register is not promised to be kept, while others are callee-save, which, in contrast, are kept the same after calling a function. We can also regarded them as caller-responsible and callee-responsible. 

The caller-save registers' liveness is at most from a function call to a function call, while the callee-save registers' liveness is at most cross the whole function. However, once you use such a register, you need to store its original value at the start of the function and restore before the return statement. 

You may think about recording what callee-save registers are used and then add corresponding store/load instructions after all. But there is a more typical way: you can simply add a virtual register for a callee-save physical register, and then add move instructions at the start and end of the function. If the register is not used, by coloring method, the move will be discarded in peephole optimization. 

Here we only talk about naïve register allocation, which uses at most three registers in a time: It stores all virtual registers - each corresponds to a variable/intermediate value - on the stack, loads when the value is required  and stores when the value is modified. So we inserts a load for each used virtual register before an instruction and a store after an instruction. 

We want to consider less, so we use caller-save registers `t0`, `t1`, `t2`, whose indices are 5-7. 

For preparation, we introduce two command: `load` and `store`. For simplicity, all virtual registers are in size of 4B, so only `lw` and `sw` are used. 

```java
public class Ld extends Inst{
    public PhyReg rd, addr;
    public Imm offset;

    public Ld(PhyReg rd, PhyReg addr, Imm offset) {
        this.rd = rd;
        this.addr = addr;
        this.offset = offset;
    }
    @Override
    public String toString() {
        return "lw " + rd + ", " + addr + "(" + offset + ")";
    }
}
```

```java
private Inst loadVirtualReg(VirtualReg r, PhyReg rd) {
    return new Ld(rd, sp, new Imm(r.index * 4));
}
private Inst storeVirtualReg(VirtualReg r) {
    return new St(t2, sp, new Imm(r.index * 4));
}
```

The function is nothing but a pass on asm function. One thing should be mentioned is that Java IS A STUPID LANGUAGE, so we implement our own link list to make insertion easier. 

```java
public void insert_before(Inst i, Inst in) {
    if (i.prev == null) headInst = in;
    else i.prev.next = in;
    in.prev = i.prev; in.next = i; i.prev = in;
}
public void insert_after(Inst i, Inst in) {
    if (i.next == null) tailInst = in;
    else i.next.prev = in;
    in.prev = i; in.next = i.next; i.next = in;
}
```

It should be mentioned that the stack length should be carefully maintained. In this stupid algorithm and language, the stack length straightly equals $\# \text{ of virtual registers} \times 4$ Bytes, but with function call(which requires some stack space if parameters are too many) and better register allocation algorithm, the stack length is known after register allocation. In this case, you should consider how to fill in the value of Immediate values(`Imm` class in above) as the offset of `store` and `load` instructions. 