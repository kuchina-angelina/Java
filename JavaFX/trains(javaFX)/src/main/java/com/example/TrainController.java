package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// контроллер для файла train.fxml
public class TrainController {
    // извлекаем переменные 
    @FXML
    private TextField name;

    @FXML
    private TextField typeTrain;

    @FXML
    private TextField wagons;

    @FXML
    private TextField seatsNumber;

    @FXML
    private Button backBtn;

    @FXML
    private Button createBtn;

    //обраюотка для нажатия кнопок
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void createAction() throws IOException {
        App.setRoot("primary");
    }

}
