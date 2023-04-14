package com.example.ToDoList.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String lastName;
    private String firstName;
    private String surname;
    private Date birthdate;

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

    
    
}
