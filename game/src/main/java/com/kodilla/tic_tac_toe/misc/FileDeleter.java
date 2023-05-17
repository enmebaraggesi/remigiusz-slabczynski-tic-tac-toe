package com.kodilla.tic_tac_toe.misc;

import java.io.*;
import java.nio.file.*;

public class FileDeleter {

    public static void deleteBoardFile() {

        File file = new File("boardFile.txt");
        if (file.exists()) {
            try {
                Files.delete(Path.of(file.getPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
