package com.kodilla.tic_tac_toe.engine;

public class ScoreChecker {

    public String checkIfWinner(String[][] board, String figure, int gameVariant) {

        boolean diag1Check = checkDiagsLR(board, figure, gameVariant);
        boolean diag2Check = checkDiagsRL(board, figure, gameVariant);
        boolean rowsCheck = checkRows(board, figure, gameVariant);
        boolean colsCheck = checkCols(board, figure, gameVariant);

        if (diag1Check || diag2Check || rowsCheck || colsCheck) {
            return figure;
        }
        return null;
    }

    public String checkIfDraw(int movesCounter, int gameVariant) {

        String draw;
        if (movesCounter == (gameVariant * gameVariant)) {
            draw = "DRAW";
            return draw;
        }
        return null;
    }

    private boolean checkRows(String[][] board, String figure, int gameVariant) {

        for (String[] row : board) {
            int counter = 0;

            for (String slot : row) {
                counter += (slot.equals(figure)) ? 1 : 0;

                if (counter == gameVariant) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkCols(String[][] board, String figure, int gameVariant) {

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

    private boolean checkDiagsLR(String[][] board, String figure, int gameVariant) {

        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            counter += (board[i][i].equals(figure)) ? 1 : 0;
        }
        return counter == gameVariant;
    }

    private boolean checkDiagsRL(String[][] board, String figure, int gameVariant) {

        int counter = 0;
        int length = board.length;
        for (int i = 0; i < length; i++) {
            counter += (board[i][length - 1 - i].equals(figure)) ? 1 : 0;
        }
        return counter == gameVariant;
    }
}
