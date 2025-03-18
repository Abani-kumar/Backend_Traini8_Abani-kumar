package com.Traini8.controller;

import com.Traini8.models.TrainingCenter;
import com.Traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {
    private final TrainingCenterService trainingCenterService;
    
    @Autowired
    public TrainingCenterController(TrainingCenterService trainingCenterService) {
        this.trainingCenterService = trainingCenterService;
    }
    
    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = trainingCenterService.createTrainingCenter(trainingCenter);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
