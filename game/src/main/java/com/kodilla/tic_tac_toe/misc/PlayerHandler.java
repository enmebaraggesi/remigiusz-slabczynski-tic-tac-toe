package com.kodilla.tic_tac_toe.misc;

import java.util.*;

import com.kodilla.tic_tac_toe.engine.GameEngine;
import com.kodilla.tic_tac_toe.engine.GameStorage;
import com.kodilla.tic_tac_toe.game_saver.*;
import com.kodilla.tic_tac_toe.gui.GameBoard;
import com.kodilla.tic_tac_toe.players.*;

import static com.kodilla.tic_tac_toe.misc.file_operators.FilesSearcher.lookForFile;
import static com.kodilla.tic_tac_toe.misc.MiscProcessor.*;

public class PlayerHandler {

    private Scanner scanner;

    public PlayerHandler() {
        this.scanner = new Scanner(System.in);
    }

    // Explanation how game works
    public void explainRules() {

        System.out.println("""
            Hi. This is my attempt of Tic Tac Toe game.
            You can choose between playing on a 3x3 or 10x10 board.
            You can play against other player or CPU of two levels.
            Each turn you will make a move, by typing coordinates of desired move.
            If you want to restart or quit game just type 'n' for restart or 'q' for quit instead of making move.
            Your game is saved while quitting.
            Let's go!""");
    }

    // Question to load game triggers only if save files exist
    // Returned boolean flag is interpreted in GameEngine.collectGameDecisions()
    public boolean askForGameLoad() {

        if (lookForFile("save\\boardFile.txt") &&
            lookForFile("save\\playersFile.txt") &&
            lookForFile("save\\restFile.txt"))
        {
            String answer;
            do {
                System.out.println("""

                Do you want to continue previously saved game?
                Type 'y' for YES or 'n' for NO.""");
                answer = scanner.nextLine();
            } while (yesOrNoLoopCheck(answer));
            return yesOrNo(answer);
        }
        return false;
    }

    // Question about number of players
    // When one, player can choose level of difficulty of CPU
    // Then players objects are created
    public void askHowManyPlayers(Player[] playersList) {

        int answer;
        do {
            System.out.println("""
            
            Do you want to play game for 1 player or 2 players?
            Type '1' for player vs CPU or '2' for two players game.""");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (oneOrTwoLoopCheck(answer));
        if (oneOrTwo(answer)) {
            askForCPULevel(playersList);
            askForNames(playersList);
        }
        else if (!oneOrTwo(answer)){
            askForNames(playersList);
        }

    }

    // Question about CPU difficulty level
    // Chosen level CPU player object is created
    public void askForCPULevel(Player[] playersList) {

        int answer;
        do {
            System.out.println("""
                            
                Choose level of CPU opponent.
                Type '1' for easy or '2' for hard.""");
            answer = scanner.nextInt();
            scanner.nextLine();
            if (answer == 1) {
                playersList[0] = new CpuPlayerEasy("CPU", randomFigure(playersList));
            } else if (answer == 2) {
                playersList[0] = new CpuPlayerHard("CPU", randomFigure(playersList));
            }
        } while(oneOrTwoLoopCheck(answer));
    }

    // Question about player name
    // When no CPU player were created both players are asked about their names
    // There is rng making decision about which figure which player will have
    public void askForNames(Player[] playersList) {

        String name;
        if (playersList[0] == null) {
            for (int i = 0; i < 2; i++) {
                do {
                    System.out.println("\nPlayer " + (i + 1) + " please write desired nickname:");
                    name = scanner.nextLine();
                } while (name.equals(""));
                playersList[i] = new HumanPlayer(name, randomFigure(playersList));

                System.out.println("\n" + playersList[i].getName()
                    + " you will play with "
                    + playersList[i].getFigure() + "'s");
            }
        }
        else {
            do {
                System.out.println("\nPlayer please write desired nickname:");
                name = scanner.nextLine();
            } while (name.equals(""));
            playersList[1] = new HumanPlayer(name, randomFigure(playersList));

            System.out.println("\n" + playersList[1].getName()
                + " you will play with "
                + playersList[1].getFigure() + "'s");
        }
    }

    // There are two variants of game 3x3 board and 10x10 board
    // After player designate desired variant sample board with coordinates is printed
    // Returned int value is interpreted in GameEngine.collectGameDecisions()
    public int askForGameVariant() {

        int answer;
        do {
            System.out.println("""

                Which variant of game you want to play?
                Type '1' for 3x3 board or '2' for 10x10 board.""");
            answer = scanner.nextInt();
            scanner.nextLine();
        } while (oneOrTwoLoopCheck(answer));

        System.out.println("""
                
                Those are coordinates you will use to make a move:
                """);
        GameBoard gameBoard = new GameBoard(1);
        if (answer == 1) {
            gameBoard.displayCoordinates(3);
            return 3;
        }
        gameBoard.displayCoordinates(10);
        return 10;
    }

    // Player is asked about number of games they will play
    // Returned int value is interpreted in GameEngine.collectGameDecisions()
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

    // After every game player is informed with this game summary
    // Score is displayed for whole set of games ended during this play
    public void displayScore(Player[] playersList, int gameCount) {

        int p1TimesWon = playersList[0].getScore();
        int p2TimesWon = playersList[1].getScore();
        int draws = gameCount - p1TimesWon - p2TimesWon;

        System.out.println("For " + gameCount + " games played:\n" +
            playersList[0].getName() + " won " + p1TimesWon + " times, while " +
            playersList[1].getName() + " won " + p2TimesWon + " times.\n" +
            draws + " rounds resulted in draw.");
    }

    // If 'n' is typed by player instead of move coordinates question to run new game is asked
    public void askForRestart() {

        String answer;
        do {
            System.out.println("""
        
        Do you want to start a new game?
        Type 'y' for YES or 'n' for NO.""");
            answer = scanner.nextLine();
        } while (yesOrNoLoopCheck(answer));
        if (yesOrNo(answer)) {
            GameEngine gameEngine = new GameEngine();
            gameEngine.playGame();
        }
    }

    // If 'q' is typed by player instead of move coordinates question to quit game is asked
    // When player confirms his will to end game, current state of play is saved in main directory
    public void askForQuit(GameStorage gameStorage) {

        String answer;
        do {
            System.out.println("""
                
                Do you want to quit? Current game state will be saved.
                Type 'y' for YES or 'n' for NO.""");
            answer = scanner.nextLine();
        } while (yesOrNoLoopCheck(answer));
        if (yesOrNo(answer)) {
            GameSaver.saveGame(gameStorage);
            System.exit(0);
        }
    }

    // Every game the order of players doing their turn should be randomly taken
    // If rng draw even number order of players will be swapped
    public void playerRandomizer(Player[] players) {

        Random rng = new Random();
        boolean flag = rng.nextInt(100) % 2 == 0;
        while(flag) {
            Player temp;
            temp = players[0];
            players[0] = players[1];
            players[1] = temp;
            flag = false;
        }
    }

    // Every round there is information displayed about current state of play
    public void displayRoundNumber(int round, int gameCount) {

        System.out.println("\n====================");
        System.out.println("| Round " + round + " / Game " + gameCount + " |");
        System.out.println("====================");
    }
}
