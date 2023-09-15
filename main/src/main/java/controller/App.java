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


    /**
     * This method is responsible for handling the action when the "encryptedButton" is clicked.
     * It retrieves text from a text field, computes its SHA-256 hash, and displays the hash in the same text field.
     * If the text field is empty, it shows a visual indicator (emptyField) to notify the user.
     */

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

    /**
     * This method handles the action when the "decryptedButton" is clicked.
     * It retrieves text from a text field, checks if it conforms to the format of a SHA-256 hash,
     * and performs decryption if the input matches the format. Otherwise, it displays an error message.
     * For decryption, it checks the "dictionary.yml" file for reference, assuming it contains mappings
     * required for the decryption process.
     */

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

    /**
     * This method handles the action when the "cleanButtonEncrypt" is clicked.
     * It clears the content of the text field, enables text field editing, and hides the "copiedTxt" indicator.
     */

    @FXML
    protected void cleanButtonEncrypt() {

        txtField.clear();
        txtField.setEditable(true);
        copiedTxt.setVisible(false);
    }

    /**
     * This method handles the action when the "cleanButtonDecrypt" is clicked.
     * It clears the content of the text field, enables text field editing, and hides the "copiedTxt" and "invalidHash" indicators.
     */

    @FXML
    protected void cleanButtonDecrypt() {

        txtField.clear();
        txtField.setEditable(true);
        copiedTxt.setVisible(false);
        invalidHash.setVisible(false);
    }

    /**
     * This method handles the action when the "copyHash" button is clicked.
     * It copies the content of the text field to the system clipboard, making it available for pasting.
     * If the text field is empty, it displays an empty field indicator (either "emptyField" or "emptyField2").
     * If successful, it also displays a "copiedTxt" indicator to notify the user of successful copy.
     */

    @FXML
    protected void copyHash() {
        String text = txtField.getText();

        if (text.isEmpty()) {
            if (emptyField != null) {
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

    /**
     * This method handles the action when a "goBack" button is clicked.
     * It initiates a navigation action to return to the "enter.fxml" scene, used for navigating
     * back to a previous screen or interface. It uses the Main class to manage scene transitions.
     *
     * @param event An ActionEvent represanting the button click event that triggered the navigation.
     * @throws IOException If an IOException occurs during the scene transition.
     */

    @FXML
    public void goBack(ActionEvent event) throws IOException {
        Main m = new Main();
        m.enterScene("enter.fxml");
    }

    /**
     * This method handles the case when the input for decryption is empty.
     * It displays the empty field indicator ("emptyField2"), and hides the "copiedTxt" and "invalidHash" indicators.
     */

    public void emptyDecrypt() {
        emptyField2.setVisible(true);
        copiedTxt.setVisible(false);
        invalidHash.setVisible(false);
    }

    /**
     * This method handles the case when the input for decryption matches the format of a SHA-256 hash.
     * It performs decryption using the provided Decrypt object, updates the text field with the decrypted result,
     * disables text field editing, and hides the empty field, invalid hash, and copied text indicators.
     *
     * @param decrypt  An instance of the Decrypt class used for decryption.
     * @param text     The input text to be decrypted.
     * @param filePath The file path to the dictionary file required for decryption.
     */

    public void matchesDecrypt(Decrypt decrypt, String text, String filePath) {
        txtField.setText(decrypt.goDecrypt(text, filePath));
        txtField.setEditable(false);
        emptyField2.setVisible(false);
        invalidHash.setVisible(false);
        copiedTxt.setVisible(false);
    }

    /**
     * This method handles the case when the input for decryption does not match the format of a SHA-256 hash.
     * It displays an "Invalid Hash" message in the text field, changes the text color to red for emphasis,
     * and hides the empty field and copied text indicators.
     */

    public void setInvalidHash() {
        emptyField2.setVisible(false);
        txtField.setText("Invalid Hash");
        txtField.setStyle("-fx-text-fill: red");
        copiedTxt.setVisible(false);
    }

}
