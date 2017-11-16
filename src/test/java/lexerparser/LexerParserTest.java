package lexerparser;

import edu.wwu.cptr.lexerparser.LexerParser;
import edu.wwu.cptr.lexerparser.Sym;
import edu.wwu.cptr.lexerparser.Token;
import org.junit.Assert;
import org.junit.Test;

public class LexerParserTest {
    private LexerParser lex;

    @Test
    public void testPunc() {
        lex = new LexerParser("src/test_texts/testPunc.txt");
        lex.lexer();
        Token t1 = lex.getToken();
        Assert.assertEquals("*", t1.getLexeme());
        Assert.assertEquals(Sym.T_STAR, t1.getType());
    }

    @Test
    public void testKeyword() {
        lex = new LexerParser("src/test_texts/testKeywork.txt");
        lex.lexer();
        Token t1 = lex.getToken();
        Assert.assertEquals("MODULE", t1.getLexeme());
        Assert.assertEquals(Sym.T_MODULE, t1.getType());
    }

    @Test
    public void testId() {
        lex = new LexerParser("src/test_texts/testId.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("abcd", t1.getLexeme());
        Assert.assertEquals(Sym.T_ID, t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("a123456789a123456789a123456789a123456789", t2.getLexeme());
        Assert.assertEquals(Sym.T_ID, t2.getType());
    }

    @Test
    public void testIntLiteral() {
        lex = new LexerParser("src/test_texts/testIntLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t1.getType());
        Assert.assertEquals("1234567890", t1.getLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t2.getType());
        Assert.assertEquals("7890ABCDEFH", t2.getLexeme());

        Token t3 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t3.getType());
        Assert.assertEquals("12345", t3.getLexeme());

        Token t4 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t4.getType());
        Assert.assertEquals("ABCDEH", t4.getLexeme());

        Token t5 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t5.getType());
        Assert.assertEquals("1234567890", t5.getLexeme());

        Token t6 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t6.getType());
        Assert.assertEquals("123456789AH", t6.getLexeme());

        Token t7 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t7.getType());
        Assert.assertEquals("ABCH", t7.getLexeme());

        Token t8 = lex.getToken();
        Assert.assertEquals(Sym.T_INT_LITERAL, t8.getType());
        Assert.assertEquals("123456789AH", t8.getLexeme());
    }

    @Test
    public void testStrLiteral() {
        lex = new LexerParser("src/test_texts/testStrLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("Hello", t1.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("Hello", t2.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t2.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("Hello, my name is Bob", t3.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t3.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("'Nested 1'", t4.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t4.getType());

        Token t5 = lex.getToken();
        Assert.assertEquals("\"Nested 2\"", t5.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t5.getType());

        Token t6 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t6.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t6.getType());

        Token t7 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t7.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t7.getType());

        Token t8 = lex.getToken();
        Assert.assertEquals("a123456789b123456789c123456789d123456789e123456789f123456789g123456789h123456789", t8.getLexeme());
        Assert.assertEquals(Sym.T_STR_LITERAL, t8.getType());
    }

    @Test
    public void testRealLiteral() {
        lex = new LexerParser("src/test_texts/testRealLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t1.getType());
        Assert.assertEquals("1.234", t1.getLexeme());

        Token t2 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t2.getType());
        Assert.assertEquals("1.234", t2.getLexeme());

        Token t3 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t3.getType());
        Assert.assertEquals("1.234E123", t3.getLexeme());

        Token t4 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t4.getType());
        Assert.assertEquals("0.234D123", t4.getLexeme());

        Token t5 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t5.getType());
        Assert.assertEquals("1.234E123", t5.getLexeme());

        Token t6 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t6.getType());
        Assert.assertEquals("1234.", t6.getLexeme());

        Token t7 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t7.getType());
        Assert.assertEquals("1.234E123", t7.getLexeme());

        Token t8 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t8.getType());
        Assert.assertEquals("0.1234", t8.getLexeme());

        Token t9 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t9.getType());
        Assert.assertEquals("123.456789", t9.getLexeme());

        Token t10 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t10.getType());
        Assert.assertEquals("123.456789", t10.getLexeme());

        Token t11 = lex.getToken();
        Assert.assertEquals(Sym.T_REAL_LITERAL, t11.getType());
        Assert.assertEquals("123456789.", t11.getLexeme());
    }

    @Test
    public void testCharLiteral() {
        lex = new LexerParser("src/test_texts/testCharLiteral.txt");
        lex.lexer();

        Token t1 = lex.getToken();
        Assert.assertEquals("ABCX", t1.getLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.getType());

        Token t2 = lex.getToken();
        Assert.assertEquals("123X", t2.getLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.getType());

        Token t3 = lex.getToken();
        Assert.assertEquals("12AX", t3.getLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t1.getType());

        Token t4 = lex.getToken();
        Assert.assertEquals("12AX", t4.getLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t4.getType());

        Token t5 = lex.getToken();
        Assert.assertEquals("12AX", t5.getLexeme());
        Assert.assertEquals(Sym.T_CHAR_LITERAL, t5.getType());
    }

    @Test
    public void testGetToken() {
        lex = new LexerParser("src/test_texts/testGetToken.txt");
        lex.lexer();
        Token t1 = lex.getToken();
        Assert.assertEquals("abc", t1.getLexeme());
        Assert.assertEquals(Sym.T_ID, t1.getType());
    }
}
