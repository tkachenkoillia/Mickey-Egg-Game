package GUI.Panels;

import Defaults.Settings;

import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class MainMenuPanel {

    public static Group group;
    public static Scene scene;

    public MainMenuPanel(Stage mainStage){
        mainStage.hide();

        group = new Group();
        scene = new Scene(group, 800 ,600);

        ImageView bg = new ImageView(Settings.background);
        group.getChildren().add(bg);

        ImageView henHouseTopRight = new ImageView(Settings.henHouseRight);
        henHouseTopRight.setLayoutX(710);
        henHouseTopRight.setLayoutY(100);
        ImageView henHouseLowRight = new ImageView(Settings.henHouseRight);
        henHouseLowRight.setLayoutX(710);
        henHouseLowRight.setLayoutY(300);
        ImageView henHouseTopLeft = new ImageView(Settings.henHouseLeft);
        henHouseTopLeft.setLayoutX(-110);
        henHouseTopLeft.setLayoutY(100);
        ImageView henHouseLowLeft = new ImageView(Settings.henHouseLeft);
        henHouseLowLeft.setLayoutX(-110);
        henHouseLowLeft.setLayoutY(300);
        group.getChildren().addAll(henHouseLowLeft, henHouseLowRight, henHouseTopLeft, henHouseTopRight);

        Text newGame = new Text("New Game");
        newGame.setFont(Settings.font40);
        newGame.setX(400 - newGame.getLayoutBounds().getWidth() / 2);
        newGame.setY(200 - newGame.getLayoutBounds().getHeight() / 2);
        Text settings = new Text("Settings");
        settings.setFont(Settings.font40);
        settings.setX(400 - settings.getLayoutBounds().getWidth() / 2);
        settings.setY(250 - settings.getLayoutBounds().getHeight() / 2);
        Text leaderboard = new Text("Leaderboard");
        leaderboard.setFont(Settings.font40);
        leaderboard.setLayoutX((400 - leaderboard.getLayoutBounds().getWidth() / 2));
        leaderboard.setLayoutY(300 - leaderboard.getLayoutBounds().getHeight() / 2);
        Text exit = new Text("Exit");
        exit.setFont(Settings.font40);
        exit.setLayoutX((400 - exit.getLayoutBounds().getWidth() / 2));
        exit.setLayoutY(350 - exit.getLayoutBounds().getHeight() / 2);

        group.getChildren().addAll(newGame, settings, leaderboard, exit);

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        group.setOnMouseClicked(e -> {
            if (e.getSceneX() >= 275 && e.getSceneX() <= 495 && e.getSceneY() >= 135 && e.getSceneY() <= 160){
                new ChooseDifficultyPanel(mainStage);
            }
            if (e.getSceneX() >= 275 && e.getSceneX() <= 495 && e.getSceneY() >= 185 && e.getSceneY() <= 210){
                new SettingsPanel(mainStage);
            }
            if (e.getSceneX() >= 235 && e.getSceneX() <= 535 && e.getSceneY() >= 235 && e.getSceneY() <= 260){
                new ScorePanel(mainStage);
            }
            if (e.getSceneX() >= 335 && e.getSceneX() <= 435 && e.getSceneY() >= 285 && e.getSceneY() <= 310){
                System.exit(0);
            }
        });
    }
}
