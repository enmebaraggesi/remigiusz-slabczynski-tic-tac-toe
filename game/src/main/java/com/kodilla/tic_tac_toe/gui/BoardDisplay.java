package com.kodilla.tic_tac_toe.gui;

import java.util.Map;

public class BoardDisplay {

    public void displayBoard(Map<String, String> board) {

        String zero0 = board.get("00");
        String zero1 = board.get("01");
        String zero2 = board.get("02");
        String one0 = board.get("10");
        String one1 = board.get("11");
        String one2 = board.get("12");
        String two0 = board.get("20");
        String two1 = board.get("21");
        String two2 = board.get("22");

        System.out.println(
            "|" + zero0 + "|" + zero1 + "|" + zero2 + "|\n" +
            "|" + one0 + "|" + one1 + "|" + one2 + "|\n" +
            "|" + two0 + "|" + two1 + "|" + two2 + "|\n"
        );
    }
}
