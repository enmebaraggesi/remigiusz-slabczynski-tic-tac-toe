package com.kodilla.tic_tac_toe.communication;

import com.kodilla.tic_tac_toe.misc.MiscProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiscProcessorTestSuite {

    @Test
    void yerOrNo() {

        //given
        MiscProcessor miscProcessor = new MiscProcessor();

        //when
        String answerY = "y";
        String answerN = "n";

        //then
        assertTrue(miscProcessor.yerOrNo(answerY));
        assertFalse(miscProcessor.yerOrNo(answerN));
    }

    @Test
    void yesOrNoLoopCheck() {

        //given
        MiscProcessor miscProcessor = new MiscProcessor();

        //when
        String answerY = "y";
        String answerN = "n";
        String answerX = "x";

        //then
        assertFalse(miscProcessor.yesOrNoLoopCheck(answerY));
        assertFalse(miscProcessor.yesOrNoLoopCheck(answerN));
        assertTrue(miscProcessor.yesOrNoLoopCheck(answerX));
    }

    @Test
    void oneOrTwo() {

        //given
        MiscProcessor miscProcessor = new MiscProcessor();

        //when
        Integer one = 1;
        Integer two = 2;

        //then
        assertTrue(miscProcessor.oneOrTwo(one));
        assertFalse(miscProcessor.oneOrTwo(two));
    }

    @Test
    void oneOrTwoLoopCheck() {

        //given
        MiscProcessor miscProcessor = new MiscProcessor();

        //when
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;

        //then
        assertFalse(miscProcessor.oneOrTwoLoopCheck(one));
        assertFalse(miscProcessor.oneOrTwoLoopCheck(two));
        assertTrue(miscProcessor.oneOrTwoLoopCheck(three));
    }
}