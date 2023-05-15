package com.kodilla.tic_tac_toe;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class GameRunner {

    private Image chalkboard = new Image("file:src/main/resources/chalkboard.jpg");

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.playGame();
    }

//    @Override
//    public void start(Stage stage) throws Exception {
//
//        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true,
//            true, true, false);
//        BackgroundImage backgroundImage = new BackgroundImage(chalkboard, BackgroundRepeat.REPEAT,
//            BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//        Background background = new Background(backgroundImage);
//
//        GridPane grid = new GridPane();
//        grid.setBackground(background);
//
//        Scene scene = new Scene(grid, 910, 700, Color.BLACK);
//
//        stage.setTitle("Tic Tac Toe");
//        stage.setScene(scene);
//        stage.show();
//    }


}
