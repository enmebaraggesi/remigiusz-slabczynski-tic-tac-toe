package com.kodilla.tic_tac_toe.misc.file_operators;

import java.io.File;

public class FilesSearcher {

    public static boolean lookForFile(String fileName) {

        File file = new File(fileName);
        return (file.exists());
    }
}
