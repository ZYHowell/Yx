package MIR;

public class binary extends statement {
    public enum opType {
        add, sub, eq, ne
    }

    public register lhs;
    public entity op1, op2;
    public opType op;
    public binary(register lhs, entity op1, entity op2, opType op) {
        super();
        this.lhs = lhs;
        this.op1 = op1;
        this.op2 = op2;
        this.op = op;
    }
}
