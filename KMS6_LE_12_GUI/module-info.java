module KMS6_LE_12_01_JAVAFX {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens views to javafx.fxml;
    opens controllers to javafx.fxml;
    opens models to javafx.fxml;
    opens data_persistance to javafx.fxml;

    exports views;
}
