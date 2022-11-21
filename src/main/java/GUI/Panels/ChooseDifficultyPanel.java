package GUI.Panels;


import Defaults.Settings;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChooseDifficultyPanel {

    public static Group group;
    public static Scene scene;

    ChooseDifficultyPanel(Stage mainStage){
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

        Text difficulty = new Text("Choose Difficulty:");
        difficulty.setFont(Settings.font40);
        difficulty.setX(400 - difficulty.getLayoutBounds().getWidth() / 2);
        difficulty.setY(250 - difficulty.getLayoutBounds().getHeight() / 2);
        Text easy = new Text("Easy");
        easy.setFont(Settings.font30);
        easy.setLayoutX((400 - easy.getLayoutBounds().getWidth() / 2));
        easy.setLayoutY(300 - easy.getLayoutBounds().getHeight() / 2);
        Text hard = new Text("Hard");
        hard.setFont(Settings.font30);
        hard.setLayoutX((400 - hard.getLayoutBounds().getWidth() / 2));
        hard.setLayoutY(350 - hard.getLayoutBounds().getHeight() / 2);
        group.getChildren().addAll(difficulty, easy, hard);

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        group.setOnMouseClicked(e -> {
            if (e.getSceneX() >= 335 && e.getSceneX() <= 435 && e.getSceneY() >= 235 && e.getSceneY() <= 265){
                new GamePanel(mainStage, "EASY");
            }
            if (e.getSceneX() >= 335 && e.getSceneX() <= 435 && e.getSceneY() >= 285 && e.getSceneY() <= 305){
                new GamePanel(mainStage, "HARD");
            }
        });
    }


}
