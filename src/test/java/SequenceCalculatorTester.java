import com.leliuk.math.FactorialCalculator;
import com.leliuk.math.FibonacciCalculator;
import com.leliuk.math.SequenceCalculator;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class SequenceCalculatorTester {
    private SequenceCalculator calculator = new SequenceCalculator();

    @Test
    public void testFactorial() {
        FactorialCalculator calculator = this.calculator;

        assertEquals(1, calculator.iterativeFac(0));
        assertEquals(1, calculator.iterativeFac(0));
        assertEquals(120, calculator.iterativeFac(5));

        assertEquals(1, calculator.recursiveFac(0));
        assertEquals(1, calculator.recursiveFac(1));
        assertEquals(120, calculator.recursiveFac(5));

        assertEquals(BigInteger.ONE, calculator.bigFac(0));
        assertEquals(BigInteger.ONE, calculator.bigFac(1));
        assertEquals(BigInteger.valueOf(120), calculator.bigFac(5));
        assertEquals(new BigInteger("2432902008176640000"), calculator.bigFac(20));
    }

    @Test
    public void testFibonacci() {
        FibonacciCalculator calculator = this.calculator;

        assertEquals(0, calculator.iterativeFib(0));
        assertEquals(1, calculator.iterativeFib(1));
        assertEquals(75025, calculator.iterativeFib(25));

        assertEquals(0, calculator.recursiveFib(0));
        assertEquals(1, calculator.recursiveFib(1));
        assertEquals(75025, calculator.recursiveFib(25));

        assertEquals(BigInteger.ZERO, calculator.bigMathFib(0));
        assertEquals(BigInteger.ONE, calculator.bigMathFib(1));
        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), calculator.bigMathFib(200));
    }
}
