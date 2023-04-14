package com.example.burger;

import lombok.Data;

//класс ингридиентов
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    //перечисление типов , к которым относятся продукты, чтобы было удобнее обращаться к ингридиентам 
    public enum Type {
        MEAT,
        SAUCE,
        VEGETABLES,
        CHEESE,
    }
}
