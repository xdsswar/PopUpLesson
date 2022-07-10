package org.popup.lesson.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.popup.lesson.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author XDSSWAR
 * Created on 7/10/2022
 */
public class MainController implements Initializable {
    @FXML
    private TextField textField;

    @FXML
    private Button showPopUpBtn; //We take the button from the FXML file main.fxml

    //PopUp Stage
    private static Stage popUpStage;

    /**
     * This method prepares everything
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
         * Click event to display the popup
         */
        showPopUpBtn.setOnAction(event -> {
            try {
              showPopUp(textField.getText());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    /**
     * Display the popUp Stage
     * @param text The text from the TextField
     * @throws IOException Error
     */
    private void showPopUp(String text) throws IOException {
        //Check if the popUpStage is not null to close it
        if (popUpStage!=null) popUpStage.close();

        //Initialize the popUpStage
        popUpStage=new Stage();
        popUpStage.setResizable(false);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        //We can get the Stage we want to use as Owner from any node that in on it like in this
        //case we use the showPopUpBtn
        popUpStage.initOwner(showPopUpBtn.getScene().getWindow());

        //Create the popup controller with the parameter, here is where the load method from Main class come handy
        //so we can create controllers with parameters, this text parameter is the text we will use in the PopUpController
        PopUpController controller=new PopUpController(text);
        //Now we load the fxml, set the controller  and setup all to display
        Parent parent = Main.load("/org/popup/lesson/pop-up.fxml",controller);
        Scene scene=new Scene(parent);
        popUpStage.setScene(scene);
        //We show and wait
        popUpStage.showAndWait();
    }
}
