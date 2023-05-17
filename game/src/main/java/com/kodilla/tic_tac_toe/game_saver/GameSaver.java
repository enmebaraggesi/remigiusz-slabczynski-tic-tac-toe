package com.kodilla.tic_tac_toe.game_saver;

import java.io.*;
import com.kodilla.tic_tac_toe.misc.FileCreator;

public class GameSaver {

    public static void saveGame(String[][] board) {

        saveBoard(board);
        savePlayersDetails();
    }

    public static void saveBoard(String[][] board) {

//        FileCreator.createNewFile("boardFile.txt");

        try (FileWriter fileWriter = new FileWriter("boardFile.txt")) {
            for (String[] row : board) {
                for (String value : row) {
                    fileWriter.write(value);
                    fileWriter.write("|");
                }
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savePlayersDetails() {

        //todo make to save points and names into file
    }

//    Path path = Paths.get("/tmp/foo/bar.txt");
//
//        Files.createDirectories(path.getParent());
//
//        try {
//        Files.createFile(path);
//    } catch (
//    FileAlreadyExistsException e) {
//        System.err.println("already exists: " + e.getMessage());
//    }
}
