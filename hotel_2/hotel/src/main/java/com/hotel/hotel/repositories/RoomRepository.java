package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    //поиск по атрибуту
    List<Room> findByNumber(Integer number);
    
    
}
