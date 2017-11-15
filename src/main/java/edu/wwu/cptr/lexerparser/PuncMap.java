package edu.wwu.cptr.lexerparser;

import java.util.HashMap;
import java.util.Map;

public class PuncMap {
    private Map<String, String> punc;

    public PuncMap() {
        punc = new HashMap<>();

        // standard tokens
        punc.put("&", "T_AMPERSAND");
        punc.put("^", "T_ARROW");
        punc.put(":=", "T_ASSIGN");
        punc.put("|", "T_BAR");
        punc.put(":", "T_COLON");
        punc.put(",", "T_COMMA");
        punc.put("..", "T_DOTDOT");
        punc.put(".", "T_DOT");
        punc.put("=", "T_EQU");
        punc.put(">", "T_GT");
        punc.put(">=", "T_GTE");
        punc.put("{", "T_LBRACE");
        punc.put("[", "T_LBRACKET");
        punc.put("(", "T_LPAREN");
        punc.put("<", "T_LT");
        punc.put("<=", "T_LTE");
        punc.put("-", "T_MINUS");
        punc.put("#", "T_NEQ");
        punc.put("+", "T_PLUS");
        punc.put("}", "T_RBRACE");
        punc.put("]", "T_RBRACKET");
        punc.put(")", "T_RPAREN");
        punc.put(";", "T_SEMI");
        punc.put("~", "T_TILDE");
        punc.put("/", "T_SLASH");
        punc.put("*", "T_STAR");

        // string quotes
        punc.put("\"", "T_QUOTATION");
        punc.put("'", "T_APOSTROPHE");
    }

    public boolean isPunc(String p) {
        return punc.containsKey(p);
    }

    public boolean isPunc(char p) {
        return punc.containsKey(Character.toString(p));
    }

    public String getToken(String p) {
        if(punc.containsKey(p)) {
            return punc.get(p);
        }
        return p;
    }

    public String getToken(char p) {
        if(punc.containsKey(Character.toString(p))) {
            return punc.get(Character.toString(p));
        }
        return Character.toString(p);
    }
}
