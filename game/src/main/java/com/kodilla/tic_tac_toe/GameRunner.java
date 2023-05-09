package com.kodilla.tic_tac_toe;

import com.kodilla.tic_tac_toe.engine.GameEngine;

public class GameRunner {

    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.playGame();
    }
}
