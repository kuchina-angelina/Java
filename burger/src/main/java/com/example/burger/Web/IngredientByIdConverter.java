package com.example.burger.Web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import com.example.burger.*;
import com.example.burger.Ingredient.Type;

//данный класс преобразовываетингридиент в строку
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{
    
    private Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
            // создаем словарь ингредиентов с ключами в виде строк id
        ingredientMap.put("chedder", new Ingredient("chedder", "Сыр чеддер", Type.CHEESE));
        ingredientMap.put("feta",new Ingredient("feta", "Сыр фета", Type.CHEESE));
        ingredientMap.put("pig",new Ingredient("pig", "Свинина", Type.MEAT));
        ingredientMap.put("beef",new Ingredient("beef", "Говядина", Type.MEAT));
        ingredientMap.put("blueCheese",new Ingredient("blueCheese", "Соус Блю Чиз", Type.SAUCE));
        ingredientMap.put("teriyaki",new Ingredient("teriyaki", "Соус Терияки", Type.SAUCE));
        ingredientMap.put("tomato",new Ingredient("tomato", "Томаты", Type.VEGETABLES));
        ingredientMap.put("onion",new Ingredient("onion", "Красный лук", Type.VEGETABLES));
        ingredientMap.put("pepper",new Ingredient("pepper", "Перец", Type.VEGETABLES));
        ingredientMap.put("cucumber",new Ingredient("cucumber", "Дольки огурца", Type.VEGETABLES));
    }

    @Override
    // а заем вытаскиваем из словаря ингредиенты по ключу(айди)-строке

    public Ingredient convert(String id){
        return ingredientMap.get(id);
    }

}
