package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.*;

import java.util.*;

public class GameRound {

    private int roundNumber = 0;
    private int gameCount = 1;

    public void playRound(PlayerHandler playerHandler, GameBoard gameBoard,
                          int random) {

        //TODO round structure
        List<String> randomFigures = List.of("X", "O");
        String first = randomFigures.get(random);
        String second = randomFigures.get(0);
        if (random == 0) {
            second = randomFigures.get(1);
        }

        playerHandler.displayRoundNumber(roundNumber, gameCount);
        Map<String, Integer> firstPlayer = playerHandler.getPlayers().get(first);
        String firstPlayerName = firstPlayer.keySet().toString();
        System.out.println(firstPlayerName + ", it's your turn.");
        BoardDisplay boardDisplay = new BoardDisplay();
        Map<String, String> actualBoard = gameBoard.getBoard();
        boardDisplay.displayBoard(actualBoard);
        String firstPlayerMove = playerHandler.askForMove(firstPlayerName, gameBoard);
        actualBoard.put(firstPlayerMove, first);
        //TODO if winning/draw conditions - finish
                //if other decision than move
                    //save game
                    //restart game
                    //quit game
        Map<String, Integer> secondPlayer = playerHandler.getPlayers().get(second);
        String secondPlayerName = secondPlayer.keySet().toString();
        System.out.println(secondPlayerName + ", it's your turn.");
        boardDisplay.displayBoard(actualBoard);
        String secondPlayerMove = playerHandler.askForMove(secondPlayerName, gameBoard);
        actualBoard.put(secondPlayerMove, second);
        //TODO if winning/draw conditions - finish
                //if other decision than move
                //save game
                //restart game
                //quit game
        roundNumber++;
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
