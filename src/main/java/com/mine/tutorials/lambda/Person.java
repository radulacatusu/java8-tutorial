package com.mine.tutorials.lambda;


/**
 * @stefanl
 */
public class Person {

    public String firstName;
    public String lastName;
    public int age;

    /**
     *
     */
    public Person() {
    }

    /**
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    /**
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
