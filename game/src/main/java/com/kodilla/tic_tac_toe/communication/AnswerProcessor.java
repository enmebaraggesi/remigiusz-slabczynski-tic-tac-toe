package com.kodilla.tic_tac_toe.communication;

import java.util.Map;

public final class AnswerProcessor {

    private final Map<String, Boolean> YES_NO_MAP = Map.of("y", true, "n", false);
    private final Map<Integer, Boolean> ONE_TWO_MAP = Map.of(1, true, 2, false);

    public boolean yerOrNo(String answer) {

        answer = answer.toLowerCase();
        return YES_NO_MAP.get(answer);
    }

    public boolean yesOrNoLoopCheck(String answer) {

        answer = answer.toLowerCase();
        return !YES_NO_MAP.containsKey(answer);
    }

    public boolean oneOrTwo(Integer answer) {

        return ONE_TWO_MAP.get(answer);
    }

    public boolean oneOrTwoLoopCheck(Integer answer) {

        return !ONE_TWO_MAP.containsKey(answer);
    }
}
