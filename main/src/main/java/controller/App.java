package controller;

import functionality.Main;
import hash_code.Hash;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import java.io.IOException;
import java.util.Objects;

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
    private CheckBox toLower;

    @FXML
    private Label emptyField;

    @FXML
    private Label copiedTxt;

    @FXML
    private TextField txtField;


    @FXML
    protected void encryptedButton() {

        String texto = txtField.getText();

        if (toLower.isSelected()) {
            if (texto.isEmpty()) {
                emptyField.setVisible(true);
            } else {
                emptyField.setVisible(false);
                txtField.setText(Hash.getSHA256Hash(texto.toLowerCase()));
                txtField.setEditable(false);
            }
        } else {
            emptyField.setVisible(false);
            txtField.setText(Hash.getSHA256Hash(texto));
            txtField.setEditable(false);
        }


    }

    @FXML
    protected void decryptedButton() {

        

        String text = txtField.getText();
        String filePath = "/yml/dictionary.yml";

        System.out.println(goDecrypt(text, filePath));

    }

    protected String goDecrypt(String hash, String filepath) {

        try {

            InputStream inputStream = App.class.getResourceAsStream(filepath);

            Yaml yaml = new Yaml();

            Map<String, Map<String, String>> yamlData = yaml.load(inputStream);

            if (yamlData.containsKey("Dictionary")) {
                Map<String, String> dictionary = yamlData.get("Dictionary");
                if (dictionary.containsKey(hash)) {
                    return dictionary.get(hash);
                }
            }

            return "Not found";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
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
