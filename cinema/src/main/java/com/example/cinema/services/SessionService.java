package com.example.cinema.services;

import java.util.List;
import com.example.cinema.models.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.repositories.SessionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SessionService {
    @Autowired
    SessionRepository sessionRepository;

    public List<Session> getAllSession(){
        return sessionRepository.findAll();
    }

    // public List<Session> getSeatByStarr(Date start){
    //     return sessionRepository.findByStart(start); // надо понять, какой тип данных использовать для этого 
    // }

    public void saveSession(Session session){
        sessionRepository.save(session);
    }

    public void deleteSession(Integer id){
        sessionRepository.deleteById(id);
    }
    
}
