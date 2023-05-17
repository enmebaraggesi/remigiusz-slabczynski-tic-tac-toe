package com.kodilla.tic_tac_toe;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.game_saver.GameSaver;
import com.kodilla.tic_tac_toe.gui.GameBoard;
import com.kodilla.tic_tac_toe.misc.FileCreator;


public class GameRunner {

//    private Image chalkboard = new Image("file:src/main/resources/chalkboard.jpg");

    public static void main(String[] args) {

//        GameEngine gameEngine = new GameEngine();
//        gameEngine.playGame();

        GameBoard board = new GameBoard(3);
        String[][] coordinatesMap = new String[3][3];
        for (int i = 0; i < coordinatesMap.length; i++) {
            for (int j = 0; j < coordinatesMap[i].length; j++) {
                coordinatesMap[i][j] = String.valueOf(i) + j;
            }
        }
        board.setBoard(coordinatesMap);

        GameSaver.saveBoard(board.getBoard());
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
