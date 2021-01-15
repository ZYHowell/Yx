package Assembly.Operand;

public class PhyReg extends Reg {
    public String name;
    public PhyReg(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
