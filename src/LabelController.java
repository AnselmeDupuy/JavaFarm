import Farm.Farm;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.util.Duration;

public class LabelController {
    @FXML
    private Label coinLabel;
    @FXML
    private Label wheatLabel;
    @FXML
    private Label riceLabel;
    @FXML
    private Label milletLabel;
    @FXML
    private Label milletSeed;
    @FXML
    private Label wheatSeed;
    @FXML
    private Label riceSeed;


    @FXML
    private TabPane tabPane;

    private Farm farm;

    @FXML
    public void initialize() {
        farm = new Farm();
        farm.constructFarm();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                coinLabel.setText("Coins: " + farm.getCoins());
                wheatLabel.setText("Wheat: " + farm.getWheat());
                riceLabel.setText("Rice: " + farm.getRice());
                milletLabel.setText("Millet: " + farm.getMillet());
                milletSeed.setText("Millet Seeds: " + farm.getMilletSeeds());
                wheatSeed.setText("Wheat Seeds: " + farm.getWheatSeeds());
                riceSeed.setText("Rice Seeds: " + farm.getRiceSeeds());


        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}

