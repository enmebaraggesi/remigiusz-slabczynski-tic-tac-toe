package com.kodilla.tic_tac_toe.engine;

import com.kodilla.tic_tac_toe.communication.PlayerHandler;

public class GameRound {

    private int roundNumber = 0;

    public void playRound(PlayerHandler playerHandler) {

        //todo round structure
        //display round number
        //first player turn
            //display player name
            //display actual state of board
            //ask for move
                //save move
                //if other decision than move
                    //save game
                    //restart game
                    //quit game
        //second player turn
            //display player name
            //display actual state of board
            //ask for move
                //save move
                //if other decision than move
                //save game
                //restart game
                //quit game
        //update round counter
    }

    //============ GETTER & SETTER

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
