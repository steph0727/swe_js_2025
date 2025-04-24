module com.example.j_25 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.j_25 to javafx.fxml;
    exports com.example.j_25;
}