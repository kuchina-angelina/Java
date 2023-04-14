package com.hotel.hotel.models;

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
@Data
@Table(name = "Tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer number;
    private String level;

    @ManyToMany
    @JoinColumn(name = "adder_id")
    private Set<Adder> adders;
    
    public void updateTariff(Tariff tariff){
        if (tariff.number != null){
            this.number = tariff.number;
        }

        if (tariff.level != null){
            this.level = tariff.level;
        }
        
    }
}
