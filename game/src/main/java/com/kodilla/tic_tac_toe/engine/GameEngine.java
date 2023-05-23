package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.misc.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import static com.kodilla.tic_tac_toe.misc.file_operators.DirectoryCreator.createSaveDirectory;
import static com.kodilla.tic_tac_toe.misc.file_operators.FilesSearcher.lookForFile;

public class GameEngine {

    private GameStorage gameStorage;

    public GameEngine() {
        this.gameStorage = new GameStorage();
    }

    // Core method to run game in main class GameRunner
    public void playGame() {

        // Creates one if there is no 'save' directory already
        createSaveDirectory();
        PlayerHandler playerHandler = new PlayerHandler();
        collectGameDecisions(playerHandler);

        // Prepares a new board when there is none from previously saved game
        if (gameStorage.getGameBoard() == null) {
            gameStorage.setGameBoard(new GameBoard(gameStorage.getGameVariant()));
        }

        GameRound gameRound = new GameRound();

        // Core loop inside which turns are made and score counted
        // Repeats until number of desired rounds is reached
        while (!(gameStorage.getRoundCount() == gameStorage.getMaxGames())) {

            gameStorage.raiseRoundCount();
            gameRound.playRound(playerHandler, gameStorage);
            playerHandler.displayScore(gameStorage.getPlayersList(), gameStorage.getRoundCount());

            // Counters and board reset after every round played
            gameStorage.setTurnNumber(0);
            gameStorage.setMovesCounter(0);
            gameStorage.setGameBoard(new GameBoard(gameStorage.getGameVariant()));
        }

        // Saves final score
        HistoryKeeper historyKeeper = new HistoryKeeper();
        historyKeeper.keepScoreBoard(gameStorage.getPlayersList(), gameStorage.getRoundCount());
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
            GameLoader.loadGame(gameStorage);
            return;
        }
        gameStorage.setGameVariant(playerHandler.askForGameVariant());
        playerHandler.askHowManyPlayers(gameStorage.getPlayersList());
        gameStorage.setMaxGames(playerHandler.askHowManyGames());
    }
}
