package AST;

import Util.position;

public class binaryExprNode extends ExprNode {
    public ExprNode lhs, rhs;
    public enum binaryOpType {
        add, sub
    }
    public binaryOpType opCode;

    public binaryExprNode(ExprNode lhs, ExprNode rhs, binaryOpType opCode, position pos) {
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
