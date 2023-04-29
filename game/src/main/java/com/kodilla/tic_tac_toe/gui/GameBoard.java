package com.kodilla.tic_tac_toe.gui;

import java.util.*;

public class GameBoard {

    public Map<String, String> board = new HashMap<>(Map.of(
        "00", " ", "01", " ", "02", " ",
        "10", " ", "11", " ", "12", " ",
        "20", " ", "21", " ", "22", " "
        ));

    public Map<String, String> getBoard() {

        return board;
    }

    public void setBoard(Map<String, String> board) {

        this.board = board;
    }
}
