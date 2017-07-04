package com.falace.parameterized;


public class Student {

    private String firstName;
    private String lastName;
    private int mathGrade;
    private int englishGrade;
    private int historyGrade;

    Student(String firstName, String lastName, int mathGrade, int englishGrade, int historyGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mathGrade = mathGrade;
        this.englishGrade = englishGrade;
        this.historyGrade = historyGrade;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
    }

    public int getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(int historyGrade) {
        this.historyGrade = historyGrade;
    }
}
