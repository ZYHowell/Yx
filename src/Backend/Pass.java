package Backend;

import MIR.block;
import MIR.mainFn;

public interface Pass {
    void visitBlock(block b);
    void visitFn(mainFn f);
}
