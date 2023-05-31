package com.example.trains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trains.models.Train;

public interface TrainRepository extends JpaRepository<Train,Integer> {
    
}
