package com.falace.parameterized;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.falace.parameterized.Teacher.SUFFICIENT;

class TeacherTestCsv {

    private Teacher teacher = new Teacher();

    @ParameterizedTest
    @CsvFileSource(resources = {"/good_students.csv"})
    void testGoodStudents(String firstName, String lastName, int math, int english, int history) {
        Student student = new Student(firstName, lastName, math, english, history);
        boolean admitted = teacher.admitToNextClass(student);
        Assertions.assertTrue(admitted);
    }


    @ParameterizedTest
    @CsvFileSource(resources = {"/all_students.csv"})
    void testAllStudents(String firstName, String lastName, int math, int english, int history) {

        Student student = new Student(firstName, lastName, math, english, history);
        double averageGrade = (math + english + history) / 3;

        Assumptions.assumingThat(averageGrade >= SUFFICIENT, () -> {
            boolean admitted = teacher.admitToNextClass(student);
            Assertions.assertTrue(admitted);
        });

        Assumptions.assumingThat(averageGrade < SUFFICIENT, () -> {
            boolean admitted = teacher.admitToNextClass(student);
            Assertions.assertFalse(admitted);
        });
    }
}




