package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;

/**
 * ChessLocalGame
 *
 * This class is the local game for chess. It is responsible for handling the
 * game logic and updating the game state. It is also responsible for sending
 * the updated game state to the players.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 26, 2023
 */
public class ChessLocalGame extends LocalGame {
    private static final String TAG = "ChessLocalGame";

    public ChessLocalGame() {
        super();
    }

    public ChessLocalGame(ChessGameState gameState) {
        super();
    }

    @Override
    public void start(GamePlayer[] players) {
        super.start(players);
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return false;
    }

    @Override
    protected String checkIfGameOver() {
        return "Hell0 World";
    }

    @Override
    protected boolean makeMove(GameAction action) {
        return false;
    }
}
