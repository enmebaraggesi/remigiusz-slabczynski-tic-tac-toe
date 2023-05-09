package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import java.util.*;

public class GameEngine {

    int gameCount = 0;
    int maxGames;
    int gameVariant;
    public void playGame() {

        List<String> winnersTab = new ArrayList<>();
        PlayerHandler playerHandler = new PlayerHandler();

        collectGameDecisions(playerHandler);

        GameBoard gameBoard = new GameBoard(gameVariant);
        GameRound gameRound = new GameRound(gameCount);

        while (!(gameCount > maxGames)) {
            gameCount++;
            Random random = new Random();
            int randomStartingPlayer = random.nextInt(2);

            String winner = gameRound.playRound(playerHandler, gameBoard, randomStartingPlayer, gameVariant);
            winnersTab.add(winner);

            playerHandler.displayScore(gameCount, winnersTab);
        }
    }

    private void collectGameDecisions(PlayerHandler playerHandler) {

        playerHandler.explainRules();
//        playerHandler.askForGameLoad();
        playerHandler.askHowManyPlayers();
        gameVariant = playerHandler.askForGameVariant();
        maxGames = playerHandler.askHowManyGames();
    }
}
