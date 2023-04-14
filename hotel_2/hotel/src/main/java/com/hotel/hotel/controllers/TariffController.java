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

import com.hotel.hotel.models.Tariff;
import com.hotel.hotel.services.TariffService;

// тут все аналогично, как и в прошлых классах

@RestController
@RequestMapping("/tariffs")
public class TariffController {
    @Autowired
    private TariffService tariffService;

    @GetMapping("/getAll")
    public List<Tariff> getAllTariffs(){
        return tariffService.getAllTariffs();
    }

    // @GetMapping("/get/{}")
    // public List<Level> getLevels(){
    //     return levelService.getLevels();
    // }

    @PostMapping("/add")
    public void saveTariff(@RequestBody Tariff tariff){
        tariffService.saveTariff(tariff);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTariff(@RequestBody Tariff tariff, @PathVariable Integer id){
        try{
            Tariff baseTariff = tariffService.getTariffById(id);
            baseTariff.updateTariff(tariff);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdder(Integer id){
        tariffService.deleteTariff(id);
    }
    
}
