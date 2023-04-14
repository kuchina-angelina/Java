package com.hotel.hotel.models;



import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer number;
    private Integer floor;
    private String description;


    @ManyToMany
    @JoinColumn(name="convenient_id")
    private List<Convenient> conveniences;
    private Set <Room> rooms;

    
    
    
    public void updateRoom(Room room){
        if (room.number != null){
            this.number = room.number;
        }

        if (room.floor != null){
            this.floor = room.floor;
        }

        if (room.description != null){
            this.description = room.description;
        }
    }
}