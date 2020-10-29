package Util;

import Util.error.semanticError;
import java.util.HashSet;

public class Scope {

    private HashSet<String> members;
    private Scope parentScope;


    public Scope(Scope parentScope) {
        members = new HashSet<>();
        this.parentScope = parentScope;
    }

    public Scope parentScope() {
        return parentScope;
    }

    public void defineVariable(String name, position pos) {
        if (members.contains(name))
            throw new semanticError("Semantic Error: variable redefine", pos);
        members.add(name);
    }

    public boolean containsVariable(String name, boolean lookUpon) {
        if (members.contains(name)) return true;
        else if (parentScope != null && lookUpon)
            return parentScope.containsVariable(name, true);
        else return false;
    }
}
