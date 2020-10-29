package AST;

import Util.position;

public class cmpExprNode extends ExprNode {
    public ExprNode lhs, rhs;
    public enum cmpOpType {
        eq, neq
    }
    public cmpOpType opCode;

    public cmpExprNode(ExprNode lhs, ExprNode rhs, cmpOpType opCode, position pos) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.opCode = opCode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
