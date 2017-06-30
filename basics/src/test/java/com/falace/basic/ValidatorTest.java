


                package com.falace.basic;


                import org.junit.jupiter.api.*;

                @Tag("validation")
                class ValidatorTest {


                    private Validator validator;


                    @BeforeAll
                    void setup(){
                        validator = new Validator();
                        validator.setTelephoneRequired(true);
                    }

                    @Test
                    @DisplayName("Validation succeeds when no field is blank")
                    void testValidateSuccess() {
                        User user = new User();
                        user.setFirstName("John");
                        user.setLastName("Doe");
                        user.setEmail("joe.doe@mail.com");
                        user.setTelephone("+3912345678910");

                        boolean isValid = validator.validate(user);

                        Assertions.assertTrue(isValid);
                    }

                    @Test
                    @DisplayName("Validation fails when telephone number is blank")
                    void testValidateFailure() {
                        User user = new User();
                        user.setFirstName("John");
                        user.setLastName("Doe");
                        user.setEmail("joe.doe@mail.com");
                        user.setTelephone("");

                        boolean isValid = validator.validate(user);

                        Assertions.assertFalse(isValid);
                    }

                }





