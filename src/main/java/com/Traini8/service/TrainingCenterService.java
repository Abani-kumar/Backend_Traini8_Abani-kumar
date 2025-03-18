package com.Traini8.service;

import com.Traini8.models.TrainingCenter;
import com.Traini8.repository.TrainingCenterRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCenterService {
    private final TrainingCenterRepository trainingCenterRepository;

    @Autowired
    public TrainingCenterService(TrainingCenterRepository trainingCenterRepository){
        this.trainingCenterRepository=trainingCenterRepository;
    }

    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter){
        trainingCenter.setCreatedOn(System.currentTimeMillis());
        return trainingCenterRepository.save(trainingCenter);
    }
    public List<TrainingCenter> getAllTrainingCenters() {
        return trainingCenterRepository.findAll();
    }
}
