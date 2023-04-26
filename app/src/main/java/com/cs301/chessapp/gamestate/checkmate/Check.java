package com.cs301.chessapp.gamestate.checkmate;

import android.util.Log;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.players.ChessComputerNormal;

import java.util.ArrayList;

public class Check {

    private final int _kingRow;
    private final int _kingCol;
    private final int _player;
    private ArrayList<ChessMove> _currMoves = new ArrayList<>();

    public Check(ChessGameState gamestate, int kingRow, int kingCol, int player) {
        this._kingRow = kingRow;
        this._kingCol = kingCol;
        this._player = player;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gamestate.getPiece(i, j) == null) {
                    continue;
                }
                else if (gamestate.getPiece(i, j).getName().equals("King")) {
                    continue;
                }
                else if (gamestate.getPiece(i, j).getPlayerId() == _player) {
                    continue;
                }
                else if (gamestate.getPiece(i, j).getName().equals("Pawn")) {
                    if (gamestate.getPiece(i, j).getPlayerId() == ChessGameState.PLAYER_1) {
                        // check in bounds
                        if ((i - 1 >= 0) && (j - 1 >= 0)) {
                            _currMoves.add(new ChessMove(new ChessComputerNormal("Temp"), i, j, i - 1, j - 1));
                        } else if ((i - 1 >= 0) && (j + 1 < 8)) {
                            _currMoves.add(new ChessMove(new ChessComputerNormal("Temp"), i, j, i - 1, j + 1));
                        }
                    } else if (gamestate.getPiece(i, j).getPlayerId() == ChessGameState.PLAYER_2) {
                        // check in bounds
                        if ((i + 1 < 8) && (j - 1 >= 0)) {
                            _currMoves.add(new ChessMove(new ChessComputerNormal("Temp"), i, j, i + 1, j - 1));
                        } else if ((i + 1 < 8) && (j + 1 < 8)) {
                            _currMoves.add(new ChessMove(new ChessComputerNormal("Temp"), i, j, i + 1, j + 1));
                        }
                    }
                    continue;
                }
                _currMoves.addAll(gamestate.getPiece(i, j).getMoves(gamestate, new ChessComputerNormal("Temp")));
            }
        }
    }

    public boolean isCheck(int row, int col) {
        for (ChessMove move : _currMoves) {
            Log.d("CHECK", "CHECKING " + move.getStartRow() + "x" + move.getStartCol() + " to " + move.getEndRow() + "x" + move.getEndCol());
            if (move.getEndRow() == row && move.getEndCol() == col) {
//                Log.d("CHECK", "NOT A SAFE MOVE" + col + "x" + row);
                return true;
            }
        }
        return false;
    }
}
