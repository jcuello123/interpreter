package com.cuello.lexer;

import com.cuello.token.Token;
import com.cuello.token.TokenType;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LexerTest {

    @Test
    public void testNextToken() {
        String input = "=+(){},;";
        Lexer lexer = new Lexer(input);
        List<Token> expectedTokens = Arrays.asList(
                new Token(TokenType.ASSIGN, "="),
                new Token(TokenType.PLUS, "+"),
                new Token(TokenType.LPAREN, "("),
                new Token(TokenType.RPAREN, ")"),
                new Token(TokenType.LBRACE, "{"),
                new Token(TokenType.RBRACE, "}"),
                new Token(TokenType.COMMA, ","),
                new Token(TokenType.SEMICOLON, ";")
        );

        for (Token expectedToken : expectedTokens) {
            Token actualToken = lexer.nextToken();
            assertEquals(expectedToken.getType(), actualToken.getType());
            assertEquals(expectedToken.getValue(), actualToken.getValue());
        }
    }
}
