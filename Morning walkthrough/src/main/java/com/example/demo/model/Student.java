package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity //  specifies that the class is an entity and is mapped to a database table.
public class Student {

@Id // specifies the primary key of an entity
@GeneratedValue(strategy = GenerationType.IDENTITY) // provides for the specification of generation strategies for the values of primary keys.
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "students") //mapped by = name of the property in 'Student' that's to be FK
    @JsonIgnoreProperties(value = {"students"})
    private Set<Lab> labs;
//    collection of labs^^

//    many libraries require a no arg constructor to run properly
    public Student() {}

    // Here are the constructors that accepts args for all properties
    public Student(Long id, String firstName, String lastName, Set<Lab> labs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.labs = labs;
    }

//    Getters and Setters
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
