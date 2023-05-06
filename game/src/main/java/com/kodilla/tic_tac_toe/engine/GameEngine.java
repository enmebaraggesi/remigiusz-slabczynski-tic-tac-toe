package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import java.util.*;

public class GameEngine {

    public void playGame() {

        int gameCount = 1;
        List<String> winnersTab = new ArrayList<>();

        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.explainRules();
//        playerHandler.askForGameLoad();
        playerHandler.askHowManyPlayers();
//        int gameVariant = playerHandler.askForGameVariant();
        int gameVariant = 3;
        int maxGames = playerHandler.askHowManyGames();

        GameBoard gameBoard = new GameBoard(gameVariant);
        GameRound gameRound = new GameRound(gameCount);
        while (!(gameCount > maxGames)) {

            Random random = new Random();
            int randomStartingPlayer = random.nextInt(2);
            String winner = gameRound.playRound(playerHandler, gameBoard, randomStartingPlayer);
            winnersTab.add(winner);
            playerHandler.displayScore(gameCount, winnersTab);
            gameCount++;
        }
    }
}
