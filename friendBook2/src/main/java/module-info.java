module com.example.friendbook2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.friendbook2 to javafx.fxml;
    exports com.example.friendbook2;
}