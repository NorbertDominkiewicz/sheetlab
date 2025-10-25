package com.sheetlab.desktop;

import com.sheetlab.desktop.utils.Cords;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class App extends Application {
    private static App instance;
    private static Stage stage;
    private static Scene scene;
    private static boolean isMaximized = false;
    private static Dimension screenSize;
    private static Cords position;
    @Override
    public void start(Stage mainStage) throws Exception {
        instance = this;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        position = new Cords();
        stage = mainStage;
        scene = new Scene(loadFXML());
        stage.setTitle("SheetLab");
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }
    private Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/app.fxml"));
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
    public static void main(String [] args){
        launch();
    }
    public static Cords getPosition() {
        return position;
    }
}
