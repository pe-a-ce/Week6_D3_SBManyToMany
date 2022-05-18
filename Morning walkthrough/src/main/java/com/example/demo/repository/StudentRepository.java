package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {

    // @Query The method name does not impact the query
    @Query(value = "SELECT * FROM STUDENT ORDER BY LAST_NAME", nativeQuery = true)
    List<Student> findAllOrdered();
}

