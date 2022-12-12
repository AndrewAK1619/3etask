package com.example.etask.calculator;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Builder
public class CalculatorDto {

    private static final int SCALE = 2;

    private BigDecimal value;

    private static CalculatorDto run() {
        return CalculatorDto.builder()
                .build();
    }

    static CalculatorDto add(double val1, double val2) {
        CalculatorDto calculator = CalculatorDto.run();
        calculator.value = BigDecimal.valueOf(val1).add(BigDecimal.valueOf(val2));
        return calculator;
    }

    static CalculatorDto div(double val1, double val2) {
        CalculatorDto calculator = CalculatorDto.run();
        calculator.value = BigDecimal.valueOf(val1).divide(BigDecimal.valueOf(val2), SCALE, RoundingMode.CEILING);
        return calculator;
    }
}
