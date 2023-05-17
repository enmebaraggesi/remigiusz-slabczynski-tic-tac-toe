package com.kodilla.tic_tac_toe.misc;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileCreatorTestSuite {

    @Test
    void createFileTest() {

        FileCreator.createNewFile("board.txt");
    }

}