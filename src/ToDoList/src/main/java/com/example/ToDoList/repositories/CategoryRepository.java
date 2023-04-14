package com.example.ToDoList.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ToDoList.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    List<Category> findByName(String name);
    
}
