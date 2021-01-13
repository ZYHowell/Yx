package AST;

import Util.Type;
import Util.position;

public class assignExprNode extends ExprNode{
    public ExprNode lhs, rhs;

    public assignExprNode(ExprNode lhs, ExprNode rhs, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
