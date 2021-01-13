package AST;

import Util.position;

public class varDefStmtNode extends StmtNode {
    public String name, typeName;
    public ExprNode init;

    public varDefStmtNode(String typeName, String name, ExprNode init, position pos) {
        super(pos);
        this.name = name;
        this.typeName = typeName;
        this.init = init;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
