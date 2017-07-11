package com.falace.extension;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class CaseMakerTest {

    // independent test Method for separate input / expected values; separate report for failures
    // Each test Method tests something different.
    // without @TestFactory: not so dirty code actually, but there's a single test testing multiple things.
    @TestFactory
    Stream<DynamicTest> generateTestsWithMap() {
        Map<String, String> inputToExpectedOutput = new HashMap<>();

        inputToExpectedOutput.put("hi", "HI");
        inputToExpectedOutput.put("dog", "DOG");
        inputToExpectedOutput.put("woof!", "WOOF!");

        return inputToExpectedOutput.keySet().stream().map(word -> dynamicTest("Test with input: " + word, () -> {
            String expected = inputToExpectedOutput.get(word);
            String result = word.toUpperCase();
            assertEquals(expected, result);
        }));
    }

}
