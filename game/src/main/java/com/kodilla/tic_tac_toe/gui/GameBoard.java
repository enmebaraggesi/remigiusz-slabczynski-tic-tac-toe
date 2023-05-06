package com.kodilla.tic_tac_toe.gui;

import java.util.Arrays;

public class GameBoard {

    public String[][] board;

    public GameBoard(int gameVariant) {

        this.board = new String[gameVariant][gameVariant];
        for (String[] strings : board) {
            Arrays.fill(strings, " ");
        }
    }

    public void displayBoard() {

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

    public String[][] getBoard() {

        return board;
    }

    public void setBoard(String[][] board) {

        this.board = board;
    }
}
