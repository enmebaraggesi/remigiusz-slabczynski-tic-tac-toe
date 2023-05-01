package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import java.util.*;

public class GameEngine {

    PlayerHandler playerHandler = new PlayerHandler();
    private Random random = new Random();
    GameBoard gameBoard = new GameBoard();

    public void playGame() {

        //TODO structure of whole game

        playerHandler.explainRules();
        playerHandler.askForGameLoad();
        playerHandler.askHowManyPlayers();
        int maxGames = playerHandler.askHowManyGames();

        GameRound gameRound = new GameRound();
        int gameCount = gameRound.getGameCount();

        List<String> winnersTab = new ArrayList<>();

        while (!(gameCount > maxGames)) {
            int randomStartingPlayer = random.nextInt(2);
            String winner = gameRound.playRound(playerHandler, gameBoard, randomStartingPlayer);
            winnersTab.add(winner);
            playerHandler.displayScore(gameCount, winnersTab);
            gameCount++;
        }
    }
}
