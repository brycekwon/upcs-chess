package com.cs301.chessapp.gamestate.players;

import android.graphics.Color;

import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessSmartComputer extends GameComputerPlayer {
    private static final String TAG = "ChessSmartComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessSmartComputer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {

        ChessGameState cgm = (ChessGameState) this.game.getGameState();

        sleep(1);

        //pieces 0,0 - 2,7
        int x = (int)(Math.random()*8);
        int y = (int)(Math.random()*8);
        for(int i = 0; i < cgm.getChessboard().length; i++) {
            for(int z = 0; z < cgm.getChessboard()[i].length; z++) {
                ChessSquare square = cgm.getChessboard()[i][z];
                try {
                    if (square.getPiece().getPlayer() == Color.WHITE && square.getPiece().isValid(x, y)) {
                        game.sendAction(new ChessMoveAction(this, new PieceMove(i, z, x, y)));
                    }
                }
                catch(NullPointerException npe) {

                }
            }
        }

    }
}
