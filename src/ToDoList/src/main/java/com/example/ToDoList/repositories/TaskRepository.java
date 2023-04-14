package com.example.ToDoList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.models.Task;
import java.util.Date;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    List<Task> findByName(String name);
    List<Task> findByDescription(String description);
    List<Task> findByEndDate(Date endDate);
}
