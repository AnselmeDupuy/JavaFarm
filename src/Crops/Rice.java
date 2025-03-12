package Crops;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Rice extends Crops{
    private static int quantity;

    public Rice(String name, int price) {
        super("Rice", 25);
    }

    public void growingTime(Button button, Farm farm) {
        button.setDisable(true);
        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
            if (this.getStage() == 4) {
                button.setText("Choose seed to plant");
                this.harvest();
                farm.addRice(1);
                System.out.println(farm.getRice());
                button.setDisable(false);
            } else if (this.getStage() < 4 && this.getStage() >= 0){
                this.grow();
                button.setText("seed planted, stage: " + this.getStage());
                this.addToQuantity(1);

            } else {
                button.setText("Plant Seed");
            }
        }));
        growingTime.setCycleCount(5);
        growingTime.play();
    }

}
