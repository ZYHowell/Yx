package Util.error;
import Util.position;

public class syntaxError extends error {

    public syntaxError(String msg, position pos) {
        super("SyntaxError: " + msg, pos);
    }

}
