package AST;

import Util.position;

public class assignExprNode extends ExprNode{
    public ExprNode lhs;

    public assignExprNode(ExprNode lhs, position pos) {
        super(pos);
        this.lhs = lhs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
