package AST;

import Util.Type;
import Util.position;

public class assignExprNode extends ExprNode{
    public ExprNode lhs, rhs;

    public assignExprNode(ExprNode lhs, ExprNode rhs, Type intType, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        type = intType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
