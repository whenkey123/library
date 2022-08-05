module com.assignment.library {
    requires javafx.controls;
    requires javafx.fxml;
    opens com.assignment.library to javafx.fxml;
    exports com.assignment.library;
}