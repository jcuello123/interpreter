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

        switch (ch) {
            case '=':
                token = new Token(TokenType.ASSIGN, "=");
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
            case '\0':
                token = new Token(TokenType.EOF, "");
                break;
            default:
                token = new Token(TokenType.ILLEGAL, "");
                break;
        }

        readChar();
        return token;
    }
}
