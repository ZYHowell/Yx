// Generated from Yx.g4 by ANTLR 4.7.2
package Parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(YxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#mainFn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainFn(YxParser.MainFnContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(YxParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(YxParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuite(YxParser.SuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code block}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(YxParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardefStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardefStmt(YxParser.VardefStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(YxParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(YxParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pureExprStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureExprStmt(YxParser.PureExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link YxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(YxParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(YxParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(YxParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link YxParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(YxParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(YxParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(YxParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link YxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(YxParser.TypeContext ctx);
}