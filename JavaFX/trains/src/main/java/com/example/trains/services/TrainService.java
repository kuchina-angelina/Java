package com.example.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trains.models.Train;
import com.example.trains.repositories.TrainRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAll(){
        return trainRepository.findAll();
    }

    public void save(Train train){
        trainRepository.save(train);
    }
    
}
