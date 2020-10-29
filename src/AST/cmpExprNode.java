package AST;

import Util.Type;
import Util.position;

public class cmpExprNode extends ExprNode {
    public ExprNode lhs, rhs;
    public enum cmpOpType {
        eq, neq
    }
    public cmpOpType opCode;

    public cmpExprNode(ExprNode lhs, ExprNode rhs, cmpOpType opCode, Type boolType, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.opCode = opCode;
        type = boolType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
