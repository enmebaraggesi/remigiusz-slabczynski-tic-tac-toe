package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.engine.cpu_player.CpuPlayerHard;
import com.kodilla.tic_tac_toe.gui.*;

import java.util.*;

public class GameRound {

    private int roundNumber = 0;
    private int movesCounter = 0;
    private int gameCount;

    public GameRound(int gameCount) {
        this.gameCount = gameCount;
    }

    public String playRound(PlayerHandler playerHandler, GameBoard gameBoard,
                            int random, int gameVariant) {

        List<String> playersFigures = new ArrayList<>();
        for (Map.Entry<String, String> figures : playerHandler.getPlayers().entrySet()) {
            playersFigures.add(figures.getKey());
        }

        String firstPlayerFigure = playersFigures.get(random);
        playersFigures.remove(random);
        String secondPlayerFigure = playersFigures.get(0);
        roundNumber++;
        gameBoard.displayBoard();
        while (true) {

            playerHandler.displayRoundNumber(roundNumber, gameCount);

            String firstPlayerName = playerHandler.getPlayers().get(firstPlayerFigure);
            String secondPlayerName = playerHandler.getPlayers().get(secondPlayerFigure);
            String winner;

            winner = playTurn(gameBoard, firstPlayerFigure, firstPlayerName, gameVariant);
            if (winner != null) {
                return winner;
            }
            //if other decision than move - save restart quit game
            winner = playTurn(gameBoard, secondPlayerFigure, secondPlayerName, gameVariant);
            if (winner != null) {
                return winner;
            }
            //if other decision than move - save restart quit game
        }
    }

    public String playTurn(GameBoard gameBoard, String playerFigure, String playerName, int gameVariant) {

        String oponentFigure;
        if (playerFigure.equals("X")) {
            oponentFigure = "O";
        } else {
            oponentFigure = "X";
        }

        String winner;
        ScoreChecker statusChecker = new ScoreChecker();
        String[][] board = gameBoard.getBoard();

        if (playerName.equals("CPU")) {
            CpuPlayerHard cpu = new CpuPlayerHard();
            int[] cpuMove = cpu.cpuMoveMaker(board, playerFigure, oponentFigure);
            board[cpuMove[0]][cpuMove[1]] = playerFigure;
            System.out.println("\nCPU made its move\n");
        } else {
            System.out.println(playerName + ", it's your turn.");
            PlayerHandler playerHandler = new PlayerHandler();
            int[] firstPlayerMove = playerHandler.askForMove(playerName, board);
            board[firstPlayerMove[0]][firstPlayerMove[1]] = playerFigure;
        }
        gameBoard.displayBoard();
        winner = statusChecker.checkIfWinner(board, playerFigure, gameVariant);
        if (winner != null) {
            return winner;
        }
        movesCounter++;
        winner = statusChecker.checkIfDraw(movesCounter, gameVariant);
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
