package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PrimaryController implements Initializable{

    // получаем кнопки с главной страницы
    @FXML
    Button addFlightButton;

    @FXML
    Button trainsButton;

    @FXML
    Button addTrainButton;

    @FXML
    Button futureButton;


    // Обработчик для кнопки, при нажатии будет открыта нужная страница
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void switchToTrain() throws IOException {
        App.setRoot("train");
    }
    
    @FXML
    private void switchToList() throws IOException {
        App.setRoot("listTrains");
    }

    @FXML
    private void switchToFlight() throws IOException {
        App.setRoot("listSchedules");
    }
    

    @Override
    // задаем название для кнопок
        public void initialize(URL location, ResourceBundle resources) {
            addFlightButton.setText("Добавить рейс");  
            trainsButton.setText("Список поездов");  
            addTrainButton.setText("Добавить поезд");         
            futureButton.setText("Расписание");         

        }


}
