package com.falace.nested;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class MoreTest {


    @ParameterizedTest
    @MethodSource(names = "provideStudents")
    void testGiveGrades(String argument) {

        Assertions.assertNotNull(argument);
    }

    static Stream<String> provideStudents() {
        return Stream.of("qqqq", "cwdfwe");
    }
}
