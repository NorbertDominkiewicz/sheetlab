package com.sheetlab.desktop.controllers;

import com.sheetlab.desktop.models.ViewController;
import com.sheetlab.desktop.utils.Page;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    List<ViewController> controllers;
    String currentFXML;
    DashboardController dashboardController;
    SetupController setupController;
    @FXML
    Button closeButton;
    @FXML
    BorderPane contentPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllers = new ArrayList<>();
        switchView(Page.DASHBOARD);
    }
    public void switchView(Page page) {
        if(viewCollision()) {
            String name = "";
            contentPane.getChildren().clear();
            switch (page) {
                case DASHBOARD -> {
                    name = "dashboard";
                    if(dashboardController == null) {
                        contentPane.getChildren().add(getNode(name));
                        dashboardController = getController(name);
                        currentFXML = name;
                        controllers.add(dashboardController);
                    } else {
                        contentPane.getChildren().add(dashboardController.getView());
                        currentFXML = name;
                    }
                }
                case SETUP -> {
                    name = "setup";
                    if(setupController == null) {
                        contentPane.getChildren().add(getNode(name));
                        setupController = getController(name);
                        currentFXML = name;
                        controllers.add(setupController);
                    } else {
                        contentPane.getChildren().add(setupController.getView());
                        currentFXML = name;
                    }
                }
            }
        }
    }
    private Node getNode(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ndominkiewicz/optui/fxml/views/" + name + ".fxml"));
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private <T extends ViewController> T getController(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ndominkiewicz/optui/fxml/views/" + name + ".fxml"));
            return loader.getController();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private boolean viewCollision() {
        return !contentPane.getCenter().equals(getNode(currentFXML));
    }
}
