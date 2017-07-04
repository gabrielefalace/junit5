package com.falace.parameterized;


            import java.util.Arrays;
            import java.util.List;
            import java.util.OptionalDouble;

            class Teacher {

                static double SUFFICIENT = 6.00;

                // intentionally fancy: so it needs to be tested
                boolean admitToNextClass(Student student) {
                    List<Integer> grades = Arrays.asList(student.getEnglishGrade(),
                                                         student.getHistoryGrade(),
                                                         student.getMathGrade());
                    OptionalDouble average = grades
                                                .stream()
                                                .mapToDouble(grade -> grade)
                                                .average();

                    return average.isPresent() && average.getAsDouble() >= SUFFICIENT;
                }

            }




