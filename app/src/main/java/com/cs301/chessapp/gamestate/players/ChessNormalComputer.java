package com.cs301.chessapp.gamestate.players;

import android.graphics.Color;

import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

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

        int x = (int) (Math.random() * 8);
        int y = (int) (Math.random() * 8);

        while (((ChessGameState) info).getChessboard()[x][y].getPiece() == null || ((ChessGameState) info).getChessboard()[x][y].getPiece().getPlayer() == Color.BLACK || ((ChessGameState) info).getChessboard()[x][y].getPiece().getMoves(x, y, ((ChessGameState) info).getChessboard()).size() < 1) {
            x = (int) (Math.random() * 8);
            y = (int) (Math.random() * 8);
        }

        PieceMove moveX1 = ((ChessGameState) info).getChessboard()[x][y].getPiece().getMoves(x, y, ((ChessGameState) info).getChessboard()).get((int) (Math.random() * ((ChessGameState) info).getChessboard()[x][y].getPiece().getMoves(x, y, ((ChessGameState) info).getChessboard()).size()));

        game.sendAction(new ChessMoveAction(this, moveX1));
    }
}
