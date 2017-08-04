package com.falace.extension.integration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
class SampleIntegrationTest implements ExternalResourceTest {

    @TestExternalResource
    Resource resource;

    @Test
    void test1() {
        assertAll("resource is fresh new",
                () -> assertTrue( resource.isClear()),
                () -> assertTrue(resource.isOpen()));

        resource.write("hello");

        assertAll("resource holds 1 item",
                () -> assertFalse(resource.isClear()),
                () -> assertEquals(1, resource.size()));
    }


    @Test
    void test2() {
        assertAll("resource is fresh new",
                () -> assertTrue( resource.isClear()),
                () -> assertTrue(resource.isOpen()));

        resource.write("hello");
        resource.write("world");
        resource.write("this is");
        resource.write("JUnit 5");

        assertAll("resource holds 4 items",
                () -> assertFalse(resource.isClear()),
                () -> assertEquals(4, resource.size()));
    }



    @Override
    public Resource getResource() {
        return resource;
    }

    @Override
    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
