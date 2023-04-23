module com.example.ll {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.ll to javafx.fxml;
    exports com.example.ll;
}