package com.kodilla.tic_tac_toe.misc;

import com.kodilla.tic_tac_toe.players.*;

public class ScoreChecker {

    // Checks all possible options for win and if there is one returns '1'
    public static int checkIfWinner(String[][] board, Player player, int gameVariant) {

        boolean diag1Check = checkDiagsLR(board, player.getFigure(), gameVariant);
        boolean diag2Check = checkDiagsRL(board, player.getFigure(), gameVariant);
        boolean rowsCheck = checkRows(board, player.getFigure(), gameVariant);
        boolean colsCheck = checkCols(board, player.getFigure(), gameVariant);

        if (diag1Check || diag2Check || rowsCheck || colsCheck) {
            player.updateScore();
            return 1;
        }
        return 0;
    }

    // Checks if number of possible moves is reached
    public static int checkIfDraw(int movesCounter, int gameVariant) {

        if (movesCounter == (gameVariant * gameVariant)) {
            return 1;
        }
        return 0;
    }

    private static boolean checkRows(String[][] board, String figure, int requiredFigures) {

        for (String[] row : board) {
            int counter = 0;

            //Stream połączenie stringów w ciąg i poszukanie
            for (String slot : row) {
                counter += (slot.equals(figure)) ? 1 : 0;

                if (counter == requiredFigures) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkCols(String[][] board, String figure, int gameVariant) {

        for (int i = 0; i < board.length; i++) {
            int counter = 0;

            for (int j = 0; j < board[i].length; j++) {
                counter += (board[j][i].equals(figure)) ? 1 : 0;

                if (counter == gameVariant) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDiagsLR(String[][] board, String figure, int gameVariant) {

        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            counter += (board[i][i].equals(figure)) ? 1 : 0;
        }
        return counter == gameVariant;
    }

    private static boolean checkDiagsRL(String[][] board, String figure, int gameVariant) {

        int counter = 0;
        int length = board.length;
        for (int i = 0; i < length; i++) {
            counter += (board[i][length - 1 - i].equals(figure)) ? 1 : 0;
        }
        return counter == gameVariant;
    }
}
