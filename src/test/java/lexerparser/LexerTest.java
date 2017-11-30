package lexerparser;

import edu.wwu.cptr.lexer.Lexer;
import edu.wwu.cptr.lexer.IdMap;
import edu.wwu.cptr.lexer.LexerToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LexerTest {
    private Lexer lex;
    private IdMap id;

    @Before
    public void setUp() {
        id = new IdMap();
    }

    @Test
    public void testLexerPuncOneLong() {
        lex = new Lexer("src/test_texts/testPuncOneLong.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("&", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_AMPERSAND"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("^", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ARROW"), t2.getTokenId());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals("|", t3.getTokenLexeme());
        Assert.assertEquals(id.getId("T_BAR"), t3.getTokenId());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals(":", t4.getTokenLexeme());
        Assert.assertEquals(id.getId("T_COLON"), t4.getTokenId());

        LexerToken t5 = lex.getToken();
        Assert.assertEquals(",", t5.getTokenLexeme());
        Assert.assertEquals(id.getId("T_COMMA"), t5.getTokenId());

        LexerToken t6 = lex.getToken();
        Assert.assertEquals(".", t6.getTokenLexeme());
        Assert.assertEquals(id.getId("T_DOT"), t6.getTokenId());

        LexerToken t7 = lex.getToken();
        Assert.assertEquals("=", t7.getTokenLexeme());
        Assert.assertEquals(id.getId("T_EQU"), t7.getTokenId());

        LexerToken t8 = lex.getToken();
        Assert.assertEquals(">", t8.getTokenLexeme());
        Assert.assertEquals(id.getId("T_GT"), t8.getTokenId());

        LexerToken t9 = lex.getToken();
        Assert.assertEquals("{", t9.getTokenLexeme());
        Assert.assertEquals(id.getId("T_LBRACE"), t9.getTokenId());

        LexerToken t10 = lex.getToken();
        Assert.assertEquals("[", t10.getTokenLexeme());
        Assert.assertEquals(id.getId("T_LBRACKET"), t10.getTokenId());

        LexerToken t11 = lex.getToken();
        Assert.assertEquals("(", t11.getTokenLexeme());
        Assert.assertEquals(id.getId("T_LPAREN"), t11.getTokenId());

        LexerToken t12 = lex.getToken();
        Assert.assertEquals("<", t12.getTokenLexeme());
        Assert.assertEquals(id.getId("T_LT"), t12.getTokenId());

        LexerToken t13 = lex.getToken();
        Assert.assertEquals("-", t13.getTokenLexeme());
        Assert.assertEquals(id.getId("T_MINUS"), t13.getTokenId());

        LexerToken t14 = lex.getToken();
        Assert.assertEquals("#", t14.getTokenLexeme());
        Assert.assertEquals(id.getId("T_NEQ"), t14.getTokenId());

        LexerToken t15 = lex.getToken();
        Assert.assertEquals("+", t15.getTokenLexeme());
        Assert.assertEquals(id.getId("T_PLUS"), t15.getTokenId());

        LexerToken t16 = lex.getToken();
        Assert.assertEquals("}", t16.getTokenLexeme());
        Assert.assertEquals(id.getId("T_RBRACE"), t16.getTokenId());

        LexerToken t17 = lex.getToken();
        Assert.assertEquals("]", t17.getTokenLexeme());
        Assert.assertEquals(id.getId("T_RBRACKET"), t17.getTokenId());

        LexerToken t18 = lex.getToken();
        Assert.assertEquals(")", t18.getTokenLexeme());
        Assert.assertEquals(id.getId("T_RPAREN"), t18.getTokenId());

        LexerToken t19 = lex.getToken();
        Assert.assertEquals(";", t19.getTokenLexeme());
        Assert.assertEquals(id.getId("T_SEMI"), t19.getTokenId());

        LexerToken t20 = lex.getToken();
        Assert.assertEquals("~", t20.getTokenLexeme());
        Assert.assertEquals(id.getId("T_TILDE"), t20.getTokenId());

        LexerToken t21 = lex.getToken();
        Assert.assertEquals("/", t21.getTokenLexeme());
        Assert.assertEquals(id.getId("T_SLASH"), t21.getTokenId());

        LexerToken t22 = lex.getToken();
        Assert.assertEquals("*", t22.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STAR"), t22.getTokenId());
    }

    @Test
    public void testLexerPuncTwoLong() {
        lex = new Lexer("src/test_texts/testPuncTwoLong.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals(":=", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ASSIGN"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("..", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_DOTDOT"), t2.getTokenId());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals(">=", t3.getTokenLexeme());
        Assert.assertEquals(id.getId("T_GTE"), t3.getTokenId());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals("<=", t4.getTokenLexeme());
        Assert.assertEquals(id.getId("T_LTE"), t4.getTokenId());
    }

    @Test
    public void testLexerKeyword() {
        lex = new Lexer("src/test_texts/testKeywork.txt");
        lex.lexer();
        LexerToken t1 = lex.getToken();
        Assert.assertEquals("MODULE", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_MODULE"), t1.getTokenId());
    }

    @Test
    public void testLexerId() {
        lex = new Lexer("src/test_texts/testId.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("abcd", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("a123456789a123456789a123456789a123456789", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t2.getTokenId());
    }

    @Test
    public void testLexerIntLiteral() {
        lex = new Lexer("src/test_texts/testIntLiteral.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t1.getTokenId());
        Assert.assertEquals("1234567890", t1.getTokenLexeme());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t2.getTokenId());
        Assert.assertEquals("7890ABCDEFH", t2.getTokenLexeme());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t3.getTokenId());
        Assert.assertEquals("12345", t3.getTokenLexeme());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t4.getTokenId());
        Assert.assertEquals("ABCDEH", t4.getTokenLexeme());

        LexerToken t5 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t5.getTokenId());
        Assert.assertEquals("1234567890", t5.getTokenLexeme());

        LexerToken t6 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t6.getTokenId());
        Assert.assertEquals("123456789AH", t6.getTokenLexeme());

        LexerToken t7 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t7.getTokenId());
        Assert.assertEquals("ABCH", t7.getTokenLexeme());

        LexerToken t8 = lex.getToken();
        Assert.assertEquals(id.getId("T_INT_LITERAL"), t8.getTokenId());
        Assert.assertEquals("123456789AH", t8.getTokenLexeme());
    }

    @Test
    public void testLexerStrLiteral() {
        lex = new Lexer("src/test_texts/testStrLiteral.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("Hello", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("Hello", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t2.getTokenId());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals("Hello, my name is Bob", t3.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t3.getTokenId());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals("'Nested 1'", t4.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t4.getTokenId());

        LexerToken t5 = lex.getToken();
        Assert.assertEquals("\"Nested 2\"", t5.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t5.getTokenId());

        LexerToken t6 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t6.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t6.getTokenId());

        LexerToken t7 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t7.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t7.getTokenId());

        LexerToken t8 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t8.getTokenLexeme());
        Assert.assertEquals(id.getId("T_STR_LITERAL"), t8.getTokenId());
    }

    @Test
    public void testLexerRealLiteral() {
        lex = new Lexer("src/test_texts/testRealLiteral.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t1.getTokenId());
        Assert.assertEquals("1.234", t1.getTokenLexeme());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t2.getTokenId());
                Assert.assertEquals("1.234",t2.getTokenLexeme());

                        LexerToken t3 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t3.getTokenId());
                Assert.assertEquals("1.234E123",t3.getTokenLexeme());

                        LexerToken t4 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t4.getTokenId());
                Assert.assertEquals("0.234D123",t4.getTokenLexeme());

                        LexerToken t5 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t5.getTokenId());
                Assert.assertEquals("1.234E123",t5.getTokenLexeme());

                        LexerToken t6 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t6.getTokenId());
                Assert.assertEquals("1234.",t6.getTokenLexeme());

                        LexerToken t7 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t7.getTokenId());
                Assert.assertEquals("1.234E123",t7.getTokenLexeme());

                        LexerToken t8 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t8.getTokenId());
                Assert.assertEquals("0.1234",t8.getTokenLexeme());

                        LexerToken t9 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t9.getTokenId());
                Assert.assertEquals("123.456789",t9.getTokenLexeme());

                        LexerToken t10 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t10.getTokenId());
                Assert.assertEquals("123.456789",t10.getTokenLexeme());

                        LexerToken t11 = lex.getToken();
        Assert.assertEquals(id.getId("T_REAL_LITERAL"), t11.getTokenId());
                Assert.assertEquals("123456789.",t11.getTokenLexeme());
    }

    @Test
    public void testLexerCharLiteral() {
        lex = new Lexer("src/test_texts/testCharLiteral.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("ABCX", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("123X", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getTokenId());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals("12AX", t3.getTokenLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t1.getTokenId());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals("12AX", t4.getTokenLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t4.getTokenId());

        LexerToken t5 = lex.getToken();
        Assert.assertEquals("12AX", t5.getTokenLexeme());
        Assert.assertEquals(id.getId("T_CHAR_LITERAL"), t5.getTokenId());
    }

    @Test
    public void testLexerUnknownLexeme() {
        lex = new Lexer("src/test_texts/testUnknownLexeme.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("123xyz", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("error"), t1.getTokenId());
    }

    @Test
    public void testLexerMultiWordLine() {
        lex = new Lexer("src/test_texts/testMultiWordLine.txt");
        lex.lexer();

        LexerToken t1 = lex.getToken();
        Assert.assertEquals("AA", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getTokenId());

        LexerToken t2 = lex.getToken();
        Assert.assertEquals("BB", t2.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t2.getTokenId());

        LexerToken t3 = lex.getToken();
        Assert.assertEquals("CC", t3.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t3.getTokenId());

        LexerToken t4 = lex.getToken();
        Assert.assertEquals("DD", t4.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t4.getTokenId());
    }

    @Test
    public void testGetToken() {
        lex = new Lexer("src/test_texts/testGetToken.txt");
        lex.lexer();
        LexerToken t1 = lex.getToken();
        Assert.assertEquals("abc", t1.getTokenLexeme());
        Assert.assertEquals(id.getId("T_ID"), t1.getTokenId());
    }

    @Test
    public void testSampleText() {
        lex = new Lexer("src/test_texts/testSample.txt");
        lex.lexer();
        String tokenLexeme = "";
        while(!tokenLexeme.equals("EOF")) {
            tokenLexeme = lex.getToken().getTokenLexeme();
            System.out.println(tokenLexeme);
        }
    }
}
