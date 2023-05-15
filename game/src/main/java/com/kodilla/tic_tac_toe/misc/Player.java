package com.kodilla.tic_tac_toe.misc;

import java.util.Scanner;

public class Player implements PlayersMoving {

    private String name;
    private String figure;
    private int score = 0;

    public Player(String name, String figure) {
        this.name = name;
        this.figure = figure;
    }

    @Override
    public Move makeAMove(String[][] board) {

        if (name.contains("CPU")) {
            CpuPlayer cpuPlayer = new CpuPlayer(name, figure);
            return cpuPlayer.makeAMove(board);
        }

        //TODO write exception properly
        Scanner scanner = new Scanner(System.in);
        Move move;
        do {
            System.out.println(name + ", make your move by writing coordinates:");
            String preprocessedAnswer = scanner.nextLine();
            String[] answerArray = preprocessedAnswer.split("");
            move = new Move(Integer.parseInt(answerArray[0]), Integer.parseInt(answerArray[1]));
        } while (!board[move.getX()][move.getY()].equals(" "));
        return move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void updateScore() {
        this.score++;
    }
}
