module com.ndominkiewicz.desktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.ndominkiewicz.desktop to javafx.fxml;
    exports com.ndominkiewicz.desktop;
}