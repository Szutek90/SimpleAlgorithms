package com.app.algorithm.text;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The ReversePolishNotationCalculator interface provides a static method to evaluate expressions in Reverse Polish Notation (RPN).
 */

public interface ReversePolishNotationCalculator {
    /**
     * Evaluates the expression in Reverse Polish Notation (RPN) and returns the result.
     *
     * @param value the expression in RPN
     * @return the result of the expression evaluation
     * @throws IllegalArgumentException if the expression is invalid or contains division by zero
     */

    static int evaluateExpression(String value) {
        var chars = value.toCharArray();
        Deque<Integer> deque = new LinkedList<>();
        for (var character : chars) {
            if (isDigit(character)) {
                deque.push(character - '0');
            } else {
                if (deque.size() < 2) {
                    throw new IllegalArgumentException("Wrong operation. Size of deque is " + deque.size());
                }
                var a = deque.pop();
                var b = deque.pop();
                deque.push(makeOperation(character, a, b));
            }
        }
        return deque.pop();
    }

    private static boolean isDigit(char value) {
        return value > 47 && value < 58;
    }

    private static int makeOperation(char operator, int a, int b) {
        return switch (operator) {
            case '+' -> a + b;
            case '-' -> b - a;
            case '*' -> a * b;
            case '/' -> {
                if (a == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                yield b / a;
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
