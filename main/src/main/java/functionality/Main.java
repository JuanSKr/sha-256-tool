package functionality;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    private static Stage stg;

    public Main() {

    }

    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fx/enter.fxml")));
        stage.setTitle("SHA-256");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fx/app.fxml")));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}