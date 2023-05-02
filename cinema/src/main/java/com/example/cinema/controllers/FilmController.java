package com.example.cinema.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cinema.models.Film;
import com.example.cinema.services.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping("/add")
    public void save(@RequestBody Film film) {
        filmService.saveFilm(film);
    }

    @GetMapping("/getAll")
    public List<Film> getAll() {
        return filmService.getAllFilms();
    }
    
}
