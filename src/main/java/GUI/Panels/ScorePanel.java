package GUI.Panels;

import Defaults.Settings;
import Defaults.nicknameAndScore;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ScorePanel{

    public static Group group;
    public static Scene scene;
    public static ArrayList<nicknameAndScore> scores;
    public static ListView<String> scoresList;
    ScrollPane scrollPane;


    public ScorePanel(Stage mainStage){
        mainStage.hide();

        group = new Group();
        scene = new Scene(group, 800 ,600);
        scores = new ArrayList<>();
        scoresList = new ListView<>();
        scrollPane = new ScrollPane();

        read();
        scores.sort(Comparator.comparing(nicknameAndScore::getScore).reversed());
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

        Text back = new Text("Back");
        back.setFont(Settings.font30);
        back.setLayoutX((400 - back.getLayoutBounds().getWidth() / 2));
        back.setLayoutY(500 - back.getLayoutBounds().getHeight() / 2);
        group.getChildren().add(back);

        configureList();
        scoresList.setPrefSize(383, 300);
        scrollPane.setContent(scoresList);
        scrollPane.setPrefSize(400, 300);
        scrollPane.setLayoutX(200);
        scrollPane.setLayoutY(150);
        group.getChildren().add(scrollPane);

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        scene.setOnMousePressed(e -> {
            if (e.getSceneX() >= 335 && e.getSceneX() <= 435 && e.getSceneY() >= 435 && e.getSceneY() <= 465){
                new MainMenuPanel(mainStage);
            }
        });
    }

    void configureList() {
        if (scores != null){
            for (int i = 0; i < scores.size(); i++) {
                scoresList.getItems().add(scores.get(i).getNickname() + ":  " + scores.get(i).getScore());
            }
        }
    }

    void read(){
        try {
            FileReader fileReader = new FileReader("Files/Others/Files/scores.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null){
                String name = "";
                int score = 0;
                int index = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) != ' ') {
                        name = name + line.charAt(i);
                    } else{
                        index = i + 1;
                        break;
                    }
                }
                for (int i = index; i < line.length(); i++) {
                    int num = Character.getNumericValue(line.charAt(i));
                    score = score * 10 + num;
                }
                scores.add(new nicknameAndScore(name, score));
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
