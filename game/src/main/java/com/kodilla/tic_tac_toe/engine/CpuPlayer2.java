package com.kodilla.tic_tac_toe.engine;

public class CpuPlayer2 {

    public int[] cpuMoveMaker(String[][] board, String myFigure, String oponentFigure) {

        int[][] pointsBoard = new int[3][3];

        String[] diags1 = {board[0][0], board[1][1], board[2][2]};
        String[] diags2 = {board[0][2], board[1][1], board[2][0]};
        int pointsForDiags = pointsForDiags(diags1,diags2, myFigure);
        int pointsAgainstDiags = pointsAgainstDiags(diags1,diags2, oponentFigure);
        int pointsDiags = pointsForDiags + pointsAgainstDiags;

        for (int i = 0; i < board.length; i++) {

            int pointsRows = pointsForRows(board[i], myFigure) + pointsAgainstRows(board[i], oponentFigure);

            for (int j = 0; j < board[i].length; j++) {

                String[] col = {board[0][j], board[1][j], board[2][j]};
                int pointsCols = pointsForCols(col, myFigure) + pointsAgainstCols(col, oponentFigure);
                int pointsIfFree = checkIfFree(board[i][j]);
                pointsBoard[i][j] = pointsCols + pointsRows + pointsDiags + pointsIfFree;
            }
        }

        int highest = Integer.MIN_VALUE;
        int[] move = new int[2];
        for (int i = 0; i < pointsBoard.length; i++) {
            for (int j = 0; j < pointsBoard[i].length; j++) {
                if(pointsBoard[i][j] > highest) {
                    highest = pointsBoard[i][j];
                    move[0] = i;
                    move[1] = j;
                }
            }
        }
        return move;
    }

    public static int checkIfFree(String slot) {

        return (slot.equals(" ")) ? 0 : -500;
    }

    public static int pointsForRows(String[] row, String figure) {

        int quantity = checkRows(row, figure);
        return (quantity == 2) ? 100 : quantity;
    }

    public static int pointsAgainstRows(String[] row, String oponentFigure) {

        int quantity = checkRows(row, oponentFigure);
        return (quantity == 2) ? 50 : quantity;
    }

    public static int pointsForCols(String[] col, String figure) {

        int quantity = checkCols(col, figure);
        return (quantity == 2) ? 100 : quantity;
    }

    public static int pointsAgainstCols(String[] col, String oponentFigure) {

        int quantity = checkCols(col, oponentFigure);
        return (quantity == 2) ? 50 : quantity;
    }

    public static int pointsForDiags(String[] diag1, String[] diag2, String figure) {

        int quantity1 = checkDiag(diag1, figure);
        int total1 = (quantity1 == 2) ? 100 : quantity1;
        int quantity2 = checkDiag(diag2, figure);
        int total2 = (quantity2 == 2) ? 100 : quantity2;
        return total1 + total2;
    }

    public static int pointsAgainstDiags(String[] diag1, String[] diag2, String oponentFigure) {

        int quantity1 = checkDiag(diag1, oponentFigure);
        int total1 = (quantity1 == 2) ? 50 : quantity1;
        int quantity2 = checkDiag(diag2, oponentFigure);
        int total2 = (quantity2 == 2) ? 50 : quantity2;
        return total1 + total2;
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
}
