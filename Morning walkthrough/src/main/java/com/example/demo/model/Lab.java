package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    /* CascadeType.ALL is the easiest to use in the code
   propagates all operations — including Hibernate-specific ones — from a parent to a child entity.

   cascade = CascadeType.ALL attribute: Hibernate will propagate all actions
        e.g. in DBSeeder we save a lab with a set of Students - we don't need to manually save them as
        Hibernate will make sure all the orders from the list will be saved to the corresponding table

 but may cause us some troubles during runtime - would cause issues if we begin to use the delete operation
 due to the lab holding students who could then also be deleted

     */
    @ManyToMany(cascade = CascadeType.ALL)

/*   join table will be the extra table gluing the lab table and the student table

Note that using @JoinTable or even @JoinColumn isn't required.
JPA will generate the table and column names for us.
However, the strategy JPA uses won't always match the naming conventions we use.
So, we need the possibility to configure table and column names.
 */
    @JoinTable(name = "enrolments",
            joinColumns = @JoinColumn(name = "lab_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnoreProperties(value = {"labs"}) // ignores the specified logical properties in JSON serialization and deserialization. It is annotated at class level.
    private Set<Student> students;

    public Lab() {
    }

    public Lab(Long id, String title, String description, Set<Student> students) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
