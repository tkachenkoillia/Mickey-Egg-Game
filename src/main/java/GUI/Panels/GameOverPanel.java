package GUI.Panels;

import Defaults.Settings;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class GameOverPanel {

    public static Group group;
    public static Scene scene;


    GameOverPanel(Stage mainStage, int score){
        mainStage.hide();

        group = new Group();
        scene = new Scene(group, 800, 600);

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

        Text gameOver = new Text("Game Over");
        gameOver.setFont(Settings.font40);
        gameOver.setX(400 - gameOver.getLayoutBounds().getWidth() / 2);
        gameOver.setY(200 - gameOver.getLayoutBounds().getHeight() / 2);
        Text scoreText = new Text("Your score: " + score);
        scoreText.setFont(Settings.font30);
        scoreText.setX(400 - scoreText.getLayoutBounds().getWidth() / 2);
        scoreText.setY(250 - scoreText.getLayoutBounds().getHeight() / 2);
        Text writeNickname = new Text("Write your nickname:");
        writeNickname.setFont(Settings.font30);
        writeNickname.setX(400 - writeNickname.getLayoutBounds().getWidth() / 2);
        writeNickname.setY(300 - writeNickname.getLayoutBounds().getHeight() / 2);
        TextField nickname = new TextField();
        nickname.setFont(Settings.font20);
        nickname.setPrefSize(300, 30);
        nickname.setLayoutX(250);
        nickname.setLayoutY(300);
        Text backToMenu = new Text("Back to menu");
        backToMenu.setFont(Settings.font30);
        backToMenu.setX(400 - gameOver.getLayoutBounds().getWidth() / 2);
        backToMenu.setY(400 - gameOver.getLayoutBounds().getHeight() / 2);
        group.getChildren().addAll(gameOver, scoreText, writeNickname, nickname, backToMenu);

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        group.setOnMouseClicked(e -> {
            if (e.getSceneX() >= 275 && e.getSceneX() <= 495 && e.getSceneY() >= 345 && e.getSceneY() <= 365){
                if (validNickname(nickname.getText())) {
                    String str = nickname.getText() + " " + score + "\n";
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("Files/Others/Files/scores.txt", true);
                        PrintStream printStream = new PrintStream(fileOutputStream);
                        printStream.print(str);
                        printStream.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    new MainMenuPanel(mainStage);
                }
                else{
                    Alert invalidNicknameAlert = new Alert(Alert.AlertType.WARNING);
                    invalidNicknameAlert.setHeaderText("INVALID NICKNAME");
                    invalidNicknameAlert.setContentText("Your nickname can't be empty and can't contain spaces");
                    invalidNicknameAlert.showAndWait();
                }
            }

        });
    }

    boolean validNickname(String nickname){
        if (nickname.equals(""))
            return false;
        for (int i = 0; i < nickname.length(); i++) {
            if (' ' == nickname.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
