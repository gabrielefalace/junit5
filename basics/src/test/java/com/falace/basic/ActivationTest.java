


                            package com.falace.basic;


                            import org.junit.jupiter.api.Assertions;
                            import org.junit.jupiter.api.BeforeAll;
                            import org.junit.jupiter.api.RepeatedTest;

                            class ActivationTest {

                                private static UserService userService;

                                private static User user;

                                @BeforeAll
                                static void init() {
                                    userService = new UserService();
                                    user = new User();
                                }

                                @RepeatedTest(8)
                                void activateUser() {
                                    userService.activate(user);
                                    Assertions.assertTrue(user.isActive());
                                }

                            }










