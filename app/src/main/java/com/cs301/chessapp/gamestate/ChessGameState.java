package com.cs301.chessapp.gamestate;


import android.graphics.Color;

import com.cs301.chessapp.gameframework.infoMessage.GameState;

import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.chessboard.ChessTile;
import com.cs301.chessapp.gamestate.pieces.Bishop;
import com.cs301.chessapp.gamestate.pieces.King;
import com.cs301.chessapp.gamestate.pieces.Knight;
import com.cs301.chessapp.gamestate.pieces.Pawn;
import com.cs301.chessapp.gamestate.pieces.Queen;
import com.cs301.chessapp.gamestate.pieces.Rook;
import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessGameState class
 *
 * This class is the main gamestate for the chess game. It contains information
 * on the board and the current turn.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessGameState extends GameState {

    // these constants define the players
    public static final int PLAYER_1 = 0;
    public static final int PLAYER_2 = 1;

    // these variables define the gamestate
    private final ChessTile[][] _chessboard;
    private int _currTurn;

    /**
     * ChessGameState constructor
     *
     * This constructor initializes a new gamestate.
     */
    public ChessGameState() {
        // white always goes first
        this._currTurn = PLAYER_1;

        // initialize the chessboard
        this._chessboard = new ChessTile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // alternate the colors of the squares
                if ((i + j) % 2 == 0) {
                    this._chessboard[i][j] = new ChessTile(Color.WHITE, i, j);
                } else {
                    this._chessboard[i][j] = new ChessTile(Color.DKGRAY, i, j);
                }
            }
        }

        // set up the board with the initial black pieces
        this._chessboard[0][0].setPiece(new Rook(PLAYER_2));
        this._chessboard[0][1].setPiece(new Knight(PLAYER_2));
        this._chessboard[0][2].setPiece(new Bishop(PLAYER_2));
        this._chessboard[0][3].setPiece(new Queen(PLAYER_2));
        this._chessboard[0][4].setPiece(new King(PLAYER_2));
        this._chessboard[0][5].setPiece(new Bishop(PLAYER_2));
        this._chessboard[0][6].setPiece(new Knight(PLAYER_2));
        this._chessboard[0][7].setPiece(new Rook(PLAYER_2));
        for (int i = 0; i < 8; i++) {
            this._chessboard[1][i].setPiece(new Pawn(PLAYER_2));
        }

        // set up the board with the initial white pieces
        this._chessboard[7][0].setPiece(new Rook(PLAYER_1));
        this._chessboard[7][1].setPiece(new Knight(PLAYER_1));
        this._chessboard[7][2].setPiece(new Bishop(PLAYER_1));
        this._chessboard[7][3].setPiece(new Queen(PLAYER_1));
        this._chessboard[7][4].setPiece(new King(PLAYER_1));
        this._chessboard[7][5].setPiece(new Bishop(PLAYER_1));
        this._chessboard[7][6].setPiece(new Knight(PLAYER_1));
        this._chessboard[7][7].setPiece(new Rook(PLAYER_1));
        for (int i = 0; i < 8; i++) {
            this._chessboard[6][i].setPiece(new Pawn(PLAYER_1));
        }
    }

    /**
     * ChessGameState copy constructor
     *
     * This constructor initializes a copy of another gamestate.
     *
     * @param other     the gamestate to copy
     */
    public ChessGameState(ChessGameState other) {
        this._currTurn = other.getCurrTurn();

        this._chessboard = new ChessTile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this._chessboard[i][j] = new ChessTile(other.getTile(i, j));
                this._chessboard[i][j].setPiece(other.getPiece(i, j));
            }
        }
    }

    /**
     * nextTurn
     *
     * This method increments the turn between player 1 and player 2.
     */
    public void nextTurn() {
        _currTurn = _currTurn == PLAYER_1 ? PLAYER_2 : PLAYER_1;
    }

    // todo: make more readbale

    public boolean movePiece(ChessMove action) {
        int x = action.getPlayer().getPlayerTurn();
        if (action.getStartRow() == -1) {
            return true;
        }

        ChessTile fromTile = _chessboard[action.getStartRow()][action.getStartCol()];
        ChessTile toTile = _chessboard[action.getEndRow()][action.getEndCol()];

        if (fromTile.getPiece() == null) {
            return true;
        }

        else if (fromTile.getPiece() instanceof Pawn) {
            if (fromTile.getPiece().getPlayerId() == PLAYER_1 && action.getEndRow() == 0) {
                toTile.setPiece(new Queen(PLAYER_1));
                fromTile.setPiece(null);

                nextTurn();
                return true;
            } else if (fromTile.getPiece().getPlayerId() == PLAYER_2 && action.getEndRow() == 7) {
                toTile.setPiece(new Queen(PLAYER_2));
                fromTile.setPiece(null);

                nextTurn();
                return true;
            }
        }

        else if (fromTile.getPiece() instanceof King && toTile.getPiece() instanceof Rook) {
            if (toTile.getCol() == 7) {
                _chessboard[fromTile.getRow()][6].setPiece(new King(fromTile.getPiece().getPlayerId()));
                _chessboard[fromTile.getRow()][5].setPiece(new Rook(toTile.getPiece().getPlayerId()));
                fromTile.setPiece(null);
                toTile.setPiece(null);

                nextTurn();
                return true;
            }
            else if (toTile.getCol() == 0) {
                _chessboard[fromTile.getRow()][3].setPiece(new King(fromTile.getPiece().getPlayerId()));
                _chessboard[fromTile.getRow()][2].setPiece(new Rook(toTile.getPiece().getPlayerId()));
                fromTile.setPiece(null);
                toTile.setPiece(null);

                nextTurn();
                return true;
            }
        }

        toTile.setPiece(fromTile.getPiece());
        fromTile.setPiece(null);

        nextTurn();

        return true;
    }

    /**
     * getTurn
     *
     * This method returns the current turn of the game.
     *
     * @return      the current turn
     */
    public int getCurrTurn() {
        return _currTurn;
    }

    /**
     * getTile
     *
     * This method returns the chess tile at a given position.
     *
     * @param row       the row of the tile
     * @param col       the column of the tile
     * @return          the tile at the given position
     */
    public ChessTile getTile(int row, int col) {
        return _chessboard[row][col];
    }

    /**
     * getPiece
     *
     * This method returns the piece at a given position.
     *
     * @param row       the row of the piece
     * @param col       the column of the piece
     * @return          the piece at the given position
     */
    public Piece getPiece(int row, int col) {
        return _chessboard[row][col].getPiece();
    }

    // todo: redo in check for gamestate
    public boolean inCheck(int playerNum) {
        Piece currPiece;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                currPiece = _chessboard[i][j].getPiece();
                if (currPiece instanceof King && currPiece.getPlayerId() == playerNum) {
                    ((King) _chessboard[i][j].getPiece()).update(this);
                    return ((King) _chessboard[i][j].getPiece()).inCheck();
                }
            }
        }
        return false;
    }
}
