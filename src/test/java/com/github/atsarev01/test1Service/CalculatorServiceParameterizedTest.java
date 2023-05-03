package com.github.atsarev01.test1Service;

import com.github.atsarev01.test1.exception.DivideByZeroException;
import com.github.atsarev01.test1.service.CalculatorService;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceParameterizedTest {
    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> plusTestParams() {
        return Stream.of(
                Arguments.of(2F,5F,7F),
                Arguments.of(3F,6F,9F),
                Arguments.of(0F,0F,0F)
        );
    }

    public static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(4F,1F,3F),
                Arguments.of(3F,2F,1F),
                Arguments.of(0F,0F,0F)
        );
    }

    public static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(2F,5F,10F),
                Arguments.of(3F,6F,18F),
                Arguments.of(0F,0F,0F)
        );
    }

    public static Stream<Arguments> divideTestParams() {
        return Stream.of(
                Arguments.of(10F,2F,5F),
                Arguments.of(6F,3F,2F),
                Arguments.of(5F,5F,1F)
        );
    }

    public static Stream<Arguments> divideNegativeTestParams() {
        return Stream.of(
                Arguments.of(0F, 0F),
                Arguments.of(6F, 0F)
        );
    }

    @ParameterizedTest
    @MethodSource("plusTestParams")
    public void plusTest(Float a, Float b, Number expected) {
        Assertions.assertThat(calculatorService.plus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void minusTest(Float a, Float b, Float expected) {
        Assertions.assertThat(calculatorService.minus(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void multiplyTest(Float a, Float b, Float expected) {
        Assertions.assertThat(calculatorService.multiply(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("divideTestParams")
    public void divideTest(Float a, Float b, Float expected) {
        Assertions.assertThat(calculatorService.divide((float) a, (float) b)).isEqualTo(expected);
    }
    @ParameterizedTest
    @MethodSource("divideNegativeTestParams")
    public void divideNegativeTest(Float a, Float b) {
        Assertions.assertThatExceptionOfType(DivideByZeroException.class)
                .isThrownBy(() -> calculatorService.divide((float) a, (float) b))
                .withMessage("Делить на 0 нельзя");

    }
}
