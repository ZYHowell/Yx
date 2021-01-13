// Generated from Yx.g4 by ANTLR 4.7.2
package Parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YxParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Int=2, If=3, Else=4, Return=5, Struct=6, LeftParen=7, RightParen=8, 
		LeftBracket=9, RightBracket=10, LeftBrace=11, RightBrace=12, Less=13, 
		LessEqual=14, Greater=15, GreaterEqual=16, LeftShift=17, RightShift=18, 
		Plus=19, Minus=20, And=21, Or=22, AndAnd=23, OrOr=24, Caret=25, Not=26, 
		Tilde=27, Question=28, Colon=29, Semi=30, Comma=31, Assign=32, Equal=33, 
		NotEqual=34, Identifier=35, DecimalInteger=36, Whitespace=37, Newline=38, 
		BlockComment=39, LineComment=40;
	public static final int
		RULE_program = 0, RULE_mainFn = 1, RULE_varDef = 2, RULE_classDef = 3, 
		RULE_suite = 4, RULE_statement = 5, RULE_expression = 6, RULE_primary = 7, 
		RULE_literal = 8, RULE_type = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainFn", "varDef", "classDef", "suite", "statement", "expression", 
			"primary", "literal", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main()'", "'int'", "'if'", "'else'", "'return'", "'struct'", 
			"'('", "')'", "'['", "']'", "'{'", "'}'", "'<'", "'<='", "'>'", "'>='", 
			"'<<'", "'>>'", "'+'", "'-'", "'&'", "'|'", "'&&'", "'||'", "'^'", "'!'", 
			"'~'", "'?'", "':'", "';'", "','", "'='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Int", "If", "Else", "Return", "Struct", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "Minus", 
			"And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Identifier", "DecimalInteger", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Yx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YxParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainFnContext mainFn() {
			return getRuleContext(MainFnContext.class,0);
		}
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Struct) {
				{
				{
				setState(20);
				classDef();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(26);
			mainFn();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainFnContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(YxParser.Int, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YxParser.EOF, 0); }
		public MainFnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainFn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterMainFn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitMainFn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitMainFn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainFnContext mainFn() throws RecognitionException {
		MainFnContext _localctx = new MainFnContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainFn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(Int);
			setState(29);
			match(T__0);
			setState(30);
			suite();
			setState(31);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(YxParser.Identifier, 0); }
		public TerminalNode Semi() { return getToken(YxParser.Semi, 0); }
		public TerminalNode Assign() { return getToken(YxParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			type();
			setState(34);
			match(Identifier);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(35);
				match(Assign);
				setState(36);
				expression(0);
				}
			}

			setState(39);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Struct() { return getToken(YxParser.Struct, 0); }
		public TerminalNode Identifier() { return getToken(YxParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(YxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(YxParser.RightBrace, 0); }
		public TerminalNode Semi() { return getToken(YxParser.Semi, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(Struct);
			setState(42);
			match(Identifier);
			setState(43);
			match(LeftBrace);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Int || _la==Identifier) {
				{
				{
				setState(44);
				varDef();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(RightBrace);
			setState(51);
			match(Semi);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(YxParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(YxParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(LeftBrace);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Int) | (1L << If) | (1L << Return) | (1L << LeftParen) | (1L << LeftBrace) | (1L << Semi) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
				{
				{
				setState(54);
				statement();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStmtContext extends StatementContext {
		public StatementContext trueStmt;
		public StatementContext falseStmt;
		public TerminalNode If() { return getToken(YxParser.If, 0); }
		public TerminalNode LeftParen() { return getToken(YxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(YxParser.RightParen, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(YxParser.Else, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStmtContext extends StatementContext {
		public TerminalNode Semi() { return getToken(YxParser.Semi, 0); }
		public EmptyStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterEmptyStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitEmptyStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitEmptyStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends StatementContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public BlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode Return() { return getToken(YxParser.Return, 0); }
		public TerminalNode Semi() { return getToken(YxParser.Semi, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VardefStmtContext extends StatementContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VardefStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterVardefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitVardefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitVardefStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PureExprStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semi() { return getToken(YxParser.Semi, 0); }
		public PureExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterPureExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitPureExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitPureExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		int _la;
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				suite();
				}
				break;
			case 2:
				_localctx = new VardefStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				varDef();
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(If);
				setState(65);
				match(LeftParen);
				setState(66);
				expression(0);
				setState(67);
				match(RightParen);
				setState(68);
				((IfStmtContext)_localctx).trueStmt = statement();
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(69);
					match(Else);
					setState(70);
					((IfStmtContext)_localctx).falseStmt = statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				match(Return);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LeftParen) | (1L << Identifier) | (1L << DecimalInteger))) != 0)) {
					{
					setState(74);
					expression(0);
					}
				}

				setState(77);
				match(Semi);
				}
				break;
			case 5:
				_localctx = new PureExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				expression(0);
				setState(79);
				match(Semi);
				}
				break;
			case 6:
				_localctx = new EmptyStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(81);
				match(Semi);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public AtomExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Plus() { return getToken(YxParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(YxParser.Minus, 0); }
		public TerminalNode Equal() { return getToken(YxParser.Equal, 0); }
		public TerminalNode NotEqual() { return getToken(YxParser.NotEqual, 0); }
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Assign() { return getToken(YxParser.Assign, 0); }
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new AtomExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(85);
			primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(96);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(87);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(88);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Plus || _la==Minus) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(89);
						expression(4);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(90);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(91);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==Equal || _la==NotEqual) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(92);
						expression(3);
						}
						break;
					case 3:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(93);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(94);
						match(Assign);
						setState(95);
						expression(1);
						}
						break;
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(YxParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(YxParser.RightParen, 0); }
		public TerminalNode Identifier() { return getToken(YxParser.Identifier, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primary);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LeftParen:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(LeftParen);
				setState(102);
				expression(0);
				setState(103);
				match(RightParen);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(Identifier);
				}
				break;
			case DecimalInteger:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode DecimalInteger() { return getToken(YxParser.DecimalInteger, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(DecimalInteger);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Int() { return getToken(YxParser.Int, 0); }
		public TerminalNode Identifier() { return getToken(YxParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YxListener ) ((YxListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YxVisitor ) return ((YxVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_la = _input.LA(1);
			if ( !(_la==Int || _la==Identifier) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*t\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3\2"+
		"\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\5\4(\n\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3\5\3"+
		"\5\3\5\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7J\n\7\3\7\3\7\5\7N\n\7\3\7\3\7\3\7\3\7\3\7\5\7U\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bc\n\b\f\b\16\bf\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\13\3\13\3\13\2\3\16\f\2\4"+
		"\6\b\n\f\16\20\22\24\2\5\3\2\25\26\3\2#$\4\2\4\4%%\2y\2\31\3\2\2\2\4\36"+
		"\3\2\2\2\6#\3\2\2\2\b+\3\2\2\2\n\67\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20"+
		"m\3\2\2\2\22o\3\2\2\2\24q\3\2\2\2\26\30\5\b\5\2\27\26\3\2\2\2\30\33\3"+
		"\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\5"+
		"\4\3\2\35\3\3\2\2\2\36\37\7\4\2\2\37 \7\3\2\2 !\5\n\6\2!\"\7\2\2\3\"\5"+
		"\3\2\2\2#$\5\24\13\2$\'\7%\2\2%&\7\"\2\2&(\5\16\b\2\'%\3\2\2\2\'(\3\2"+
		"\2\2()\3\2\2\2)*\7 \2\2*\7\3\2\2\2+,\7\b\2\2,-\7%\2\2-\61\7\r\2\2.\60"+
		"\5\6\4\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2"+
		"\2\63\61\3\2\2\2\64\65\7\16\2\2\65\66\7 \2\2\66\t\3\2\2\2\67;\7\r\2\2"+
		"8:\5\f\7\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2"+
		">?\7\16\2\2?\13\3\2\2\2@U\5\n\6\2AU\5\6\4\2BC\7\5\2\2CD\7\t\2\2DE\5\16"+
		"\b\2EF\7\n\2\2FI\5\f\7\2GH\7\6\2\2HJ\5\f\7\2IG\3\2\2\2IJ\3\2\2\2JU\3\2"+
		"\2\2KM\7\7\2\2LN\5\16\b\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OU\7 \2\2PQ\5\16"+
		"\b\2QR\7 \2\2RU\3\2\2\2SU\7 \2\2T@\3\2\2\2TA\3\2\2\2TB\3\2\2\2TK\3\2\2"+
		"\2TP\3\2\2\2TS\3\2\2\2U\r\3\2\2\2VW\b\b\1\2WX\5\20\t\2Xd\3\2\2\2YZ\f\5"+
		"\2\2Z[\t\2\2\2[c\5\16\b\6\\]\f\4\2\2]^\t\3\2\2^c\5\16\b\5_`\f\3\2\2`a"+
		"\7\"\2\2ac\5\16\b\3bY\3\2\2\2b\\\3\2\2\2b_\3\2\2\2cf\3\2\2\2db\3\2\2\2"+
		"de\3\2\2\2e\17\3\2\2\2fd\3\2\2\2gh\7\t\2\2hi\5\16\b\2ij\7\n\2\2jn\3\2"+
		"\2\2kn\7%\2\2ln\5\22\n\2mg\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\21\3\2\2\2op\7"+
		"&\2\2p\23\3\2\2\2qr\t\4\2\2r\25\3\2\2\2\f\31\'\61;IMTbdm";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}