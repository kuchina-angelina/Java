package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Convenient;
import com.hotel.hotel.repositories.ConvenientRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class ConvenientService {
    @Autowired
    private ConvenientRepository convenientRepository;//импортируем репо с методами для обработки запросов

        //аналоогичные методы, как и в прошлых классах сервеса


    public List<Convenient> getAllConvenients(){
        return convenientRepository.findAll();    
    }

    public List<Convenient> getConvenientByName(String name){
        return convenientRepository.findByName(name);    
    }

    public Convenient getConvenientById(Integer id){
        return convenientRepository.findById(id).get();    
    }

    public void saveConvenient(Convenient convenient){
        convenientRepository.save(convenient);
    }

    public void deleteConvenientById(Integer id){
        convenientRepository.deleteById(id);
    }
}
