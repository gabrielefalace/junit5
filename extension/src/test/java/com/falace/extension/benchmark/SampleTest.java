package com.falace.extension.benchmark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Benchmark
class SampleTest {

    @Test
    @Benchmark
    void test1(){
        assertTrue(true);
    }


    @Test
    @Benchmark
    void test2(){
        assertFalse(false);
    }


}
