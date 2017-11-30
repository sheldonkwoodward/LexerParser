package edu.wwu.cptr.lexer;

public class LexerToken {
    private int tokenId;
    private String tokenLexeme;

    public LexerToken(int id, String lexeme) {
        tokenId = id;
        tokenLexeme = lexeme;
    }

    public String getTokenLexeme() {
        return (tokenLexeme);
    }

    public int getTokenId() {
        return (tokenId);
    }
}
