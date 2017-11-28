package edu.wwu.cptr.lexer;

public class Token {
    private int tokenId;
    private String tokenLexeme;

    public Token(int id, String lexeme) {
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
