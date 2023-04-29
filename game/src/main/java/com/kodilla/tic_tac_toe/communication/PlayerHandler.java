package com.kodilla.tic_tac_toe.communication;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.gui.GameBoard;

public class PlayerHandler {

    private String player1;
    private String player2;
    private Map<String, String> figures = Map.of("P1", "", "P2", "");
    private Scanner scanner = new Scanner(System.in);

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
        List<String> yesNo = List.of("y", "n");
        do {
            System.out.println("""
                        
                Do you want to continue previously saved game? y/n
                """);
            answer = scanner.nextLine().toLowerCase();
            if (yesNo.get(0).equals(answer)) {
                //TODO load game
            } else if (yesNo.get(1).equals(answer)){
                return;
            }
        } while (!yesNo.contains(answer));
    }

    public void askHowManyPlayers() {

        Integer answer = 0;
        List<Integer> oneTwo = List.of(1, 2);
        do {
            System.out.println("""

                Do you want to play game for 1 player or 2 players? 1/2
                """);
            answer = scanner.nextInt();
            if (oneTwo.get(0).equals(answer)) {
                player2 = "CPU";
                askForNames();
            } else if (oneTwo.get(1).equals(answer)){
                askForNames();
            }
        } while (!oneTwo.contains(answer));
    }

    public void askForNames() {

        if (player1 == null) {
            System.out.println("""
                    
                    Player 1 please write desired nickname:
                    """);
            player1 = scanner.nextLine();
        }

        if (player2 == null) {
            System.out.println("""
                    
                    Player 2 please write desired nickname:
                    """);
            player2 = scanner.nextLine();
        }
    }

    public int askHowManyGames() {

        Integer answer = 0;
        do {
            System.out.println("""
                
                How many games would you like to play? 
                You can play from 1 to 9 games.
                """);
            answer = scanner.nextInt();
        } while (!(answer > 0 && answer < 10));
        return answer;
    }

    public void askForFigurePreference() {

        String answer = "";
        List<String> xOrY = List.of("X", "O");
        do {
            System.out.println("""
                    
                    Player please choose your figure: X or Y?
                    """);
            answer = scanner.nextLine().toUpperCase();
        } while (!xOrY.contains(answer));

        //TODO work over giving each player desired figures
    }

    public String askForMove(GameBoard gameBoard) {

        String answer = "";
        do {
            System.out.println("""
                    
                    Player, make your move, by writing coordinates:
                    """);
            answer = scanner.nextLine();
        } while (gameBoard.getBoard().containsValue(answer));
        return answer;
    }

    public boolean askForDecision() {

        String answer = "";
        List<String> yesNo = List.of("y", "n");
        do {
            System.out.println("""
                        
                Are you sure? y/n
                """);
            answer = scanner.nextLine().toLowerCase();
            if (yesNo.get(0).equals(answer)) {
                return true;
            } else if (yesNo.get(1).equals(answer)){
                return false;
            }
        } while (!yesNo.contains(answer));
        return false;
    }

    public void displayScore(List<String> score, int roundCount) {

        int p1TimesWon = 0;
        int p2TimesWon = 0;
        int draws = 0;
        for (String string : score) {
            if (string.equals("P1")) {
                p1TimesWon++;
            } else if (string.equals("P2")) {
                p2TimesWon++;
            } else {
                draws++;
            }
        }
        System.out.println("For " + roundCount + " rounds game:\n" +
                        player1 + " won " + p1TimesWon + " times, while " +
                        player2 + " won " + p2TimesWon + " times.\n" + 
                        draws + " rounds resulted in draw.");
    }

    public void askForRestart() {

        System.out.println("Do you want to play a new game? y/n");
        answer = scanner.nextLine().toLowerCase();
        if (answer.equals("y")) {
            boolean restart = askForDecision();
            if (restart) {
                GameEngine gameEngine = new GameEngine();
                gameEngine.playGame();
            }
        }
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
