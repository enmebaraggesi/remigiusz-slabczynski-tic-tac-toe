package com.kodilla.tic_tac_toe.communication;

import java.util.*;

public class PlayerHandler {

    private String player1;
    private String player2;
    private Map<String, String> figures = Map.of("P1", "", "P2", "");
    private Scanner scanner = new Scanner(System.in);

    //todo whole player handler
    public void explainRules() {

        //rules to write
    }

    public void askForGameLoad() {

        //ask if player want to save game and quit
    }

    public void askHowManyPlayers() {

        //ask if it is 2 player game or with cpu
    }

    public void askForNames() {

        //ask each player for names
        //if there is only one player cpu will handle second one
    }

    public void askHowManyGames() {

        //ask how many games players want to play
    }

    public void askForFigurePreference() {

        //ask first player for his figure
    }

    public void askForMove() {

        //ask player which move he will take
    }

    public void askForDecision() {

        //ask for any offside decisions
    }

    public void displayScore() {

        //display final scoring
    }

    public String askForRestart() {

        return "y";
    }

    public String askForQuit() {

        return "y";
    }

    //=========== SETTERS & GETTERS

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public Map<String, String> getFigures() {
        return figures;
    }

    public void setFigures(Map<String, String> figures) {
        this.figures = figures;
    }
}
