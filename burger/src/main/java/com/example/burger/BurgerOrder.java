package com.example.burger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//ниже приведены данные, которые клиент заполняет для доставки
@Data
public class BurgerOrder {
    @NotBlank(message = "Поле 'Имя' обязательно для заполнения") //аннтоация @NotBlank проверяет, что строка не пустая
    private String firstName;

    @NotBlank(message = "Поле 'Фамилия' обязательно для заполнения")
    private String lastName;

    @NotBlank(message = "Поле 'Улица' обязательно для заполнения")
    private String street;

    @NotBlank(message = "Поле 'Город' обязательно для заполнения")
    private String city;

    @CreditCardNumber // формат ввода номера карты - 16 цифр
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][3-9])$", // при помощи регулярных выражений проверяем, чтобы ввели корректные данные о сроке действия карты
    //а именно: месяц в диапозоне 1-12 и год не раньше 23
             message="Формат MM/YY, год не должен быть раньше текущего")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Неправильный CVV") //проверяет, чтобы введенные данные были целым числом, иначе выведется сообщение об ошибке
    private String CVV;

    private List<Burger> burgers = new ArrayList<>();

    public void addBurger(Burger burger){
        this.burgers.add(burger);// список со всеми бургерами
    }
    
}
