package com.sheetlab.desktop.controllers;

import com.sheetlab.desktop.models.ViewController;
import com.sheetlab.desktop.utils.Page;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements ViewController, Initializable {
    MainController mainController;
    @FXML
    private GridPane newProject;
    @FXML
    private GridPane root;
    @Override
    public Node getView() {
        return root;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        newProject.setOnMousePressed(event -> {
            if (mainController != null) {
                mainController.switchView(Page.SETUP);
            }
        });
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
