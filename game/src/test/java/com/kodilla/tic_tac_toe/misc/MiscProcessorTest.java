package com.kodilla.tic_tac_toe.misc;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MiscProcessorTest {

    @Test
    void testYesOrNo() {

        //when
        String answerY = "y";
        String answerN = "n";

        //then
        assertTrue(MiscProcessor.yesOrNo(answerY));
        assertFalse(MiscProcessor.yesOrNo(answerN));
    }

    @Test
    void testYesOrNoLoopCheck() {

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
    void testOneOrTwo() {

        //when
        Integer one = 1;
        Integer two = 2;

        //then
        assertTrue(MiscProcessor.oneOrTwo(one));
        assertFalse(MiscProcessor.oneOrTwo(two));
    }

    @Test
    void testOneOrTwoLoopCheck() {

        //when
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;

        //then
        assertFalse(MiscProcessor.oneOrTwoLoopCheck(one));
        assertFalse(MiscProcessor.oneOrTwoLoopCheck(two));
        assertTrue(MiscProcessor.oneOrTwoLoopCheck(three));
    }

    @Test
    void testExceptionalAnswerCheck() {

        //when
        String quit = "Q";
        int expectedQuitX = -1;
        String restart = "n";
        int expectedRestartX = -2;
        String other = "a1c";

        //then
        assertEquals(expectedQuitX, Objects.requireNonNull(MiscProcessor.exceptionalAnswerCheck(quit)).getX());
        assertEquals(expectedRestartX, Objects.requireNonNull(MiscProcessor.exceptionalAnswerCheck(restart)).getX());
        assertNull(MiscProcessor.exceptionalAnswerCheck(other));
    }

    @Test
    void testDesignateRequirement() {

        //given
        String[][] board3x3 = new String[3][3];
        String[][] board10x10 = new String[10][10];

        //when
        int actual3 = MiscProcessor.designateRequirement(board3x3);
        int actual10 = MiscProcessor.designateRequirement(board10x10);

        //then
        assertEquals(3, actual3);
        assertEquals(5, actual10);
    }
}