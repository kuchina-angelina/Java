package com.example.burger;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Burger {
    //после того, как выбрали ингридиенты необходимо ввести название своего заказа
    @NotBlank //проверяем, чтобы строчка не была пустой
    private String name;

    @NotNull //проверяет, чтобы присутствовал хотя бы один ингридиент
    @Size(min=1)
    private List<Ingredient> ingredients;
}
