package com.hotel.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotel.models.Client;
import com.hotel.hotel.repositories.ClientRepository;

import jakarta.transaction.Transactional;

@Service //аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
@Transactional
public class ClientService {
    @Autowired
    private ClientRepository clientRepository; //импортируем репо с методами для обработки запросов

        //аналоогичные методы, как и в прошлых классах сервеса


    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public List<Client> getClientByFirstName(String firstName){
        return clientRepository.findByFirstName(firstName);
    }

    public Client getClientById(Integer id){
        return clientRepository.findById(id).get();
    }

    public void saveClient(Client client){
        clientRepository.save(client);
    }

    public void deleteClientById(Integer id){
        clientRepository.deleteById(id);
    }

    
}
