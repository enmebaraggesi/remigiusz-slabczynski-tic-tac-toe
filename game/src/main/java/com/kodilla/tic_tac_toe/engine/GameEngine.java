package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.misc.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import java.util.*;

public class GameEngine {

    int gameCount = 1;
    int maxGames;
    int gameVariant;
    public void playGame() {

        PlayerHandler playerHandler = new PlayerHandler();
        collectGameDecisions(playerHandler);
        GameRound gameRound = new GameRound(gameCount);

        while (!(gameCount > maxGames)) {
            GameBoard gameBoard = new GameBoard(gameVariant);
            gameRound.playRound(playerHandler, gameBoard);
            playerHandler.displayScore(gameCount);
            gameCount++;
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
