package com.example.trains.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Класс представляет информацию о поезде.
 * Поезд хранит информацию об имени, типе, количестве вагонов и общем количестве мест в них.
 * Кроме того, имеется связь с другим поездом через ассоциацию "Многие-к-одному".
 * 
 */

@Entity
@Data
@Table(name = "Trains")
public class Train {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    /**
     *Название поезда
     */
    private String name;
    /**
     *Тип поезда
     */
    private String type;
    /**
     *Количество вагонов
     */
    private int wagons;
    /**
     *Количество мест в вагоне
     */
    private int seats;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Schedule schedule;

}
