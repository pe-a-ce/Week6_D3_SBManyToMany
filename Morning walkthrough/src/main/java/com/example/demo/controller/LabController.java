package com.example.demo.controller;

import com.example.demo.model.Lab;
import com.example.demo.repository.LabRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LabController {


//    // The right way to inject dependencies in spring
    private final LabRepository labRepository;

    public LabController(LabRepository labRepository) {
        this.labRepository = labRepository;
    }

    /*
    ResponseEntity represents an HTTP response, including headers, body, and status.
    ResponseEntity also allows us to add headers and status code.
     */
        @GetMapping("/labs")
    public ResponseEntity<List<Lab>> getAllLabs(){
            List<Lab> labs = labRepository.findAll();
            return ResponseEntity
                    .ok()
                    .body(labs);
        }

//     @RequestBody annotation to a controller’s method enables automatic deserialization of the
//     HTTP request body to an object bound to the method’s argument.
    @PostMapping("/labs")
    public ResponseEntity<Lab> createLab(@RequestBody Lab lab) {
        Lab result = labRepository.save(lab);
        return ResponseEntity
                .ok()
                .body(result);
    }

//    this relates to the nameGeneratesQuery in LabRepository
    @GetMapping("/labs/{title}")
    public ResponseEntity<Lab> getByTitle(@PathVariable String title) {
        Lab lab = labRepository.findByTitle(title);
        return ResponseEntity
                .ok().body(lab);
    }

}
