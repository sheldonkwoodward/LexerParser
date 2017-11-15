package edu.wwu.cptr.lexerparser;

public class Token {
    private int m_nType;
    private String m_strLexeme;

    public Token(int nType, String strLexeme) {
        m_nType = nType;
        m_strLexeme = strLexeme;
    }

    public String getLexeme() {
        return (m_strLexeme);
    }

    public int getType() {
        return (m_nType);
    }
}
