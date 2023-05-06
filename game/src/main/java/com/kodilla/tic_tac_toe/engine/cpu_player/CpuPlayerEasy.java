package com.kodilla.tic_tac_toe.engine.cpu_player;

import java.util.*;

public class CpuPlayerEasy {

    public int[] makeAMove(String[][] board) {

        Random random = new Random();
        List<int[]> listOfMoves = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" ")) {
                    counter++;
                    int[] move = new int[2];
                    move[0] = i;
                    move[1] = j;
                    listOfMoves.add(move);
                }
            }
        }
        return listOfMoves.get(random.nextInt(counter));
    }
}