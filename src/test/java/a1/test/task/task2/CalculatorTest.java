package a1.test.task.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static final double OUTPUT_VALUE = 1.083982D;
    private static final int INPUT_VALUE = 13;
    private static final int INVALID_INPUT_VALUE = -2;

    @Test
    public void shouldReturnDoubleValue() {
        double result = Calculator.calculateUn(INPUT_VALUE);

        assertEquals(0, Double.compare(OUTPUT_VALUE, result));
    }

    @Test
    public void shouldThrowIllegalExceptionWhenInputValueLess1() {
        assertThrows(IllegalArgumentException.class, () ->
                Calculator.calculateUn(INVALID_INPUT_VALUE));
    }
}
