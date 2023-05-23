package com.kodilla.tic_tac_toe.players;

import com.kodilla.tic_tac_toe.misc.Move;

public abstract class Player {

    protected String name;
    protected String figure;
    protected int score = 0;

    public Player(String name, String figure) {
        this.name = name;
        this.figure = figure;
    }

    public Move makeAMove(String[][] board) {
        return null;
    }

    public int getLevel() {
        return -1;
    }

    // ------------------- GETTERS & SETTERS -------------------

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
