package com.example.demo.model;

import java.util.Set;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;

    private Set<Lab> labs;

    public Student() {
    }


    public Student(Long id, String firstName, String lastName, Set<Lab> labs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.labs = labs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Lab> getLabs() {
        return labs;
    }

    public void setLabs(Set<Lab> labs) {
        this.labs = labs;
    }
}
