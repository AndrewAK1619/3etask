package com.example.etask.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService service;

    @PostMapping("/add/{val1}/{val2}")
    CalculatorDto add(@PathVariable double val1, @PathVariable double val2) {
        return service.add(val1, val2);
    }

    @GetMapping("/div/{val1}/{val2}")
    CalculatorDto div(@PathVariable double val1, @PathVariable double val2) {
        return service.div(val1, val2);
    }
}
