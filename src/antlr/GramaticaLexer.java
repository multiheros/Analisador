// Generated from C:\Analisador\src\antlr\Gramatica.g4 by ANTLR 4.10.1

    package antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GramaticaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, TIPO=5, ID=6, WS=7, NUM=8, STR=9, True=10, 
		False=11, BOL=12, OPERADOR=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "TIPO", "ID", "WS", "NUM", "STR", "True", 
			"False", "BOL", "OPERADOR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':declaracao'", "';'", "':programa'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "TIPO", "ID", "WS", "NUM", "STR", "True", 
			"False", "BOL", "OPERADOR"
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


	public GramaticaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Gramatica.g4"; }

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
		"\u0004\u0000\r}\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004H\b"+
		"\u0004\u0001\u0005\u0004\u0005K\b\u0005\u000b\u0005\f\u0005L\u0001\u0005"+
		"\u0005\u0005P\b\u0005\n\u0005\f\u0005S\t\u0005\u0003\u0005U\b\u0005\u0001"+
		"\u0006\u0004\u0006X\b\u0006\u000b\u0006\f\u0006Y\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0004\u0007_\b\u0007\u000b\u0007\f\u0007`\u0001\u0007\u0001"+
		"\u0007\u0004\u0007e\b\u0007\u000b\u0007\f\u0007f\u0003\u0007i\b\u0007"+
		"\u0001\b\u0001\b\u0005\bm\b\b\n\b\f\bp\t\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003\u000bz\b\u000b\u0001"+
		"\f\u0001\f\u0001n\u0000\r\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u0001\u0000\b\u0002\u0000AZaz\u0003\u000009AZaz\u0003\u0000"+
		"\t\n\r\r  \u0001\u000009\u0001\u0000\"\"\u0001\u000011\u0001\u000000\u0005"+
		"\u0000*+--//<<>>\u0088\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000"+
		"\u0000\u0000\u0003\'\u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000"+
		"\u0000\u00073\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000\u000b"+
		"J\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000\u000f^\u0001\u0000"+
		"\u0000\u0000\u0011j\u0001\u0000\u0000\u0000\u0013s\u0001\u0000\u0000\u0000"+
		"\u0015u\u0001\u0000\u0000\u0000\u0017y\u0001\u0000\u0000\u0000\u0019{"+
		"\u0001\u0000\u0000\u0000\u001b\u001c\u0005:\u0000\u0000\u001c\u001d\u0005"+
		"d\u0000\u0000\u001d\u001e\u0005e\u0000\u0000\u001e\u001f\u0005c\u0000"+
		"\u0000\u001f \u0005l\u0000\u0000 !\u0005a\u0000\u0000!\"\u0005r\u0000"+
		"\u0000\"#\u0005a\u0000\u0000#$\u0005c\u0000\u0000$%\u0005a\u0000\u0000"+
		"%&\u0005o\u0000\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005;\u0000\u0000"+
		"(\u0004\u0001\u0000\u0000\u0000)*\u0005:\u0000\u0000*+\u0005p\u0000\u0000"+
		"+,\u0005r\u0000\u0000,-\u0005o\u0000\u0000-.\u0005g\u0000\u0000./\u0005"+
		"r\u0000\u0000/0\u0005a\u0000\u000001\u0005m\u0000\u000012\u0005a\u0000"+
		"\u00002\u0006\u0001\u0000\u0000\u000034\u0005=\u0000\u00004\b\u0001\u0000"+
		"\u0000\u000056\u0005i\u0000\u000067\u0005n\u0000\u00007H\u0005t\u0000"+
		"\u000089\u0005f\u0000\u00009:\u0005l\u0000\u0000:;\u0005o\u0000\u0000"+
		";<\u0005a\u0000\u0000<H\u0005t\u0000\u0000=>\u0005b\u0000\u0000>?\u0005"+
		"o\u0000\u0000?@\u0005o\u0000\u0000@H\u0005l\u0000\u0000AB\u0005s\u0000"+
		"\u0000BC\u0005t\u0000\u0000CD\u0005r\u0000\u0000DE\u0005i\u0000\u0000"+
		"EF\u0005n\u0000\u0000FH\u0005g\u0000\u0000G5\u0001\u0000\u0000\u0000G"+
		"8\u0001\u0000\u0000\u0000G=\u0001\u0000\u0000\u0000GA\u0001\u0000\u0000"+
		"\u0000H\n\u0001\u0000\u0000\u0000IK\u0007\u0000\u0000\u0000JI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MT\u0001\u0000\u0000\u0000NP\u0007\u0001\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TQ\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000U\f\u0001"+
		"\u0000\u0000\u0000VX\u0007\u0002\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[\\\u0006\u0006\u0000\u0000\\\u000e\u0001"+
		"\u0000\u0000\u0000]_\u0007\u0003\u0000\u0000^]\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000ah\u0001\u0000\u0000\u0000bd\u0005.\u0000\u0000ce\u0007\u0003\u0000"+
		"\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001\u0000"+
		"\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hb\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000i\u0010\u0001\u0000\u0000"+
		"\u0000jn\u0005\"\u0000\u0000km\b\u0004\u0000\u0000lk\u0001\u0000\u0000"+
		"\u0000mp\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000nl\u0001\u0000"+
		"\u0000\u0000oq\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005"+
		"\"\u0000\u0000r\u0012\u0001\u0000\u0000\u0000st\u0007\u0005\u0000\u0000"+
		"t\u0014\u0001\u0000\u0000\u0000uv\u0007\u0006\u0000\u0000v\u0016\u0001"+
		"\u0000\u0000\u0000wz\u0003\u0013\t\u0000xz\u0003\u0015\n\u0000yw\u0001"+
		"\u0000\u0000\u0000yx\u0001\u0000\u0000\u0000z\u0018\u0001\u0000\u0000"+
		"\u0000{|\u0007\u0007\u0000\u0000|\u001a\u0001\u0000\u0000\u0000\u000b"+
		"\u0000GLQTY`fhny\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}