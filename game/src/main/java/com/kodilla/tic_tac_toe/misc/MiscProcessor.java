package com.kodilla.tic_tac_toe.misc;

import java.util.*;

public final class MiscProcessor {

    private static final Map<String, Boolean> YES_NO_MAP = Map.of("y", true, "n", false);
    private static final Map<Integer, Boolean> ONE_TWO_MAP = Map.of(1, true, 2, false);

    public static boolean yerOrNo(String answer) {

        answer = answer.toLowerCase();
        return YES_NO_MAP.get(answer);
    }

    public static boolean yesOrNoLoopCheck(String answer) {

        answer = answer.toLowerCase();
        return !YES_NO_MAP.containsKey(answer);
    }

    public static boolean oneOrTwo(Integer answer) {

        return ONE_TWO_MAP.get(answer);
    }

    public static boolean oneOrTwoLoopCheck(Integer answer) {

        return !ONE_TWO_MAP.containsKey(answer);
    }

    public static String randomFigure(String figure) {

        if (figure.equals("X")) {
            return "O";
        } else if (figure.equals("O")) {
            return "X";
        }

        Random random = new Random();
        int x = random.nextInt(2);
        if (x == 0) {
            return "X";
        }
        return "O";
    }

    public static boolean gameLimit(int answer) {
        return answer <= 0 || answer >= 10;
    }

    public static int designateGameVariant(String[][] board) {

        if (board.length >= 3 && board.length < 5) {
            return 3;
        }
        else return board.length / 2;
    }
}
