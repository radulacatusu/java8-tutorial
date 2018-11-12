package com.mine.tutorials.lambda;


import java.time.LocalDate;

/**
 * @stefanl
 */
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private LocalDate dayOfBirth;

    /**
     *
     */
    public Person() {
    }

    /**
     * @param firstName
     * @param dayOfBirth
     */
    public Person(String firstName, LocalDate dayOfBirth) {
        this.firstName = firstName;
        this.dayOfBirth = dayOfBirth;
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

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                '}';
    }
}
