package com.sheetlab.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class App extends Application {
    private static App instance;
    private static Stage stage;
    private static Scene scene;
    private static boolean isMaximized = false;
    private static Dimension screenSize;
    @Override
    public void start(Stage mainStage) throws Exception {
        instance = this;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        stage = mainStage;
        scene = new Scene(loadFXML());
        stage.setTitle("SheetLab");
        stage.setScene(scene);
        stage.show();
    }
    private Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/app.fxml"))
        return fxmlLoader.load();
    }
    private Dimension getScreenSize() {
        return screenSize;
    }
    public static App getInstance() {
        return instance;
    }
    public static Scene getScene() {
        return scene;
    }
    public static Stage getStage() {
        return stage;
    }
    public static boolean isIsMaximized() {
        return isMaximized;
    }
}
