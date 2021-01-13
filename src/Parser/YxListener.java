// Generated from Yx.g4 by ANTLR 4.7.2
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YxParser}.
 */
public interface YxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YxParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(YxParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(YxParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void enterMainFn(YxParser.MainFnContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#mainFn}.
	 * @param ctx the parse tree
	 */
	void exitMainFn(YxParser.MainFnContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(YxParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(YxParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(YxParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(YxParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSuite(YxParser.SuiteContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSuite(YxParser.SuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code block}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlock(YxParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code block}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlock(YxParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVardefStmt(YxParser.VardefStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVardefStmt(YxParser.VardefStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(YxParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(YxParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(YxParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(YxParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPureExprStmt(YxParser.PureExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPureExprStmt(YxParser.PureExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStmt(YxParser.EmptyStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStmt(YxParser.EmptyStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(YxParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(YxParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(YxParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(YxParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(YxParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(YxParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(YxParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(YxParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(YxParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(YxParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link YxParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(YxParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YxParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(YxParser.TypeContext ctx);
}