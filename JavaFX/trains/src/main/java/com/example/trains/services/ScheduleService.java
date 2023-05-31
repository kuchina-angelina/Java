package com.example.trains.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trains.models.Schedule;
import com.example.trains.repositories.ScheduleRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAll(){
        return scheduleRepository.findAll();
    }

    public void save (Schedule schedule){
        scheduleRepository.save(schedule);
    }
    
}
