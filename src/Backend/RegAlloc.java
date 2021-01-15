package Backend;

import Assembly.AsmFn;
import Assembly.Inst.*;
import Assembly.Operand.*;

public class RegAlloc {
    public AsmFn f;
    private PhyReg sp, t0, t1, t2;
    public RegAlloc(AsmFn f) {
        this.f = f;
        sp = f.phyRegs.get(2);
        t0 = f.phyRegs.get(5);
        t1 = f.phyRegs.get(6);
        t2 = f.phyRegs.get(7);
    }

    private Inst loadVirtualReg(VirtualReg r, PhyReg rd) {
        return new Ld(rd, sp, new Imm(r.index * 4));
    }
    private Inst storeVirtualReg(VirtualReg r) {
        return new St(t2, sp, new Imm(r.index * 4));
    }
    public void work() {
        f.blocks.forEach(b -> {
            for (Inst i = b.headInst; i != null; i = i.next) {
                if (i instanceof Bz) {
                    Bz bz = (Bz) i;
                    b.insert_before(i, loadVirtualReg((VirtualReg) bz.src, t0));
                    bz.src = t0;
                } else if (i instanceof IType) {
                    IType it = (IType) i;
                    b.insert_before(i, loadVirtualReg((VirtualReg) it.rs, t0));
                    it.rs = t0;
                    b.insert_after(i, storeVirtualReg((VirtualReg) it.rd));
                    it.rd = t2;
                } else if (i instanceof Li) {
                    Li l = (Li) i;
                    if (l.rd instanceof VirtualReg) //return 0;
                        b.insert_after(i, storeVirtualReg((VirtualReg) l.rd));
                    l.rd = t2;
                } else if (i instanceof Mv) {
                    Mv m = (Mv) i;
                    b.insert_before(i, loadVirtualReg((VirtualReg)m.rs1, t0));
                    m.rs1 = t0;
                    if (m.rd instanceof VirtualReg) //return x;
                        b.insert_after(i, storeVirtualReg((VirtualReg)m.rd));
                    m.rd = t2;
                } else if (i instanceof RType) {
                    RType r = (RType) i;
                    b.insert_before(i, loadVirtualReg((VirtualReg) r.rs1, t0));
                    r.rs1 = t0;
                    b.insert_before(i, loadVirtualReg((VirtualReg) r.rs2, t1));
                    r.rs2 = t1;
                    b.insert_after(i, storeVirtualReg((VirtualReg) r.rd));
                    r.rd = t2;
                }
            }
        });
        f.rootBlock.insert_before(f.rootBlock.headInst,
                new IType(sp, sp, new Imm(f.stackLength * -1), Inst.CalCategory.add)
        );
    }

}
