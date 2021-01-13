package AST;

public interface ASTVisitor {
    void visit(RootNode it);
    void visit(structDefNode it);
    void visit(FnRootNode it);

    void visit(varDefStmtNode it);
    void visit(returnStmtNode it);
    void visit(blockStmtNode it);
    void visit(exprStmtNode it);
    void visit(ifStmtNode it);

    void visit(assignExprNode it);
    void visit(binaryExprNode it);
    void visit(constExprNode it);
    void visit(cmpExprNode it);
    void visit(varExprNode it);
}
