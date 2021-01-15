package Assembly;

import Assembly.Inst.Inst;

import java.util.HashSet;
import java.util.LinkedList;

public class AsmBlock {
    public LinkedList<Inst> instructions = new LinkedList<>();
    public HashSet<AsmBlock> successors = new HashSet<>();
    public int index = -1;
    // prune-use: public AsmBlock precursor = null;

    public AsmBlock() {}

    @Override
    public String toString() {
        return "." + index;
    }
}
