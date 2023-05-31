package com.example.trains.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trains.models.Schedule;
import com.example.trains.services.ScheduleService;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired 
    private ScheduleService scheduleService;

    @PostMapping("/add")
    public void save(@RequestBody Schedule schedule) {
        scheduleService.save(schedule);
    }

    @GetMapping("/getAll")
    public List<Schedule> getAll() {
        return scheduleService.getAll();
    }
    
}
