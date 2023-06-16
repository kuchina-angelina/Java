package com.example;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ListTrainsController {
    
    @FXML
    private Label trainNameLabel;

    @FXML
    private Label trainTypeLabel;

    @FXML
    private Label trainCarCountLabel;

    @FXML
    private Label trainSeatsCountLabel;
    
    public void setTrainName(String name) {
        trainNameLabel.setText(name);
    }

    public void setTrainType(String type) {
        trainTypeLabel.setText(type);
    }

    public void setTrainCarCount(int count) {
        trainCarCountLabel.setText(String.valueOf(count));
    }

    public void setTrainSeatsCount(int count) {
        trainSeatsCountLabel.setText(String.valueOf(count));
    }

    @FXML
    private void back() throws IOException {
        App.setRoot("primary");
    }
}
