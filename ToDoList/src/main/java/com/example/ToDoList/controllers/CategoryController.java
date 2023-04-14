package com.example.ToDoList.controllers;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  com.example.ToDoList.models.Category;
import com.example.ToDoList.services.CategoryService;

@RestController
@RequestMapping("categories") //адрес для запросов
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // добавление категории
    @PostMapping("/")
    public void save(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    // получение списка всех категорий
    @GetMapping("")
    public List<Category> getAll() {
        return categoryService.getAllСategories();
    }

    // удаление категории
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
    }

    // получение категории по айди
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        try{
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<Category>(category, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
}