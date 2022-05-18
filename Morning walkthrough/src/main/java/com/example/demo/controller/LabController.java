package com.example.demo.controller;

import com.example.demo.model.Lab;
import com.example.demo.repository.LabRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabController {
    // The right way to inject dependencies
    private final LabRepository labRepository;

    public LabController(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

//        @GetMapping("/labs")
//    public ResponseEntity<List<Lab>> getAllLabs(){
//            List<Lab> labs = labRepository.findAll();
//            return ResponseEntity
//                    .ok()
//                    .body(labs);
//        }
//
//    @PostMapping("/labs")
//    public ResponseEntity<Lab> createLab(@RequestBody Lab lab) {
//        Lab result = labRepository.save(lab);
//        return ResponseEntity
//                .ok() .body(result);
//    }


}
