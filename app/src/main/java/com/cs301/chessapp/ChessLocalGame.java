package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;

public class ChessLocalGame extends LocalGame {
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }

}
