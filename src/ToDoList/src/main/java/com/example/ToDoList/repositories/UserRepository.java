package com.example.ToDoList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.models.User;
import java.util.Date;


public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findBySurname(String surname);
    List<User> findByBirthdate(Date birthdate);
}
