package com.kodilla.tic_tac_toe.game_saver;

import com.kodilla.tic_tac_toe.engine.GameStorage;
import com.kodilla.tic_tac_toe.gui.GameBoard;
import com.kodilla.tic_tac_toe.players.*;

import java.io.*;
import java.util.*;

import static com.kodilla.tic_tac_toe.misc.file_operators.FilesDeleter.deleteFile;

public class GameLoader {

    // Used to load saved game combining data from separate files
    public static void loadGame(GameStorage gameStorage) {

        loadBoard(gameStorage);
        loadPlayers(gameStorage);
        loadRestFields(gameStorage);

        // After loading game files are deleted
        deleteFile("save\\boardFile.txt");
        deleteFile("save\\playersFile.txt");
        deleteFile("save\\restFile.txt");
    }

    // Loads board from file by trimming figures, putting blank spaces and uploading them into GameStorage
    private static void loadBoard(GameStorage gameStorage) {

        File file = new File("save\\boardFile.txt");
        List<String> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\|");
            while (scanner.hasNext()) {
                String cache = scanner.next().trim();
                if (cache.isBlank()) {
                    list.add(" ");
                    continue;
                }
                list.add(cache);
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int dimension = (int) Math.sqrt(list.size());
        int counter = 0;

        String[][] board = new String[dimension][dimension];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = list.get(counter++);
            }
        }
        GameBoard gameBoard = new GameBoard(dimension);
        gameBoard.setBoard(board);
        gameStorage.setGameBoard(gameBoard);
    }

    // Loads both players names and stats with interpretation if it is human or CPU player and of which level
    public static void loadPlayers(GameStorage gameStorage) {

        File file = new File("save\\playersFile.txt");
        Player[] players = new Player[2];

        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\|");
            int counter = 0;
            while (scanner.hasNextLine()) {
                String name = scanner.next().trim();
                String figure = scanner.next().trim();
                int score = scanner.nextInt();
                int level = scanner.nextInt();

                switch (level) {
                    case 0 -> {
                        players[counter++] = new HumanPlayer(name, figure);
                        players[0].setScore(score);
                    }
                    case 1 -> {
                        players[counter++] = new CpuPlayerEasy(name, figure);
                        players[0].setScore(score);
                    }
                    case 2 -> {
                        players[counter++] = new CpuPlayerHard(name, figure);
                        players[0].setScore(score);
                    }
                    default -> System.out.println("Error: corrupt players save file");
                }
                scanner.nextLine();
            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        gameStorage.setPlayersList(players);
    }

    // Loads whole rest of needed fields to complete loaded game
    private static void loadRestFields(GameStorage gameStorage) {

        File file = new File("save\\restFile.txt");

        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\|");
            gameStorage.setRoundCount(scanner.nextInt());
            gameStorage.setMaxGames(scanner.nextInt());
            gameStorage.setGameVariant(scanner.nextInt());
            gameStorage.setTurnNumber(scanner.nextInt());
            gameStorage.setMovesCounter(scanner.nextInt());
            scanner.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
