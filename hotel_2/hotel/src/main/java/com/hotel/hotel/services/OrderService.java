package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Order;
import com.hotel.hotel.repositories.OrderRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;//импортируем репо с методами для обработки запросов
        //аналоогичные методы, как и в прошлых классах сервеса


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id){
        return orderRepository.findById(id).get();
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrderById(Integer id){
        orderRepository.deleteById(id);
    }
}
