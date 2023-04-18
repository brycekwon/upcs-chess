package com.cs301.chessapp.gamestate.players;


import android.util.Log;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessComputerNormal extends GameComputerPlayer {
    private int turn;

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessComputerNormal(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) {
            return;
        }
        ChessGameState gamestate = (ChessGameState) info;

        int row;
        int col;
        do {
            row = (int) (Math.random() * 8);
            col = (int) (Math.random() * 8);
        } while (gamestate.getPiece(row, col) == null ||
                gamestate.getPiece(row, col).getPlayer() != this.turn ||
                gamestate.getPiece(row, col).getMoves(row, col, gamestate).size() < 1);

        int index = (int) (Math.random() * gamestate.getPiece(row, col).getMoves(row, col, gamestate).size());
        PieceMove move = gamestate.getPiece(row, col).getMoves(row, col, gamestate).get(index);

        sleep(0.5);

        game.sendAction(new ChessMoveAction(this, move));
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getTurn() {
        return this.turn;
    }
}
