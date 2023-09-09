module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;

    opens controller to javafx.fxml;
    exports controller;

    opens functionality to javafx.fxml;
    exports functionality;

    opens hash_code;
}
