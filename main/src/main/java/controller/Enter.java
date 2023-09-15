package controller;

import functionality.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class Enter {

    @FXML
    private Button decrypt;

    @FXML
    private Button encrypt;

    @FXML
    private Button leave;


    public void goEncrypt(ActionEvent event) throws IOException {
        Main m = new Main();
        m.encryptScene("enter.fxml");
    }

    public void goDecrypt(ActionEvent event) throws IOException {
        Main m = new Main();
        m.decryptScene("decrypt.fxml");
    }

    public void goLeave(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
