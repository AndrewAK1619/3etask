package com.example.etask.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    CalculatorDto add(double val1, double val2) {
        return CalculatorDto.add(val1, val2);
    }

    CalculatorDto div(double val1, double val2) {
        return CalculatorDto.div(val1, val2);
    }
}
