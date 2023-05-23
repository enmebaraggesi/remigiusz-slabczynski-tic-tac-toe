package com.kodilla.tic_tac_toe.gui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameBoardTest {

    private final PrintStream sysOut = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUpTests() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(sysOut);
    }

    @Test
    void testDisplayBoard_3x3EmptyBoard() {

        // Given
        GameBoard gameBoard = new GameBoard(3);

        // When
        gameBoard.displayBoard(gameBoard.getBoard());
        String expected = """
                | | | |
                | | | |
                | | | |""";

        // Then
        assertEquals(expected, outputStream.toString().trim());

    }

    @Test
    void testDisplayBoard_10x10EmptyBoard() {

        // Given
        GameBoard gameBoard = new GameBoard(10);

        // When
        gameBoard.displayBoard(gameBoard.getBoard());
        String expected = """
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |
                | | | | | | | | | | |""";

        // Then
        assertEquals(expected, outputStream.toString().trim());

    }

    @Test
    void testDisplayBoard_3x3MarkedBoard() {

        // Given
        GameBoard gameBoardMock = mock(GameBoard.class);
        GameBoard properGameBoard = new GameBoard(3);
        String[][] mockedBoard = {
                {"X", " ", " "},
                {" ", "O", " "},
                {" ", " ", "X"}
        };
        when(gameBoardMock.getBoard()).thenReturn(mockedBoard);

        // When
        properGameBoard.displayBoard(gameBoardMock.getBoard());
        String expected = """
                |X| | |
                | |O| |
                | | |X|""";

        // Then
        assertEquals(expected, outputStream.toString().trim());

    }

    @Test
    void testDisplayBoard_10x10MarkedBoard() {

        // Given
        GameBoard gameBoardMock = mock(GameBoard.class);
        GameBoard properGameBoard = new GameBoard(3);
        String[][] mockedBoard = {
                {"X", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", "O", " ", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", "X", " ", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", "O", " ", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                {" ", " ", " ", " ", "X", " ", " ", " ", " ", " "},
                {" ", " ", " ", "O", " ", " ", " ", " ", " ", " "},
                {" ", " ", "X", " ", " ", " ", " ", " ", " ", " "},
                {" ", "O", " ", " ", " ", " ", " ", " ", " ", " "},
                {"X", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        };
        when(gameBoardMock.getBoard()).thenReturn(mockedBoard);

        // When
        properGameBoard.displayBoard(gameBoardMock.getBoard());
        String expected = """
                |X| | | | | | | | | |
                | |O| | | | | | | | |
                | | |X| | | | | | | |
                | | | |O| | | | | | |
                | | | | |X| | | | | |
                | | | | |X| | | | | |
                | | | |O| | | | | | |
                | | |X| | | | | | | |
                | |O| | | | | | | | |
                |X| | | | | | | | | |""";

        // Then
        assertEquals(expected, outputStream.toString().trim());

    }

    @Test
    void testDisplayCoordinates_3x3Board() {

        // Given
        GameBoard gameBoard = new GameBoard(3);

        // When
        gameBoard.displayCoordinates(3);
        String expected = """
                |00|01|02|
                |10|11|12|
                |20|21|22|""";

        // Then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    void testDisplayCoordinates_10x10Board() {

        // Given
        GameBoard gameBoard = new GameBoard(3);

        // When
        gameBoard.displayCoordinates(10);
        String expected = """
                |00|01|02|03|04|05|06|07|08|09|
                |10|11|12|13|14|15|16|17|18|19|
                |20|21|22|23|24|25|26|27|28|29|
                |30|31|32|33|34|35|36|37|38|39|
                |40|41|42|43|44|45|46|47|48|49|
                |50|51|52|53|54|55|56|57|58|59|
                |60|61|62|63|64|65|66|67|68|69|
                |70|71|72|73|74|75|76|77|78|79|
                |80|81|82|83|84|85|86|87|88|89|
                |90|91|92|93|94|95|96|97|98|99|""";

        // Then
        assertEquals(expected, outputStream.toString().trim());
    }
}
