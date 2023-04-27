package com.cs301.chessapp.gamestate.checkmate;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

import java.util.ArrayList;

public class Check {

    private int _kingRow;
    private int _kingCol;
    private final int _player;
    private ChessGameState _gameState;
    private ArrayList<ChessMove> _currMoves = new ArrayList<>();

    public Check(ChessGameState gamestate, int kingRow, int kingCol, int player) {
        this._gameState = gamestate;
        this._kingRow = kingRow;
        this._kingCol = kingCol;
        this._player = player;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (_gameState.getPiece(i, j) == null) {
                    continue;
                }
                else if (_gameState.getPiece(i, j).getName().equals("King")) {
                    continue;
                }
                else if (_gameState.getPiece(i, j).getPlayerId() == _player) {
                    continue;
                }
                _currMoves.addAll(_gameState.getPiece(i, j).getChecks(_gameState));
            }
        }
    }

    public Check(int player) {
        this._player = player;
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

    public void reset(ChessGameState gamestate, int kingRow, int kingCol) {
        _currMoves.clear();
        this._kingRow = kingRow;
        this._kingCol = kingCol;

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
                _currMoves.addAll(gamestate.getPiece(i, j).getChecks(gamestate));
            }
        }
    }
}
