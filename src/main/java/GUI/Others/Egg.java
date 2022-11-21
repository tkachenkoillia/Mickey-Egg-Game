package GUI.Others;

import Defaults.Positions;
import Defaults.Settings;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Egg extends ImageView{

    MoveTo moveTo;
    LineTo lineTo;
    Path path = new Path();
    RotateTransition rotateTransition;
    PathTransition pathTransition;
    public boolean animationFinished = false;
    public Positions position;
    int interval;
    String difficulty;

    public Egg(Positions position, String diff){
        difficulty = diff;
        this.position = position;
        if (this.difficulty.equals("EASY")){
            this.interval = 4000;
        }
        else{
            this.interval = 2000;
        }
        this.setImage(Settings.egg);

        this.rotateTransition = new RotateTransition(Duration.millis(interval), this);
        this.rotateTransition.setCycleCount(Animation.INDEFINITE);
        this.pathTransition = new PathTransition();
        this.pathTransition.setDuration(Duration.millis(interval));
        this.pathTransition.setNode(this);
        this.pathTransition.setCycleCount(1);


        switch (position){
            case TOPLEFT -> {
                this.rotateTransition.setFromAngle(0);
                this.rotateTransition.setToAngle(720);
                this.moveTo = new MoveTo(100, 165);
                this.lineTo = new LineTo(160, 230);
            }
            case TOPRIGHT -> {
                this.rotateTransition.setFromAngle(0);
                this.rotateTransition.setToAngle(-720);
                this.moveTo = new MoveTo(700, 165);
                this.lineTo = new LineTo(640, 230);
            }
            case LOWLEFT -> {
                this.rotateTransition.setFromAngle(0);
                this.rotateTransition.setToAngle(720);
                this.moveTo = new MoveTo(100, 350);
                this.lineTo = new LineTo(160, 415);

            }
            case LOWRIGHT -> {
                this.rotateTransition.setFromAngle(0);
                this.rotateTransition.setToAngle(-720);
                this.moveTo = new MoveTo(700, 350);
                this.lineTo = new LineTo(640, 415);
            }
            default -> {
                moveTo = new MoveTo(0, 0);
                moveTo.setAbsolute(true);
            }
        }
        this.path.getElements().add(this.moveTo);
        this.path.getElements().add(this.lineTo);
        this.pathTransition.setPath(this.path);
        this.pathTransition.play();
        this.rotateTransition.play();

        this.pathTransition.setOnFinished(e -> this.animationFinished = true);
    }
}
