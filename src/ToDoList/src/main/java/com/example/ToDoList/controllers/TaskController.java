package com.example.ToDoList.controllers;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ToDoList.models.Task;
 

import com.example.ToDoList.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/get/{id}")
    public Task getTaskById(@RequestParam Integer id) {
        return taskService.getTaskById(id);
    }


    @GetMapping(value="/get/{name}")
    public List<Task> getUserByName(@RequestParam String name) {
        return taskService.getTaskByName(name);
    }
    
    @GetMapping("/get/{description}")
    public List<Task> getTaskByDescription(@RequestParam String description) {
        return taskService.getTaskByDescription(description);
    }

    @GetMapping("/get/{endDate}")
    public List<Task> getUserByEndDate(@RequestParam Date date){
        return taskService.getUserByEndDate(date);
    }

    
    
    @PostMapping(value="/add")
    public void saveTask(@RequestBody Task task) {
        taskService.saveTask(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Task task, @PathVariable Integer id){
        try{
            Task baseTask = taskService.getTaskById(id);
            baseTask.update(task);
            taskService.saveTask(baseTask);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } 
    }
}
