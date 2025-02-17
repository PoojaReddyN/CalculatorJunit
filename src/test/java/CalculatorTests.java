import com.epam.tat.module4.Calculator;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTests {
    private static Calculator calculator;

    @BeforeAll
    public static void setup() {
        calculator = new Calculator();
        System.out.println("Calculator instance created.");
    }


    @BeforeEach
    public void beforeTest() {
        System.out.println("Starting test...");
    }



    @Test
    @Category(ArithmeticTestGroup.class)
    void testSumPositive() {
        assertEquals(10, calculator.sum(4, 6), "Sum calculation is incorrect");
    }

    @Test
    @Category(ArithmeticTestGroup.class)
    void testSubPositive() {
        assertEquals(4, calculator.sub(10, 6), "Subtraction calculation is incorrect");
    }

    @Test
    @Category(ArithmeticTestGroup.class)
    void testMultPositive() {
        assertEquals(20, calculator.mult(4, 5), "Multiplication calculation is incorrect");
    }

    @Test
    @Category(ArithmeticTestGroup.class)
    void testDivPositive() {
        assertEquals(2, calculator.div(10, 5), "Division calculation is incorrect");
    }

    @Test
    @Category(ArithmeticTestGroup.class)
    void testPowPositive() {
        assertEquals(16, calculator.pow(4, 2), "Power calculation is incorrect");
    }

    @Test
    @Category(ArithmeticTestGroup.class)
    void testDivByZero() {
        Exception exception = assertThrows(NumberFormatException.class, () -> calculator.div(10, 0));
        assertEquals("Attempt to divide by zero", exception.getMessage());
    }

    @Test
    void testNegativeSum() {
        assertNotEquals(15, calculator.sum(4, 6), "Negative test failed");
    }

    @Test
    void testNegativeMult() {
        assertNotEquals(25, calculator.mult(4, 5), "Negative test failed");
    }

    @Test
    void testNegativeSqrt() {
        assertEquals(4, calculator.sqrt(16), "Negative test failed");
    }

    @Test
    void testNegativePow() {
        assertNotEquals(10, calculator.pow(4, 2), "Negative test failed");
    }


    @ParameterizedTest
    @CsvSource({"4,6,10", "3,5,8", "7,3,10"})
    void testSumParameterized(long a, long b, long expected) {
        assertEquals(expected, calculator.sum(a, b));
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, -1})
    void testIsPositive(long value) {
        assertEquals(value > 0, calculator.isPositive(value));
    }

    @Test
    @Timeout(2)
    void testTimeout() {
        assertDoesNotThrow(() -> Thread.sleep(1000));
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each Test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All Tests");
    }
}
