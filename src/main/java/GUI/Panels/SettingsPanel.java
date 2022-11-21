package GUI.Panels;

import Defaults.Settings;
import Defaults.Themes;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class SettingsPanel {

    final KeyCombination exitCombination = new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN);
    public static Group group;
    public static Scene scene;
    static ImageView bg = new ImageView();
    static Image Default;
    static Image DefaultChosen;
    static Image DuckTales;
    static Image DuckTalesChosen;
    static {
        try {
            Default = new Image(new FileInputStream("Files/Images/Themes/Default.png"));
            DefaultChosen = new Image(new FileInputStream("Files/Images/Themes/DefaultChosen.png"));
            DuckTales = new Image(new FileInputStream("Files/Images/Themes/DuckTales.png"));
            DuckTalesChosen = new Image(new FileInputStream("Files/Images/Themes/DuckTalesChosen.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ImageView themeDefault;
    static ImageView themeDuckTales;

    public SettingsPanel(Stage mainStage) {
        group = new Group();
        scene = new Scene(group, 800, 600);

        bg.setImage(Settings.background);
        group.getChildren().add(bg);

        themeDefault = new ImageView(Default);
        themeDuckTales = new ImageView(DuckTales);
        themeDefault.setLayoutX(65);
        themeDefault.setLayoutY(65);
        themeDuckTales.setLayoutX(435);
        themeDuckTales.setLayoutY(65);
        group.getChildren().addAll(themeDuckTales, themeDefault);

        Text back = new Text("Back");
        back.setFont(Settings.font30);
        back.setLayoutX((400 - back.getLayoutBounds().getWidth() / 2));
        back.setLayoutY(500 - back.getLayoutBounds().getHeight() / 2);
        group.getChildren().add(back);

        new Thread(SettingsPanel :: Update).start();

        mainStage.setScene(scene);
        mainStage.show();

        scene.setOnMouseEntered(e -> group.setCursor(new ImageCursor(Settings.cursor)));

        scene.setOnKeyPressed(e -> {
            if (exitCombination.match(e)){
                new MainMenuPanel(mainStage);
            }
        });

        group.setOnMouseClicked(e -> {
            if (e.getSceneX() >= 65 && e.getSceneX() <= 365 && e.getSceneY() >= 65 && e.getSceneY() <= 265){
                Settings.theme = Themes.DEFAULT;
                Settings.setSettings();
            }
            if (e.getSceneX() >= 435 && e.getSceneX() <= 735 && e.getSceneY() >= 65 && e.getSceneY() <= 265){
                Settings.theme = Themes.DUCKTALES;
                Settings.setSettings();
            }
            if (e.getSceneX() >= 335 && e.getSceneX() <= 435 && e.getSceneY() >= 435 && e.getSceneY() <= 465){
                new MainMenuPanel(mainStage);
            }
        });

    }

    private static void Update() {
        int interval = 100;
        while (true) {
            bg.setImage(Settings.background);
            group.setCursor(new ImageCursor(Settings.cursor));
            switch (Settings.theme){
                case DEFAULT -> {
                    themeDefault.setImage(DefaultChosen);
                    themeDuckTales.setImage(DuckTales);
                }
                case DUCKTALES -> {
                    themeDefault.setImage(Default);
                    themeDuckTales.setImage(DuckTalesChosen);
                }
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
