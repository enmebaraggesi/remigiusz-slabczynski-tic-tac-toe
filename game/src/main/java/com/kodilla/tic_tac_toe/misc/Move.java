package com.kodilla.tic_tac_toe.misc;

// Used to keep player move
public class Move {

    private int x;
    private int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ---------------- GETTERS & SETTERS ----------------

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
