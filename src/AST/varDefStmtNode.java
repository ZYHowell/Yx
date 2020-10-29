package AST;

import Util.position;

public class varDefStmtNode extends StmtNode {
    public String name;
    public ExprNode init;

    public varDefStmtNode(String name, ExprNode init, position pos) {
        super(pos);
        this.name = name;
        this.init = init;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
