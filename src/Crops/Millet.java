package Crops;

import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Millet extends Crops{
    private static int quantity;

    public Millet(String name, int price) {
        super("Millet", 75);
    }

    public void growingTime(Button button, Farm farm) {
        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(5), e -> {
            if (this.getStage() == 4) {
                button.setText("Choose seed to plant");
                this.harvest();
                farm.addMillet(1);
                System.out.println(farm.getMillet());
                button.setDisable(false);
            } else if (this.getStage() < 4 && this.getStage() >= 0){
                button.setDisable(true);
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
