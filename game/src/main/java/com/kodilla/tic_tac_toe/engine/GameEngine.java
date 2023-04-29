package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import java.util.Random;

public class GameEngine {

    PlayerHandler playerHandler = new PlayerHandler();
    private Random random = new Random();
    GameBoard gameBoard = new GameBoard();
    private int maxGames;

    public void playGame() {

        //TODO structure of whole game

        playerHandler.explainRules();
        playerHandler.askForGameLoad();
        playerHandler.askHowManyPlayers();
        maxGames = playerHandler.askHowManyGames();

        GameRound gameRound = new GameRound();
        int gameCount = gameRound.getGameCount();
        while (!(gameCount > maxGames)) {
            int randomNumber = random.nextInt(2);
            gameRound.playRound(playerHandler, gameBoard, randomNumber);
            playerHandler.displayScore(gameCount);
            gameCount++;
        }
    }
}
