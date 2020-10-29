package Frontend;

import AST.*;
import Parser.YxBaseVisitor;
import Parser.YxParser;
import Util.position;
import org.antlr.v4.runtime.ParserRuleContext;

public class ASTBuilder extends YxBaseVisitor<ASTNode> {

    @Override public ASTNode visitProgram(YxParser.ProgramContext ctx) {

        if (!ctx.suite().isEmpty()) {
            visit(ctx.suite());
        }
        return new RootNode(new position(ctx));
    }

    @Override public ASTNode visitVarDef(YxParser.VarDefContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitSuite(YxParser.SuiteContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitBlock(YxParser.BlockContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitVardefStmt(YxParser.VardefStmtContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitIfStmt(YxParser.IfStmtContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitReturnStmt(YxParser.ReturnStmtContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitPureExprStmt(YxParser.PureExprStmtContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitEmptyStmt(YxParser.EmptyStmtContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitAtomExpr(YxParser.AtomExprContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitBinaryExpr(YxParser.BinaryExprContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitAssignExpr(YxParser.AssignExprContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitPrimary(YxParser.PrimaryContext ctx) { return visitChildren(ctx); }

    @Override public ASTNode visitLiteral(YxParser.LiteralContext ctx) { return visitChildren(ctx); }

}
