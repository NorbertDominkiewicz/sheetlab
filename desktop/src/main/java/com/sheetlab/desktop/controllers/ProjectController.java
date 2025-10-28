package com.sheetlab.desktop.controllers;

import com.sheetlab.desktop.models.ViewController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ProjectController implements Initializable, ViewController {
    @FXML
    private GridPane root;
    @Override
    public Node getView() {
        return root;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
