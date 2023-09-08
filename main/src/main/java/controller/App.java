package controller;

import functionality.Main;
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
    private Button backButton;

    @FXML
    private Label emptyField;

    @FXML
    private Label copiedTxt;

    @FXML
    private TextField txtField;


    @FXML
    protected void encryptedButton() {

        String texto = txtField.getText();

        if (texto.isEmpty()) {
            emptyField.setVisible(true);
        } else {
            emptyField.setVisible(false);
            txtField.setText(Hash.getSHA256Hash(texto));
            txtField.setEditable(false);
        }
    }

    @FXML
    protected void cleanButton() {

        txtField.clear();
        txtField.setEditable(true);
        copiedTxt.setVisible(false);

    }

    @FXML
    protected void copyHash() {
        String texto = txtField.getText();

        if (texto.isEmpty()) {
            emptyField.setVisible(true);
        } else {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();

            copiedTxt.setVisible(true);
            content.putString(texto);
            clipboard.setContent(content);

        }
    }

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Main m = new Main();
        m.enterScene("enter.fxml");
    }

}
