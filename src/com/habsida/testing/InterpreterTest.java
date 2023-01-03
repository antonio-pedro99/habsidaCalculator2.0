package com.habsida.testing;
import  com.habsida.logic.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterpreterTest {
    @Test
    public void testInterpret() {
        // Test simple addition
        Interpreter interpreter = new Interpreter("5 + 2");
        int result = interpreter.interpret();
        assertEquals(7, result);

        // Test simple subtraction
        interpreter = new Interpreter("5 - 2");
        result = interpreter.interpret();
        assertEquals(3, result);

        // Test multiple operations
        interpreter = new Interpreter("5 - 2 + 8");
        result = interpreter.interpret();
        assertEquals(11, result);

        // Test negative numbers
        interpreter = new Interpreter("5 + -2");
        result = interpreter.interpret();
        assertEquals(3, result);
    }
}
