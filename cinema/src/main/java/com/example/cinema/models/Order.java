package com.example.cinema.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<Ticket> tickets;

}


// Аннотация @JoinColumn помогает нам указать столбец, который мы 
// будем использовать для присоединения к ассоциации сущностей или 
// коллекции элементов. 

// С другой стороны, атрибут mappedBy используется 
// для определения ссылающейся стороны (не владеющей стороной) отношения.
