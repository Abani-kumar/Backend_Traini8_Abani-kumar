package com.Traini8.repository;

import com.Traini8.models.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long>{
    
}
