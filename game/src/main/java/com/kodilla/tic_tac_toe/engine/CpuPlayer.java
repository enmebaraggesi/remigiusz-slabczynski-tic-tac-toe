package com.kodilla.tic_tac_toe.engine;

import java.util.*;

public class CpuPlayer {

    public int[] makeCPUMove(String[][] actualBoard, String cpuFigure, String oponentFigure) {

        //todo decision making for best suited move
        winMove(actualBoard, cpuFigure);
        blockMove(actualBoard, oponentFigure);

        return null;
    }

    private static int[] winMove(String[][] board, String figure) {

        return checkIfWinAhead(board, figure);
    }

    private static int[] blockMove(String[][] board, String oponentFigure) {

        return checkIfWinAhead(board, oponentFigure);
    }








    //===================== winning condition

    private static int[] checkIfWinAhead(String[][] board, String figure) {

        int[] move = new int[2];

        // Szukanie wierszy z dwoma symbolami gracza i pustym miejscem
        for (int i = 0; i < board.length; i++) {
            int figureSlots = 0;
            int emptySpaces = 0;

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(figure)) {
                    figureSlots++;
                } else if (board[i][j].equals("")) {
                    emptySpaces++;
                    move[0] = i;
                    move[1] = j;
                }
            }

            if (figureSlots == 2 && emptySpaces == 1) {
                return move;
            }
        }

        // Szukanie kolumn z dwoma symbolami gracza i pustym miejscem
        for (int i = 0; i < board.length; i++) {
            int figureSlots = 0;
            int emptySpaces = 0;

            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i].equals(figure)) {
                    figureSlots++;
                } else if (board[j][i].equals("")) {
                    emptySpaces++;
                    move[0] = j;
                    move[1] = i;
                }
            }

            if (figureSlots == 2 && emptySpaces == 1) {
                return move;
            }
        }

        // Szukanie przekątnej z dwoma symbolami gracza i pustym miejscem
        int figureSlots = 0;
        int emptySpaces = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i][i].equals(figure)) {
                figureSlots++;
            } else if (board[i][i].equals("")) {
                emptySpaces++;
                move[0] = i;
                move[1] = i;
            }
        }

        if (figureSlots == 2 && emptySpaces == 1) {
            return move;
        }

        figureSlots = 0;
        emptySpaces = 0;
        int x = board.length - 1;

        for (int i = 0; i < board.length; i++) {
            if (board[i][x - i].equals(figure)) {
                figureSlots++;
            } else if (board[i][x - i].equals("")) {
                emptySpaces++;
                move[0] = i;
                move[1] = x - i;
            }
        }

        if (figureSlots == 2 && emptySpaces == 1) {
            return move;
        }

        return null;
    }
}