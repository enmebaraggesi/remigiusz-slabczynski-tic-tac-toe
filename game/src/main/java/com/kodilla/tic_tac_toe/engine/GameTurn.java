package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.misc.*;

import static com.kodilla.tic_tac_toe.misc.MiscProcessor.designateRequirement;
import static com.kodilla.tic_tac_toe.misc.ScoreChecker.*;

public class GameTurn {

    // One turn is played for every player making them choose desired move and then checking for winning move
    public int playTurn(GameStorage g, int index) {

        int requiredFigures = designateRequirement(g.getGameBoard().getBoard());

        // Display of current state of board
        g.getGameBoard().displayBoard(g.getGameBoard().getBoard());

        // Player making its move, where human player writes board coordinates and CPU algorithm chooses one
        Move move = g.getPlayersList()[index].makeAMove(g.getGameBoard().getBoard());
        // When player type 'q' or 'n' willing to quit or restart game specific value is returned
        if (move.getX() == -1 || move.getX() == -2) {
            return move.getX();
        }
        // Update board with newly made move
        g.getGameBoard().getBoard()[move.getX()][move.getY()] = g.getPlayersList()[index].getFigure();

        // Moves counter is used by checkIfDraw
        g.raiseMovesCounter();

        // Both checks for winning move or draw after filling board without winning condition
        System.out.println();
        int answer = checkIfWinner(g.getGameBoard().getBoard(), g.getPlayersList()[index], requiredFigures);
        if (answer == 0) {
            answer = checkIfDraw(g.getMovesCounter(), g.getGameVariant());
        }
        return answer;
    }
}