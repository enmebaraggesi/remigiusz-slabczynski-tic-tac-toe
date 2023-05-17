package com.kodilla.tic_tac_toe.misc;

import java.io.IOException;
import java.nio.file.*;

public class FileCreator {

    public static void createNewFile(String path) {

        try {
            Path file = Files.createFile(Path.of(path));
        }
        catch (FileAlreadyExistsException e) {
            FileDeleter.deleteBoardFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
