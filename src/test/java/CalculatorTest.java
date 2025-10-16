import org.example.junitTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void givenPositiveNumbers_whenAdd_ReturnCorrectSum() {
        //Arrange
        int a = 5;
        int b = 3;
        //Act
        int result = calculator.add(a,b);
        //Assert
        assertThat(result).isEqualTo(8);
        System.out.println(result);
    }
}
