package com.kodilla.tic_tac_toe.misc.file_operators;

import java.io.*;
import java.nio.file.*;

public class DirectoryCreator {

    public static void createSaveDirectory() {

        File file = new File("save");
        if (!file.exists()) {
            try {
                Files.createDirectory(Path.of("save"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
