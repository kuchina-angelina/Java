package com.example.ToDoList.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.models.User;
import com.example.ToDoList.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
    public List<User> getUserByFirstName(String firstName){
        return userRepository.findByFirstName(firstName);
    }

    public List<User> getUserByLastName(String lastName){
        return userRepository.findByLastName(lastName);

    }

    public List<User> getUserBySurname(String surname){
        return userRepository.findBySurname(surname);

    }
    public List<User> getUserByBirthdate(Date date){
        return userRepository.findByBirthdate(date);

    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    
}
