package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.gui.GameBoard;
import com.kodilla.tic_tac_toe.misc.*;

import static com.kodilla.tic_tac_toe.misc.MiscProcessor.designateGameVariant;

public class GameTurn {

    public boolean playTurn(GameBoard gameBoard, Player player, int movesCounter) {

        String[][] board = gameBoard.getBoard();
        int gameVariant = designateGameVariant(board);

        Move move = player.makeAMove(board);
        board[move.getX()][move.getY()] = player.getFigure();

        System.out.println();
        gameBoard.displayBoard();
        boolean answer = ScoreChecker.checkIfWinner(board, player, gameVariant);
        if (!answer) {
            answer = ScoreChecker.checkIfDraw(movesCounter, gameVariant);
        }
        return answer;
    }
}
