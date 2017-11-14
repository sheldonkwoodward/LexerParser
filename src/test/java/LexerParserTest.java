import org.junit.Assert;
import org.junit.Test;

public class LexerParserTest {
    private LexerParser lex;

    @Test
    public void testPunc() {
        lex = new LexerParser("src/test_texts/testPunc.txt");
        lex.tokenize();
        Token t1 = lex.getToken();
        Assert.assertEquals("*", t1.GetLexeme());
        Assert.assertEquals(Sym.T_STAR, t1.GetType());
    }

    @Test
    public void testKeyword() {
        lex = new LexerParser("src/test_texts/testKeywork.txt");
        lex.tokenize();
        Token t1 = lex.getToken();
        Assert.assertEquals("MODULE", t1.GetLexeme());
        Assert.assertEquals(Sym.T_MODULE, t1.GetType());
    }

    @Test
    public void testId() {
        lex = new LexerParser("src/test_texts/testId.txt");
        lex.tokenize();

        Token t1 = lex.getToken();
        Assert.assertEquals("abcd", t1.GetLexeme());
        Assert.assertEquals(Sym.T_ID, t1.GetType());

        Token t2 = lex.getToken();
        Assert.assertEquals("a123456789a123456789a123456789a123456789", t2.GetLexeme());
        Assert.assertEquals(Sym.T_ID, t2.GetType());
    }

    @Test
    public void testIntLiteral() {
        lex = new LexerParser("src/test_texts/testIntLiteral.txt");
        lex.tokenize();

        Token t1 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t1.GetType());
        Assert.assertEquals("1234567890", t1.GetLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t2.GetType());
        Assert.assertEquals("7890ABCDEFH", t2.GetLexeme());

        Token t3 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t3.GetType());
        Assert.assertEquals("12345", t3.GetLexeme());

        Token t4 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t4.GetType());
        Assert.assertEquals("ABCDEH", t4.GetLexeme());

        Token t5 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t5.GetType());
        Assert.assertEquals("1234567890", t5.GetLexeme());

        Token t6 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t6.GetType());
        Assert.assertEquals("123456789AH", t6.GetLexeme());

        Token t7 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t7.GetType());
        Assert.assertEquals("ABCH", t7.GetLexeme());

        Token t8 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t8.GetType());
        Assert.assertEquals("123456789AH", t8.GetLexeme());
    }

    @Test
    public void testStrLiteral() {
        lex = new LexerParser("src/test_texts/testStrLiteral.txt");
        lex.tokenize();

        Token t1 = lex.getToken();
        Assert.assertEquals("Hello", t1.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t1.GetType());

        Token t2 = lex.getToken();
        Assert.assertEquals("Hello", t2.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t2.GetType());

        Token t3 = lex.getToken();
        Assert.assertEquals("Hello, my name is Bob", t3.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t3.GetType());

        Token t4 = lex.getToken();
        Assert.assertEquals("'Nested 1'", t4.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t4.GetType());

        Token t5 = lex.getToken();
        Assert.assertEquals("\"Nested 2\"", t5.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t5.GetType());

        Token t6 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t6.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t6.GetType());

        Token t7 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t7.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t7.GetType());

        Token t8 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t8.GetLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t8.GetType());
    }

    @Test
    public void testRealLiteral() {
        lex = new LexerParser("src/test_texts/testRealLiteral.txt");
        lex.tokenize();

        Token t1 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t1.GetType());
        Assert.assertEquals("1.234", t1.GetLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t2.GetType());
        Assert.assertEquals("1.234", t2.GetLexeme());

        Token t3 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t3.GetType());
        Assert.assertEquals("1.234E123", t3.GetLexeme());

        Token t4 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t4.GetType());
        Assert.assertEquals("0.234D123", t4.GetLexeme());

        Token t5 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t5.GetType());
        Assert.assertEquals("1.234E123", t5.GetLexeme());

        Token t6 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t6.GetType());
        Assert.assertEquals("1234.", t6.GetLexeme());

        Token t7 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t7.GetType());
        Assert.assertEquals("1.234E123", t7.GetLexeme());

        Token t8 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t8.GetType());
        Assert.assertEquals("0.1234", t8.GetLexeme());

        Token t9 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t9.GetType());
        Assert.assertEquals("123.456789", t9.GetLexeme());

        Token t10 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t10.GetType());
        Assert.assertEquals("123.456789", t10.GetLexeme());

        Token t11 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t11.GetType());
        Assert.assertEquals("123456789.", t11.GetLexeme());
    }

    @Test
    public void testCharLiteral() {
        lex = new LexerParser("src/test_texts/testCharLiteral.txt");
        lex.tokenize();

        Token t1 = lex.getToken();
        Assert.assertEquals("ABCX", t1.GetLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.GetType());

        Token t2 = lex.getToken();
        Assert.assertEquals("123X", t2.GetLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.GetType());

        Token t3 = lex.getToken();
        Assert.assertEquals("12AX", t3.GetLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.GetType());

        Token t4 = lex.getToken();
        Assert.assertEquals("12AX", t4.GetLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t4.GetType());

        Token t5 = lex.getToken();
        Assert.assertEquals("12AX", t5.GetLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t5.GetType());
    }

    @Test
    public void testSample() {
        lex = new LexerParser("src/test_texts/testSample.txt");
        lex.tokenize();
    }

    @Test
    public void testGetToken() {
        lex = new LexerParser("src/test_texts/testGetToken.txt");
        lex.tokenize();
        Token t1 = lex.getToken();
        Assert.assertEquals("abc", t1.GetLexeme());
        Assert.assertEquals(Sym.T_ID, t1.GetType());
    }
}
