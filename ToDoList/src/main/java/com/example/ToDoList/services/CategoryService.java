package com.example.ToDoList.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ToDoList.models.Category;
import com.example.ToDoList.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    //получение категорий по айди,имени и список всех категорий
    public List<Category> getAllСategories(){
        return categoryRepository.findAll();
    }

    public List<Category> getCategorsByName(String name){
        return categoryRepository.findByName(name);

    }


    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id).get();
    }

    //добавление категории
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    // удаление категории по id 
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    
    

}
