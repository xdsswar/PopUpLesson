package org.popup.lesson.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author XDSSWAR
 * Created on 7/10/2022
 */
public class PopUpController implements Initializable {

    @FXML
    private Button closeBtn;

    @FXML
    private Label labelTxt;

    private final String text;

    public PopUpController(String text) {
        this.text = text;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Since we passed the text as parameter we check if empty
        if (text.isEmpty()){
            labelTxt.setText("You typed nothing...");
        }else {
            //If not empty we set the label with it
            labelTxt.setText(text);
        }

        //Close the popup stage
        closeBtn.setOnAction(event -> {
           Stage stage=  ((Stage)closeBtn.getScene().getWindow());
           stage.close();
        });
    }

}
