package com.hotel.hotel.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//аналогично, как и в прошлых моделях

@Entity
@Data
@Table(name="Levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String price;

    public void updateLevel(Level level){
        if(this.name != null){
            this.name = level.name;
        }

        if(this.description != null){
            this.name = level.description;
        }

        if(this.price != null){
            this.name = level.price;
        }
    }

    
}
