package com.hotel.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    // метод для поиска клиента по имени
    List<Client> findByFirstName(String firstName);
}
