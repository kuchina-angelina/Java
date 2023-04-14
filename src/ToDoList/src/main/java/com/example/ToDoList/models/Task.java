package com.example.ToDoList.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date endDate;
    private boolean done;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    
    public void update(Task task ){
        if (task.name != null ){
            this.name = task.name;
        }
        if (task.description != null){
            this.description = task.description;
        }
        if (task.endDate != null){
            this.endDate = task.endDate;
        }
        if (task.done != this.done){
            this.done = task.done;
        }
    }

}
