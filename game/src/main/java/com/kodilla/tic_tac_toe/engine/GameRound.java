package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.misc.*;

public class GameRound {

    // Playing round of game. One round consists of number of players turns until winner or draw is designated
    public void playRound(PlayerHandler playerHandler, GameStorage gameStorage) {

        GameTurn gameTurn = new GameTurn();

        // Randomly changed order of play every new game round
        playerHandler.playerRandomizer(gameStorage.getPlayersList());

        // Turns are played until there is a win or draw
        while (true) {
            gameStorage.raiseRoundNumber();

            // Information about current state of play is displayed
            playerHandler.displayRoundNumber(gameStorage.getTurnNumber(), gameStorage.getRoundCount());

            // Two times (once for every player) repeated turn play
            int winner;
            for (int i = 0; i < 2; i++) {
                winner = gameTurn.playTurn(gameStorage, i);

                switch (winner) {
                    case -2 -> playerHandler.askForRestart();
                    case -1 -> playerHandler.askForQuit(gameStorage);
                    case 1 -> {
                        return;
                    }
                }
            }
        }
    }
}
