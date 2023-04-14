package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Adder;

public interface AddersRepository extends JpaRepository<Adder,Integer>{
    
}
