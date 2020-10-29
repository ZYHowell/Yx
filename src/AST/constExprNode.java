package AST;

import Util.position;

import Util.Type;

public class constExprNode extends ExprNode {
    public int value;

    public constExprNode(int value, Type intType, position pos) {
        super(pos);
        this.value = value;
        type = intType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
