package com.example.trains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trains.models.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>{
    
}
