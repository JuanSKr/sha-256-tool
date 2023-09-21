module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.yaml.snakeyaml;
    requires google.api.client;
    requires google.api.services.youtube.v3.rev222;

    opens controller to javafx.fxml;
    exports controller;

    opens functionality to javafx.fxml;
    exports functionality;

    opens hash_code;
}
