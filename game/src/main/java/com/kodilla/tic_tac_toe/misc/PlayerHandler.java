package com.kodilla.tic_tac_toe.misc;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;

import static com.kodilla.tic_tac_toe.misc.MiscProcessor.*;

public class PlayerHandler {

    private Player[] playersList = new Player[2];
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
            if (yerOrNo(answer)) {
                GameLoader.loadGame();
            }
            else if (!yerOrNo(answer)){
                return;
            }
        } while (yesOrNoLoopCheck(answer));
    }

    public void askHowManyPlayers() {

        int answer;
        do {
            System.out.println("""
            
            Do you want to play game for 1 player or 2 players?
            Type '1' for player vs CPU or '2' for two players game.""");
            answer = scanner.nextInt();
            scanner.nextLine();
            if (oneOrTwo(answer)) {
                playersList[0] = new Player("CPU_easy", randomFigure(""));
                askForNames();
            }
            else if (!oneOrTwo(answer)){
                askForNames();
            }
        } while (oneOrTwoLoopCheck(answer));
    }

    public void askForNames() {

        if (playersList[0] == null) {
            String name;
            do {
                System.out.println("\nPlayer 1 please write desired nickname:");
                name = scanner.nextLine();
            } while (name.equals(""));
            playersList[0] = new Player(name, randomFigure(""));

            System.out.println("\n" + playersList[0].getName()
                + " you will play with "
                + playersList[0].getFigure());

            do {
                System.out.println("\nPlayer 2 please write desired nickname:");
                name = scanner.nextLine();
            } while (name.equals(""));
            playersList[1] = new Player(name, randomFigure(playersList[0].getFigure()));

            System.out.println("\n" + playersList[1].getName()
                + " you will play with "
                + playersList[1].getFigure());
        }
        else {
            String name;
            do {
                System.out.println("\nPlayer please write desired nickname:");
                name = scanner.nextLine();
            } while (name.equals(""));
            playersList[1] = new Player(name, randomFigure(playersList[0].getFigure()));

            System.out.println("\n" + playersList[1].getName()
                + " you will play with "
                + playersList[1].getFigure());
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
        } while (oneOrTwoLoopCheck(answer));

        if (answer == 1) {
            GameBoard gameBoard = new GameBoard(3);
            String[][] coordinatesMap = new String[3][3];
            for (int i = 0; i < coordinatesMap.length; i++) {
                for (int j = 0; j < coordinatesMap[i].length; j++) {
                    coordinatesMap[i][j] = String.valueOf(i) + j;
                }
            }
            gameBoard.setBoard(coordinatesMap);
            gameBoard.displayBoard();
            return 3;
        }
        GameBoard gameBoard = new GameBoard(10);
        String[][] coordinatesMap = new String[10][10];
        for (int i = 0; i < coordinatesMap.length; i++) {
            for (int j = 0; j < coordinatesMap[i].length; j++) {
                coordinatesMap[i][j] = String.valueOf(i) + j;
            }
        }
        gameBoard.setBoard(coordinatesMap);
        gameBoard.displayBoard();
        return 10;
    }

    public int askHowManyGames() {

        int answer;
        do {
            System.out.println("""

                How many games would you like to play?
                You can choose between 1 and 9 games.""");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (gameLimit(answer));
        return answer;
    }

    public void displayScore(int gameCount) {

        int p1TimesWon = playersList[0].getScore();
        int p2TimesWon = playersList[1].getScore();
        int draws = gameCount - p1TimesWon - p2TimesWon;

        System.out.println("For " + gameCount + " games played:\n" +
            playersList[0].getName() + " won " + p1TimesWon + " times, while " +
            playersList[1].getName() + " won " + p2TimesWon + " times.\n" +
            draws + " rounds resulted in draw.");
    }

    public void askForRestart() {

        System.out.println("""
        
        Do you want to play a new game?
        Type 'y' for YES or 'n' for NO.""");
        String answer = scanner.nextLine();
        if (yerOrNo(answer)) {
            GameEngine gameEngine = new GameEngine();
            gameEngine.playGame();
        }
    }

    public int askForQuit(int roundCounter, int maxRounds) {

        System.out.println("""
        
        Do you want to quit?
        Type 'y' for YES or 'n' for NO.""");
        String answer = scanner.nextLine();
        if (yerOrNo(answer)) {
            GameSaver.saveGame();
            return maxRounds;
        }
        return roundCounter;
    }

    public void displayRoundNumber(int round, int gameCount) {

        System.out.println("\nRound " + round + " / Game " + gameCount);
    }

    //=========== SETTERS & GETTERS


    public Player[] getPlayersList() {
        return playersList;
    }

    public void setPlayersList(Player[] playersList) {
        this.playersList = playersList;
    }
}
