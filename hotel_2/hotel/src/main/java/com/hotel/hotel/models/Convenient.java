package com.hotel.hotel.models;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

//аналогично, как и в прошлых моделях
@Entity
@Table(name = "Convenients")
@Data
public class Convenient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    
    public void updateConvenient(Convenient convenient){
        if(this.name != null){
            this.name = convenient.name;
        }
    }

    @ManyToMany 
    @JoinTable(name = "convenience_and_room", //таблица, оторя получится в результате установления связи
        joinColumns = @JoinColumn(name = "convenientid", referencedColumnName = "id"), // джойним таблицы по айди (в таблицах room and convenient)
        inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
    private List<Room> rooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    
    
}
