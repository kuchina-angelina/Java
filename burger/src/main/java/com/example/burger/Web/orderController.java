package com.example.burger.Web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.burger.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/order") // адрес для order.html
@SessionAttributes("burgerOrder") //открываем сессию в течение которой будет офрмляться заказ
public class orderController{
    @GetMapping("/current")
    public String orderForm(){
        return "order";
    }

    
    @PostMapping
    public String processOrder(
        @Valid BurgerOrder order, Errors errors, SessionStatus sessionStatus
    ){
        if (errors.hasErrors()){// если есть ошибки, то вернет страницу с оформлением доставки

            return "order";
        }

        sessionStatus.setComplete();
        return "redirect:/";// если ошибок нет, то вернет главную страничку
    }
}
