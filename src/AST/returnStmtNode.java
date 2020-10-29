package AST;

import Util.position;

public class returnStmtNode extends StmtNode {
    public ExprNode value;

    public returnStmtNode(ExprNode value, position pos) {
        super(pos);
        this.value = value;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
