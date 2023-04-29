package com.kodilla.tic_tac_toe.game_saver;

import java.nio.file.*;

public class GameSaver {

    public static void saveGame() {

        saveBoard();
        savePlayersDetails();
    }

    private static void saveBoard() {

        //TODO make to save into file for future loading
    }

    private static void savePlayersDetails() {

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
