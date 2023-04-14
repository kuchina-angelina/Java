package com.example.ToDoList.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // показывает, что наш класс это сущность
@Table(name= "Tasks") //имя таблицы
@Data
public class Task {
    //айди генерируется самостоятельно
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Date endDate;
    private boolean done;
    
    @ManyToMany //устанавливаем связь М:М с таблицей категории
    @JoinColumn(name = "category_id") // название столбца в таблице
    private Set<Category> categories; //множество, где хранятся категории
    
    //метод для внесения изменений в задание
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
