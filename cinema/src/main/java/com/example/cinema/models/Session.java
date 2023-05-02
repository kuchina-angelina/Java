package com.example.cinema.models;

import java.util.List;

// import javax.print.attribute.standard.DateTimeAtCompleted;
// import javax.print.attribute.standard.DateTimeAtCreation;

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

@Entity
@Data
@Table(name = "Sessions")
public class Session {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "start")
    private String start; //дата + время ? тип данных ?

    @Column(name = "finish")
    private String finish;
    // private String finish;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name= "hall_id")
    private Hall hall;

    @OneToMany(mappedBy = "session")
    private List <Ticket> tickets;
}
