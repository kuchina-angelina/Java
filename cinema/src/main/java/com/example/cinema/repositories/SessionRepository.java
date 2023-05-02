package com.example.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.models.Session;

public interface SessionRepository extends JpaRepository<Session,Integer>{
    
}
