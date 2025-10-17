import org.example.junitTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
    }

}
