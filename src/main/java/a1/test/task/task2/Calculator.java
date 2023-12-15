package a1.test.task.task2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {
    public static double calculateUn(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException("N should be more than 1");
        }
        BigDecimal numerator = BigDecimal.ZERO;
        BigDecimal denominator = BigDecimal.ONE;

        for (int i = 1; i <= n; i++) {
            numerator = numerator.add(factorial(i));
            denominator = denominator.multiply(BigDecimal.valueOf(i));
        }

        MathContext mc = new MathContext(7, RoundingMode.HALF_UP);
        BigDecimal result = numerator.divide(denominator, mc);
        return result.doubleValue();
    }

    private static BigDecimal factorial(int num) {
        BigDecimal fact = BigDecimal.ONE;
        for (int i = 2; i <= num; i++) {
            fact = fact.multiply(BigDecimal.valueOf(i));
        }
        return fact;
    }
}
