package com.kodilla.tic_tac_toe.gui;

import java.util.Arrays;

public class GameBoard {

    public String[][] board = new String[3][3];

    public GameBoard() {
        for (String[] strings : board) {
            Arrays.fill(strings, " ");
        }
    }

    public void displayBoard() {

        for (String[] strings : board) {
            System.out.println("|" + strings[0] + "|" + strings[1] + "|" + strings[2] + "|");
        }
    }

    public String[][] getBoard() {

        return board;
    }

    public void setBoard(String[][] board) {

        this.board = board;
    }
}
