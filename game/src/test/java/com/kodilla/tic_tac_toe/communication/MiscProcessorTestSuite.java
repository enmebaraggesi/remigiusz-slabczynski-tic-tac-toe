package com.kodilla.tic_tac_toe.communication;

import com.kodilla.tic_tac_toe.misc.MiscProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiscProcessorTestSuite {

    @Test
    void yerOrNo() {

        //given

        //when
        String answerY = "y";
        String answerN = "n";

        //then
        assertTrue(MiscProcessor.yerOrNo(answerY));
        assertFalse(MiscProcessor.yerOrNo(answerN));
    }

    @Test
    void yesOrNoLoopCheck() {

        //given

        //when
        String answerY = "y";
        String answerN = "n";
        String answerX = "x";

        //then
        assertFalse(MiscProcessor.yesOrNoLoopCheck(answerY));
        assertFalse(MiscProcessor.yesOrNoLoopCheck(answerN));
        assertTrue(MiscProcessor.yesOrNoLoopCheck(answerX));
    }

    @Test
    void oneOrTwo() {

        //given

        //when
        Integer one = 1;
        Integer two = 2;

        //then
        assertTrue(MiscProcessor.oneOrTwo(one));
        assertFalse(MiscProcessor.oneOrTwo(two));
    }

    @Test
    void oneOrTwoLoopCheck() {

        //given

        //when
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;

        //then
        assertFalse(MiscProcessor.oneOrTwoLoopCheck(one));
        assertFalse(MiscProcessor.oneOrTwoLoopCheck(two));
        assertTrue(MiscProcessor.oneOrTwoLoopCheck(three));
    }
}