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
        String input = "let five = 5;" + "\n" +
                "let ten = 10;" + "\n" +
                "let add = fn(x, y) {" + "\n" +
                "x + y;" + "\n" +
                "};" + "\n" +
                "let result = add(five, ten);" + "\n" +
                "!-/*5;" + "\n" +
                "5 < 100 > 5;" + "\n" +
                "if (5 < 10) { return true; }" +
                "else { return false; }" +
                "10 == 10;" +
                "10 != 9;";

        Lexer lexer = new Lexer(input);
        List<Token> expectedTokens = Arrays.asList(
                new Token(TokenType.LET, "let"),
                new Token(TokenType.IDENTIFIER, "five"),
                new Token(TokenType.ASSIGN, "="),
                new Token(TokenType.INT, "5"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.LET, "let"),
                new Token(TokenType.IDENTIFIER, "ten"),
                new Token(TokenType.ASSIGN, "="),
                new Token(TokenType.INT, "10"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.LET, "let"),
                new Token(TokenType.IDENTIFIER, "add"),
                new Token(TokenType.ASSIGN, "="),
                new Token(TokenType.FUNCTION, "fn"),
                new Token(TokenType.LPAREN, "("),
                new Token(TokenType.IDENTIFIER, "x"),
                new Token(TokenType.COMMA, ","),
                new Token(TokenType.IDENTIFIER, "y"),
                new Token(TokenType.RPAREN, ")"),
                new Token(TokenType.LBRACE, "{"),
                new Token(TokenType.IDENTIFIER, "x"),
                new Token(TokenType.PLUS, "+"),
                new Token(TokenType.IDENTIFIER, "y"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.RBRACE, "}"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.LET, "let"),
                new Token(TokenType.IDENTIFIER, "result"),
                new Token(TokenType.ASSIGN, "="),
                new Token(TokenType.IDENTIFIER, "add"),
                new Token(TokenType.LPAREN, "("),
                new Token(TokenType.IDENTIFIER, "five"),
                new Token(TokenType.COMMA, ","),
                new Token(TokenType.IDENTIFIER, "ten"),
                new Token(TokenType.RPAREN, ")"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.NOT, "!"),
                new Token(TokenType.MINUS, "-"),
                new Token(TokenType.DIVIDE, "/"),
                new Token(TokenType.MULTIPLY, "*"),
                new Token(TokenType.INT, "5"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.INT, "5"),
                new Token(TokenType.LESS_THAN, "<"),
                new Token(TokenType.INT, "100"),
                new Token(TokenType.GREATER_THAN, ">"),
                new Token(TokenType.INT, "5"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.IF, "if"),
                new Token(TokenType.LPAREN, "("),
                new Token(TokenType.INT, "5"),
                new Token(TokenType.LESS_THAN, "<"),
                new Token(TokenType.INT, "10"),
                new Token(TokenType.RPAREN, ")"),
                new Token(TokenType.LBRACE, "{"),
                new Token(TokenType.RETURN, "return"),
                new Token(TokenType.TRUE, "true"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.RBRACE, "}"),
                new Token(TokenType.ELSE, "else"),
                new Token(TokenType.LBRACE, "{"),
                new Token(TokenType.RETURN, "return"),
                new Token(TokenType.FALSE, "false"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.RBRACE, "}"),
                new Token(TokenType.INT, "10"),
                new Token(TokenType.EQUAL, "=="),
                new Token(TokenType.INT, "10"),
                new Token(TokenType.SEMICOLON, ";"),
                new Token(TokenType.INT, "10"),
                new Token(TokenType.NOT_EQUAL, "!="),
                new Token(TokenType.INT, "9"),
                new Token(TokenType.SEMICOLON, ";")
        );

        for (Token expectedToken : expectedTokens) {
            Token actualToken = lexer.nextToken();
            assertEquals(expectedToken.getType(), actualToken.getType());
            assertEquals(expectedToken.getValue(), actualToken.getValue());
        }
    }
}
