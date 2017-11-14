import java.util.HashMap;
import java.util.Map;

class IdMap {
    private Map<String, Integer> id;

    IdMap() {
        id = new HashMap<>();

        // ids
        id.put("T_ASSIGN", 45);
        id.put("T_BOOLEAN", 36);
        id.put("T_STR_LITERAL", 69);
        id.put("T_PLUS", 61);
        id.put("T_BAR", 46);
        id.put("T_EXIT", 12);
        id.put("T_RBRACKET", 63);
        id.put("T_INT_LITERAL", 72);
        id.put("T_ARROW", 44);
        id.put("T_IS", 17);
        id.put("T_LBRACE", 54);
        id.put("T_TYPE", 31);
        id.put("T_STAR", 68);
        id.put("T_IN", 16);
        id.put("T_LT", 57);
        id.put("T_LPAREN", 56);
        id.put("T_LOOP", 18);
        id.put("T_THEN", 29);
        id.put("T_BY", 4);
        id.put("T_REAL_LITERAL", 73);
        id.put("T_LTE", 58);
        id.put("T_TRUE", 42);
        id.put("T_IF", 14);
        id.put("T_WITH", 35);
        id.put("T_RETURN", 28);
        id.put("T_MOD", 19);
        id.put("T_ID", 74);
        id.put("T_ELSIF", 10);
        id.put("T_PROCEDURE", 25);
        id.put("T_OR", 23);
        id.put("T_SEMI", 65);
        id.put("T_CONST", 6);
        id.put("T_DOTDOT", 49);
        id.put("T_CHAR_LITERAL", 70);
        id.put("T_ELSE", 9);
        id.put("T_EOF", 71);
        id.put("T_INTEGER", 39);
        id.put("T_ARRAY", 2);
        id.put("T_OF", 22);
        id.put("T_IMPORT", 15);
        id.put("T_BEGIN", 3);
        id.put("T_UNTIL", 32);
        id.put("T_WHILE", 34);
        id.put("T_RBRACE", 62);
        id.put("T_REPEAT", 27);
        id.put("T_POINTER", 24);
        id.put("T_NIL", 21);
        id.put("T_MODULE", 20);
        id.put("T_RPAREN", 64);
        id.put("T_DIV", 7);
        id.put("error", 1);
        id.put("T_AMPERSAND", 43);
        id.put("T_EQU", 51);
        id.put("T_FALSE", 38);
        id.put("T_COLON", 47);
        id.put("T_NEW", 40);
        id.put("T_LBRACKET", 55);
        id.put("T_SLASH", 67);
        id.put("T_NEQ", 60);
        id.put("T_END", 11);
        id.put("T_DO", 8);
        id.put("T_CHAR", 37);
        id.put("T_TILDE", 66);
        id.put("T_GT", 52);
        id.put("T_FOR", 13);
        id.put("T_DOT", 50);
        id.put("T_MINUS", 59);
        id.put("T_RECORD", 26);
        id.put("T_VAR", 33);
        id.put("T_TO", 30);
        id.put("T_GTE", 53);
        id.put("T_COMMA", 48);
        id.put("T_REAL", 41);
        id.put("T_CASE", 5);
    }

    boolean isToken(String p) {
        return id.containsKey(p);
    }

    int getId(String p) {
        if(id.containsKey(p)) {
            return id.get(p);
        }
        return -1;
    }
}
