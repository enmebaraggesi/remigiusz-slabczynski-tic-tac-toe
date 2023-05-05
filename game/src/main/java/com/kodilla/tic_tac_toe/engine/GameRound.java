package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;
import com.kodilla.tic_tac_toe.gui.*;

import java.util.*;

public class GameRound {

    private int roundNumber = 1;
    private int movesCounter = 0;
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

        boolean end = false;
        while (!end) {
            playerHandler.displayRoundNumber(roundNumber, gameCount);

            String[][] board = gameBoard.getBoard();
            String firstPlayerName = playerHandler.getPlayers().get(firstPlayerFigure);
            String secondPlayerName = playerHandler.getPlayers().get(secondPlayerFigure);

            if (firstPlayerName.equals("CPU")) {
                CpuPlayer2 cpu = new CpuPlayer2();
                int[] cpuMove = cpu.cpuMoveMaker(board, firstPlayerFigure, secondPlayerFigure);
                board[cpuMove[0]][cpuMove[1]] = firstPlayerFigure;
                System.out.println("CPU made its move\n");
            } else {
                System.out.println(firstPlayerName + ", it's your turn.");

                gameBoard.displayBoard();

                int[] firstPlayerMove = playerHandler.askForMove(firstPlayerName, board);
                board[firstPlayerMove[0]][firstPlayerMove[1]] = firstPlayerFigure;
                winner = checkIfWinner(board, firstPlayerFigure);
                //TODO if winning/draw conditions - finish
                    //end = true;
                //if other decision than move
                //save game
                //restart game
                //quit game
            }

            if (secondPlayerName.equals("CPU")) {
                CpuPlayer2 cpu = new CpuPlayer2();
                int[] cpuMove = cpu.cpuMoveMaker(board, secondPlayerFigure, firstPlayerFigure);
                board[cpuMove[0]][cpuMove[1]] = secondPlayerFigure;
                System.out.println("CPU made its move\n");
            } else {

                System.out.println(secondPlayerName + ", it's your turn.");

                gameBoard.displayBoard();

                int[] secondPlayerMove = playerHandler.askForMove(secondPlayerName, board);
                board[secondPlayerMove[0]][secondPlayerMove[1]] = firstPlayerFigure;
                //TODO if winning/draw conditions - finish
                    // end = true;
                //if other decision than move
                //save game
                //restart game
                //quit game
            }

            winner = firstPlayerName;
            roundNumber++;
        }
        return winner;
    }

    public static String checkIfWinner(String[][] board, String figure) {

        for (int i = 0; i < board.length; i++) {

            int rowsCheck = checkRows(board[i], figure);

            String[] diags1 = {board[0][0], board[1][1], board[2][2]};
            String[] diags2 = {board[0][2], board[1][1], board[2][0]};
            int diag1Check = checkDiag(diags1, figure);
            int diag2Check = checkDiag(diags2, figure);

            if (rowsCheck != 3 || diag1Check != 3 || diag2Check != 3) {
                for (int j = 0; j < board[i].length; j++) {
                    String[] col = {board[0][j], board[1][j], board[2][j]};
                    int colsCheck = checkCols(col, figure);
                    if (colsCheck != 3) {
                        return "";
                    }
                }
            }
        }
        return figure;
    }

    public static int checkRows(String[] row, String figure) {

        int counter = 0;
        for (String slot : row) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
    }

    public static int checkCols(String[] col, String figure) {

        int counter = 0;
        for (String slot : col) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
    }

    public static int checkDiag(String[] diag, String figure) {

        int counter = 0;
        for (String slot : diag) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
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
