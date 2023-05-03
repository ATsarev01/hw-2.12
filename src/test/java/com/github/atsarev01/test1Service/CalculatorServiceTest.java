package com.github.atsarev01.test1Service;

import com.github.atsarev01.test1.exception.DivideByZeroException;
import com.github.atsarev01.test1.service.CalculatorService;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

@Test
    public void plusTest() {
    Number actual = calculatorService.plus(3F, 5F);
    Number expected = 8F;

    Assertions.assertThat(actual).isEqualTo(expected);
    Assertions.assertThat(calculatorService.plus((float) 0, (float) 0)).isEqualTo(0);
    }

    @Test
    public void minusTest() {
        Assertions.assertThat(calculatorService.minus((float) 4, (float) 3)).isEqualTo(1);
        Assertions.assertThat(calculatorService.minus((float) 2, (float) 4)).isEqualTo(-2);
    }

    @Test
    public void multiplyTest() {
        Assertions.assertThat(calculatorService.multiply((float) 4, (float) 3)).isEqualTo(12);
        Assertions.assertThat(calculatorService.multiply((float) 2, (float) 4)).isEqualTo(8);
    }

    @Test
    public void divideTest() {
        Assertions.assertThat(calculatorService.divide((float) 4, (float) 2)).isEqualTo(2);
        Assertions.assertThat(calculatorService.divide((float) 8, (float) 2)).isEqualTo(4);
    }
@Test
    public void divideNegativeTest() {
        Assertions.assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide((float) 4, (float) 0))
        .withMessage("Делить на 0 нельзя");
    Assertions.assertThatExceptionOfType(DivideByZeroException.class)
            .isThrownBy(() -> calculatorService.divide((float) 0, (float) 0))
            .withMessage("Делить на 0 нельзя");

    }
}
