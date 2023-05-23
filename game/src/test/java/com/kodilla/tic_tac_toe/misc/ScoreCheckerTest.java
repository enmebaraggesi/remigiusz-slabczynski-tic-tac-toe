package com.kodilla.tic_tac_toe.misc;

import com.kodilla.tic_tac_toe.players.HumanPlayer;
import com.kodilla.tic_tac_toe.players.Player;
import org.junit.jupiter.api.Test;

import static com.kodilla.tic_tac_toe.misc.ScoreChecker.checkIfWinner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCheckerTest {

    @Test
    void testCheckIfWinner_WithDiagonalWin() {

        //given
        String[][] board1 = {
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", " ", "X"}
        };
        String[][] board2 = {
                {" ", " ", "X"},
                {" ", "X", " "},
                {"X", " ", " "}
        };
        Player dummy = new HumanPlayer("Dummy", "X");
        int gameVariant = 3;

        //when
        int actualReturn1 = checkIfWinner(board1, dummy, gameVariant);
        int actualScore1 = dummy.getScore();
        int actualReturn2 = checkIfWinner(board2, dummy, gameVariant);
        int actualScore2 = dummy.getScore();
        int expected1 = 1;
        int expected2 = 2;

        //then
        assertEquals(expected1, actualReturn1);
        assertEquals(expected1, actualReturn2);
        assertEquals(expected1, actualScore1);
        assertEquals(expected2, actualScore2);
    }

    @Test
    void testCheckIfWinner_WithVerticalWin() {

        //given
        String[][] board1 = {
                {" ", "X", " "},
                {" ", "X", " "},
                {" ", "X", " "}
        };
        String[][] board2 = {
                {" ", "X", " "},
                {" ", "X", " "},
                {"X", " ", " "}
        };
        Player dummy = new HumanPlayer("Dummy", "X");
        int gameVariant = 3;

        //when
        int actualReturnWin = checkIfWinner(board1, dummy, gameVariant);
        int actualScore1 = dummy.getScore();
        int actualReturnFail = checkIfWinner(board2, dummy, gameVariant);
        int actualScore2 = dummy.getScore();
        int expected0 = 0;
        int expected1 = 1;

        //then
        assertEquals(expected1, actualReturnWin);
        assertEquals(expected0, actualReturnFail);
        assertEquals(expected1, actualScore1);
        assertEquals(expected1, actualScore2);
    }

    @Test
    void testCheckIfWinner_WithHorizontalWin() {

        //given
        String[][] board1 = {
                {" ", " ", " "},
                {" ", " ", " "},
                {"X", "X", "X"}
        };
        String[][] board2 = {
                {" ", " ", " "},
                {" ", "X", " "},
                {"X", " ", "X"}
        };
        Player dummy = new HumanPlayer("Dummy", "X");
        int gameVariant = 3;

        //when
        int actualReturnWin = checkIfWinner(board1, dummy, gameVariant);
        int actualScore1 = dummy.getScore();
        int actualReturnFail = checkIfWinner(board2, dummy, gameVariant);
        int actualScore2 = dummy.getScore();
        int expected0 = 0;
        int expected1 = 1;

        //then
        assertEquals(expected1, actualReturnWin);
        assertEquals(expected0, actualReturnFail);
        assertEquals(expected1, actualScore1);
        assertEquals(expected1, actualScore2);
    }

    @Test
    void testCheckIfWinner_WithNoWin() {

        //given
        String[][] board1 = {
                {"X", " ", " "},
                {" ", "X", " "},
                {" ", "X", " "}
        };
        String[][] board2 = {
                {" ", "X", " "},
                {" ", "X", "X"},
                {"X", " ", "X"}
        };
        Player dummy = new HumanPlayer("Dummy", "X");
        int gameVariant = 3;

        //when
        int actualReturnWin = checkIfWinner(board1, dummy, gameVariant);
        int actualScore1 = dummy.getScore();
        int actualReturnFail = checkIfWinner(board2, dummy, gameVariant);
        int actualScore2 = dummy.getScore();
        int expected0 = 0;

        //then
        assertEquals(expected0, actualReturnWin);
        assertEquals(expected0, actualReturnFail);
        assertEquals(expected0, actualScore1);
        assertEquals(expected0, actualScore2);
    }
}