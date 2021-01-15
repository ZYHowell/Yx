package Assembly.Inst;

public abstract class Inst {
    public Inst prev = null, next = null;
    public enum CalCategory {
        add, sub, eq, ne
    }

    // below: for Asm Printer
    @Override abstract public String toString();
}
