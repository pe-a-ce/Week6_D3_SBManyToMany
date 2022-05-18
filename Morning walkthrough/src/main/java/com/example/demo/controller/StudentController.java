package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllLabs(){
        List<Student> students = studentRepository.findAll();
        return ResponseEntity .ok()
                .body(students);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createLab(@RequestBody Student student) {


    Student result = studentRepository.save(student);
return ResponseEntity
        .ok() .body(result);

}}
