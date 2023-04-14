package com.example.ToDoList.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public void update(Category category){
        if(category.name != null){
            this.name = category.name;
        }
    }

    @ManyToMany
    @JoinTable(name = "CT", // таблица, которая получится в результате установки связей
        joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"), // category_id - id в таблице категории
        inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id")) // ас заданием точно также
    private Set<Task> tasks;
    
}
