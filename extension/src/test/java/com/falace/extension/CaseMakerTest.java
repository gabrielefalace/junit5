package com.falace.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static com.falace.extension.CaseMode.FIRST_CHAR;
import static com.falace.extension.CaseMode.ALL_UPPERCASE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CaseMakerTest {

    private CaseMaker caseMaker;

    @BeforeEach
    void setup() {
        caseMaker = new CaseMaker();
    }

    @Test
    public void testSomething(){
        //TODO implement some extension cases for the tests
    }

}
