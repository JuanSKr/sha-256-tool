package controller;

import functionality.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FirstScene {

    @FXML
    private Button enterButton;

    public void enter(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("enter.fxml");
    }

}
