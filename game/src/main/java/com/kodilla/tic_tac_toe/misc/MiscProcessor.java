package com.kodilla.tic_tac_toe.misc;

import com.kodilla.tic_tac_toe.players.Player;

import java.util.*;

// Used as processing helper
public final class MiscProcessor {

    private static final Map<String, Boolean> YES_NO_MAP =
            Map.of("y", true, "n", false);
    private static final Map<Integer, Boolean> ONE_TWO_MAP =
            Map.of(1, true, 2, false);
    private static final Map<String, Move> QUIT_RESET_MAP =
            Map.of("q", new Move(-1, 0), "n", new Move(-2, 0));

    // Returns true if user choose 'yes'
    public static boolean yesOrNo(String answer) {

        answer = answer.toLowerCase();
        return YES_NO_MAP.get(answer);
    }

    // Return true to keep loop going until proper answer is given
    public static boolean yesOrNoLoopCheck(String answer) {

        if (answer != null) {
            answer = answer.toLowerCase();
        }
        return !YES_NO_MAP.containsKey(answer);
    }

    // Returns true if user choose '1'
    public static boolean oneOrTwo(Integer answer) {

        return ONE_TWO_MAP.get(answer);
    }

    // Return true to keep loop going until proper answer is given
    public static boolean oneOrTwoLoopCheck(Integer answer) {

        return !ONE_TWO_MAP.containsKey(answer);
    }

    // Returns specific Move object when 'q' or 'n' chosen by user
    public static Move exceptionalAnswerCheck(String answer) {

        answer = answer.toLowerCase();
        if (QUIT_RESET_MAP.containsKey(answer)) {
            return QUIT_RESET_MAP.get(answer);
        }
        return null;
    }

    // Checks if chosen number of games is within limit
    public static boolean gameLimit(int answer) {

        return answer <= 0 || answer >= 10;
    }

    // Gives random figure to every player
    public static String randomFigure(Player[] playersList) {

        if (playersList[0] == null) {
            Random random = new Random();
            int x = random.nextInt(100) % 2;
            if (x == 0) {
                return "X";
            }
            return "O";
        }
        else if (playersList[0].getFigure().equals("X")) {
            return "O";
        }
        else {
            return "X";
        }
    }

    // Returns number of required figures in one row to win
    public static int designateRequirement(String[][] board) {

        if (board.length >= 3 && board.length < 5) {
            return 3;
        }
        else return board.length / 2;
    }
}
