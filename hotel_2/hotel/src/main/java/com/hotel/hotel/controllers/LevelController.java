package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Level;
import com.hotel.hotel.services.LevelService;

@RestController
@RequestMapping("/levels") //адрес для запрсов
public class LevelController {
    @Autowired
    private LevelService levelService;//импортируем сервис для оущетсвления методов

    //список всех уровней
    @GetMapping("/getAll")
    public List<Level> getLevels(){
        return levelService.getLevels();
    }

    // @GetMapping("/get/{}")
    // public List<Level> getLevels(){
    //     return levelService.getLevels();
    // }

    //добавление уровня
    @PostMapping("/add")
    public void save(@RequestBody Level level){
        levelService.saveLevel(level);
    }

    //изменение
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateLevel(@RequestBody Level level, @PathVariable Integer id){
        try{
            Level baseLevel = levelService.getLevelById(id);
            baseLevel.updateLevel(level);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //удаление
    @DeleteMapping("/delete/{id}")
    public void delete(Integer id){
        levelService.deleteLevelById(id);
    }

    
}
