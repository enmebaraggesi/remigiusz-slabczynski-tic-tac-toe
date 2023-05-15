package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.misc.*;
import com.kodilla.tic_tac_toe.gui.*;

import java.util.Random;

public class GameRound {

    private int roundNumber = 0;
    private int movesCounter = 0;
    private int gameCount;

    public GameRound(int gameCount) {
        this.gameCount = gameCount;
    }

    public void playRound(PlayerHandler playerHandler, GameBoard gameBoard) {

        GameTurn gameTurn = new GameTurn();
        Player firstPlayer = playerHandler.getPlayersList()[0];
        Player secondPlayer = playerHandler.getPlayersList()[1];

        Random random = new Random();
        int randomStartingPlayer = random.nextInt(2);
        if (randomStartingPlayer == 1) {
            firstPlayer = playerHandler.getPlayersList()[1];
            secondPlayer = playerHandler.getPlayersList()[0];
        }

        while (true) {
            playerHandler.displayRoundNumber(++roundNumber, gameCount);
            boolean winner;

            winner = gameTurn.playTurn(gameBoard, firstPlayer, ++movesCounter);
            if (winner) {
                roundNumber = 0;
                movesCounter = 0;
                return;
            }
            //if other decision than move - save restart quit game
            winner = gameTurn.playTurn(gameBoard, secondPlayer, ++movesCounter);
            if (winner) {
                roundNumber = 0;
                movesCounter = 0;
                return;
            }
            //if other decision than move - save restart quit game
        }
    }

    //============ GETTER & SETTER

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }
}
