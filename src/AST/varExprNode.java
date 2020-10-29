package AST;

import Util.Type;
import Util.position;

public class varExprNode extends ExprNode {
    public String name;

    public varExprNode(String name, Type intType, position pos) {
        super(pos);
        this.name = name;
        type = intType;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isAssignable() {return true;}
}
