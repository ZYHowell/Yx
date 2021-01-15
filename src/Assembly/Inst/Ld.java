package Assembly.Inst;

import Assembly.Operand.Imm;
import Assembly.Operand.PhyReg;

public class Ld extends Inst{
    public PhyReg rd, addr;
    public Imm offset;

    public Ld(PhyReg rd, PhyReg addr, Imm offset) {
        this.rd = rd;
        this.addr = addr;
        this.offset = offset;
    }
    @Override
    public String toString() {
        return "lw " + rd + ", " + addr + "(" + offset + ")";
    }
}
