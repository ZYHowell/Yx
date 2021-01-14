package MIR;

public class branch extends terminalStmt {
    public entity op;
    public block trueBranch, falseBranch;
    public branch(entity op, block trueBranch, block falseBranch) {
        super();
        this.op = op;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }
}
