package edu.wwu.cptr.lexer;

import java.util.HashMap;
import java.util.Map;

class KeywordMap {
    private Map<String, String> keyword;

    public KeywordMap() {
        keyword = new HashMap<>();

        // standard tokens
        keyword.put("ARRAY", "T_ARRAY");
        keyword.put("BEGIN", "T_BEGIN");
        keyword.put("BY", "T_BY");
        keyword.put("CASE", "T_CASE");
        keyword.put("CONST", "T_CONST");
        keyword.put("DIV", "T_DIV");
        keyword.put("DO", "T_DO");
        keyword.put("ELSE", "T_ELSE");
        keyword.put("ELSIF", "T_ELSIF");
        keyword.put("END", "T_END");
        keyword.put("EXIT", "T_EXIT");
        keyword.put("FOR", "T_FOR");
        keyword.put("IF", "T_IF");
        keyword.put("IMPORT", "T_IMPORT");
        keyword.put("IN", "T_IN");
        keyword.put("IS", "T_IS");
        keyword.put("LOOP", "T_LOOP");
        keyword.put("MOD", "T_MOD");
        keyword.put("MODULE", "T_MODULE");
        keyword.put("NIL", "T_NIL");
        keyword.put("OF", "T_OF");
        keyword.put("OR", "T_OR");
        keyword.put("POINTER", "T_POINTER");
        keyword.put("PROCEDURE", "T_PROCEDURE");
        keyword.put("RECORD", "T_RECORD");
        keyword.put("REPEAT", "T_REPEAT");
        keyword.put("RETURN", "T_RETURN");
        keyword.put("THEN", "T_THEN");
        keyword.put("TO", "T_TO");
        keyword.put("TYPE", "T_TYPE");
        keyword.put("UNTIL", "T_UNTIL");
        keyword.put("VAR", "T_VAR");
        keyword.put("WHILE", "T_WHILE");
        keyword.put("WITH", "T_WITH");
        keyword.put("EOF", "T_EOF");
    }

    public boolean isKeyword(String kw) {
        return keyword.containsKey(kw);
    }

    public String getToken(String kw) {
        if(keyword.containsKey(kw)) {
            return keyword.get(kw);
        }
        return kw;
    }
}
