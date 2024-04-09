package ua.com.alevel.entity;

// entity
// data class
// encapsulation
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private int age;

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
        if (age > 17 && age < 80) {
            this.age = age;
        } else {
            throw new RuntimeException("Invalid age");
        }
    }
}
