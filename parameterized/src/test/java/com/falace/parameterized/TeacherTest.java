package com.falace.parameterized;


                    import org.junit.jupiter.api.Assertions;
                    import org.junit.jupiter.api.DisplayName;
                    import org.junit.jupiter.params.ParameterizedTest;
                    import org.junit.jupiter.params.provider.MethodSource;

                    import java.util.stream.Stream;

                    class TeacherTest {

                        private Teacher teacher = new Teacher();

                        @ParameterizedTest
                        @MethodSource(names = "provideGoodStudents")
                        @DisplayName("Good Students")
                        void test(Student arg) {
                            boolean admitted = teacher.admitToNextClass(arg);
                            Assertions.assertTrue(admitted);
                        }

                        static Stream<Student> provideGoodStudents() {
                            return Stream.of(
                                    new Student("Joe", "Doe", 5, 6, 8),
                                    new Student("Jane", "Dao", 6, 6, 9)
                            );
                        }

                    }






