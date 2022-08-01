package com.cuello.lexer;

import com.cuello.token.Token;
import com.cuello.token.TokenType;

public class Lexer {
    private String input;
    private int position;
    private int readPosition;
    private char ch;

    public Lexer(String input) {
       this.input = input;
       this.ch = '\0';
       readChar();
    }

    private void readChar() {
        if (readPosition >= input.length()) {
            ch = '\0';
        }
        else {
            ch = input.charAt(readPosition);
        }
        position = readPosition;
        readPosition++;
    }

    public Token nextToken() {
        Token token;

        skipWhiteSpace();

        switch (ch) {
            case '=':
                if (peekChar() == '=') {
                    readChar();
                    token = new Token(TokenType.EQUAL, "==");
                }
                else {
                    token = new Token(TokenType.ASSIGN, "=");
                }
                break;
            case ';':
                token = new Token(TokenType.SEMICOLON, ";");
                break;
            case '(':
                token = new Token(TokenType.LPAREN, "(");
                break;
            case ')':
                token = new Token(TokenType.RPAREN, ")");
                break;
            case ',':
                token = new Token(TokenType.COMMA, ",");
                break;
            case '+':
                token = new Token(TokenType.PLUS, "+");
                break;
            case '{':
                token = new Token(TokenType.LBRACE, "{");
                break;
            case '}':
                token = new Token(TokenType.RBRACE, "}");
                break;
            case '!':
                if (peekChar() == '=') {
                    readChar();
                    token = new Token(TokenType.NOT_EQUAL, "!=");
                }
                else {
                    token = new Token(TokenType.NOT, "!");
                }
                break;
            case '-':
                token = new Token(TokenType.MINUS, "-");
                break;
            case '/':
                token = new Token(TokenType.DIVIDE, "/");
                break;
            case '*':
                token = new Token(TokenType.MULTIPLY, "*");
                break;
            case '<':
                token = new Token(TokenType.LESS_THAN, "<");
                break;
            case '>':
                token = new Token(TokenType.GREATER_THAN, ">");
                break;
            case '\0':
                token = new Token(TokenType.EOF, "");
                break;
            default:
                if (isLetter()) {
                    String identifier = getIdentifier();
                    TokenType tokenType = Token.getTokenTypeByIdentifier(identifier);
                    return new Token(tokenType, identifier);
                }
                else if (Character.isDigit(ch)) {
                    String digit = getDigit();
                    return new Token(TokenType.INT, digit);
                }
                else {
                    token = new Token(TokenType.ILLEGAL, ch + "");
                }
                break;
        }

        readChar();
        return token;
    }

    private String getDigit() {
        int pos = position;
        while (Character.isDigit(ch)) {
            readChar();
        }
        String digit = input.substring(pos, position);
        return digit;
    }

    private void skipWhiteSpace() {
        while (Character.isWhitespace(ch)) {
            readChar();
        }
    }

    private String getIdentifier() {
        int pos = position;
        while (isLetter()) {
            readChar();
        }
        String identifier = input.substring(pos, position);
        return identifier;
    }

    private boolean isLetter() {
        return Character.isLetter(ch) || ch == '_';
    }

    private char peekChar() {
        if (readPosition >= input.length()) {
            return '\0';
        }
        return input.charAt(readPosition);
    }
}
