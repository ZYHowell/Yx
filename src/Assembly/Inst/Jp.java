package Assembly.Inst;

import Assembly.AsmBlock;

public class Jp extends Inst {
    public AsmBlock destination;
    public Jp(AsmBlock d) {
        destination = d;
    }

    @Override
    public String toString() {
        return "j " + destination;
    }
}
