package com.kodilla.tic_tac_toe.players;

import com.kodilla.tic_tac_toe.misc.*;

import java.util.*;

public class CpuPlayerEasy extends Player {

    public CpuPlayerEasy(String name, String figure) {
        super(name, figure);
    }

    @Override
    public Move makeAMove(String[][] board) {

        System.out.println("\nCPU made its move");
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

    // ---------------- GETTERS & SETTERS ----------------

    @Override
    public int getLevel() {
        return 1;
    }
}
