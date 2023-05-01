package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.*;

import java.util.*;

public class GameRound {

    private int roundNumber = 1;
    private int gameCount = 1;

    public String playRound(PlayerHandler playerHandler, GameBoard gameBoard,
                          int random) {

        //TODO round structure
        String winner = "";
        List<String> playersFigures = new ArrayList<>();
        for (Map.Entry<String, String> figures : playerHandler.getPlayers().entrySet()) {
            playersFigures.add(figures.getKey());
        }

        String firstPlayerFigure = playersFigures.get(random);
        playersFigures.remove(random);
        String secondPlayerFigure = playersFigures.get(0);

        while (roundNumber < 2) {
            playerHandler.displayRoundNumber(roundNumber, gameCount);
            String firstPlayerName = playerHandler.getPlayers().get(firstPlayerFigure);
            System.out.println(firstPlayerName + ", it's your turn.");

            BoardDisplay boardDisplay = new BoardDisplay();
            Map<String, String> actualBoard = gameBoard.getBoard();
            boardDisplay.displayBoard(actualBoard);

            String firstPlayerMove = playerHandler.askForMove(secondPlayerFigure, gameBoard);
            actualBoard.put(firstPlayerMove, firstPlayerFigure);
            //TODO if winning/draw conditions - finish
            //if other decision than move
            //save game
            //restart game
            //quit game
            String secondPlayerName = playerHandler.getPlayers().get(secondPlayerFigure);
            System.out.println(secondPlayerName + ", it's your turn.");

            boardDisplay.displayBoard(actualBoard);

            String secondPlayerMove = playerHandler.askForMove(secondPlayerName, gameBoard);
            actualBoard.put(secondPlayerMove, secondPlayerFigure);
            //TODO if winning/draw conditions - finish
            //if other decision than move
            //save game
            //restart game
            //quit game
            winner = firstPlayerName;
            roundNumber++;
        }
        return winner;
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
