package Backend;

import MIR.block;

public interface Pass {
    void visitBlock(block b);
}
