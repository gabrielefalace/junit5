package com.falace.dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class WordProcessorTest {

    private WordProcessor wordProcessor = new WordProcessor();

    @TestFactory
    Stream<DynamicTest> generateTestsWithMap() {
        Map<String, String> outputMap = new HashMap<>();

        outputMap.put("hi", "Hi");
        outputMap.put("dog", "Dog");
        outputMap.put("woof!", "Woof!");

        return outputMap.keySet().stream().map(word -> dynamicTest("Test with input: " + word, () -> {
            String expected = outputMap.get(word);
            String result = wordProcessor.capitalize(word);
            assertEquals(expected, result);
        }));
    }

}
