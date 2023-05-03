package com.github.atsarev01.test1.service;

import com.github.atsarev01.test1.exception.DivideByZeroException;
import org.springframework.stereotype.Service;

@Service

public class CalculatorService {
    public float plus(Float a, Float b) {
        return a + b;
    }
    public float minus(Float a, Float b) {
        return a - b;
    }
    public float multiply(Float a, Float b) {
        return a * b;
    }
    public float divide(Float a, Float b) {
        if (b == 0) {
            throw new DivideByZeroException("Делить на 0 нельзя");
        }
        return a / b;
    }
}
