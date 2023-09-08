package controller;

import hash_code.Hash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class App {

    @FXML
    private Button hashButton;

    @FXML
    private Button cleanButton;

    @FXML
    private Label emptyField;

    @FXML
    private TextField txtField;

    public void actionButton(ActionEvent e) throws IOException {
        encryptedButton();
    }


    protected void encryptedButton() {

        String texto = txtField.getText();

        if(texto.isEmpty()) {
            emptyField.setText("Escribe algo");
        } else {
            txtField.setText(Hash.getSHA256Hash(texto));
            txtField.setEditable(false);
            emptyField.setText(" ");

        }
    }

    @FXML
    protected void cleanButton() {

        txtField.clear();
        txtField.setEditable(true);

    }
}
