package com.kodilla.tic_tac_toe.game_saver;

import java.io.*;

import com.kodilla.tic_tac_toe.engine.GameStorage;
import com.kodilla.tic_tac_toe.players.*;

public class GameSaver {

    // Used to save game data during play when deciding to quit before end
    public static void saveGame(GameStorage gameStorage) {

        saveBoard(gameStorage.getGameBoard().getBoard());
        savePlayers(gameStorage.getPlayersList());
        saveRestFields(gameStorage);
    }

    // Saves board to file with delimiter of '|'
    private static void saveBoard(String[][] board) {

        try (FileWriter fileWriter = new FileWriter("save\\boardFile.txt")) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    fileWriter.write(board[i][j]);
                    if (i == board.length - 1 && j == board.length - 1) {
                        continue;
                    }
                    fileWriter.write("|");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Saves both players state to file with delimiter of '|'
    private static void savePlayers(Player[] playersList) {

        try (FileWriter fileWriter = new FileWriter("save\\playersFile.txt")) {
            int counter = 0;
            for (Player player : playersList) {
                fileWriter.write(player.getName());
                fileWriter.write("|");
                fileWriter.write(player.getFigure());
                fileWriter.write("|");
                fileWriter.write(Integer.toString(player.getScore()));
                fileWriter.write("|");
                fileWriter.write(Integer.toString(player.getLevel()));
                fileWriter.write("|");
                if (++counter < 2) {
                    fileWriter.write(System.lineSeparator());
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Saves whole rest of needed fields to file with delimiter of '|'
    private static void saveRestFields(GameStorage gameStorage) {

        try (FileWriter fileWriter = new FileWriter("save\\restFile.txt")) {
            fileWriter.write(Integer.toString(gameStorage.getRoundCount()));
            fileWriter.write("|");
            fileWriter.write(Integer.toString(gameStorage.getMaxGames()));
            fileWriter.write("|");
            fileWriter.write(Integer.toString(gameStorage.getGameVariant()));
            fileWriter.write("|");
            fileWriter.write(Integer.toString(gameStorage.getTurnNumber()));
            fileWriter.write("|");
            fileWriter.write(Integer.toString(gameStorage.getMovesCounter()));
            fileWriter.write("|");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
