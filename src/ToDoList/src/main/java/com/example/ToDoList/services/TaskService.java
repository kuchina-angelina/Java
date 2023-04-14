package com.example.ToDoList.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.models.Task;
import com.example.ToDoList.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Integer id){
        return taskRepository.findById(id).get();
    }
    public List<Task> getTaskByName(String name){
        return taskRepository.findByName(name);

    }

    public List<Task> getTaskByDescription(String description){
        return taskRepository.findByDescription(description);

    }

    public List<Task> getUserByEndDate(Date date){
        return taskRepository.findByEndDate(date);

    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }
    
}
