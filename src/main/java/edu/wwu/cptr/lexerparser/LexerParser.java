package edu.wwu.cptr.lexerparser;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class LexerParser {
    private Scanner file;
    private ArrayList<ArrayList<String>> lexemes;
    private ArrayList<ArrayList<String>> tokenStrings;
    private ArrayList<ArrayList<Token>> tokens;
    private int[] tokenPos;

    private PuncMap pm;
    private KeywordMap km;
    private IdMap im;

    public LexerParser(String sourceFile) {
        // scanner for source file
        try {
            file = new Scanner(new File(sourceFile));
        } catch(java.io.FileNotFoundException e) {
            System.out.println("Source file not found");
        }

        // ArrayList initializations
        lexemes = new ArrayList<>();
        tokenStrings = new ArrayList<>();
        tokens = new ArrayList<>();
        tokenPos = new int[2];
        tokenPos[0] = 0;
        tokenPos[1] = 0;

        // map initializations
        pm = new PuncMap();
        km = new KeywordMap();
        im = new IdMap();

        // split file by word
        while(file.hasNextLine()) {
            Scanner line = new Scanner(file.nextLine());
            if(line.hasNext()) {
                lexemes.add(new ArrayList<>());
            }
            while(line.hasNext()) {
                lexemes.get(lexemes.size() - 1).add(line.next());
            }
        }
    }

    public void lexer() {
        splitPunc();
        combineStrings();

        // convert punctuation and keywords to token strings
        for(ArrayList<String> line : lexemes) {
            tokenStrings.add(new ArrayList<>());
            for(int w = 0; w < line.size(); w++) {

                // punctuation
                if(pm.isPunc(line.get(w))) {
                    tokenStrings.get(tokenStrings.size() - 1).add(pm.getToken(line.get(w)));
                }

                // keyword
                else if(km.isKeyword(line.get(w))) {
                    tokenStrings.get(tokenStrings.size() - 1).add(km.getToken(line.get(w)));
                }

                // T_ID
                else if(line.get(w).matches("([A-Z]|[a-z])([A-Z]|[a-z]|[0-9])+")) {
                    if(!line.get(w).matches("([A-Z]|[a-z])([A-Z]|[a-z]|[0-9]){0,39}")) {
                        System.out.println("identifier too long");
                        line.set(w, line.get(w).substring(0, 40));
                    }
                    tokenStrings.get(tokenStrings.size() - 1).add("T_ID");
                }

                // T_INT_LITERAL
                else if(line.get(w).matches("0*([0-9A-F])+H?")) {
                    stringifyINT_LITERAL(line, w);
                }

                // T_STR_LITERAL
                else if(line.get(w).charAt(0) == '"' || line.get(w).charAt(0) == '\'') {
                    stringifySTR_LITERAL(line, w);
                }

                // T_REAL_LITERAL
                else if(line.get(w).matches("([0-9]|\\.)+([DE][0-9]+)?")) {
                    stringifyREAL_LITERAL(line, w);
                }

                // T_CHAR_LITERAL
                else if(line.get(w).matches("0*[0-9A-F]+X")) {
                    stringifyCHAR_LITERAL(line, w);
                }

                // other
                else {
                    tokenStrings.get(tokenStrings.size() - 1).add(line.get(w));
                }
            }
        }
        tokenize();
    }

    private void splitPunc() {
        for(ArrayList<String> line : lexemes) {
            ListIterator<String> fsIter = line.listIterator();
            while(fsIter.hasNext()) {
                String word = fsIter.next();
                // check each character in word for punctuation
                for(int c = 0; c < word.length(); c++) {
                    if(pm.isPunc(word.charAt(c))) {
                        // possible punctuations
                        String puncOne = Character.toString(word.charAt(c));
                        String puncTwo = puncOne;

                        // build puncTwo
                        try {
                            puncTwo += Character.toString(word.charAt(c + 1));
                        } catch(IndexOutOfBoundsException e) {
                            // end of line
                        }

                        // find two letter punctuations
                        if(pm.isPunc(puncTwo) && puncTwo.length() == 2) {
                            switch(puncTwo) {
                                case ":=":
                                    c = splitArray(word, ":=", c, fsIter);
                                    break;
                                case "..":
                                    c = splitArray(word, "..", c, fsIter);
                                    break;
                                case ">=":
                                    c = splitArray(word, ">=", c, fsIter);
                                    break;
                                case "<=":
                                    c = splitArray(word, "<=", c, fsIter);
                                    break;
                                default:
                                    break;
                            }

                            // find single letter punctuations
                        } else {
                            switch(puncOne) {
                                case "&":
                                    c = splitArray(word, "&", c, fsIter);
                                    break;
                                case "^":
                                    c = splitArray(word, "^", c, fsIter);
                                    break;
                                case "|":
                                    c = splitArray(word, "|", c, fsIter);
                                    break;
                                case ":":
                                    c = splitArray(word, ":", c, fsIter);
                                    break;
                                case ",":
                                    c = splitArray(word, ",", c, fsIter);
                                    break;
                                case ".":
                                    if(!word.matches("([0-9]|\\.)+([DE][0-9]+)?")) {
                                        c = splitArray(word, ".", c, fsIter);
                                    }
                                    break;
                                case "=":
                                    c = splitArray(word, "=", c, fsIter);
                                    break;
                                case ">":
                                    c = splitArray(word, ">", c, fsIter);
                                    break;
                                case "{":
                                    c = splitArray(word, "{", c, fsIter);
                                    break;
                                case "[":
                                    c = splitArray(word, "[", c, fsIter);
                                    break;
                                case "(":
                                    c = splitArray(word, "(", c, fsIter);
                                    break;
                                case "<":
                                    c = splitArray(word, "<", c, fsIter);
                                    break;
                                case "-":
                                    c = splitArray(word, "-", c, fsIter);
                                    break;
                                case "#":
                                    c = splitArray(word, "#", c, fsIter);
                                    break;
                                case "+":
                                    c = splitArray(word, "+", c, fsIter);
                                    break;
                                case "}":
                                    c = splitArray(word, "}", c, fsIter);
                                    break;
                                case "]":
                                    c = splitArray(word, "]", c, fsIter);
                                    break;
                                case ")":
                                    c = splitArray(word, ")", c, fsIter);
                                    break;
                                case ";":
                                    c = splitArray(word, ";", c, fsIter);
                                    break;
                                case "~":
                                    c = splitArray(word, "~", c, fsIter);
                                    break;
                                case "/":
                                    c = splitArray(word, "/", c, fsIter);
                                    break;
                                case "*":
                                    c = splitArray(word, "*", c, fsIter);
                                    break;
                                case "\"":
                                    c = splitArray(word, "\"", c, fsIter);
                                    break;
                                case "'":
                                    c = splitArray(word, "'", c, fsIter);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void combineStrings() {
        for(ArrayList<String> line : lexemes) {
            ListIterator<String> fsIter = line.listIterator();
            char foundString = 'f';
            String recom = "";
            while(fsIter.hasNext()) {
                String nextLex = fsIter.next();

                // string start
                if("\"".equals(nextLex) && foundString == 'f') {
                    foundString = 'q';
                    recom = "\"";
                    fsIter.remove();
                } else if("'".equals(nextLex) && foundString == 'f') {
                    foundString = 'a';
                    recom = "'";
                    fsIter.remove();
                }

                // string close
                else if("\"".equals(nextLex) && foundString == 'q') {
                    recom += "\"";
                    fsIter.remove();
                } else if("'".equals(nextLex) && foundString == 'a') {
                    recom += "'";
                    fsIter.remove();
                }

                // string contents
                else if(foundString != 'f' && pm.isPunc(nextLex)) {
                    recom += nextLex;
                    fsIter.remove();
                } else if(foundString != 'f' && !pm.isPunc(nextLex)) {
                    recom += " " + nextLex;
                    fsIter.remove();
                }
            }
            recom = recom.replace("' ", "'");
            recom = recom.replace("\" ", "\"");
            if(!"".equals(recom)) {
                fsIter.add(recom);
            }
        }
    }

    private void stringifyINT_LITERAL(ArrayList<String> line, int w) {
        // remove leading zeros
        String INT_LITERAL = line.get(w);
        while(INT_LITERAL.charAt(0) == '0' && INT_LITERAL.length() > 1) {
            INT_LITERAL = INT_LITERAL.substring(1);
        }

        // proper integer
        if(INT_LITERAL.matches("([0-9]){1,10}") || INT_LITERAL.matches("([0-9A-F]){1,10}H")) {
            line.set(w, INT_LITERAL);
            tokenStrings.get(tokenStrings.size() - 1).add("T_INT_LITERAL");
        }
        // decimal integer literal too long error
        else if(INT_LITERAL.matches("([0-9]){11,}")) {
            System.out.println("integer literal too long");
            line.set(w, INT_LITERAL.substring(0, 10));
            tokenStrings.get(tokenStrings.size() - 1).add("T_INT_LITERAL");
        }
        // hex integer literal too long error
        else if(INT_LITERAL.matches("([0-9A-F]){11,}H")) {
            System.out.println("integer literal too long");
            line.set(w, INT_LITERAL.substring(0, 10) + "H");
            tokenStrings.get(tokenStrings.size() - 1).add("T_INT_LITERAL");
        }
        // illegal hex integer literal error
        else if(INT_LITERAL.matches("([0-9A-F])+")) {
            System.out.println("illegal hex integer literal");
            if(INT_LITERAL.length() > 10) {
                INT_LITERAL = INT_LITERAL.substring(0, 10);
            }
            line.set(w, INT_LITERAL + "H");
            tokenStrings.get(tokenStrings.size() - 1).add("T_INT_LITERAL");
        }
    }

    private void stringifySTR_LITERAL(ArrayList<String> line, int w) {
        char firstChar = line.get(w).charAt(0);
        char lastChar = line.get(w).charAt(line.get(w).length() - 1);
        String STR_LITERAL = line.get(w);

        // fix missing closure
        if(firstChar != lastChar) {
            System.out.println("unterminated string literal");
            STR_LITERAL = STR_LITERAL.substring(0, 81) + firstChar;
        }
        // over length
        if(firstChar == lastChar && line.get(w).length() > 82) {
            System.out.println("newline/EOF in string");
            STR_LITERAL = STR_LITERAL.substring(0, 81) + firstChar;
        }

        STR_LITERAL = STR_LITERAL.substring(1, STR_LITERAL.length() - 1);
        line.set(w, STR_LITERAL);
        tokenStrings.get(tokenStrings.size() - 1).add("T_STR_LITERAL");
    }

    private void stringifyREAL_LITERAL(ArrayList<String> line, int w) {
        // remove mantissa zeros
        String REAL = line.get(w);
        while(REAL.charAt(0) == '0') {
            REAL = REAL.substring(1);
        }

        // remove exponent zeros
        int expIndex = (REAL.indexOf('D') > REAL.indexOf('E') ? REAL.indexOf('D') : REAL.indexOf('E'));
        if(expIndex != -1) {
            while(REAL.charAt(expIndex + 1) == '0') {
                REAL = REAL.substring(0, expIndex + 1) + REAL.substring(expIndex + 2);
            }
        }
        if(expIndex == -1) {
            expIndex = REAL.length() - 1;
        }

        // proper real
        if(REAL.matches("[0-9]+\\.[0-9]*([DE][0-9]+)?") && REAL.matches("[1-9]([0-9]|\\.){1,9}([DE][1-9]{1,3})?")) {
            line.set(w, REAL);
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        }
        // real literal exponent too long
        else if(REAL.matches("[0-9]+\\.[0-9]*[DE][0-9]{4,}")) {
            System.out.println("real literal exponent too long");
            line.set(w, REAL.substring(0, expIndex + 4));
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        }
        // real literal . at mantissa start
        else if(REAL.charAt(0) == '.') {
            System.out.println("real literal . at mantissa start");
            line.set(w, "0" + REAL);
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        }
        // real literal more than one .
        else if(REAL.length() - REAL.replace(".", "").length() > 1) {
            System.out.println("real literal more than one .");
            int foundDot = -1;
            for(int i = 0; i < REAL.length(); i++) {
                if(REAL.charAt(i) == '.') {
                    foundDot = i;
                    break;
                }
            }
            REAL = REAL.replace(".", "");
            REAL = REAL.substring(0, foundDot) + "." + REAL.substring(foundDot);

            line.set(w, REAL);
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        }
        // real literal mantissa too long
        else if(REAL.substring(0, expIndex + 1).length() > 10) {
            System.out.println("real literal mantissa too long");
            String mantissa = REAL.substring(0, expIndex + 1);
            if(mantissa.charAt(mantissa.length() - 1) == '.') {
                mantissa = mantissa.substring(0, 9);
                REAL = mantissa + REAL.substring(expIndex);
            } else {
                REAL = REAL.substring(0, 10);
            }

            line.set(w, REAL);
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        } else {
            tokenStrings.get(tokenStrings.size() - 1).add("T_REAL_LITERAL");
        }
    }

    private void stringifyCHAR_LITERAL(ArrayList<String> line, int w) {
        String CHAR_LITERAL = line.get(w);
        while(CHAR_LITERAL.charAt(0) == '0' && CHAR_LITERAL.length() > 1) {
            CHAR_LITERAL = CHAR_LITERAL.substring(1);
        }

        // proper
        if(CHAR_LITERAL.matches("[0-9A-F]{1,3}X")) {
            line.set(w, CHAR_LITERAL);
        } else if(CHAR_LITERAL.matches("[0-9A-F]{4,}X")) {
            System.out.println("illegal character literal");
            line.set(w, CHAR_LITERAL.substring(0, 3) + "X");
        }
        tokenStrings.get(tokenStrings.size() - 1).add("T_CHAR_LITERAL");
    }

    private void tokenize() {
        for(int i = 0; i < lexemes.size(); i++) {
            // no special tokens
            if(lexemes.get(i).size() == tokenStrings.get(i).size()) {
                tokens.add(new ArrayList<>());
                for(int w = 0; w < lexemes.get(i).size(); w++) {
                    tokens.get(i).add(new Token(im.getId(tokenStrings.get(i).get(w)), lexemes.get(i).get(w)));
                }
            } else {
                tokens.add(new ArrayList<>());
            }
        }
    }

    private int splitArray(String word, String middle, int c, ListIterator<String> fsIter) {
        // remove old String
        fsIter.remove();

        // add first substring
        if(word.substring(0, c).length() > 0) {
            fsIter.add(word.substring(0, c));
        }

        // add punctuation
        fsIter.add(middle);

        // add last substring
        if(word.substring(c + middle.length()).length() > 0) {
            fsIter.add(word.substring(c + middle.length()));
        }

        if(word.substring(0, c).length() > 0 || word.substring(c + middle.length()).length() > 0) {
            fsIter.previous();
        }

        return word.length();
    }

    public Token getToken() {
        Token theToken = tokens.get(tokenPos[0]).get(tokenPos[1]);
        if(tokenPos[1] < tokens.get(tokenPos[0]).size() - 1) {
            tokenPos[1]++;
        } else {
            tokenPos[1] = 0;
            tokenPos[0]++;
        }
        return theToken;
    }

    public void printLexemes(String separator) {
        System.out.println("==1 LEXEMES==");
        for(ArrayList<String> line : lexemes) {
            for(String word : line) {
                System.out.print(word + " " + separator + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printTokenStrings(String separator) {
        System.out.println("==2 TOKEN STRINGS==");
        for(ArrayList<String> line : tokenStrings) {
            for(String word : line) {
                System.out.print(word + " " + separator + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printTokenLexemes(String separator) {
        System.out.println("==3 TOKEN LEXEMES==");
        for(ArrayList<Token> line : tokens) {
            for(Token token : line) {
                System.out.print(token.getLexeme() + " " + separator + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printTokenId(String separator) {
        System.out.println("==4 TOKEN IDS==");
        for(ArrayList<Token> line : tokens) {
            for(Token token : line) {
                System.out.print(token.getType() + " " + separator + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
