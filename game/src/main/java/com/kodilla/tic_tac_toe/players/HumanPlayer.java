package com.kodilla.tic_tac_toe.players;

import com.kodilla.tic_tac_toe.misc.*;

import java.util.Scanner;

import static com.kodilla.tic_tac_toe.misc.MiscProcessor.exceptionalAnswerCheck;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, String figure) {
        super(name, figure);
    }

    @Override
    public Move makeAMove(String[][] board) {

        Scanner scanner = new Scanner(System.in);
        Move move;

        do {
            System.out.println(name + ", make your move by writing coordinates:");
            String preprocessedAnswer = scanner.nextLine();
            Move exceptionalAnswer = exceptionalAnswerCheck(preprocessedAnswer);
            if (exceptionalAnswer != null) {
                return exceptionalAnswer;
            }
            String[] answerArray = preprocessedAnswer.split("");
            move = new Move(Integer.parseInt(answerArray[0]), Integer.parseInt(answerArray[1]));
        } while (!board[move.getX()][move.getY()].equals(" "));
        return move;
    }

    // ---------------- GETTERS & SETTERS ----------------

    @Override
    public int getLevel() {
        return 0;
    }
}
