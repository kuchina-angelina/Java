package com.hotel.hotel.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // показывает, что наш класс это сущность
@Data //генерирует геттеры и сеттеры
@Table(name = "Adders") //название таблицы
public class Adder {
    //прописываем аннотации, которы ебудут гененрировать на айди
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String price;

    //метод для изменения данных об услугах
    public void updateAdder(Adder adder){
        if(adder.name != null){
            this.name = adder.name;
        }

        if(adder.price != null){
            this.price = adder.price;
        }
    }

    @ManyToMany
    @JoinTable(name = "adders_and_tarifffs",
        joinColumns = @JoinColumn(name = "servise_id", referencedColumnName = "id"), //соединяем таблицы по их айди
        inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id"))
    private List<Adder> adders;
}