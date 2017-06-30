package com.falace.parameterized;


import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Teacher {

    public boolean admitToNextClass(Student student) {
        List<Integer> grades = Arrays.asList(student.getEnglishGrade(), student.getHistoryGrade(), student.getMathGrade());
        OptionalDouble average = grades
                                    .stream()
                                    .mapToDouble(grade -> grade)
                                    .average();
        return average.isPresent() && average.getAsDouble() > 6.00;
    }


}
