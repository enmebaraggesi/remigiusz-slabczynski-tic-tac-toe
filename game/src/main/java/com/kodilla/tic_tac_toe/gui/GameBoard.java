package com.kodilla.tic_tac_toe.gui;

import java.util.Arrays;

public class GameBoard {

    private String[][] board;

    public GameBoard(int gameVariant) {
        // Creates empty board of various dimensions
        board = new String[gameVariant][gameVariant];
        for (String[] strings : board) {
            Arrays.fill(strings, " ");
        }
    }

    // Displays game board
    public void displayBoard(String[][] board) {

        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : board) {
            stringBuilder.append("|");
            for (int i = 0; i < strings.length; i++) {
                stringBuilder.append(strings[i]).append("|");
                if (i == strings.length - 1) {
                    stringBuilder.append("\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }

    // Displays game board filled with coordinates for every slot
    public void displayCoordinates(int variant) {

        String[][] sampleBoard = new String[variant][variant];
        for (int i = 0; i < variant; i++) {
            for (int j = 0; j < variant; j++) {
                sampleBoard[i][j] = String.valueOf(i) + j;
            }
        }
        displayBoard(sampleBoard);
    }

    // ---------------- GETTERS & SETTERS ----------------

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}
