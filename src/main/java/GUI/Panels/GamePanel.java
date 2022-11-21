package GUI.Panels;

import Defaults.Positions;
import Defaults.Settings;

import GUI.Others.Character;
import GUI.Others.Egg;
import GUI.Others.HelpCharacter;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GamePanel{

    final KeyCombination exitCombination = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
    static Text scoreText;
    static int score;
    static double HP;
    public static Group group;
    public static Scene scene;
    public static Character character;
    public static int maxEggs;
    public static ArrayList<Egg> eggs;
    static boolean gameOver;
    static Stage stage;
    static String difficulty;

    static ImageView HPImage = new ImageView();
    static HelpCharacter helpCharacter = new HelpCharacter();

    public GamePanel(Stage mainStage, String diff){
        difficulty = diff;
        stage = mainStage;
        mainStage.hide();
        score = 0;
        if (difficulty.equals("EASY")){
            HP = 3;
            maxEggs = 3;
        }
        else{
            HP = 1.5;
            maxEggs = 5;
        }
        character = new Character();
        gameOver = false;
        eggs = new ArrayList<Egg>();
        group = new Group();
        scene = new Scene(group, 800, 600);

        ImageView bg = new ImageView(Settings.background);
        group.getChildren().add(bg);

        scoreText = new Text("Score: " + score);
        scoreText.setFont(Settings.font30);
        scoreText.setLayoutX(80);
        scoreText.setLayoutY(30);
        HPImage.setLayoutX(550);
        HPImage.setLayoutY(30);
        group.getChildren().addAll(scoreText, HPImage);


        ImageView henHouseTopRight = new ImageView(Settings.henHouseRight);
        henHouseTopRight.setLayoutX(635);
        henHouseTopRight.setLayoutY(65);
        ImageView henHouseLowRight = new ImageView(Settings.henHouseRight);
        henHouseLowRight.setLayoutX(635);
        henHouseLowRight.setLayoutY(250);
        ImageView henHouseTopLeft = new ImageView(Settings.henHouseLeft);
        henHouseTopLeft.setLayoutX(-35);
        henHouseTopLeft.setLayoutY(65);
        ImageView henHouseLowLeft = new ImageView(Settings.henHouseLeft);
        henHouseLowLeft.setLayoutX(-35);
        henHouseLowLeft.setLayoutY(250);
        group.getChildren().addAll(henHouseLowLeft, henHouseLowRight, henHouseTopLeft, henHouseTopRight);

        Rectangle rectLeft = new Rectangle(0, 0, 75, 600);
        Rectangle rectRight = new Rectangle(725, 0, 75, 600);
        group.getChildren().addAll(rectRight, rectLeft);

        ImageView buttonTopLeft = new ImageView();
        buttonTopLeft.setImage(Settings.buttonReleased);
        buttonTopLeft.setLayoutX(0);
        buttonTopLeft.setLayoutY(135);
        ImageView buttonLowLeft = new ImageView();
        buttonLowLeft.setImage(Settings.buttonReleased);
        buttonLowLeft.setLayoutX(0);
        buttonLowLeft.setLayoutY(400);
        ImageView buttonTopRight = new ImageView();
        buttonTopRight.setImage(Settings.buttonReleased);
        buttonTopRight.setLayoutX(725);
        buttonTopRight.setLayoutY(135);
        ImageView buttonLowRight = new ImageView();
        buttonLowRight.setImage(Settings.buttonReleased);
        buttonLowRight.setLayoutX(725);
        buttonLowRight.setLayoutY(400);
        group.getChildren().addAll(buttonTopLeft, buttonLowLeft, buttonTopRight, buttonLowRight);


        ImageView characterImage = character.getImage();
        characterImage.setImage(Settings.characterTopLeft);
        characterImage.setLayoutX(225);
        characterImage.setLayoutY(200);
        group.getChildren().add(characterImage);

        new Thread(GamePanel::eggsController).start();
        new Thread(GamePanel::helpController).start();
        new Thread(GamePanel::update).start();

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        scene.setOnMousePressed(e -> {
            if (e.getSceneX() >= -15 && e.getSceneX() <= 60 && e.getSceneY() >= 120 && e.getSceneY() <= 195){
                buttonTopLeft.setImage(Settings.buttonPressed);
                Settings.position = Positions.TOPLEFT;
            }
            if (e.getSceneX() >= 710 && e.getSceneX() <= 785 && e.getSceneY() >= 120 && e.getSceneY() <= 195){
                buttonTopRight.setImage(Settings.buttonPressed);
                Settings.position = Positions.TOPRIGHT;
            }
            if (e.getSceneX() >= -15 && e.getSceneX() <= 60 && e.getSceneY() >= 385 && e.getSceneY() <= 460){
                buttonLowLeft.setImage(Settings.buttonPressed);
                Settings.position = Positions.LOWLEFT;
            }
            if (e.getSceneX() >= 710 && e.getSceneX() <= 785 && e.getSceneY() >= 385 && e.getSceneY() <= 460){
                buttonLowRight.setImage(Settings.buttonPressed);
                Settings.position = Positions.LOWRIGHT;
            }
            character = new Character();
        });

        scene.setOnMouseReleased(e -> {
            buttonTopLeft.setImage(Settings.buttonReleased);
            buttonTopRight.setImage(Settings.buttonReleased);
            buttonLowLeft.setImage(Settings.buttonReleased);
            buttonLowRight.setImage(Settings.buttonReleased);
        });

        scene.setOnKeyPressed(e -> {
            if (exitCombination.match(e)){
                new MainMenuPanel(stage);
            }
            if (e.getCode() == KeyCode.UP){
                switch (Settings.position){
                    case LOWLEFT -> Settings.position = Positions.TOPLEFT;
                    case LOWRIGHT -> Settings.position = Positions.TOPRIGHT;
                }
            }
            else if (e.getCode() == KeyCode.DOWN){
                switch (Settings.position){
                    case TOPLEFT -> Settings.position = Positions.LOWLEFT;
                    case TOPRIGHT -> Settings.position = Positions.LOWRIGHT;
                }
            }
            else if (e.getCode() == KeyCode.RIGHT){
                switch (Settings.position){
                    case TOPLEFT -> Settings.position = Positions.TOPRIGHT;
                    case LOWLEFT -> Settings.position = Positions.LOWRIGHT;
                }
            }
            else if (e.getCode() == KeyCode.LEFT){
                switch (Settings.position){
                    case TOPRIGHT -> Settings.position = Positions.TOPLEFT;
                    case LOWRIGHT -> Settings.position = Positions.LOWLEFT;
                }
            }
            character = new Character();
        });
    }

    private static void helpController() {
        int interval = 10000;
        while (!gameOver) {
            if (!group.getChildren().contains(helpCharacter)){
                helpCharacter = new HelpCharacter();
                helpCharacter.setLayoutX(300);
                helpCharacter.setLayoutY(30);
                Platform.runLater(() -> group.getChildren().add(helpCharacter));
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void eggsController(){
        int interval = 0;
        if (difficulty.equals("EASY")){
            interval = 2000;
        }
        else{
            interval = 1000;
        }
        while (!gameOver) {
            if (interval > 500)
                interval -= 10;
            if (eggs.size() < maxEggs){
                Positions position = Positions.random();
                Egg egg = new Egg(position, difficulty);
                eggs.add(egg);
            }
            if (score != 0 && score % 10 == 0)
                ++maxEggs;
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void update() {
        int interval = 100;
        while (!gameOver) {
            for (int i = 0; i < eggs.size(); i++) {

                Egg egg = eggs.get(i);

                if (!group.getChildren().contains(egg)){
                    Platform.runLater(() -> group.getChildren().add(egg));
                }

                if(helpCharacter.animationFinished){
                    Platform.runLater(() -> group.getChildren().remove(helpCharacter));
                }

                if(egg.animationFinished){
                    if (egg.position == Settings.position){
                        score++;
                    }
                    else {
                        if (helpCharacter.animationFinished)
                            HP --;
                        else
                            HP -= 0.5;
                        if (HP <= 0){
                            gameOver = true;
                        }
                    }

                    Platform.runLater(() ->group.getChildren().remove(egg));
                    eggs.remove(egg);

                    scoreText.setText("Score: " + score );

                    i--;
                }

                if (HP == 3)
                    HPImage.setImage(Settings.HP_3);
                else if (HP == 2.5)
                    HPImage.setImage(Settings.HP_2_5);
                else if (HP == 2)
                    HPImage.setImage(Settings.HP_2);
                else if (HP == 1.5)
                    HPImage.setImage(Settings.HP_1_5);
                else if (HP == 1)
                    HPImage.setImage(Settings.HP_1);
                else if (HP == 0.5)
                    HPImage.setImage(Settings.HP_0_5);
                else if (HP <= 0)
                    HPImage.setImage(Settings.HP_0);

                i++;
            }

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Platform.runLater(() -> new GameOverPanel(stage, score));

    }
}
