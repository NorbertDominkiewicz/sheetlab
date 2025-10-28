package com.sheetlab.desktop.controllers;

import com.sheetlab.desktop.App;
import com.sheetlab.desktop.models.ViewController;
import com.sheetlab.desktop.utils.Page;
import com.sheetlab.desktop.utils.ProjectData;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class MainController implements Initializable {
    List<ViewController> controllers;
    String currentFXML;
    DashboardController dashboardController;
    SetupController setupController;
    ProjectController projectController;
    @FXML
    Button closeButton;
    @FXML
    BorderPane contentPane;
    @FXML
    GridPane topBar;
    @FXML
    FlowPane bottomPane;
    @FXML
    Button homeButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controllers = new ArrayList<>();
        loadUpActions();
        switchView(Page.DASHBOARD);
    }
    private void loadUpActions() {
        closeButton.setOnAction( event -> close());
        homeButton.setOnAction(event -> switchView(Page.DASHBOARD));
        topBar.setOnMousePressed( event -> {
            App.getPosition().setX((int) (event.getScreenX() - App.getStage().getX()));
            App.getPosition().setY((int) (event.getScreenY() -  App.getStage().getY()));
        });
        topBar.setOnMouseDragged(event -> {
            App.getStage().setX(event.getScreenX() - App.getPosition().getX());
            App.getStage().setY(event.getScreenY() - App.getPosition().getY());
        });
        bottomPane.setOnMousePressed( event -> {
            App.getPosition().setX((int) (event.getScreenX() - App.getStage().getX()));
            App.getPosition().setY((int) (event.getScreenY() -  App.getStage().getY()));
        });
        bottomPane.setOnMouseDragged(event -> {
            App.getStage().setX(event.getScreenX() - App.getPosition().getX());
            App.getStage().setY(event.getScreenY() - App.getPosition().getY());
        });
    }
    public void switchView(Page page, ProjectData data) {

    }
    public void switchView(Page page) {
        String name = "";
        contentPane.getChildren().clear();
        switch (page) {
            case DASHBOARD -> {
                name = "dashboard";
                if(dashboardController == null) {
                    dashboardController = loadController(name);
                    if(dashboardController != null) {
                        dashboardController.setMainController(this);
                    }
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
                    contentPane.setCenter(getNode(name));
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
    private void close() {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), new KeyValue(App.getScene().getRoot().opacityProperty(), 0));
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished((event) -> System.exit(0));
        timeline.play();
    }
    private Node getNode(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sheetlab/desktop/fxml/views/" + name + ".fxml"));
            return loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private <T extends ViewController> T loadController(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sheetlab/desktop/fxml/views/" + name + ".fxml"));
            Node node = loader.load();
            T controller = loader.getController();
            contentPane.setCenter(node);
            return controller;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private <T extends ViewController> T getController(String name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sheetlab/desktop/fxml/views/" + name + ".fxml"));
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
