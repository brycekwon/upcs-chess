package com.cs301.chessapp.gamestate;

import android.graphics.Color;

import com.cs301.chessapp.gameframework.infoMessage.GameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.pieces.*;

/**
 * MainGameState
 * <p>
 * This class is the main game state for the chess game. It contains information
 * on the board, the current turn, and the game mode. It is a subclass of
 * GameState. It is serializable so that it can be sent to other devices.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class ChessGameState extends GameState {
    private static final String TAG = "ChessGameState";

    // these constants define the players
    private static final int PLAYER_1 = 0;
    private static final int PLAYER_2 = 1;

    // these variables define the game state
    private int _playerTurn;
    private final ChessSquare[][] _chessboard;

    /**
     * ChessGameState constructor
     * <p>
     * This constructor initializes the game state.
     */
    public ChessGameState() {
        // white always goes first
        this._playerTurn = 0;

        // initialize the chessboard
        this._chessboard = new ChessSquare[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // alternate the colors of the squares
                if ((i + j) % 2 == 0) {
                    this._chessboard[i][j] = new ChessSquare(Color.WHITE);
                } else {
                    this._chessboard[i][j] = new ChessSquare(Color.BLACK);
                }
            }
        }

        // set up the board with the initial black pieces
        this._chessboard[0][0].setPiece(new Rook(PLAYER_1));
        this._chessboard[0][1].setPiece(new Knight(PLAYER_1));
        this._chessboard[0][2].setPiece(new Bishop(PLAYER_1));
        this._chessboard[0][3].setPiece(new Queen(PLAYER_1));
        this._chessboard[0][4].setPiece(new King(PLAYER_1));
        this._chessboard[0][5].setPiece(new Bishop(PLAYER_1));
        this._chessboard[0][6].setPiece(new Knight(PLAYER_1));
        this._chessboard[0][7].setPiece(new Rook(PLAYER_1));
        for (int i = 0; i < 8; i++) {
            this._chessboard[1][i].setPiece(new Pawn(PLAYER_1));
        }

        // set up the board with the initial white pieces
        this._chessboard[7][0].setPiece(new Rook(PLAYER_2));
        this._chessboard[7][1].setPiece(new Knight(PLAYER_2));
        this._chessboard[7][2].setPiece(new Bishop(PLAYER_2));
        this._chessboard[7][3].setPiece(new Queen(PLAYER_2));
        this._chessboard[7][4].setPiece(new King(PLAYER_2));
        this._chessboard[7][5].setPiece(new Bishop(PLAYER_2));
        this._chessboard[7][6].setPiece(new Knight(PLAYER_2));
        this._chessboard[7][7].setPiece(new Rook(PLAYER_2));
        for (int i = 0; i < 8; i++) {
            this._chessboard[6][i].setPiece(new Pawn(PLAYER_2));
        }
    }

    /**
     * ChessGameState copy constructor
     * <p>
     * This constructor initializes the game state with a copy of another game.
     *
     * @param other     The game state to copy.
     */
    public ChessGameState(ChessGameState other) {
        this._playerTurn = other._playerTurn;

        this._chessboard = new ChessSquare[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this._chessboard[i][j] = new ChessSquare(other._chessboard[i][j]);
            }
        }
    }

    /**
     * nextTurn
     * <p>
     * This method increments the turn between 0 and 1.
     */
    public void nextTurn() {
        _playerTurn = _playerTurn == 0 ? 1 : 0;
    }

    /**
     * getTurn
     * <p>
     * This method returns the current turn.
     *
     * @return          The current turn.
     */
    public int getTurn() {
        return _playerTurn;
    }

    /**
     * getChessboard
     * <p>
     * This method returns the chessboard.
     *
     * @return          The chessboard.
     */
    public ChessSquare[][] getChessboard() {
        return _chessboard;
    }

    /**
     * getTile
     * <p>
     * This method returns the tile at the given coordinates.
     *
     * @param row       The row of the tile.
     * @param col       The column of the tile.
     */
    public ChessSquare getTile(int row, int col) {
        return _chessboard[row][col];
    }
}
