package com.example.ToDoList.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // показывает, что класс пользователь - это сущность
@Table(name= "Users") //задае название таблицы
@Data // используем для сокращения кода
public class User {
    //прописываем, чтобы наш айди генерировался самостоятельно 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String lastName;
    private String firstName;
    private String surname;
    private Date birthdate;

    //метод для изменения  пользователя
    public void update(User user ){
        if (user.login != null){
            this.login = user.login;
        }
        if (user.lastName != null){
            this.lastName = user.lastName;
        }
        if (user.firstName != null){
            this.firstName = user.firstName;
        }
        if (user.surname != null){
            this.surname = user.surname;
        }
    }
    //устанавливаем связь с заданием
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Task> tasks;

    
    
}
