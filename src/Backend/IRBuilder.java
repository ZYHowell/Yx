package Backend;

import AST.*;
import MIR.*;
import Util.Scope;
import Util.globalScope;

import static MIR.binary.opType.add;
import static MIR.binary.opType.sub;
import static MIR.binary.opType.eq;
import static MIR.binary.opType.ne;

public class IRBuilder implements ASTVisitor {
    private block currentBlock;
    private mainFn fn;
    private Scope currentScope;
    private globalScope gScope;
    public IRBuilder(mainFn fn, globalScope gScope) {
        this.fn = fn;
        currentBlock = fn.rootBlock;
        currentScope = gScope;
        this.gScope = gScope;
    }

    @Override
    public void visit(RootNode it) {
        it.fn.accept(this);
    }

    @Override public void visit(structDefNode it) {

    }

    @Override
    public void visit(FnRootNode it) {
        currentScope = new Scope(currentScope);
        it.stmts.forEach(s -> s.accept(this));
        currentScope = currentScope.parentScope();
    }

    @Override
    public void visit(varDefStmtNode it) {
        currentScope.entities.put(it.name, new register());
    }

    @Override
    public void visit(returnStmtNode it) {
        entity value;
        if (it.value != null) {
            it.value.accept(this);
            value = it.value.val;
        } else value = null;
        currentBlock.push_back(new ret(value));
    }

    @Override
    public void visit(blockStmtNode it) {
        currentScope = new Scope(currentScope);
    }

    @Override
    public void visit(exprStmtNode it) {
        it.expr.accept(this);
    }

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

        fn.blocks.add(trueBranch);fn.blocks.add(falseBranch);fn.blocks.add(destination);
    }

    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        if (it.rhs instanceof binaryExprNode ||
            it.rhs instanceof cmpExprNode) {
            it.rhs.val = it.lhs.val;
            it.rhs.accept(this);
        } else {
            it.rhs.accept(this);
            currentBlock.push_back(
                    new binary((register) it.lhs.val, it.rhs.val, new constant(0), add)
            );
        }
    }

    @Override
    public void visit(binaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        register value;
        if (it.val != null) value = (register)it.val;
        else {
            value = new register();
            it.val = value;
        }
        binary.opType op = it.opCode == binaryExprNode.binaryOpType.add ? add : sub;
        currentBlock.push_back(new binary(value, it.lhs.val, it.rhs.val, op));
    }

    @Override
    public void visit(constExprNode it) {
        it.val = new constant(it.value);
    }

    @Override
    public void visit(cmpExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        register value;
        if (it.val != null) value = (register)it.val;
        else {
            value = new register();
            it.val = value;
        }
        binary.opType op = it.opCode == cmpExprNode.cmpOpType.eq ? eq : ne;
        currentBlock.push_back(new binary(value, it.lhs.val, it.rhs.val, op));
    }

    @Override
    public void visit(varExprNode it) {
        it.val = currentScope.getEntity(it.name, true);
    }
}
