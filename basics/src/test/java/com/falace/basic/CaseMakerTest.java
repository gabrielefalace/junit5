package com.falace.basic;

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
import static com.falace.basic.CaseMode.ALL_UPPERCASE;
import static com.falace.basic.CaseMode.FIRST_CHAR;
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
    @DisplayName("Successful case of fully capitalizing a string")
    void testUppercaseSucceeds() {
        String input = "hello";
        caseMaker.setCaseMode(ALL_UPPERCASE);

        assumeTrue(caseMaker.getCaseMode() == ALL_UPPERCASE);

        String actualResult = caseMaker.changeCase(input);

        assertEquals("HELLO", actualResult);
    }

    @Test
    @DisplayName("Successful case of capitalizing only the first character of a string")
    void testCapitalizationSucceds() {
        String input = "hello";
        caseMaker.setCaseMode(FIRST_CHAR);

        assumeTrue(caseMaker.getCaseMode() == FIRST_CHAR);

        String actualResult = caseMaker.changeCase(input);

        assertEquals("Hello", actualResult);
    }

    @Test
    @DisplayName("Unsuccessful case of capitalizing when mode is null")
    void testFailureWithUnknownMode() {
        String input = "hello";
        caseMaker.setCaseMode(null);

        assumeFalse(caseMaker.getCaseMode() == FIRST_CHAR);
        assumeFalse(caseMaker.getCaseMode() == ALL_UPPERCASE);

        assertThrows(NullPointerException.class, () -> caseMaker.changeCase(input));
    }


}
