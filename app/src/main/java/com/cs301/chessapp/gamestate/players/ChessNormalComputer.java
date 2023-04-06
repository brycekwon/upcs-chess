package com.cs301.chessapp.gamestate.players;

import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.pieces.Piece;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

import java.util.Random;

public class ChessNormalComputer extends GameComputerPlayer {
    private static final String TAG = "ChessNormalComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessNormalComputer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) {
            return;
        }

        sleep(1);

        // get all pieces
//        int m = (int) (Math.random() * 1) + 6;
//        int n = (int) (Math.random() * 7) + 1;
//
//        // get random piece
//        Piece piece = ((ChessGameState) this.game.getGameState()).getChessboard()[m][n].getPiece();
//        if

        game.sendAction(new ChessMoveAction(this, new PieceMove(0, 1, 2, 2)));
    }
}
