package chapter1.section3.exercise4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise4Test {
    @Test
    void testParentheses() {
        Assertions.assertTrue(Exercise4.parentheses("[()]{}{[()()]()}"));
        assertTrue(!Exercise4.parentheses("[(])"));
    }
}
