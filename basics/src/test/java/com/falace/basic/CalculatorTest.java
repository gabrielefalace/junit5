package com.falace.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {


    private Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        int x = 2;
        int y = 1;
        int result = calculator.add(x, y);
        Assertions.assertEquals(3, result);
    }

}






