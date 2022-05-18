package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /*
    The findAll method of the CrudRepository returns an iterable collection of entities from the database.
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllLabs(){
        List<Student> students = studentRepository.findAll();
        return ResponseEntity .ok()
                .body(students);
    }

    /*
    The save method of the CrudRepository can be used to create or update an entity in the database.
    It returns the newly-saved / updated entity.
     */
    @PostMapping("/students")
    public ResponseEntity<Student> createLab(@RequestBody Student student) {


    Student result = studentRepository.save(student);
return ResponseEntity
        .ok() .body(result);
    }

    @GetMapping("/students_2")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false, defaultValue = "false")
                                                        boolean orderedByLastName) {

        List<Student> students;
        if (orderedByLastName) {
            students = studentRepository.findAllByLastNameOrdered();
        } else {
            students = studentRepository.findAll();
        }
        return ResponseEntity
                .ok()
                .body(students);
    }

}
