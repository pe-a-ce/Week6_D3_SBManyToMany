package com.example.demo.repository;

import com.example.demo.model.Lab;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabRepository extends JpaRepository <Lab, Long> {

    /*
           nameGeneratesQuery
           1. Can only use findBy[a paramter we set in the lab class title, description, id in this example]
           2. Any potential issues with the return type?
        */
    Lab findByTitle(String title);
}

