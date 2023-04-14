package com.hotel.hotel.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.models.Room;
import com.hotel.hotel.services.RoomService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// тут все аналогично, как и в прошлых классах

@RestController
@RequestMapping("/rooms")
public class RoomController{
    @Autowired
    private RoomService roomService;

    @GetMapping("/getAll")
    public List<Room> getAllRooms() {
        return  roomService.getAllRooms();
    }
    
    @GetMapping("/getRoom/{number}")
    public List<Room> getRoomByNumber(@PathVariable Integer number){
        return roomService.getRoomByNumber(number);

    }    

    @PostMapping("/add")
    public void add(@RequestBody Room room){
        roomService.saveRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoomById(@PathVariable Integer id){
        roomService.deleteRoomById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRoom(@RequestBody Room room, @PathVariable Integer id){
        try{
            Room baseRoom = roomService.getRoomById(id);
            baseRoom.updateRoom(room);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}