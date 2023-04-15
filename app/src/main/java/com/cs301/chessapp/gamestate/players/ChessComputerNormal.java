package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessComputerNormal extends GameComputerPlayer {
    private static final String TAG = "ChessNormalComputer";

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
        if (info instanceof ChessGameState) {
            ChessGameState gamestate = (ChessGameState) info;

            int row;
            int col;
            do {
                row = (int) (Math.random() * 8);
                col = (int) (Math.random() * 8);
            } while ((gamestate.getPiece(row, col) == null ||
                    gamestate.getPiece(row, col).getPlayer() != this.playerNum ||
                    gamestate.getPiece(row, col).getMoves(row, col, gamestate).size() < 1));

            PieceMove move;
            do {
                int index = (int) (Math.random() * gamestate.getPiece(row, col).getMoves(row, col, gamestate).size());
                move = gamestate.getPiece(row, col).getMoves(row, col, gamestate).get(index);
            } while (gamestate.getPiece(row, col).isValidMove(move, gamestate));


            sleep(0.5);

            Logger.debugLog(TAG, "Computer " + (this.playerNum == 0 ? "1" : "2") + " is moving " + gamestate.getPiece(row, col).toString() + " from " + "[" + row + ", " + col + "]" + " to " + "[" + move.getEndRow() + ", " + move.getEndCol() + "]");
            game.sendAction(new ChessMoveAction(this, move));
        }
    }
}
