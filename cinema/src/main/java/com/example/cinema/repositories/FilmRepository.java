package com.example.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.models.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
    
}
