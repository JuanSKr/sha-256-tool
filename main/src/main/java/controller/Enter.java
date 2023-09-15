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


    /**
     * This method handles the action when a "goEncrypt" button is clicked.
     * It initiates a navigation action to transition to an "enter.fxml" scene, used for encryption purposes.
     * It uses the Main class to manage scene transitions.
     *
     * @param event An ActionEvent representing the button click event that triggered the navigation.
     * @throws IOException If an IOException occurs during the scene transition.
     */

    public void goEncrypt(ActionEvent event) throws IOException {
        Main m = new Main();
        m.encryptScene("enter.fxml");
    }

    /**
     * This method handles the action when a "goDecrypt" button is clicked.
     * It initiates a navigation action to transition to a "decrypt.fxml" scene, used for decryption purposes.
     * It uses the Main class to manage scene transitions.
     *
     * @param event An ActionEvent representing the button click event that triggered the navigation.
     * @throws IOException If an IOException occurs during the scene transition.
     */

    public void goDecrypt(ActionEvent event) throws IOException {
        Main m = new Main();
        m.decryptScene("decrypt.fxml");
    }

    /**
     * This method handles the action when a "goLeave" button is clicked.
     * It terminates the application by calling System.exit(0).
     *
     * @param event An ActionEvent representing the button click event that triggered the termination.
     * @throws IOException If an IOException occurs, though it is not expected in this context.
     */

    public void goLeave(ActionEvent event) throws IOException {
        System.exit(0);
    }

}
