package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("fx.fxml"));
        stage.setTitle("SHA-256");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}