package com.kodilla.tic_tac_toe.misc;

import java.util.*;

public class CpuPlayer implements PlayersMoving {

    private String name;
    private String figure;

    public CpuPlayer(String name, String figure) {
        this.name = name;
        this.figure = figure;
    }

    @Override
    public Move makeAMove(String[][] board) {

        System.out.println("\n" + name + " made its move\n");
        if (name.contains("easy")) {
            return easyMove(board);
        }
        return hardMove(board);
    }

    private Move easyMove(String[][] board) {

        Random random = new Random();
        List<Move> listOfMoves = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" ")) {
                    counter++;
                    listOfMoves.add(new Move(i, j));
                }
            }
        }
        return listOfMoves.get(random.nextInt(counter));
    }

    public Move hardMove(String[][] board) {

        int variant = board.length;
        int[][] scoredBoard = new int[variant][variant];

        String[] diags1 = new String[variant];
        for (int i = 0; i < variant; i++) {
            diags1[i] = board[i][i];
        }

        String[] diags2 = new String[variant];
        for (int i = 0; i < variant; i++) {
            diags2[i] = board[i][variant - 1 - i];
        }

        int pointsForDiags = pointsForDiags(diags1,diags2, figure);
        int pointsAgainstDiags = pointsAgainstDiags(diags1,diags2, oponentFigure());
        int pointsDiags = pointsForDiags + pointsAgainstDiags;

        for (int i = 0; i < board.length; i++) {

            int pointsRows = pointsForRows(board[i], figure) + pointsAgainstRows(board[i], oponentFigure());

            for (int j = 0; j < board[i].length; j++) {

                String[] col = {board[0][j], board[1][j], board[2][j]};
                int pointsCols = pointsForCols(col, figure) + pointsAgainstCols(col, oponentFigure());
                int pointsIfFree = checkIfFree(board[i][j]);
                scoredBoard[i][j] = pointsCols + pointsRows + pointsDiags + pointsIfFree;
            }
        }

        int highest = Integer.MIN_VALUE;
        Move move = new Move(-1, -1);
        for (int i = 0; i < scoredBoard.length; i++) {
            for (int j = 0; j < scoredBoard[i].length; j++) {
                if(scoredBoard[i][j] > highest) {
                    highest = scoredBoard[i][j];
                    move.setX(i);
                    move.setY(j);
                }
            }
        }
        return move;
    }

    private String oponentFigure() {

        if (figure.equals("X")) {
            return "O";
        }
        return "X";
    }

    public int checkIfFree(String slot) {

        return (slot.equals(" ")) ? 0 : -500;
    }

    public int pointsForRows(String[] row, String figure) {

        int quantity = checkRows(row, figure);
        return (quantity >= 2) ? 100 : quantity;
    }

    public int pointsAgainstRows(String[] row, String oponentFigure) {

        int quantity = checkRows(row, oponentFigure);
        return (quantity >= 2) ? 50 : quantity;
    }

    public int pointsForCols(String[] col, String figure) {

        int quantity = checkCols(col, figure);
        return (quantity >= 2) ? 100 : quantity;
    }

    public int pointsAgainstCols(String[] col, String oponentFigure) {

        int quantity = checkCols(col, oponentFigure);
        return (quantity >= 2) ? 50 : quantity;
    }

    public int pointsForDiags(String[] diag1, String[] diag2, String figure) {

        int quantity1 = checkDiag(diag1, figure);
        int total1 = (quantity1 >= 2) ? 100 : quantity1;
        int quantity2 = checkDiag(diag2, figure);
        int total2 = (quantity2 >= 2) ? 100 : quantity2;
        return total1 + total2;
    }

    public int pointsAgainstDiags(String[] diag1, String[] diag2, String oponentFigure) {

        int quantity1 = checkDiag(diag1, oponentFigure);
        int total1 = (quantity1 >= 2) ? 50 : quantity1;
        int quantity2 = checkDiag(diag2, oponentFigure);
        int total2 = (quantity2 >= 2) ? 50 : quantity2;
        return total1 + total2;
    }

    public int checkRows(String[] row, String figure) {

        int counter = 0;
        for (String slot : row) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
    }

    public int checkCols(String[] col, String figure) {

        int counter = 0;
        for (String slot : col) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
    }

    public int checkDiag(String[] diag, String figure) {

        int counter = 0;
        for (String slot : diag) {
            counter += (slot.equals(figure)) ? 1 : 0;
        }
        return counter;
    }
}
