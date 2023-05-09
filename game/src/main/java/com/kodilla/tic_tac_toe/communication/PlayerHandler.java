package com.kodilla.tic_tac_toe.communication;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.game_saver.*;

public class PlayerHandler {

    private String player1Name = "";
    private String player2Name = "";
    private Map<String, String> players = new HashMap<>(Map.of("X", "", "O", ""));
    private AnswerProcessor answerProcessor = new AnswerProcessor();
    private Scanner scanner = new Scanner(System.in);

    public void explainRules() {

        System.out.println("""
            Hi. This is a game of Tic Tac Toe.
            You will play against your opponent by placing X or O figures on a board.
            You can choose between playing on a 3x3 or 10x10 board.
            In 3x3 game you win by having 3 figures in a line.
            While in 10x10 game you have to put 5 figures in a line to win.
            Each turn you MUST take a move, by typing coordinates of desired move.""");
    }

    public void askForGameLoad() {

        //TODO before asking app will search for existing save file

        String answer;
        do {
            System.out.println("""
                
                Do you want to continue previously saved game?
                Type 'y' for YES or 'n' for NO.""");
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
            System.out.println("""
            
            Do you want to play game for 1 player or 2 players?
            Type '1' for player vs CPU or '2' for two players game.""");
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

    public int askForGameVariant() {

        int answer;
        do {
            System.out.println("""

                Which variant of game you want to play?
                Type '1' for 3x3 board or '2' for 10x10 board.""");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (!(answer == 1 || answer == 2));

        if (answer == 1) {
            System.out.println("""
                
                Here are coordinates map of game board:
            
                | 00 | 01 | 02 |
            
                | 10 | 11 | 12 |
            
                | 20 | 21 | 22 |
            
                Have fun!
                """);
            return 3;
        }
        System.out.println("""
            
            Here are coordinates map of game board:
            
            | 00 | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 |
            
            | 10 | 11 | 12 | 13 | 14 | 15 | 16 | 17 | 18 | 19 |
            
            | 20 | 21 | 22 | 23 | 24 | 25 | 26 | 27 | 28 | 29 |
            
            | 30 | 31 | 32 | 33 | 34 | 35 | 36 | 37 | 38 | 39 |
            
            | 40 | 41 | 42 | 43 | 44 | 45 | 46 | 47 | 48 | 49 |
            
            | 50 | 51 | 52 | 53 | 54 | 55 | 56 | 57 | 58 | 59 |
            
            | 60 | 61 | 62 | 63 | 64 | 65 | 66 | 67 | 68 | 69 |
            
            | 70 | 71 | 72 | 73 | 74 | 75 | 76 | 77 | 78 | 79 |
            
            | 80 | 81 | 82 | 83 | 84 | 85 | 86 | 87 | 88 | 89 |
            
            | 90 | 91 | 92 | 93 | 94 | 95 | 96 | 97 | 98 | 99 |
            
            Have fun!
            """);
        return 5;
    }

    public int askHowManyGames() {

        int answer;
        do {
            System.out.println("""

                How many games would you like to play?
                You can choose between 1 and 9 games.""");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (!(answer > 0 && answer < 10));
        return answer;
    }

    public int[] askForMove(String player, String[][] board) {

        int[] answer = new int[2];

        //TODO write exception properly
        try {
            do {
                System.out.println(player + ", make your move by writing coordinates:");
                String preprocessedAnswer = scanner.nextLine();
                String[] answerArray = preprocessedAnswer.split("");
                for (int i = 0; i < preprocessedAnswer.length(); i++) {
                    answer[i] = Integer.parseInt(answerArray[i]);
                }
            } while (!board[answer[0]][answer[1]].equals(" "));
        } catch (IndexOutOfBoundsException e) {
            throw e;
        }
        return answer;
    }

    public void displayScore(int gameCount, List<String> winnersTab) {

        long p1TimesWon = winnersTab.stream()
            .filter(name -> name.equals("X"))
            .count();
        long p2TimesWon = winnersTab.stream()
            .filter(name -> name.equals("O"))
            .count();
        long draws = winnersTab.stream()
            .filter(name -> name.equals("DRAW"))
            .count();

        System.out.println("For " + gameCount + " games played:\n" +
            player1Name + " won " + p1TimesWon + " times, while " +
            player2Name + " won " + p2TimesWon + " times.\n" +
            draws + " rounds resulted in draw.");
    }

    public void askForRestart() {

        System.out.println("""
        
        Do you want to play a new game?
        Type 'y' for YES or 'n' for NO.""");
        String answer = scanner.nextLine();
        if (answerProcessor.yerOrNo(answer)) {
            GameEngine gameEngine = new GameEngine();
            gameEngine.playGame();
        }
    }

    public int askForQuit(int roundCounter, int maxRounds) {

        System.out.println("""
        
        Do you want to quit?
        Type 'y' for YES or 'n' for NO.""");
        String answer = scanner.nextLine();
        if (answerProcessor.yerOrNo(answer)) {
            GameSaver.saveGame();
            return maxRounds;
        }
        return roundCounter;
    }

    public void displayRoundNumber(int round, int gameCount) {

        System.out.println("\nRound " + round + " / Game " + gameCount);
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
