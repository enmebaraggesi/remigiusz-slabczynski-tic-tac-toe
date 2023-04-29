package com.kodilla.tic_tac_toe.communication;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;

public class PlayerHandler {

    private Map<String, Map<String, Integer>> players = new HashMap<>(Map.of("X", new HashMap<>(),
        "O", new HashMap<>()));
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
                players.replace("O", Map.of("CPU", 0));
                askForNames();
            } else if (!answerProcessor.oneOrTwo(answer)){
                askForNames();
            }
        } while (answerProcessor.oneOrTwoLoopCheck(answer));
    }

    public void askForNames() {

        if (!players.get("O").containsKey("CPU")) {
            System.out.println("\nPlayer X please write desired nickname:");
            String player1name = scanner.nextLine();
            players.replace("X", Map.of(player1name, 0));
            System.out.println("\nPlayer O please write desired nickname:");
            String player2name = scanner.nextLine();
            players.replace("O", Map.of(player2name, 0));
        } else {
            System.out.println("\nPlayer X please write desired nickname:");
            String player1name = scanner.nextLine();
            players.replace("X", Map.of(player1name, 0));
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
        } while (gameBoard.getBoard().containsValue(answer));
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

    public void displayScore(int gameCount) {

        int p1TimesWon = 0;
        int p2TimesWon = 0;
        int draws = 0;
        String player1 = null;
        String player2 = null;

        for (Map.Entry<String, Map<String, Integer>> entry : players.entrySet()) {
            if (entry.getKey().equals("X")) {
                Map<String, Integer> p1Stats = entry.getValue();
                player1 = p1Stats.keySet().toString();
                p1TimesWon = p1Stats.get(player1);
            } else {
                Map<String, Integer> p2Stats = entry.getValue();
                player2 = p2Stats.keySet().toString();
                p1TimesWon = p2Stats.get(player2);
            }
        }

        System.out.println("For " + gameCount + " rounds game:\n" +
            player1 + " won " + p1TimesWon + " times, while " +
            player2 + " won " + p2TimesWon + " times.\n" +
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


    public Map<String, Map<String, Integer>> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Map<String, Integer>> players) {
        this.players = players;
    }
}
