package com.cs301.chessapp.gamestate.checkmate;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.chessboard.ChessTile;

import java.util.ArrayList;

public class CheckAlgorithm {

    public boolean _inCheck;
    private int _kingRow;
    private int _kingCol;
    private final int _player;
    private ArrayList<ChessMove> _currMoves = new ArrayList<>();

    public CheckAlgorithm(int player) {
        this._player = player;
        this._inCheck = false;
    }

    public boolean isCheck(int row, int col) {
        for (ChessMove move : _currMoves) {
            if (move.getEndRow() == row && move.getEndCol() == col) {
                return true;
            }
        }
        return false;
    }

    public boolean inCheck() {
        for (ChessMove move : _currMoves) {
            if (move.getEndRow() == _kingRow && move.getEndCol() == _kingCol) {
                return true;
            }
        }
        return false;
    }

    public void set(ChessGameState gamestate, int kingRow, int kingCol) {
        _currMoves.clear();
        this._kingRow = kingRow;
        this._kingCol = kingCol;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gamestate.getPiece(i, j) == null) {
                    continue;
                }
                else if (gamestate.getPiece(i, j).getPlayerId() == _player) {
                    continue;
                }
                _currMoves.addAll(gamestate.getPiece(i, j).getChecks(gamestate));
            }
        }
    }

    public static boolean testMove(ChessGameState gamestate, ChessMove move, int playernum) {
        ChessGameState tempstate = new ChessGameState(gamestate);

        ChessTile tempfrom = tempstate.getTile(move.getStartRow(), move.getStartCol());
        ChessTile tempto = tempstate.getTile(move.getEndRow(), move.getEndCol());

        tempfrom.setPiece(null);
        tempto.setPiece(tempfrom.getPiece());

        return tempstate.inCheck(playernum);
    }
}
