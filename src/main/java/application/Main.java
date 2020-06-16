package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/application.fxml"));
        Parent root = loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        primaryStage.setTitle("UBC Grade Manager");
        primaryStage.setScene(new Scene(root, 1050, 550));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
