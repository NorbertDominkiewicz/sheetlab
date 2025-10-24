module com.sheetlab.desktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens com.sheetlab.desktop to javafx.fxml;
    exports com.sheetlab.desktop;
}