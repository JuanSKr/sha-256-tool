package controller;

import functionality.Main;
import hash_code.Decrypt;
import hash_code.Hash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    @FXML
    private Button hashButton;

    @FXML
    private Button decryptButton;

    @FXML
    private Button cleanButton;

    @FXML
    private Button copyButton;

    @FXML
    private Button backButton;

    @FXML
    private Label emptyField;

    @FXML
    private Label emptyField2;

    @FXML
    private Label copiedTxt;

    @FXML
    private Label invalidHash;

    @FXML
    private TextField txtField;


    @FXML
    protected void encryptedButton() {

        String text = txtField.getText();

        if (text.isEmpty()) {
            emptyField.setVisible(true);
        } else {
            emptyField.setVisible(false);
            txtField.setText(Hash.getSHA256Hash(text.toLowerCase()));
            txtField.setEditable(false);
        }

    }

    @FXML
    protected void decryptedButton() {

        String text = txtField.getText();
        String filePath = "/yml/dictionary.yml";

        Decrypt decrypt = new Decrypt();

        Pattern pattern = Pattern.compile("^[a-fA-F0-9]{64}$");
        Matcher matcher = pattern.matcher(text);

        if (text.isEmpty()) {
            emptyDecrypt();
        } else {
            if (matcher.matches()) {
                matchesDecrypt(decrypt, text, filePath);
            } else {
                setInvalidHash();
            }
        }
    }

    @FXML
    protected void cleanButtonEncrypt() {

        txtField.clear();
        txtField.setEditable(true);
        copiedTxt.setVisible(false);
    }

    @FXML
    protected void cleanButtonDecrypt() {

        txtField.clear();
        txtField.setEditable(true);
        copiedTxt.setVisible(false);
        invalidHash.setVisible(false);
    }

    @FXML
    protected void copyHash() {
        String text = txtField.getText();

        if (text.isEmpty()) {
            if(emptyField != null) {
                emptyField.setVisible(true);
            } else {
                emptyField2.setVisible(true);
            }
        } else {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();

            copiedTxt.setVisible(true);
            content.putString(text);
            clipboard.setContent(content);
        }
    }


    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Main m = new Main();
        m.enterScene("enter.fxml");
    }

    public void emptyDecrypt() {
        emptyField2.setVisible(true);
        copiedTxt.setVisible(false);
        invalidHash.setVisible(false);
    }

    public void matchesDecrypt(Decrypt decrypt, String text, String filePath) {
        txtField.setText(decrypt.goDecrypt(text, filePath));
        txtField.setEditable(false);
        emptyField2.setVisible(false);
        invalidHash.setVisible(false);
        copiedTxt.setVisible(false);
    }

    public void setInvalidHash() {
        emptyField2.setVisible(false);
        txtField.setText("Invalid Hash");
        txtField.setStyle("-fx-text-fill: red");
        copiedTxt.setVisible(false);
    }


}
