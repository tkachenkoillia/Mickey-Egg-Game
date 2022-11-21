package Defaults;

import GUI.Panels.GamePanel;
import GUI.Panels.MainMenuPanel;

import javafx.application.Application;

import javafx.stage.Stage;



public class Main extends Application{

    Stage mainStage = new Stage();


    @Override
    public void start(Stage stage) throws Exception {
        mainStage.setOnCloseRequest(windowEvent -> mainStage.close());
        mainStage.setTitle("Project 3");
        mainStage.setWidth(800);
        mainStage.setHeight(600);
        mainStage.setResizable(false);

        new MainMenuPanel(mainStage);

    }

    public static void main(String[] args) {
        launch(args);
    }

}
