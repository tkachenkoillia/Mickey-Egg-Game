package GUI.Others;

import Defaults.Positions;
import Defaults.Settings;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;


public class Character {

    static ImageView character = new ImageView();

    public Character(){
        switch (Settings.position){
            case TOPLEFT -> character.setImage(Settings.characterTopLeft);
            case TOPRIGHT -> character.setImage(Settings.characterTopRight);
            case LOWLEFT -> character.setImage(Settings.characterLowLeft);
            case LOWRIGHT -> character.setImage(Settings.characterLowRight);
        }
    }

    public static ImageView getImage(){
        return character;
    }

}


