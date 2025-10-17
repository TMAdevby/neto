import org.example.junitTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorHamcrestTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    void testAddPositiveNumbers(){
        int a = 5;
        int b = 3;

        int result = calculator.add(a,b);

        assertThat(result, is(equalTo(8)));
        assertThat(result, is(greaterThan(0)));
        assertThat(result, is(lessThan(10)));
        assertThat(result, is(not(equalTo(9))));
    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключения")
    void givenZeroDivisor_whenDivide_thenThrowArithmeticException() {
        //Arrange
        int a = 10;
        int b = 0;

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a, b);
        });

        assertThat(exception.getMessage(), containsString("Деление на ноль невозможно"));
    }
}
