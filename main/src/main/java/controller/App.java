package controller;

import hash_code.Hash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.io.IOException;

public class App {

    @FXML
    private Button hashButton;

    @FXML
    private Button cleanButton;

    @FXML
    private Button copyButton;

    @FXML
    private Label emptyField;

    @FXML
    private TextField txtField;

    @FXML
    protected void encryptedButton() {

        String texto = txtField.getText();

        if (texto.isEmpty()) {
            System.out.println("Empty");
        } else {
            txtField.setText(Hash.getSHA256Hash(texto));
            txtField.setEditable(false);
        }
    }

    @FXML
    protected void cleanButton() {

        txtField.clear();
        txtField.setEditable(true);

    }

    @FXML
    protected void copyHash() {
        String texto = txtField.getText();

        if (texto.isEmpty()) {
            System.out.println("Empty");
        } else {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();

            content.putString(texto);
            clipboard.setContent(content);

        }


    }

}
