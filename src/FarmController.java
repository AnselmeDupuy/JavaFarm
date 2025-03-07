import Crops.Millet;
import Crops.Rice;
import Crops.Wheat;
import Farm.Farm;
import Seeds.MilletSeed;
import Seeds.RiceSeed;
import Seeds.WheatSeed;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FarmController {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label coinLabel;
    @FXML
    private Label wheatLabel;
    @FXML
    private Label riceLabel;
    @FXML
    private Label milletLabel;
    @FXML
    private Label cowsLabel;
    @FXML
    private Label muttonsLabel;
    @FXML
    private Label horsesLabel;
    @FXML
    private Pane choiceBtn;

    private String seedName = "";
    private Farm farm = new Farm();
    private WheatSeed wheatSeed = new WheatSeed();
    private RiceSeed riceSeed = new RiceSeed();
    private MilletSeed milletSeed = new MilletSeed();
    private Rice rice = new Rice("Rice", 30);
    private Millet millet = new Millet("Millet", 150);

    public void initialize() {
        int rows = 3;
        int columns = 3;

        farm.constructFarm();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button button = new Button("Price: 150Coins");
                gridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
                gridPane.setValignment(button, javafx.geometry.VPos.CENTER);
                gridPane.setAlignment(Pos.CENTER);

                button.setOnMouseClicked((event) -> {

                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setTitle("What to plant");
                    Button btnRice = new Button("Crop: rice");
                    Button btnMillet = new Button("Crop: millet");
                    Button btnWheat = new Button("Crop: wheat");
                    VBox vbox = new VBox(btnRice, btnMillet, btnWheat);
                    vbox.setAlignment(Pos.CENTER);
                    stage.setScene(new Scene(vbox,100, 100));

                    btnWheat.setOnMouseClicked(event1 -> {
                        System.out.println("Wheat seed planted");
                        Wheat wheat = new Wheat("wheat", 100);
                        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                            if (wheat.getStage() == 4) {
                                button.setText("Choose seed to plant");
                                wheat.harvest();
                                button.setDisable(false);
                            } else if (wheat.getStage() < 4 && wheat.getStage() >= 0){
                                button.setDisable(true);
                                wheat.grow();
                                button.setText("seed planted, stage: " + wheat.getStage());
                                wheat.addToQuantity(1);

                            } else {
                                button.setText("Plant Seed");
                            }
                        }));
                        growingTime.setCycleCount(5);
                        growingTime.play();
                        seedName = "Wheat";
                        stage.close();
                    });
                    btnMillet.setOnMouseClicked(event1 -> {
                        System.out.println("Millet seed planted");
                        seedName = "Millet";
                        button.setText(seedName);
                        stage.close();
                    });
                    btnRice.setOnMouseClicked(event1 ->{
                        System.out.println("Rice seed planted");
                        seedName = "Rice";
                        button.setText(seedName);
                        stage.close();
                    });
                    stage.show();
                });
                gridPane.add(button, col, row);
            }
        }
    }

}
