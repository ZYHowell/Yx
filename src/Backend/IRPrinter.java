package Backend;

import MIR.*;

import java.io.PrintStream;
import java.util.HashMap;

public class IRPrinter implements Pass {
    private PrintStream out;

    private int blockCnt = 0, regCnt = 0;
    private HashMap<block, Integer> blockIndex = new HashMap<>();
    private HashMap<register, Integer> regIndex = new HashMap<>();

    public IRPrinter(PrintStream out) {
        this.out = out;
    }

    public void visitBlock(block b) {
        out.println(getBlockName(b) + ": ");
        b.stmts().forEach(this::print);
        b.successors().forEach(this::visitBlock);
    }

    @Override
    public void visitFn(mainFn f) {
        visitBlock(f.rootBlock);
    }

    private String getBlockName(block b) {
        if (blockIndex.containsKey(b)) return "b." + blockIndex.get(b);
        else {
            blockIndex.put(b, blockCnt++);
            return "b." + (blockCnt - 1);
        }
    }
    private String getRegName(register r) {
        if (regIndex.containsKey(r)) return "%" + regIndex.get(r);
        else {
            regIndex.put(r, regCnt++);
            return "%" + (regCnt - 1);
        }
    }
    private String getEntityString(entity e) {
        if (e instanceof register) return getRegName((register) e);
        else return ((constant) e).value() + "";
    }
    private String getOpString(binary.opType op) {
        if (op == binary.opType.add) return "+";
        else if (op == binary.opType.sub) return "-";
        else if (op == binary.opType.eq) return "==";
        else return "!=";
    }

    private void print(statement s) {
        if (s instanceof binary) {
            binary b = (binary) s;
            out.println("\t" + getRegName(b.lhs) + " = " +
                    getEntityString(b.op1) + " " + getOpString(b.op) +
                    " " + getEntityString(b.op2) + ";");
        } else if (s instanceof jump) {
            jump j = (jump) s;
            out.println("\tj " + getBlockName(j.destination) + ";");
        } else if (s instanceof branch) {
            branch b = (branch) s;
            out.println("\tbr " + getEntityString(b.op) + " " +
                    getBlockName(b.trueBranch) + ", " + getBlockName(b.falseBranch) + ";");
        } else if (s instanceof ret) {
            ret r = (ret) s;
            out.println("\tret" + (r.value == null ? "" :
                                    (" " + getEntityString(r.value))) + ";");
        }
    }
}
