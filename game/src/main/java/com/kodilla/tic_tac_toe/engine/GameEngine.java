package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.misc.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import static com.kodilla.tic_tac_toe.misc.file_operators.DirectoryCreator.createSaveDirectory;
import static com.kodilla.tic_tac_toe.misc.file_operators.FilesSearcher.lookForFile;

public class GameEngine {

    private final GameStorage GAME_STORAGE;

    public GameEngine() {
        this.GAME_STORAGE = new GameStorage();
    }

    // Core method to run game in main class GameRunner
    public void playGame() {

        // Creates one if there is no 'save' directory already
        createSaveDirectory();
        PlayerHandler playerHandler = new PlayerHandler();
        collectGameDecisions(playerHandler);

        // Prepares a new board when there is none from previously saved game
        if (GAME_STORAGE.getGameBoard() == null) {
            GAME_STORAGE.setGameBoard(new GameBoard(GAME_STORAGE.getGameVariant()));
        }

        GameRound gameRound = new GameRound();

        // Core loop inside which turns are made and score counted
        // Repeats until number of desired rounds is reached
        while ((GAME_STORAGE.getRoundCount() <= GAME_STORAGE.getMaxGames())) {

            gameRound.playRound(playerHandler, GAME_STORAGE);
            GAME_STORAGE.raiseRoundCount();
            playerHandler.displayScore(GAME_STORAGE.getPlayersList(), GAME_STORAGE.getRoundCount());

            // Counters and board reset after every round played
            GAME_STORAGE.setTurnNumber(0);
            GAME_STORAGE.setMovesCounter(0);
            GAME_STORAGE.setGameBoard(new GameBoard(GAME_STORAGE.getGameVariant()));
        }

        // Saves final score
        HistoryKeeper historyKeeper = new HistoryKeeper();
        historyKeeper.keepScoreBoard(GAME_STORAGE.getPlayersList(), GAME_STORAGE.getRoundCount());
    }

    // Communicates with player to gather information needed to start a game
    private void collectGameDecisions(PlayerHandler playerHandler) {

        playerHandler.explainRules();
        // If there is saved scoreboard program will display last 10 scores
        if (lookForFile("save\\scoreboard.txt")) {
            HistoryKeeper historyKeeper = new HistoryKeeper();
            historyKeeper.displayScoreBoard();
        }
        // If player wish to load saved game, here game will be loaded
        if(playerHandler.askForGameLoad()) {
            GameLoader.loadGame(GAME_STORAGE);
            return;
        }
        GAME_STORAGE.setGameVariant(playerHandler.askForGameVariant());
        playerHandler.askHowManyPlayers(GAME_STORAGE.getPlayersList());
        GAME_STORAGE.setMaxGames(playerHandler.askHowManyGames());
    }
}
