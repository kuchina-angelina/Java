package com.example.trains.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Класс представляет информацию о расписании.
 * Расписание хранит информацию о маршруте поездки:
 * город отправления, город назначения, даты и время отправления/прибытия,
 * а также цену поездки.
 */
@Entity // Отмечает класс как сущность, которая будет храниться в базе данных.
@Data 
@Table (name = "Schedules") 
public class Schedule {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY) 
    private int id;

    /**
     *Название города отправления
     */
    private String cityFrom; 
    /**
     *Название города назначения
     */
    private String cityTo; 
    /**
     *Дата отправления
     */
    private Date dateFrom; 
    /**
     * Дата прибытия.
     */
    private Date dateTo; 
    /**
     *Время отправления
     */
    private Time timeFrom; 
    /**
     *Время прибытия
     */
    private Time timeTo; 
    /**
     *Базовая цена
     */
    private int price; 
 
    
    @OneToMany(mappedBy = "film")
    @JsonIgnore
    private List<Train> trains;

}
