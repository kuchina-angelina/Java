package com.example.burger.Web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.burger.Ingredient.Type;
import jakarta.validation.Valid;
import com.example.burger.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;



@Controller //класс явл контроллером
@SessionAttributes("burgerOrder") //заускаем сессию, в течение которой будет обрабаьываться заказ
@RequestMapping("/create") // обертка, которая контролирует html страничку 

public class CreateController {
    @ModelAttribute
    //создаем ингридиенты и затем добавляем их в модель
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("chedder", "Сыр чеддер", Type.CHEESE),
            new Ingredient("feta", "Сыр фета", Type.CHEESE),
            new Ingredient("pig", "Свинина", Type.MEAT),
            new Ingredient("beef", "Говядина", Type.MEAT),
            new Ingredient("blueCheese", "Соус Блю Чиз", Type.SAUCE),
            new Ingredient("teriyaki", "Соус Терияки", Type.SAUCE),
            new Ingredient("tomato", "Томаты", Type.VEGETABLES),
            new Ingredient("onion", "Красный лук", Type.VEGETABLES),
            new Ingredient("pepper", "Перец", Type.VEGETABLES),
            new Ingredient("cucumber", "Дольки огурца", Type.VEGETABLES)

        );
        Type[] types = Ingredient.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
            filterByType(ingredients, type));// сортируем по типу ингридиентов
       }
    }

    @ModelAttribute(name="burgerOrder") //создаёт объект класса, где заказываем бургер, в html и обращение к его атрибутам
    public BurgerOrder order(){
        return new BurgerOrder();
    }

    @ModelAttribute(name="burger") //создаёт объект класса бургер в html и обращение к его атрибутам
    public Burger  burger(){
        return new Burger();
    }

    private Iterable<Ingredient> filterByType(
        List<Ingredient> ingredients, Type type
    ){
        return ingredients.stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
    }
    // ingredients.stream() – создание стрима (потока) из списка
        // filter(x -> x.getType().equals(type)) – фильтрация по типам ингредиентов
        // collect(Collector collector) – метод собирает все элементы в список, множество или другую коллекцию
    
    
    @PostMapping
    public String processBurger(
        @Valid Burger burger, Errors errors, @ModelAttribute BurgerOrder burgerOrder
    ){
        if (errors.hasErrors()){ //если при сборке заказа произошла ошибка, то вернется страничка с созданием бургера
            return "create";
        }
        burgerOrder.addBurger(burger); //если же все хорошо, то оно перекинет на другую страничку для заполнения данных
        return "redirect:/order/current";
    }

    @GetMapping //отображает нашу страничку
    public String showCreate(){
        return "create";
    }
}

