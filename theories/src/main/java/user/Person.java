package user;


public class Person {

    private String firstName;

    private String lastName;

    private int age;

    private boolean goodHealth;

    public boolean isGoodHealth() {
        return goodHealth;
    }

    public void setGoodHealth(boolean goodHealth) {
        this.goodHealth = goodHealth;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean canDrive() {
        return age >= 18 && age <= 100 && goodHealth;
    }

}
