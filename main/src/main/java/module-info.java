module app {
    requires javafx.controls;
    requires javafx.fxml;

    opens controller to javafx.fxml;
    exports controller;

    opens functionality to javafx.fxml;
    exports functionality;

    opens hash_code;
}
