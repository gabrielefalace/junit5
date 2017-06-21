package com.falace.extension;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.falace.extension.CaseMode.ALL_UPPERCASE;
import static org.junit.jupiter.api.Assertions.*;

class CaseMakerTest {

    private CaseMaker caseMaker;

    @BeforeEach
    void setup() {
        caseMaker = new CaseMaker();
    }

    @Nested
    @DisplayName("test with a single word in the text")
    class TestSingleWord {

        String input = "Pollo";

        @Test
        void testAllUppercase() {
            //TODO implement me
            assertNull(null);
        }

        @Test
        void testCapitalize() {
            //TODO implement me
            assertNull(null);
        }

    }


    @Nested
    @DisplayName("test with multiple words in the text")
    class TestMultipleWords {

        String input = "Calamari Frutti, tutti Frutti";

        @Test
        void testAllUppercase() {
            //TODO implement me
            assertNull(null);
        }

        @Test
        void testCapitalize() {
            //TODO implement me
            assertNull(null);
        }

    }

}
