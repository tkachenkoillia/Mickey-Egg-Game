package GUI.Others;

import Defaults.Settings;
import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelpCharacter extends ImageView {

    FadeTransition fadeTransition;
    public boolean animationFinished = false;

    public HelpCharacter(){
        this.setImage(Settings.help_Character);

        this.fadeTransition = new FadeTransition();
        this.fadeTransition.setDuration(Duration.millis(2500));
        this.fadeTransition.setNode(this);
        this.fadeTransition.setCycleCount(2);
        this.fadeTransition.setFromValue(0.0);
        this.fadeTransition.setToValue(1.0);
        this.fadeTransition.setAutoReverse(true);
        this.fadeTransition.play();

        this.fadeTransition.setOnFinished(e -> this.animationFinished = true);
    }


}
