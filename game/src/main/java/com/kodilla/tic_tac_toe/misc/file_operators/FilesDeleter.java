package com.kodilla.tic_tac_toe.misc.file_operators;

import java.io.*;
import java.nio.file.*;

public class FilesDeleter {

    public static void deleteFile(String fileName) {

        File file = new File(fileName);
        if (file.exists()) {
            try {
                Files.delete(Path.of(file.getPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
