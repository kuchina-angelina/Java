package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Convenient;
import com.hotel.hotel.services.ConvenientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// тут все аналогично, как и в прошлых классах

@RestController
@RequestMapping("/convenients")
public class ConvenientController {
    @Autowired
    private ConvenientService convenientService;

    @GetMapping("/getAll")
    public List<Convenient> getAllConvenients() {
        return convenientService.getAllConvenients();
    }
    
    @GetMapping("/getConvenient/{name}")
        public List<Convenient> getConvenientByName(@PathVariable String name){
            return convenientService.getConvenientByName(name);
    }

    @PostMapping("/add")
    public void add(@RequestBody Convenient convenient){
        convenientService.saveConvenient(convenient);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoom(@RequestBody Convenient convenient, @PathVariable Integer id){
        try{
            Convenient baseConvenient = convenientService.getConvenientById(id);
            baseConvenient.updateConvenient(convenient);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Integer id){
        convenientService.deleteConvenientById(id);
    }
}
