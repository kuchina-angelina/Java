package com.example.ToDoList.controllers;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.ToDoList.models.User;
import com.example.ToDoList.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value="/get/{firstName}")
    public List<User> getUserByFirstname(@RequestParam String firstName) {
        return userService.getUserByFirstName(firstName);
    }
    
    @GetMapping(value="/get/{lastName}")
    public List<User> getUserByLastname(@RequestParam String lastName) {
        return userService.getUserByLastName(lastName);
    }

    @GetMapping(value="/get/{surname}")
    public List<User> getUserBySurname(@RequestParam String surname) {
        return userService.getUserBySurname(surname);
    }

    @GetMapping(value="/get/{birthdate}")
    public List<User> getUserByBirthdate(@RequestParam Date birthdate) {
        return userService.getUserByBirthdate(birthdate);
    }
    
    @PostMapping(value="/add")
    public void postMethodName(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PutMapping(value="update/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id){
        try{
            User baseUser = userService.getUserById(id);
            baseUser.update(user);
            userService.saveUser(baseUser);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    




    

    
}
