package com.example.cinema.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Seats")
public class Seat {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "line")
    private int line;

    @Column(name = "number")
    private int number;
    
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> tickets;
}
