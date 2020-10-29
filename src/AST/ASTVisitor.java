package AST;

/* anyone going to write a compiler like this is suggested to consider
   if rebuild an AST out ANTLR is essential. */
public interface ASTVisitor {
    void visit(ASTNode it);

    void visit(varDefStmtNode it);
    void visit(returnStmtNode it);
    void visit(exprStmtNode it);
    void visit(ifStmtNode it);

    void visit(assignExprNode it);
    void visit(binaryExprNode it);
    void visit(constExprNode it);
    void visit(cmpExprNode it);
    void visit(varExprNode it);
}
