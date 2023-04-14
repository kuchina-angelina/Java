package com.example.ToDoList.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.models.Task;
import com.example.ToDoList.repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional //выполняется либо полностью, либо не выполняется
public class TaskService {
    @Autowired //собирает проект и подгружает все необходимые зависимости
    private TaskRepository taskRepository;

    //получение списка всех заданий, получение по имени,описанию  и айди
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

    public List<Task> getTaskByEndDate(Date date){
        return taskRepository.findByEndDate(date);

    }

    //сохранение задания
    public void saveTask(Task task){
        taskRepository.save(task);
    }

    //удаление задания
    public void deleteTask(Integer id){
        taskRepository.deleteById(id);
    }
    
}
