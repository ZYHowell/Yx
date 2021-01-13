// Generated from Yx.g4 by ANTLR 4.7.2
package Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class YxLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "Int", "If", "Else", "Return", "Struct", "LeftParen", "RightParen", 
			"LeftBracket", "RightBracket", "LeftBrace", "RightBrace", "Less", "LessEqual", 
			"Greater", "GreaterEqual", "LeftShift", "RightShift", "Plus", "Minus", 
			"And", "Or", "AndAnd", "OrOr", "Caret", "Not", "Tilde", "Question", "Colon", 
			"Semi", "Comma", "Assign", "Equal", "NotEqual", "Identifier", "DecimalInteger", 
			"Whitespace", "Newline", "BlockComment", "LineComment"
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


	public YxLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Yx.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\7"+
		"$\u00b7\n$\f$\16$\u00ba\13$\3%\3%\7%\u00be\n%\f%\16%\u00c1\13%\3%\5%\u00c4"+
		"\n%\3&\6&\u00c7\n&\r&\16&\u00c8\3&\3&\3\'\3\'\5\'\u00cf\n\'\3\'\5\'\u00d2"+
		"\n\'\3\'\3\'\3(\3(\3(\3(\7(\u00da\n(\f(\16(\u00dd\13(\3(\3(\3(\3(\3(\3"+
		")\3)\3)\3)\7)\u00e8\n)\f)\16)\u00eb\13)\3)\3)\3\u00db\2*\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*\3\2\b\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\4\2\13\13\""+
		"\"\4\2\f\f\17\17\2\u00f5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\3S\3\2\2\2\5Z\3\2\2\2\7^\3\2\2\2\ta\3\2\2\2\13f\3\2\2\2\rm\3"+
		"\2\2\2\17t\3\2\2\2\21v\3\2\2\2\23x\3\2\2\2\25z\3\2\2\2\27|\3\2\2\2\31"+
		"~\3\2\2\2\33\u0080\3\2\2\2\35\u0082\3\2\2\2\37\u0085\3\2\2\2!\u0087\3"+
		"\2\2\2#\u008a\3\2\2\2%\u008d\3\2\2\2\'\u0090\3\2\2\2)\u0092\3\2\2\2+\u0094"+
		"\3\2\2\2-\u0096\3\2\2\2/\u0098\3\2\2\2\61\u009b\3\2\2\2\63\u009e\3\2\2"+
		"\2\65\u00a0\3\2\2\2\67\u00a2\3\2\2\29\u00a4\3\2\2\2;\u00a6\3\2\2\2=\u00a8"+
		"\3\2\2\2?\u00aa\3\2\2\2A\u00ac\3\2\2\2C\u00ae\3\2\2\2E\u00b1\3\2\2\2G"+
		"\u00b4\3\2\2\2I\u00c3\3\2\2\2K\u00c6\3\2\2\2M\u00d1\3\2\2\2O\u00d5\3\2"+
		"\2\2Q\u00e3\3\2\2\2ST\7o\2\2TU\7c\2\2UV\7k\2\2VW\7p\2\2WX\7*\2\2XY\7+"+
		"\2\2Y\4\3\2\2\2Z[\7k\2\2[\\\7p\2\2\\]\7v\2\2]\6\3\2\2\2^_\7k\2\2_`\7h"+
		"\2\2`\b\3\2\2\2ab\7g\2\2bc\7n\2\2cd\7u\2\2de\7g\2\2e\n\3\2\2\2fg\7t\2"+
		"\2gh\7g\2\2hi\7v\2\2ij\7w\2\2jk\7t\2\2kl\7p\2\2l\f\3\2\2\2mn\7u\2\2no"+
		"\7v\2\2op\7t\2\2pq\7w\2\2qr\7e\2\2rs\7v\2\2s\16\3\2\2\2tu\7*\2\2u\20\3"+
		"\2\2\2vw\7+\2\2w\22\3\2\2\2xy\7]\2\2y\24\3\2\2\2z{\7_\2\2{\26\3\2\2\2"+
		"|}\7}\2\2}\30\3\2\2\2~\177\7\177\2\2\177\32\3\2\2\2\u0080\u0081\7>\2\2"+
		"\u0081\34\3\2\2\2\u0082\u0083\7>\2\2\u0083\u0084\7?\2\2\u0084\36\3\2\2"+
		"\2\u0085\u0086\7@\2\2\u0086 \3\2\2\2\u0087\u0088\7@\2\2\u0088\u0089\7"+
		"?\2\2\u0089\"\3\2\2\2\u008a\u008b\7>\2\2\u008b\u008c\7>\2\2\u008c$\3\2"+
		"\2\2\u008d\u008e\7@\2\2\u008e\u008f\7@\2\2\u008f&\3\2\2\2\u0090\u0091"+
		"\7-\2\2\u0091(\3\2\2\2\u0092\u0093\7/\2\2\u0093*\3\2\2\2\u0094\u0095\7"+
		"(\2\2\u0095,\3\2\2\2\u0096\u0097\7~\2\2\u0097.\3\2\2\2\u0098\u0099\7("+
		"\2\2\u0099\u009a\7(\2\2\u009a\60\3\2\2\2\u009b\u009c\7~\2\2\u009c\u009d"+
		"\7~\2\2\u009d\62\3\2\2\2\u009e\u009f\7`\2\2\u009f\64\3\2\2\2\u00a0\u00a1"+
		"\7#\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7\u0080\2\2\u00a38\3\2\2\2\u00a4"+
		"\u00a5\7A\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7<\2\2\u00a7<\3\2\2\2\u00a8\u00a9"+
		"\7=\2\2\u00a9>\3\2\2\2\u00aa\u00ab\7.\2\2\u00ab@\3\2\2\2\u00ac\u00ad\7"+
		"?\2\2\u00adB\3\2\2\2\u00ae\u00af\7?\2\2\u00af\u00b0\7?\2\2\u00b0D\3\2"+
		"\2\2\u00b1\u00b2\7#\2\2\u00b2\u00b3\7?\2\2\u00b3F\3\2\2\2\u00b4\u00b8"+
		"\t\2\2\2\u00b5\u00b7\t\3\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9H\3\2\2\2\u00ba\u00b8\3\2\2\2"+
		"\u00bb\u00bf\t\4\2\2\u00bc\u00be\t\5\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c4\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c4\7\62\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c2\3"+
		"\2\2\2\u00c4J\3\2\2\2\u00c5\u00c7\t\6\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8"+
		"\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\b&\2\2\u00cbL\3\2\2\2\u00cc\u00ce\7\17\2\2\u00cd\u00cf\7\f\2\2"+
		"\u00ce\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00d2"+
		"\7\f\2\2\u00d1\u00cc\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\b\'\2\2\u00d4N\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\7,\2\2"+
		"\u00d7\u00db\3\2\2\2\u00d8\u00da\13\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00df\7,\2\2\u00df\u00e0\7\61\2\2\u00e0\u00e1\3\2"+
		"\2\2\u00e1\u00e2\b(\2\2\u00e2P\3\2\2\2\u00e3\u00e4\7\61\2\2\u00e4\u00e5"+
		"\7\61\2\2\u00e5\u00e9\3\2\2\2\u00e6\u00e8\n\7\2\2\u00e7\u00e6\3\2\2\2"+
		"\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b)\2\2\u00edR\3\2\2\2\13\2\u00b8"+
		"\u00bf\u00c3\u00c8\u00ce\u00d1\u00db\u00e9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}