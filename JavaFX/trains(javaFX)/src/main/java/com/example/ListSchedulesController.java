package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ListSchedulesController {
    
    @FXML
    private Label departureCityLabel;

    @FXML
    private Label arrivalCityLabel;

    @FXML
    private Label departureDateLabel;

    @FXML
    private Label departureTimeLabel;

    @FXML
    private Label arrivalDateLabel;

    @FXML
    private Label arrivalTimeLabel;

    @FXML
    private Label trainSeatsCountLabel;

    @FXML
    private Label trainFreeSeatsCountLabel;
    
    public void setDepartureCity(String city) {
        departureCityLabel.setText(city);
    }

    public void setArrivalCity(String city) {
        arrivalCityLabel.setText(city);
    }

    public void setDepartureDate(String date) {
        departureDateLabel.setText(date);
    }

    public void setDepartureTime(String time) {
        departureTimeLabel.setText(time);
    }

    public void setArrivalDate(String date) {
        arrivalDateLabel.setText(date);
    }

    public void setArrivalTime(String time) {
        arrivalTimeLabel.setText(time);
    }

    public void setTrainSeatsCount(int count) {
        trainSeatsCountLabel.setText(String.valueOf(count));
    }

    public void setTrainFreeSeatsCount(int count) {
        trainFreeSeatsCountLabel.setText(String.valueOf(count));
    }

    @FXML
    private void backTo() throws IOException {
        App.setRoot("primary");
    }
}
