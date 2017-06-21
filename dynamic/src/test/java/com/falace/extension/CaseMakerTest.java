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

    @TestFactory
    Stream<DynamicTest> generateTests() {
        List<String> input = asList("Hi", "Cane");
        caseMaker.setCaseMode(ALL_UPPERCASE);

        return input.stream().map(word -> dynamicTest("Now testing with input " + word, () -> {
            String expected = word.toUpperCase();
            String result = caseMaker.changeCase(word);
            assertEquals(expected, result);
        }));
    }

    // independent test Method for separate input / expected values; separate report for failures
    // Each test Method tests something different.
    @TestFactory
    Stream<DynamicTest> generateTestsWithMap() {
        Map<String, String> inputToExpectedOutput = new HashMap<>();

        inputToExpectedOutput.put("hi", "Hi");
        inputToExpectedOutput.put("dog", "Dog");
        inputToExpectedOutput.put("woof!", "Woof!");

        caseMaker.setCaseMode(FIRST_CHAR);

        return inputToExpectedOutput.keySet().stream().map(word -> dynamicTest("Now testing with input " + word, () -> {
            String expected = inputToExpectedOutput.get(word);
            String result = caseMaker.changeCase(word);
            assertEquals(expected, result);
        }));
    }

    // without @TestFactory: not so dirty code actually, but there's a single test testing multiple things.
    @Test
    void multipleTest() {
        caseMaker.setCaseMode(ALL_UPPERCASE);
        asList("Hi", "Dog").forEach(word -> {
            String expected = word.toUpperCase();
            String actual = caseMaker.changeCase(word);
            assertEquals(expected, actual);
        });
    }

}
