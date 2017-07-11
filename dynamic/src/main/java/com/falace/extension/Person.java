package com.falace.extension;


public class Person {

    private String firstName;

    private String lastName;

    private String jobTitle;

    private int age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getAge() {
        return age;
    }

    // setter methods with similar logic:

    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle.toUpperCase();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
