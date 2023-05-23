package com.kodilla.tic_tac_toe.misc;

import com.kodilla.tic_tac_toe.gui.GameBoard;
import com.kodilla.tic_tac_toe.players.Player;

// Keeps all information needed in game in one place
// What becomes especially handy during save and load of game
public class GameStorage {

    // --------------------- PLAYERS ---------------------
    private Player[] playersList = new Player[2];

    // ---------------------- BOARD ----------------------
    GameBoard gameBoard;

    // ------------------- GAME ENGINE -------------------
    private int roundCount = 0;
    private int maxGames;
    private int gameVariant;

    // ------------------- GAME ROUND --------------------
    private int turnNumber = 0;
    private int movesCounter = 0;

    // ---------------- GETTERS & SETTERS ----------------
    public Player[] getPlayersList() {
        return playersList;
    }

    public void setPlayersList(Player[] playersList) {
        this.playersList = playersList;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void raiseRoundCount() {
        roundCount++;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getMaxGames() {
        return maxGames;
    }

    public void setMaxGames(int maxGames) {
        this.maxGames = maxGames;
    }

    public int getGameVariant() {
        return gameVariant;
    }

    public void setGameVariant(int gameVariant) {
        this.gameVariant = gameVariant;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void raiseRoundNumber() {
        turnNumber++;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getMovesCounter() {
        return movesCounter;
    }

    public void raiseMovesCounter() {
        movesCounter++;
    }

    public void setMovesCounter(int movesCounter) {
        this.movesCounter = movesCounter;
    }
}
