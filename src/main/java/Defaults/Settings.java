package Defaults;

import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Settings {

    public static Themes theme = Themes.DEFAULT;
    public static Positions position = Positions.TOPLEFT;


    public static Image buttonPressed;
    public static Image buttonReleased;
    static {
        try {
            buttonPressed = new Image(new FileInputStream("Files/Images/Others/ButtonPressed.png"));
            buttonReleased = new Image(new FileInputStream("Files/Images/Others/ButtonReleased.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image egg;
    public static Image help_Character;
    static {
        try {
            egg = new Image(new FileInputStream("Files/Images/Others/egg.png"));
            help_Character = new Image(new FileInputStream("Files/Images/Characters/Minnie.png"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Image background;
    static {
        try {
            background = new Image(new FileInputStream("Files/Images/Backgrounds/Background1.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Image henHouseRight;
    public static Image henHouseLeft;
    static {
        try {
            henHouseRight = new Image((new FileInputStream("Files/Images/Others/henHouseRight.png")));
            henHouseLeft = new Image((new FileInputStream("Files/Images/Others/henHouseLeft.png")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image characterTopLeft;
    public static Image characterLowLeft;
    public static Image characterTopRight;
    public static Image characterLowRight;
    static {
        try {
            characterTopLeft = new Image(new FileInputStream("Files/Images/Characters/Mickey_TOPLEFT.png"));
            characterLowLeft = new Image(new FileInputStream("Files/Images/Characters/Mickey_LOWLEFT.png"));
            characterTopRight = new Image(new FileInputStream("Files/Images/Characters/Mickey_TOPRIGHT.png"));
            characterLowRight = new Image(new FileInputStream("Files/Images/Characters/Mickey_LOWRIGHT.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Image cursor;
    static {
        try {
            cursor = new Image(new FileInputStream("Files/Images/Others/Cursor.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Font font40;
    public static Font font30;
    public static Font font20;
    static {
        try {
            font40 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 40);
            font30 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 30);
            font20 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 20);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Image HP_3;
    public static Image HP_2_5;
    public static Image HP_2;
    public static Image HP_1_5;
    public static Image HP_1;
    public static Image HP_0_5;
    public static Image HP_0;
    static {
        try {
            HP_3 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_3.png"));
            HP_2_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_2.5.png"));
            HP_2 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_2.png"));
            HP_1_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_1.5.png"));
            HP_1 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_1.png"));
            HP_0_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_0.5.png"));
            HP_0 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_0.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setSettings(){
        try{
            switch (theme){
                case DEFAULT -> {
                    background = new Image(new FileInputStream("Files/Images/Backgrounds/Background1.jpg"));
                    egg = new Image(new FileInputStream("Files/Images/Others/egg.png"));
                    help_Character = new Image(new FileInputStream("Files/Images/Characters/Minnie.png"));
                    henHouseRight = new Image((new FileInputStream("Files/Images/Others/henHouseRight.png")));
                    henHouseLeft = new Image((new FileInputStream("Files/Images/Others/henHouseLeft.png")));
                    characterTopLeft = new Image(new FileInputStream("Files/Images/Characters/Mickey_TOPLEFT.png"));
                    characterLowLeft = new Image(new FileInputStream("Files/Images/Characters/Mickey_LOWLEFT.png"));
                    characterTopRight = new Image(new FileInputStream("Files/Images/Characters/Mickey_TOPRIGHT.png"));
                    characterLowRight = new Image(new FileInputStream("Files/Images/Characters/Mickey_LOWRIGHT.png"));
                    cursor = new Image(new FileInputStream("Files/Images/Others/Cursor.png"));
                    font40 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 40);
                    font30 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 30);
                    font20 = Font.loadFont(new FileInputStream("Files/Others/Fonts/crackman.ttf"), 20);
                    HP_3 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_3.png"));
                    HP_2_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_2.5.png"));
                    HP_2 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_2.png"));
                    HP_1_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_1.5.png"));
                    HP_1 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_1.png"));
                    HP_0_5 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_0.5.png"));
                    HP_0 = new Image(new FileInputStream("Files/Images/Others/HP_Egg_0.png"));
                }
                case DUCKTALES -> {
                    background = new Image(new FileInputStream("Files/Images/Backgrounds/Background2.png"));
                    egg = new Image(new FileInputStream("Files/Images/Others/coin.png"));
                    help_Character = new Image(new FileInputStream("Files/Images/Characters/Ducks.png"));
                    henHouseRight = new Image((new FileInputStream("Files/Images/Others/SafeRight.png")));
                    henHouseLeft = new Image((new FileInputStream("Files/Images/Others/SafeLeft.png")));
                    characterTopLeft = new Image(new FileInputStream("Files/Images/Characters/Scrooge_TOPLEFT.png"));
                    characterLowLeft = new Image(new FileInputStream("Files/Images/Characters/Scrooge_LOWLEFT.png"));
                    characterTopRight = new Image(new FileInputStream("Files/Images/Characters/Scrooge_TOPRIGHT.png"));
                    characterLowRight = new Image(new FileInputStream("Files/Images/Characters/Scrooge_LOWRIGHT.png"));
                    cursor = new Image(new FileInputStream("Files/Images/Others/Cursor2.png"));
                    font40 = Font.loadFont(new FileInputStream("Files/Others/Fonts/zagreb.ttf"), 40);
                    font30 = Font.loadFont(new FileInputStream("Files/Others/Fonts/zagreb.ttf"), 30);
                    font20 = Font.loadFont(new FileInputStream("Files/Others/Fonts/zagreb.ttf"), 20);
                    HP_3 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_3.png"));
                    HP_2_5 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_2.5.png"));
                    HP_2 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_2.png"));
                    HP_1_5 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_1.5.png"));
                    HP_1 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_1.png"));
                    HP_0_5 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_0.5.png"));
                    HP_0 = new Image(new FileInputStream("Files/Images/Others/HP_Coin_0.png"));
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
