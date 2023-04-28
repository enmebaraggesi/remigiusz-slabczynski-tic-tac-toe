package com.kodilla.tic_tac_toe.communication;

import java.util.*;

public class PlayerHandler {

    private String player1;
    private String player2;
    private Map<String, String> figures = Map.of("P1", "", "P2", "");
    private Scanner scanner = new Scanner(System.in);

    //todo whole player handler
    public void explainRules() {

        System.out.println("""
            Hi. This is a game of Tic Tac Toe.
            You will play against your opponent or CPU by placing X or O figures on a 3x3 board.
            First player to place orthogonal or diagonal lane of 3 same figures WINS.
            Each turn you MUST take a move, by typing coordinates of desired move.
            Here are coordinates map of game board:
            |00|01|02|
            |10|11|12|
            |20|21|22|
            
            Have fun!
            """);
    }

    public void askForGameLoad() {

        //TODO before asking app will search for existing save file

        String answer = "";
        while (!(answer.equals("y") || answer.equals("n"))) {
            System.out.println("""
                        
                Do you want to continue previously saved game? y/n
                        
                """);
            answer = scanner.nextLine();
            if ("y".equals(scanner.nextLine())) {
                //TODO load game
            } else {
                return;
            }
        }
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
