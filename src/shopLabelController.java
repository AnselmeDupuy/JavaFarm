import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class shopLabelController {
    @FXML
    private Label coinLabel1;
    @FXML
    private Label wheatLabel1;
    @FXML
    private Label riceLabel1;
    @FXML
    private Label milletLabel1;
    @FXML
    private Label wheatSeeds;
    @FXML
    private Label riceSeed;
    @FXML
    private Label milletSeed;

    private Farm farm;

    public void initialize() {
        farm = new Farm();
        farm.constructFarm();


        // Periodically update the labels
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            Platform.runLater(() -> {
                coinLabel1.setText("Coins: " + farm.getCoins());
                wheatLabel1.setText("Wheat: " + farm.getWheat());
                riceLabel1.setText("Rice: " + farm.getRice());
                milletLabel1.setText("Millet: " + farm.getMillet());
                milletSeed.setText("Millet Seeds: " + farm.getMilletSeeds());
                wheatSeeds.setText("Wheat Seeds: " + farm.getWheatSeeds());
                riceSeed.setText("Rice Seeds: " + farm.getRiceSeeds());

            });
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
