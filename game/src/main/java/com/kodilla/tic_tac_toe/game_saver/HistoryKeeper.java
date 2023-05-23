package com.kodilla.tic_tac_toe.game_saver;

import com.kodilla.tic_tac_toe.players.Player;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class HistoryKeeper {

    // Used to save resulting score after finishing desired number of rounds
    public void keepScoreBoard(Player[] playersList, int gameCount) {

        int limit = 10;
        File file = new File("save\\scoreboard.txt");

        List<String> linesList;
        if (file.exists()) {
            linesList = wrapUpToList(file);
        }
        else {
            linesList = new ArrayList<>();
        }

        linesList.add(addNewLine(playersList, gameCount));

        if (linesList.size() > limit) {
            linesList.remove(0);
        }

        writeToFile(file, linesList);
    }

    // Updates file with current scoring
    private String addNewLine(Player[] playersList, int gameCount) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("| ");
        for (Player player : playersList) {
            stringBuilder.append(player.getName()).append(": ");
            stringBuilder.append(player.getScore()).append(" points | " );
        }
        stringBuilder.append("Games played: ").append(gameCount).append(" | ");
        stringBuilder.append("Date: ").append(LocalDate.now()).append(" |");

        return stringBuilder.toString();
    }

    // Returns list of all lines in saved scoreboard file, needed to trim file up to limit of 10 last plays
    private List<String> wrapUpToList(File file) {

        List<String> cacheList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                cacheList.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cacheList;
    }

    // Writes trimmed lost to 10 lines of results
    private void writeToFile(File file, List<String> cacheList) {

        try {
            FileWriter fileWriter = new FileWriter(file);
            for (String line : cacheList) {
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Reads saved results from file and displays them after welcoming message
    public void displayScoreBoard() {

        File file = new File("save\\scoreboard.txt");
        if (file.exists()) {

            try {
                Scanner scanner = new Scanner(file);
                scanner.useDelimiter("\\|");
                System.out.println("\nLast 10 game results:");
                while(scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
