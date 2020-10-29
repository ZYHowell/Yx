package Util.error;
import Util.position;

public class semanticError extends error {

    public semanticError(String msg, position pos) {
        super("Semantic Error: " + msg, pos);
    }

}
