package lexerparser;

import edu.wwu.cptr.lexerparser.LexerParser;
import edu.wwu.cptr.lexerparser.IdMap;
import edu.wwu.cptr.lexerparser.Token;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LexerParserTest {
    private LexerParser lex;
    private IdMap id;

    @Before
    public void setUp() {
        id = new IdMap();
    }

    @Test
    public void testLexerPuncOneLong() {
        lex = new LexerParser("src/test_texts/testPuncOneLong.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("&", t1.getLexeme());
        Assert.assertEquals(id.getId("T_AMPERSAND"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("^", t2.getLexeme());
        Assert.assertEquals(id.getId("T_ARROW"), t2.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("|", t3.getLexeme());
        Assert.assertEquals(id.getId("T_BAR"), t3.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals(":", t4.getLexeme());
        Assert.assertEquals(id.getId("T_COLON"), t4.getType());

        Token t5 = lex.getToken();
        Assert.assertEquals(",", t5.getLexeme());
        Assert.assertEquals(id.getId("T_COMMA"), t5.getType());

        Token t6 = lex.getToken();
        Assert.assertEquals(".", t6.getLexeme());
        Assert.assertEquals(id.getId("T_DOT"), t6.getType());

        Token t7 = lex.getToken();
        Assert.assertEquals("=", t7.getLexeme());
        Assert.assertEquals(id.getId("T_EQU"), t7.getType());

        Token t8 = lex.getToken();
        Assert.assertEquals(">", t8.getLexeme());
        Assert.assertEquals(id.getId("T_GT"), t8.getType());

        Token t9 = lex.getToken();
        Assert.assertEquals("{", t9.getLexeme());
        Assert.assertEquals(id.getId("T_LBRACE"), t9.getType());

        Token t10 = lex.getToken();
        Assert.assertEquals("[", t10.getLexeme());
        Assert.assertEquals(id.getId("T_LBRACKET"), t10.getType());

        Token t11 = lex.getToken();
        Assert.assertEquals("(", t11.getLexeme());
        Assert.assertEquals(id.getId("T_LPAREN"), t11.getType());

        Token t12 = lex.getToken();
        Assert.assertEquals("<", t12.getLexeme());
        Assert.assertEquals(id.getId("T_LT"), t12.getType());

        Token t13 = lex.getToken();
        Assert.assertEquals("-", t13.getLexeme());
        Assert.assertEquals(id.getId("T_MINUS"), t13.getType());

        Token t14 = lex.getToken();
        Assert.assertEquals("#", t14.getLexeme());
        Assert.assertEquals(id.getId("T_NEQ"), t14.getType());

        Token t15 = lex.getToken();
        Assert.assertEquals("+", t15.getLexeme());
        Assert.assertEquals(id.getId("T_PLUS"), t15.getType());

        Token t16 = lex.getToken();
        Assert.assertEquals("}", t16.getLexeme());
        Assert.assertEquals(id.getId("T_RBRACE"), t16.getType());

        Token t17 = lex.getToken();
        Assert.assertEquals("]", t17.getLexeme());
        Assert.assertEquals(id.getId("T_RBRACKET"), t17.getType());

        Token t18 = lex.getToken();
        Assert.assertEquals(")", t18.getLexeme());
        Assert.assertEquals(id.getId("T_RPAREN"), t18.getType());

        Token t19 = lex.getToken();
        Assert.assertEquals(";", t19.getLexeme());
        Assert.assertEquals(id.getId("T_SEMI"), t19.getType());

        Token t20 = lex.getToken();
        Assert.assertEquals("~", t20.getLexeme());
        Assert.assertEquals(id.getId("T_TILDE"), t20.getType());

        Token t21 = lex.getToken();
        Assert.assertEquals("/", t21.getLexeme());
        Assert.assertEquals(id.getId("T_SLASH"), t21.getType());

        Token t22 = lex.getToken();
        Assert.assertEquals("*", t22.getLexeme());
        Assert.assertEquals(id.getId("T_STAR"), t22.getType());
    }

    @Test
    public void testLexerPuncTwoLong() {
        lex = new LexerParser("src/test_texts/testPuncTwoLong.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals(":=", t1.getLexeme());
        Assert.assertEquals(id.getId("T_ASSIGN"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("..", t2.getLexeme());
        Assert.assertEquals(id.getId("T_DOTDOT"), t2.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals(">=", t3.getLexeme());
        Assert.assertEquals(id.getId("T_GTE"), t3.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("<=", t4.getLexeme());
        Assert.assertEquals(id.getId("T_LTE"), t4.getType());
    }

    @Test
    public void testLexerKeyword() {
        lex = new LexerParser("src/test_texts/testKeywork.txt");
        lex.lexer();
        Token t1 = lex.getToken();
        Assert.assertEquals("MODULE", t1.getLexeme());
        Assert.assertEquals(id.getId("T_MODULE"), t1.getType());
    }

    @Test
    public void testLexerId() {
        lex = new LexerParser("src/test_texts/testId.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("abcd", t1.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("a123456789a123456789a123456789a123456789", t2.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t2.getType());
    }

    @Test
    public void testLexerIntLiteral() {
        lex = new LexerParser("src/test_texts/testIntLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t1.getType());
        Assert.assertEquals("1234567890", t1.getLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t2.getType());
        Assert.assertEquals("7890ABCDEFH", t2.getLexeme());

        Token t3 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t3.getType());
        Assert.assertEquals("12345", t3.getLexeme());

        Token t4 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t4.getType());
        Assert.assertEquals("ABCDEH", t4.getLexeme());

        Token t5 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t5.getType());
        Assert.assertEquals("1234567890", t5.getLexeme());

        Token t6 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t6.getType());
        Assert.assertEquals("123456789AH", t6.getLexeme());

        Token t7 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t7.getType());
        Assert.assertEquals("ABCH", t7.getLexeme());

        Token t8 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t8.getType());
        Assert.assertEquals("123456789AH", t8.getLexeme());
    }

    @Test
    public void testLexerStrLiteral() {
        lex = new LexerParser("src/test_texts/testStrLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("Hello", t1.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("Hello", t2.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t2.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("Hello, my name is Bob", t3.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t3.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("'Nested 1'", t4.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t4.getType());

        Token t5 = lex.getToken();
        Assert.assertEquals("\"Nested 2\"", t5.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t5.getType());

        Token t6 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t6.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t6.getType());

        Token t7 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t7.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t7.getType());

        Token t8 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t8.getLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t8.getType());
    }

    @Test
    public void testLexerRealLiteral() {
        lex = new LexerParser("src/test_texts/testRealLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t1.getType());
        Assert.assertEquals("1.234", t1.getLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t2.getType());
                Assert.assertEquals("1.234",t2.getLexeme());

                        Token t3 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t3.getType());
                Assert.assertEquals("1.234E123",t3.getLexeme());

                        Token t4 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t4.getType());
                Assert.assertEquals("0.234D123",t4.getLexeme());

                        Token t5 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t5.getType());
                Assert.assertEquals("1.234E123",t5.getLexeme());

                        Token t6 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t6.getType());
                Assert.assertEquals("1234.",t6.getLexeme());

                        Token t7 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t7.getType());
                Assert.assertEquals("1.234E123",t7.getLexeme());

                        Token t8 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t8.getType());
                Assert.assertEquals("0.1234",t8.getLexeme());

                        Token t9 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t9.getType());
                Assert.assertEquals("123.456789",t9.getLexeme());

                        Token t10 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t10.getType());
                Assert.assertEquals("123.456789",t10.getLexeme());

                        Token t11 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t11.getType());
                Assert.assertEquals("123456789.",t11.getLexeme());
    }

    @Test
    public void testLexerCharLiteral() {
        lex = new LexerParser("src/test_texts/testCharLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("ABCX", t1.getLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("123X", t2.getLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("12AX", t3.getLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("12AX", t4.getLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t4.getType());

        Token t5 = lex.getToken();
        Assert.assertEquals("12AX", t5.getLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t5.getType());
    }

    @Test
    public void testLexerUnknownLexeme() {
        lex = new LexerParser("src/test_texts/testUnknownLexeme.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("123xyz", t1.getLexeme());
        Assert.assertEquals(id.getId("error"), t1.getType());
    }

    @Test
    public void testLexerMultiWordLine() {
        lex = new LexerParser("src/test_texts/testMultiWordLine.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("AA", t1.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("BB", t2.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t2.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("CC", t3.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t3.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("DD", t4.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t4.getType());
    }

    @Test
    public void testGetToken() {
        lex = new LexerParser("src/test_texts/testGetToken.txt");
        lex.lexer();
        Token t1 = lex.getToken();
        Assert.assertEquals("abc", t1.getLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getType());
    }
}
