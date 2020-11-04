package guitar;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Guitar extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Label l1 = new Label("Welcome! This is");
        l1.setFont(Font.font("Arial Rounded MT Bold", 36));
        l1.setTextFill(Paint.valueOf("white"));
        l1.setLayoutX(160);
        l1.setLayoutY(330);
        
        fade(l1,2);
       
        Label l2 = new Label("Blues!");
        l2.setFont(Font.font("Arial Rounded MT Bold", 45));
        l2.setTextFill(Paint.valueOf("white"));
        l2.setLayoutX(-160);
        l2.setLayoutY(390);
        
        translate(l2, 2);
        
        AnchorPane parent = new AnchorPane(l1,l2);
        parent.setId("parent");
        
        Scene scene = new Scene(parent, 1320, 600);
        scene.getStylesheets().add(getClass().getResource("guitar.css").toExternalForm());
        
        stage.getIcons().add(new Image("/images/logo.png"));
        stage.setTitle("Blues!");
        stage.setScene(scene);
        stage.show();
    }

    private void fade(Node node, double time){
        FadeTransition l1Trans = new FadeTransition(Duration.seconds(time), node);
        l1Trans.setFromValue(0);
        l1Trans.setToValue(0.7f);
        l1Trans.setCycleCount(3);
        l1Trans.setAutoReverse(true);
        l1Trans.play();
    }
    
    private void translate(Node node, double time){
        TranslateTransition l2Trans = new TranslateTransition(Duration.seconds(time), node);
        l2Trans.setDelay(Duration.seconds(1.5));
        l2Trans.setToX(390);
        l2Trans.setCycleCount(1);
        l2Trans.play();
    }
    
    public static void main(String[] args) {
        launch(args);
    }    
}