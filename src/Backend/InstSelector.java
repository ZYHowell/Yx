package Backend;

import Assembly.*;
import Assembly.Inst.*;
import Assembly.Operand.*;
import MIR.*;

import java.util.HashMap;
import static Assembly.Inst.Inst.CalCategory.*;

public class InstSelector implements Pass {
    private HashMap<block, AsmBlock> blockMap = new HashMap<>();
    private HashMap<register, VirtualReg> regMap = new HashMap<>();
    private int cnt = 0;

    public AsmFn mainF;
    public InstSelector(AsmFn mainFn) {
        this.mainF = mainFn;
    }

    private AsmBlock getAsmBlock(block b) {
        if (!blockMap.containsKey(b)) {
            blockMap.put(b, new AsmBlock());
        }
        return blockMap.get(b);
    }
    private VirtualReg getAsmReg(register r) {
        if (!regMap.containsKey(r)) {
            regMap.put(r, new VirtualReg(cnt++));
        }
        return regMap.get(r);
    }
    private Imm getImm(constant c) {
        return new Imm(c.value());
    }
    @Override
    public void visitBlock(block B) {
        AsmBlock b = getAsmBlock(B);
        B.stmts().forEach(s -> {
            if (s instanceof jump) {
                jump j = (jump) s;
                b.push_back(new Jp(getAsmBlock(j.destination)));
                b.successors.add(getAsmBlock(j.destination));
            } else if (s instanceof branch) {
                branch br = (branch) s;
                VirtualReg src;
                if (br.op instanceof constant) {
                    src = new VirtualReg(cnt++);
                    b.push_back(new Li(src, getImm((constant) br.op)));
                }
                else src = getAsmReg((register) br.op);
                b.push_back(new Bz(src, getAsmBlock(br.falseBranch)));
                b.successors.add(getAsmBlock(br.falseBranch));
                AsmBlock suc = getAsmBlock(br.trueBranch);
                // if (suc.precursor == null) suc.precursor = b;
                // else     // prune-use
                b.push_back(new Jp(suc));
                b.successors.add(suc);
            } else if (s instanceof ret) {
                ret r = (ret) s;
                if (r.value != null) {
                    if (r.value instanceof register)
                        b.push_back(
                                new Mv(mainF.phyRegs.get(10), getAsmReg((register) r.value))
                        );
                    else b.push_back(
                            new Li(mainF.phyRegs.get(10), getImm((constant) r.value))
                    );
                }   // First move the return value to x10, then return
                b.push_back(new Ret());
            } else if (s instanceof binary) {
                binary bi = (binary) s;
                Inst.CalCategory op = bi.op == binary.opType.add ? add : sub;
                Reg rd;
                if (bi.op == binary.opType.eq || bi.op == binary.opType.ne)
                    rd = new VirtualReg(cnt++);
                else rd = getAsmReg(bi.lhs);
                if (bi.op1 instanceof constant) {
                    b.push_back(new Li(rd, getImm((constant) bi.op2)));
                } else if (bi.op2 instanceof constant) {
                    b.push_back(new IType(rd,
                            getAsmReg((register)bi.op1),
                            getImm((constant) bi.op2),
                            op)
                    );
                } else {
                    b.push_back(new RType(rd,
                            getAsmReg((register) bi.op1),
                            getAsmReg((register) bi.op2),
                            op));
                }
                if (bi.op == binary.opType.eq)
                    b.push_back(new IType(getAsmReg(bi.lhs), rd, new Imm(0), eq));
                else if (bi.op == binary.opType.ne)
                    b.push_back(new IType(getAsmReg(bi.lhs), rd, new Imm(0), ne));
                // Assembly code only has seqz and snez, no seq and sne
            }
        });
    }

    @Override
    public void visitFn(mainFn f) {
        f.blocks.forEach(B -> mainF.blocks.add(getAsmBlock(B)));
        mainF.rootBlock = getAsmBlock(f.rootBlock);
        f.blocks.forEach(this::visitBlock);
        mainF.stackLength += 4 * cnt;
    }
}
