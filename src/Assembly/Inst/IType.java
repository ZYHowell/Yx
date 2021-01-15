package Assembly.Inst;

import Assembly.Operand.Imm;
import Assembly.Operand.Reg;

public class IType extends Inst {
    public Reg rd, rs;
    public Imm imm;
    public CalCategory op;

    public IType(Reg rd, Reg rs, Imm imm, CalCategory op) {
        this.rd = rd;
        this.rs = rs;
        this.imm = imm;
        this.op = op;
    }

    @Override
    public String toString() {
        if (op.ordinal() < 2) return op + "i " + rd + ", " + rs + ", " + imm;
        else {
            assert(imm.value == 0);
            return "s" + op + "z " + rd + ", " + rs;
        }
    }
}
