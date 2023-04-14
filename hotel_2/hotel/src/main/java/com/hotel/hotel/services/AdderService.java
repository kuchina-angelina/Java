package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Adder;
import com.hotel.hotel.repositories.AddersRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class AdderService {
    @Autowired
    private AddersRepository adderRepository; //импортируем репо с методами для обработки запросов

    //методы для получения данных
    public List<Adder> getAllAdders(){
        return adderRepository.findAll();
    }

    public Adder getAdderById(Integer id){
        return adderRepository.findById(id).get();
    }

    // public List<Adder> getClientByFirstName(String firstName){
    //     return adderRepository.findByFirstName(firstName);
    // }

    //сохранение 
    public void saveAdder(Adder adder){
        adderRepository.save(adder);
    }

    //удаление
    public void deleteAdder(Integer id){
        adderRepository.deleteById(id);
    }

    

    

    
}
