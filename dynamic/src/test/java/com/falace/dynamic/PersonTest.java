package com.falace.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class PersonTest {

    private static final String INPUT_VALUE = "abc Def";

    private static final String EXPECTED_OUTPUT = "ABC DEF";

    @TestFactory
    Stream<DynamicTest> testFieldAreSet() {
        Person person = new Person();

        Stream<String> fields = Stream.of(person.getClass().getDeclaredFields()).map(Field::getName).map(f -> capitalize(f));

        return fields
                .filter(f -> isStringField(f, person.getClass()))
                .map(field -> dynamicTest("Test on field: " + field, () -> {

                    Method setter = person.getClass().getMethod("set" + field, String.class);
                    setter.invoke(person, INPUT_VALUE);

                    Method getter = person.getClass().getMethod("get" + field);
                    String result = (String) getter.invoke(person);

                    Assertions.assertEquals(EXPECTED_OUTPUT, result);
                }));
    }

    private String capitalize(String word) {
        String firstCharUppercase = String.valueOf(word.charAt(0)).toUpperCase();
        return firstCharUppercase + word.substring(1);
    }

    private boolean isStringField(String fieldName, Class clazz) {
        return stream(clazz.getMethods())
                .filter(method -> method.getReturnType().equals(String.class))
                .map(Method::getName)
                .anyMatch(name -> name.equals("get" + fieldName));
    }

}
