package com.kodilla.tic_tac_toe.communication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerProcessorTestSuite {

    @Test
    void yerOrNo() {

        //given
        AnswerProcessor answerProcessor = new AnswerProcessor();

        //when
        String answerY = "y";
        String answerN = "n";

        //then
        assertTrue(answerProcessor.yerOrNo(answerY));
        assertFalse(answerProcessor.yerOrNo(answerN));
    }

    @Test
    void yesOrNoLoopCheck() {

        //given
        AnswerProcessor answerProcessor = new AnswerProcessor();

        //when
        String answerY = "y";
        String answerN = "n";
        String answerX = "x";

        //then
        assertFalse(answerProcessor.yesOrNoLoopCheck(answerY));
        assertFalse(answerProcessor.yesOrNoLoopCheck(answerN));
        assertTrue(answerProcessor.yesOrNoLoopCheck(answerX));
    }

    @Test
    void oneOrTwo() {

        //given
        AnswerProcessor answerProcessor = new AnswerProcessor();

        //when
        Integer one = 1;
        Integer two = 2;

        //then
        assertTrue(answerProcessor.oneOrTwo(one));
        assertFalse(answerProcessor.oneOrTwo(two));
    }

    @Test
    void oneOrTwoLoopCheck() {

        //given
        AnswerProcessor answerProcessor = new AnswerProcessor();

        //when
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;

        //then
        assertFalse(answerProcessor.oneOrTwoLoopCheck(one));
        assertFalse(answerProcessor.oneOrTwoLoopCheck(two));
        assertTrue(answerProcessor.oneOrTwoLoopCheck(three));
    }
}