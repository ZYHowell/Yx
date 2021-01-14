package MIR;

public class jump extends terminalStmt {
    public block destination;
    public jump(block destination) {
        super();
        this.destination = destination;
    }
}
