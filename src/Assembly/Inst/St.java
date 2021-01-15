package Assembly.Inst;

import Assembly.Operand.Imm;
import Assembly.Operand.PhyReg;

public class St extends Inst {
    public PhyReg rs, addr;
    public Imm offset;

    public St(PhyReg rs, PhyReg addr, Imm offset) {
        this.rs = rs;
        this.addr = addr;
        this.offset = offset;
    }
    @Override
    public String toString() {
        return "sw " + rs + ", " + addr + "(" + offset + ")";
    }
}
