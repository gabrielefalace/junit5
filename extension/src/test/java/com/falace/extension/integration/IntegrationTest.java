package com.falace.extension.integration;


import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(IntegrationTestExtension.class)
public @interface IntegrationTest {

}
