package com.example.trains.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trains.models.Train;
import com.example.trains.services.TrainService;

@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired 
    private TrainService trainService;

    @PostMapping("/add")
    public void save(@RequestBody Train train) {
        trainService.save(train);
    }

    @GetMapping("/getAll")
    public List<Train> getAll() {
        return trainService.getAll();
    }
}
