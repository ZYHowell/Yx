package Frontend;

import AST.*;
import Util.Scope;
import Util.error.semanticError;

public class SemanticChecker implements ASTVisitor {
    Scope currentScope;

    @Override
    public void visit(RootNode it) {
        currentScope = new Scope(null);
        for (StmtNode stmt : it.stmts) stmt.accept(this);
    }

    @Override
    public void visit(varDefStmtNode it) {
        if (it.init != null) {
            it.init.accept(this);
            if (!it.init.type.isInt)
                throw new semanticError("Semantic Error: type not match. It should be int",
                                        it.init.pos);
        }
        currentScope.defineVariable(it.name, it.pos);
    }

    @Override
    public void visit(returnStmtNode it) {
        if (it.value != null) {
            it.value.accept(this);
            if (!it.value.type.isInt)
                throw new semanticError("Semantic Error: type not match. It should be int",
                        it.value.pos);
        }
    }

    @Override
    public void visit(blockStmtNode it) {
        if (!it.stmts.isEmpty()) {
            currentScope = new Scope(currentScope);
            for (StmtNode stmt : it.stmts) stmt.accept(this);
            currentScope = currentScope.parentScope();
        }
    }

    @Override
    public void visit(exprStmtNode it) {
        it.expr.accept(this);
    }

    @Override
    public void visit(ifStmtNode it) {
        it.condition.accept(this);
        if (!it.condition.type.isBool)
            throw new semanticError("Semantic Error: type not match. It should be bool",
                    it.condition.pos);
        it.thenStmt.accept(this);
        if (it.elseStmt != null) it.elseStmt.accept(this);
    }

    @Override
    public void visit(assignExprNode it) {
        it.rhs.accept(this);
        it.lhs.accept(this);
        if (it.rhs.type != it.lhs.type)
            throw new semanticError("Semantic Error: type not match. ", it.pos);
        if (!it.lhs.isAssignable())
            throw new semanticError("Semantic Error: not assignable", it.lhs.pos);
    }

    @Override
    public void visit(binaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (!it.lhs.type.isInt)
            throw new semanticError("Semantic error: type not match. It should be int",
                    it.lhs.pos);
        if (!it.rhs.type.isInt)
            throw new semanticError("Semantic error: type not match. It should be int",
                    it.rhs.pos);
    }

    @Override
    public void visit(constExprNode it) {}

    @Override
    public void visit(cmpExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.rhs.type != it.lhs.type)
            throw new semanticError("Semantic Error: type not match. ", it.pos);
    }

    @Override
    public void visit(varExprNode it) {
        if (!currentScope.containsVariable(it.name, true))
            throw new semanticError("Semantic Error: variable not defined. ", it.pos);
    }
}
