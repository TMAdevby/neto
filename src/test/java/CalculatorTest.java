import org.example.junitTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Сложение положительных чисел")
    public void givenPositiveNumbers_whenAdd_ReturnCorrectSum() {
        //Arrange
        int a = 5;
        int b = 3;
        //Act
        int result = calculator.add(a,b);
        //Assert
        assertThat(result).isEqualTo(8);
        //System.out.println(result);
    }

    @Test
    @DisplayName("Сложение двух отридцательных чисел")
    void givenTwoNegativeNumbers_whenAdd_thenReturnCorrectSum(){
        //Arrange
        int a = -5;
        int b = -3;
        //Act
        int result = calculator.add(a,b);
        //Assert
        assertThat(result).isEqualTo(-8);
        System.out.println(result);
    }
}
