import org.example.junitTesting.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    @DisplayName("Деление на ноль выбрасывает исключения")
    void givenZeroDivisor_whenDivide_thenThrowArithmeticException(){
        //Arrange
        int a = 10;
        int b = 0;
        //Act
        //Assert
        assertThatThrownBy(() -> calculator.divide(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Деление на ноль невозможно");

    }
}
