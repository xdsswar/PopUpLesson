package org.popup.lesson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.popup.lesson.controllers.MainController;

import java.io.IOException;

/**
 * @author XDSSWAR
 * Created on 7/10/2022
 *
 * Since we are using gradle to run the jfx app for first time [Intelij in this case] we need to
 * click gradle on the right side , under Tasks select application and then double-click
 * on run , that's all
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Create MainController Instance
        MainController mainController=new MainController();
        //Pass the MainController instance to the load method
        Parent parent=load("/org/popup/lesson/main.fxml",mainController);

        //Create Scene and soo on
        Scene scene=new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * I like to set the controller of the fxml file this way instead of in the fxml file, this way I'm able to
     * pass parameters to the constructor, like a User from the Login controller to the Dashboard controller for example
     * @param location fxml path
     * @param controller Object Controller
     * @return Parent
     * @throws IOException Error
     */
    public static Parent load(final String location, Object controller) throws IOException {
        //I use the Main class as reference to load the files inside the resource folder
        //So to load main.fxm I just need to pass the location as "/org/popup/lesson/main.fxml"
        FXMLLoader loader=new FXMLLoader(Main.class.getResource(location));
        loader.setController(controller);
        return loader.load();
    }
}
