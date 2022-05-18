package com.example.demo.repository;

import com.example.demo.model.Lab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LabRepositoryTest {

    @Autowired
    private LabRepository labRepository;

    @Test
    void findByTitle() {

//       Given
        String existingTitle = "BRAINWASHING";
//       When
        Lab byTitle = labRepository.findByTitle(existingTitle);
//       Then
        assertEquals(existingTitle, byTitle.getTitle());
        }

    @Test
    void findByNonExisitingTitle() {
        // Given the data.sql
        String nenExisistingTtile  = "HOW TO TRAIN GOLDFISH USING ELEPHANT TRAINING TECHNIQUES";

        // When
        Lab byTitle = labRepository.findByTitle(nenExisistingTtile);

        // Then
        assertNull(byTitle);
    }
    }
