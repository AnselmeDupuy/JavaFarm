import Animals.Animals;
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
import Animals.Cows;

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

    private Farm farm = new Farm();
    private WheatSeed wheatSeed = new WheatSeed();
    private RiceSeed riceSeed = new RiceSeed();
    private MilletSeed milletSeed = new MilletSeed();
    private Rice rice = new Rice("Rice", 30);
    private Millet millet = new Millet("Millet", 150);
    private boolean isBought = false;
    private int isCrop;


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
                    Stage choiceType = new Stage();
                    choiceType.initModality(Modality.APPLICATION_MODAL);
                    choiceType.setTitle("Choice animals or crop");
                    Button animalBtn = new Button("Animals");
                    Button cropBtn = new Button("Crops");
                    VBox choiceVbox = new VBox(animalBtn, cropBtn);
                    choiceType.setScene(new Scene(choiceVbox, 100,100));
                    choiceVbox.setAlignment(Pos.CENTER);

                    animalBtn.setOnMouseClicked((e) -> {
                        if (button.getText().equals("Animal field")) {
                            isBought = true;
                        } else {
                            isBought = false;
                        }
                        if(farm.getCoins() > 149 && isBought == false) {
                            farm.removeCoins(150);
                            button.setText("Animal field");
                            choiceType.close();

                        } else if (isBought == true){
                            Cows cows = new Cows("Cows", 150);
                            cows.growingTime(button, farm);
                            choiceType.close();
                        } else {
                            Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(1), e2 -> {
                                button.setText("Price: 150Coins");
                            }));
                            button.setText("Not enough Coins");
                            growingTime.setCycleCount(3);
                            growingTime.play();
                        }
                    });

                    cropBtn.setOnMouseClicked((e) -> {
                        if (button.getText().equals("Choose seed to plant")) {
                            isBought = true;
                        } else {
                            isBought = false;
                        }
                        if(farm.getCoins() > 150 && isBought == false) {
                            farm.removeCoins(150);
                            Stage stage = new Stage();
                            stage.initModality(Modality.APPLICATION_MODAL);
                            stage.setTitle("What to plant");
                            Button btnRice = new Button("Crop: rice");
                            Button btnMillet = new Button("Crop: millet");
                            Button btnWheat = new Button("Crop: wheat");
                            VBox vbox = new VBox(btnRice, btnMillet, btnWheat);
                            vbox.setAlignment(Pos.CENTER);
                            stage.setScene(new Scene(vbox,100, 100));

                            choiceType.close();

                            btnWheat.setOnMouseClicked(event1 -> {
                                System.out.println("Wheat seed planted");
                                Wheat wheat = new Wheat("wheat", 50);
                                wheat.growingTime(button, farm);
                                stage.close();
                            });

                            btnMillet.setOnMouseClicked(event1 -> {
                                System.out.println("Millet seed planted");
                                Millet millet = new Millet("millet", 75);
                                millet.growingTime(button, farm);
                                stage.close();
                            });

                            btnRice.setOnMouseClicked(event1 ->{
                                System.out.println("Rice seed planted");
                                Rice rice = new Rice("rice", 25);
                                rice.growingTime(button, farm);
                                stage.close();
                            });

                            stage.show();


                        } else if (isBought == true){
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
                                Wheat wheat = new Wheat("wheat", 50);
                                wheat.growingTime(button, farm);
                                stage.close();
                            });

                            btnMillet.setOnMouseClicked(event1 -> {
                                System.out.println("Millet seed planted");
                                Millet millet = new Millet("millet", 75);
                                millet.growingTime(button, farm);
                                stage.close();
                            });

                            btnRice.setOnMouseClicked(event1 ->{
                                System.out.println("Rice seed planted");
                                Rice rice = new Rice("rice", 25);
                                rice.growingTime(button, farm);
                                stage.close();
                            });
                            choiceType.close();
                        } else {
                            Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(1), e2 -> {
                                button.setText("Price: 150Coins");
                            }));
                            button.setText("Not enough Coins");
                            growingTime.setCycleCount(3);
                            growingTime.play();
                        }
                    });
                    choiceType.showAndWait();
                });
                gridPane.add(button, col, row);
            }
        }
    }

}
