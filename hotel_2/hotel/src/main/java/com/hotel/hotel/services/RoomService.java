package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.repositories.RoomRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;//импортируем репо с методами для обработки запросов

        //аналоогичные методы, как и в прошлых классах сервеса

    public List<Room> getAllRooms(){
        return roomRepository.findAll();    
    }

    public List<Room> getRoomByNumber(Integer number){
        return roomRepository.findByNumber(number);
    }

    public Room getRoomById(Integer id){
        return roomRepository.findById(id).get();
    }

    public void saveRoom(Room room){
         roomRepository.save(room);
    }

    public void deleteRoomById(Integer id){
         roomRepository.deleteById(id);
    }

    


}
