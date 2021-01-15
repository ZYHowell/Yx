package Assembly.Inst;

import Assembly.Operand.Reg;

public class Mv extends Inst {
    public Reg rd, rs1;

    public Mv(Reg rd, Reg rs1) {
        this.rd = rd;
        this.rs1 = rs1;
    }

    @Override
    public String toString() {
        return "mv " + rd + ", " + rs1;
    }
}

