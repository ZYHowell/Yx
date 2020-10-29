package Frontend;

import AST.*;
import Parser.YxBaseVisitor;
import Parser.YxParser;
import Util.Type;
import Util.position;
import org.antlr.v4.runtime.ParserRuleContext;
import AST.binaryExprNode.binaryOpType;
import AST.cmpExprNode.cmpOpType;

import java.util.ArrayList;

public class ASTBuilder extends YxBaseVisitor<ASTNode> {

    Type intType, boolType;

    @Override public ASTNode visitProgram(YxParser.ProgramContext ctx) {

        RootNode root = new RootNode(new position(ctx));
        intType = root.intType;
        boolType = root.boolType;

        if (ctx.suite() != null) {
            for (ParserRuleContext stmt : ctx.suite().statement())
                root.stmts.add((StmtNode) visit(stmt));
        }
        return root;
    }

    @Override public ASTNode visitVarDef(YxParser.VarDefContext ctx) {
        String name = ctx.Identifier().toString();
        ExprNode expr = null;
        if (ctx.expression() != null) expr = (ExprNode)visit(ctx.expression());

        return new varDefStmtNode(name, expr, new position(ctx));
    }

    @Override public ASTNode visitSuite(YxParser.SuiteContext ctx) {
        blockStmtNode node = new blockStmtNode(new position(ctx));

        if (!ctx.statement().isEmpty()) {
            for (ParserRuleContext stmt : ctx.statement()) {
                StmtNode tmp = (StmtNode)visit(stmt);
                if (tmp != null) node.stmts.add(tmp);
            }
        }
        return node;
    }

    @Override public ASTNode visitBlock(YxParser.BlockContext ctx) {
        return visit(ctx.suite());
    }

    @Override public ASTNode visitVardefStmt(YxParser.VardefStmtContext ctx) { return visit(ctx.varDef()); }

    @Override public ASTNode visitIfStmt(YxParser.IfStmtContext ctx) {
        StmtNode thenStmt = (StmtNode)visit(ctx.trueStmt), elseStmt = null;
        ExprNode condition = (ExprNode)visit(ctx.expression());
        if (ctx.falseStmt != null) elseStmt = (StmtNode)visit(ctx.falseStmt);
        return new ifStmtNode(condition, thenStmt, elseStmt, new position(ctx));
    }

    @Override public ASTNode visitReturnStmt(YxParser.ReturnStmtContext ctx) {
        ExprNode value = null;
        if (ctx.expression() != null) value = (ExprNode) visit(ctx.expression());
        return new returnStmtNode(value, new position(ctx));
    }

    @Override public ASTNode visitPureExprStmt(YxParser.PureExprStmtContext ctx) {
        return new exprStmtNode((ExprNode) visit(ctx.expression()), new position(ctx));
    }

    @Override public ASTNode visitEmptyStmt(YxParser.EmptyStmtContext ctx) {
        return null;
    }

    @Override public ASTNode visitAtomExpr(YxParser.AtomExprContext ctx) {
        return visit(ctx.primary());
    }

    @Override public ASTNode visitBinaryExpr(YxParser.BinaryExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression(0)),
                 rhs = (ExprNode) visit(ctx.expression(1));
        binaryOpType biOp = ctx.Plus() != null ? binaryOpType.add :
                            (ctx.Minus() != null ? binaryOpType.sub : null);
        cmpOpType cmpOp = ctx.Equal() != null ? cmpOpType.eq :
                            (ctx.NotEqual() != null ? cmpOpType.neq : null);

        return biOp != null ? (new binaryExprNode(lhs, rhs, biOp, intType, new position(ctx))) :
                                (new cmpExprNode(lhs, rhs, cmpOp, boolType, new position(ctx)));
    }

    @Override public ASTNode visitAssignExpr(YxParser.AssignExprContext ctx) {
        ExprNode lhs = (ExprNode) visit(ctx.expression(0)),
                 rhs = (ExprNode) visit(ctx.expression(1));
        return new assignExprNode(lhs, rhs, intType, new position(ctx));
    }

    @Override public ASTNode visitPrimary(YxParser.PrimaryContext ctx) {
        if (ctx.expression() != null) return visit(ctx.expression());
        else if (ctx.literal() != null) return visit(ctx.literal());
        else return new varExprNode(ctx.Identifier().toString(),
                                    intType, new position(ctx.Identifier()));
    }

    @Override public ASTNode visitLiteral(YxParser.LiteralContext ctx) {
        return new constExprNode(Integer.parseInt(ctx.DecimalInteger().toString()),
                                 intType, new position(ctx));
    }

}
