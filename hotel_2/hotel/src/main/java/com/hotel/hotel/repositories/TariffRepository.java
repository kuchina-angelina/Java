package com.hotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Tariff;

public interface TariffRepository extends JpaRepository<Tariff,Integer>{
    
}
