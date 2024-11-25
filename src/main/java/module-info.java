module com.project.textprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.textprocessingtool to javafx.fxml;
    exports com.project.textprocessingtool;
}