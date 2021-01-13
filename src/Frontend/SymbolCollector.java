package Frontend;

import AST.*;
import Util.Type;
import Util.globalScope;

import java.util.HashMap;

public class SymbolCollector implements ASTVisitor {
    private globalScope gScope;
    public SymbolCollector(globalScope gScope) {
        this.gScope = gScope;
    }
    @Override
    public void visit(RootNode it) {
        it.strDefs.forEach(sd -> sd.accept(this));
    }

    @Override public void visit(structDefNode it) {
        Type struct = new Type();
        struct.members = new HashMap<>();
        it.varDefs.forEach(vd -> vd.accept(this));
        gScope.addType(it.name, struct, it.pos);
    }
    @Override public void visit(FnRootNode it) {}
    @Override public void visit(varDefStmtNode it) {}
    @Override public void visit(returnStmtNode it) {}
    @Override public void visit(blockStmtNode it) {}
    @Override public void visit(exprStmtNode it) {}
    @Override public void visit(ifStmtNode it) {}
    @Override public void visit(assignExprNode it) {}
    @Override public void visit(binaryExprNode it) {}
    @Override public void visit(constExprNode it) {}
    @Override public void visit(cmpExprNode it) {}
    @Override public void visit(varExprNode it) {}
}
