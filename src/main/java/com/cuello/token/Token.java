package com.cuello.token;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private TokenType type;
    private String value;
    private static Map<String, TokenType> keywords;
    static {
        keywords = new HashMap<>();
        keywords.put("fn", TokenType.FUNCTION);
        keywords.put("let", TokenType.LET);
        keywords.put("if", TokenType.IF);
        keywords.put("else", TokenType.ELSE);
        keywords.put("return", TokenType.RETURN);
        keywords.put("true", TokenType.TRUE);
        keywords.put("false", TokenType.FALSE);
    }

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public static TokenType getTokenTypeByIdentifier(String identifier) {
        return keywords.getOrDefault(identifier, TokenType.IDENTIFIER);
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
