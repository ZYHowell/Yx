package Backend;

import Assembly.AsmBlock;
import Assembly.AsmFn;
import Assembly.Inst.Inst;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AsmPrinter {
    private PrintStream out;

    private AsmFn fn;
    private int blockCnt = 0;
    private List<AsmBlock> printList = new LinkedList<>();

    public AsmPrinter(AsmFn fn, PrintStream out) {
        this.fn = fn;
        this.out = out;
    }

    private void rename() {
        fn.blocks.forEach(b -> b.index = -1);
        Queue<AsmBlock> queue = new LinkedList<>();
        queue.offer(fn.rootBlock);
        fn.rootBlock.index = blockCnt++;
        while(!queue.isEmpty()) {
            AsmBlock b = queue.poll();
            b.successors.forEach(s -> {
                if (s.index == -1){
                    s.index = blockCnt++;
                    queue.offer(s);
                }
            });
            printList.add(b);
        }
    }
    public void printBlock(AsmBlock b) {
        out.println(b + ": ");
        for (Inst i = b.headInst; i != null; i = i.next) {
            out.println("\t" + i.toString());
        }
    }
    public void print() {
        rename();
        printList.forEach(this::printBlock);
    }
}
