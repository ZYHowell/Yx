package Assembly;

import Assembly.Inst.Inst;

import java.util.HashSet;

public class AsmBlock {
    public Inst headInst = null, tailInst = null;
    public HashSet<AsmBlock> successors = new HashSet<>();
    public int index = -1;
    // prune-use: public AsmBlock precursor = null;

    public AsmBlock() {}


    public void push_back(Inst i) {
        if (headInst == null) headInst = tailInst = i;
        else {
            tailInst.next = i;
            i.prev = tailInst;
            tailInst = i;
        }
    }
    public void insert_before(Inst i, Inst in) {
        if (i.prev == null) headInst = in;
        else i.prev.next = in;
        in.prev = i.prev; in.next = i; i.prev = in;
    }
    public void insert_after(Inst i, Inst in) {
        if (i.next == null) tailInst = in;
        else i.next.prev = in;
        in.prev = i; in.next = i.next; i.next = in;
    }

    @Override
    public String toString() {
        return "." + index;
    }
}
