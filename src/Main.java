import Crops.Millet;
import Crops.Rice;
import Crops.Wheat;
import Farm.Farm;
import Seeds.WheatSeed;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.util.Duration;
import java.util.ArrayList;

public class Main extends Application {
    @FXML
    private Button fieldBtn1;
    @FXML
    private Button fieldBtn2;
    @FXML
    private Button fieldBtn3;
    @FXML
    private Button fieldBtn4;
    @FXML
    private Button fieldBtn5;
    @FXML
    private Button fieldBtn6;
    @FXML
    private Button fieldBtn7;
    @FXML
    private Button fieldBtn8;
    @FXML
    private Button fieldBtn9;
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


    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/farm.fxml"));
        Parent root = loader.load();
        Main controller = loader.getController();
        primaryStage.setTitle("JavaFarm");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();

        Farm farm = new Farm();

        Rice rice = new Rice("Rice", 100);
        Millet millet = new Millet("Millet", 100);
        WheatSeed wheatSeed = new WheatSeed();


        farm.constructFarm();
        farm.getAll();

        ArrayList<Button> fields = new ArrayList<>();
        fields.add(controller.fieldBtn1);
        fields.add(controller.fieldBtn2);
        fields.add(controller.fieldBtn3);
        fields.add(controller.fieldBtn4);
        fields.add(controller.fieldBtn5);
        fields.add(controller.fieldBtn6);
        fields.add(controller.fieldBtn7);
        fields.add(controller.fieldBtn8);
        fields.add(controller.fieldBtn9);

        wheatSeed.setQuantity(10);

        for (Button field : fields) {
            field.setText("150 Coins");
            field.setOnMouseClicked(event -> {
                if (field.getText().equals("150 Coins")) {
                    field.setText("Plant Seed");
                    System.out.println("test");
                } else {
                    wheatSeed.getQuantity();
                    field.setText("Plant Seed");
                    if (wheatSeed.getQuantity() > 0) {
                        Wheat wheat = new Wheat("Wheat", 0);
                        field.setDisable(true);
                        field.setText("seed planted, stage: " + wheat.getStage());
                        System.out.println("test2");
                        Timeline growingTime = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                            if (wheat.getStage() == 4) {
                                field.setText("seed ready to harvest");
                                field.setDisable(false);
                                wheat.harvest();
                                field.setText("Plant Seed");
                            } else if (wheat.getStage() < 4 && wheat.getStage() > 0){
                                field.setText("seed planted, stage: " + wheat.getStage());
                            } else {
                                field.setText("Plant Seed");
                            }
                            wheat.grow();
                        }));
                        growingTime.setCycleCount(5);
                        growingTime.setOnFinished(e -> {
                        });

                        growingTime.play();
                    }
                };
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}