package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class PrimaryController implements Initializable{

    @FXML
    Button primaryButton;
    

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @Override
        public void initialize(URL location, ResourceBundle resources) {
            primaryButton.setText("Click to start");
            // StringBuilder sb = new StringBuilder("Hello 2345678");
            // primaryButton.setText(sb.toString());
        }


}
