package Animals;

import Crops.Crops;
import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Cows extends Animals {
    private static int quantity;

    public Cows(String name, int price) {
        super("Cow", 150);
    }

    public void growingTime(Button button, Farm farm) {
        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            button.setDisable(true);
            if (this.getStage() == 4) {
                this.harvest();
                farm.addCows(1);
                System.out.println(farm.getCows());
                button.setDisable(false);
            } else if (this.getStage() < 4 && this.getStage() >= 0){
                this.grow();
                button.setText("Animal growing, stage: " + this.getStage());
                this.addToQuantity(1);

            } else {
                button.setText(this.getName());
            }
        }));
        growingTime.setCycleCount(5);
        growingTime.play();
    }
}
