package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Convenient;

public interface ConvenientRepository extends JpaRepository<Convenient,Integer>{
    //метод для поиска по атрибуту
    List<Convenient> findByName(String name);
    
}
