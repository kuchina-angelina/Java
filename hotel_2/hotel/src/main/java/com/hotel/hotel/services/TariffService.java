package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Tariff;
import com.hotel.hotel.repositories.TariffRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class TariffService {
    @Autowired
    private TariffRepository tariffRepository;//импортируем репо с методами для обработки запросов

    //аналоогичные методы, как и в прошлых классах сервеса
    public List<Tariff> getAllTariffs(){
        return tariffRepository.findAll();
    }

    public Tariff getTariffById(Integer id){
            return tariffRepository.findById(id).get();
    }
    // public List<Adder> getClientByFirstName(String firstName){
    //     return adderRepository.findByFirstName(firstName);
    // }

    public void saveTariff(Tariff tariff){
        tariffRepository.save(tariff);
    }

    public void deleteTariff(Integer id){
        tariffRepository.deleteById(id);
    }

    

    
}
