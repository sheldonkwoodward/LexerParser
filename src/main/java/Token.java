public class Token {
    private int m_nType;
    private String m_strLexeme;

    Token(int nType, String strLexeme) {
        m_nType = nType;
        m_strLexeme = strLexeme;
    }

    public String GetLexeme() {
        return (m_strLexeme);
    }

    public int GetType() {
        return (m_nType);
    }
}
