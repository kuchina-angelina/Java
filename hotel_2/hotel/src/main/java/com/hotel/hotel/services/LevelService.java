package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Level;
import com.hotel.hotel.repositories.LevelRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class LevelService {
    @Autowired
    private LevelRepository levelrepository;//импортируем репо с методами для обработки запросов
    
    //аналоогичные методы, как и в прошлых классах сервеса
    public List<Level> getLevels(){
        return levelrepository.findAll();    
    }

    // public List<Level> getLevelByName(String name){
    //     return levelrepository.findByName(name);    
    // }

    public Level getLevelById(Integer id){
        return levelrepository.findById(id).get();    
    }

    public void saveLevel(Level level){
         levelrepository.save(level);
    }
  

    public void deleteLevelById(Integer id) {
       levelrepository.deleteById(id);

    }
}



