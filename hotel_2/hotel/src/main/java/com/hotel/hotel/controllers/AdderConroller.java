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

import com.hotel.hotel.models.Adder;
import com.hotel.hotel.services.AdderService;

@RestController
@RequestMapping("/adders") //адрес для передачи запросов
public class AdderConroller {
    @Autowired
    private AdderService adderService; //импортируем сервис с методами

    //получение списка всех услуг
    @GetMapping("/getAll")
    public List<Adder> getAllAdders(){
        return adderService.getAllAdders();
    }

    // @GetMapping("/get/{}")
    // public List<Level> getLevels(){
    //     return levelService.getLevels();
    // }

    //добавление услуг
    @PostMapping("/add")
    public void saveAdder(@RequestBody Adder adder){
        adderService.saveAdder(adder);
    }

    //корректировка услуг
    @PutMapping("/update/{id}")
    //@RequestBody сопоставляет тело HttpRequest с объектом передачи или домен
        //PathVariable извлекает номер айди из строки
        //ResponseEntity<?> принимает любой объект джава
        //Конструктор ResponseEntity позволяет перегружать этот объект, добавляя в него не только наш возвращаемый тип, но и статус, 
        //чтобы в случае ошибки можно было понимать, что именно пошло не так.
    public ResponseEntity<?> updateAdder(@RequestBody Adder adder, @PathVariable Integer id){
        try{
            Adder baseAdder = adderService.getAdderById(id);
            baseAdder.updateAdder(adder);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //удаление 
    @DeleteMapping("/delete/{id}")
    public void deleteAdder(Integer id){
        adderService.deleteAdder(id);
    }

}
