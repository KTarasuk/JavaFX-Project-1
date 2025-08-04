module dev.ktarasuk.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens dev.ktarasuk.demo to javafx.fxml;
    exports dev.ktarasuk.demo;
}