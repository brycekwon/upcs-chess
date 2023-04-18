package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessComputerSmart extends GameComputerPlayer {

    private int turn;

    public ChessComputerSmart(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) {
            return;
        }
        ChessGameState gamestate = (ChessGameState) info;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (gamestate.getPiece(row, col) == null) {
                    continue;
                } else if (gamestate.getPiece(row, col).getPlayer() != this.turn) {
                    continue;
                }

                // check for any capture moves
                for (PieceMove move : gamestate.getPiece(row, col).getMoves(row, col, gamestate)) {
                    if (gamestate.getPiece(move.getEndRow(), move.getEndCol()) != null && gamestate.getPiece(move.getEndRow(), move.getEndCol()).getPlayer() != this.turn) {
                        game.sendAction(new ChessMoveAction(this, move));
                        return;
                    }
                }
            }
        }

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

    public String toString() {
        return "ChessComputerSmart { " +
                "name=" + this.name + ", " +
                "turn=" + this.turn +
                " }";
    }
}
