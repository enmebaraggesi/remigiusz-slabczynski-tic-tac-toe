package com.kodilla.tic_tac_toe.communication;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;

public class PlayerHandler {

    private String player1Name = "";
    private String player2Name = "";
    private Map<String, String> players = new HashMap<>(Map.of("X", "", "O", ""));
    private AnswerProcessor answerProcessor = new AnswerProcessor();
    private Scanner scanner = new Scanner(System.in);

    public void explainRules() {

        System.out.println("""
            Hi. This is a game of Tic Tac Toe.
            You will play against your opponent by placing X or O figures on a 3x3 board.
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

        String answer;
        do {
            System.out.println("\nDo you want to continue previously saved game? y/n");
            answer = scanner.nextLine();
            if (answerProcessor.yerOrNo(answer)) {
                GameLoader.loadGame();
            } else if (!answerProcessor.yerOrNo(answer)){
                return;
            }
        } while (answerProcessor.yesOrNoLoopCheck(answer));
    }

    public void askHowManyPlayers() {

        Integer answer;
        do {
            System.out.println("\nDo you want to play game for 1 player or 2 players? 1/2");
            answer = scanner.nextInt();
            scanner.nextLine();
            if (answerProcessor.oneOrTwo(answer)) {
                player2Name = "CPU";
                players.put("O", player2Name);
                askForNames();
            } else if (!answerProcessor.oneOrTwo(answer)){
                askForNames();
            }
        } while (answerProcessor.oneOrTwoLoopCheck(answer));
    }

    public void askForNames() {

        if (!players.get("O").equals("CPU")) {
            System.out.println("\nPlayer X please write desired nickname:");
            player1Name = scanner.nextLine();
            players.put("X", player1Name);
            System.out.println("\nPlayer O please write desired nickname:");
            player2Name = scanner.nextLine();
            players.put("O", player2Name);
        } else {
            System.out.println("\nPlayer X please write desired nickname:");
            player1Name = scanner.nextLine();
            players.put("X", player1Name);
        }
    }

    public int askHowManyGames() {

        int answer;
        do {
            System.out.println("\nHow many games would you like to play? 1-9");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (!(answer > 0 && answer < 10));
        return answer;
    }

    public String askForMove(String player, GameBoard gameBoard) {

        String answer;
        do {
            System.out.println(player + ", make your move by writing coordinates:");
            answer = scanner.nextLine();
        } while (!gameBoard.getBoard().get(answer).equals(" "));
        return answer;
    }

    public boolean askForDecision() {

        String answer;
        do {
            System.out.println("\nAre you sure? y/n");
            answer = scanner.nextLine();
            if (answerProcessor.yerOrNo(answer)) {
                return true;
            } else if (!answerProcessor.yerOrNo(answer)){
                return false;
            }
        } while (answerProcessor.yesOrNoLoopCheck(answer));
        return false;
    }

    public void displayScore(int gameCount, List<String> winnersTab) {

        long p1TimesWon = winnersTab.stream()
            .filter(name -> name.equals(player1Name))
            .count();
        long p2TimesWon = winnersTab.stream()
            .filter(name -> name.equals(player2Name))
            .count();
        long draws = gameCount - (p1TimesWon + p2TimesWon);

        System.out.println("For " + gameCount + " games played:\n" +
            player1Name + " won " + p1TimesWon + " times, while " +
            player2Name + " won " + p2TimesWon + " times.\n" +
            draws + " rounds resulted in draw.");
    }

    public void askForRestart() {

        System.out.println("\nDo you want to play a new game? y/n");
        String answer = scanner.nextLine();
        if (answerProcessor.yerOrNo(answer)) {
            boolean restart = askForDecision();
            if (restart) {
                GameEngine gameEngine = new GameEngine();
                gameEngine.playGame();
            }
        }
    }

    public int askForQuit(int roundCounter, int maxRounds) {

        System.out.println("\nDo you want to quit? y/n");
        String answer = scanner.nextLine();
        if (answerProcessor.yerOrNo(answer)) {
            boolean quit = askForDecision();
            if (quit) {
                GameSaver.saveGame();
                return maxRounds;
            }
        }
        return roundCounter;
    }

    public void displayRoundNumber(int round, int gameCount) {

        System.out.println("\nRound " + round + " of game number " + gameCount);
    }

    //=========== SETTERS & GETTERS

    public Map<String, String> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, String> players) {
        this.players = players;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }
}
