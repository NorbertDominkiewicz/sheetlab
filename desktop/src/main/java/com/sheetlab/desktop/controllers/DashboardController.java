package com.sheetlab.desktop.controllers;

import com.sheetlab.desktop.models.ViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class DashboardController implements ViewController {
    @FXML
    private GridPane root;
    @Override
    public Node getView() {
        return root;
    }
}
