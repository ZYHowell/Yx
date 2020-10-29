import AST.RootNode;
import Frontend.ASTBuilder;
import Frontend.SemanticChecker;
import Parser.YxLexer;
import Parser.YxParser;
import Util.YxErrorListener;
import Util.error.error;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;


public class Main {
    public static void main(String[] args) throws Exception{

        String name = "test.yx";
        InputStream input = new FileInputStream(name);

        try {
            RootNode ASTRoot;

            YxLexer lexer = new YxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new YxErrorListener());
            YxParser parser = new YxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new YxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder();
            ASTRoot = (RootNode)astBuilder.visit(parseTreeRoot);
            new SemanticChecker().visit(ASTRoot);
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}