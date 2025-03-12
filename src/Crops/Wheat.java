package Crops;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Wheat extends Crops {
    private static int quantity;

    public Wheat(String name, int price) {
        super("Wheat", 50);
    }

    public void growingTime(Button button, Farm farm) {
        button.setDisable(true);
        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            if (this.getStage() == 4) {
                button.setDisable(false);
                button.setText("Choose seed to plant");
                this.harvest();
                farm.addWheat(1);
                System.out.println(farm.getWheat());
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
