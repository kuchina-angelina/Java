package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField myTextField;

    @FXML
    private Button myButton;

    @FXML
    private static Label resultLabel;

   


    public static void setResult(String r) {
        resultLabel.setText(r);
    }


    @FXML
    public void handleButtonClick(ActionEvent event) {
        String text = myTextField.getText();
     
        ArrayList<Integer> numbers =  new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        count(numbers);
        

    }

    @FXML
     public static ArrayList<Integer> readFile(String filename){
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bufferedReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(numbers);
        return numbers;
    }
    
    @FXML
    public static void count(ArrayList<Integer> numbers){
        int result = (numbers.get(0) + numbers.get(1))/2;
        setResult(Integer.toString(result));
}
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

