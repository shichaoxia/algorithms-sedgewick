package chapter1.section1.exercise20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise20Test {
    @Test
    void testLogFact() {
        Assertions.assertEquals(15.104412573075518, Exercise20.logFact(10));
    }
}
