package com.cs301.chessapp.gamestate;

import android.graphics.Color;

import com.cs301.chessapp.gameframework.infoMessage.GameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;
import com.cs301.chessapp.gamestate.utilities.ChessTimer;
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
 * @version March 17, 2023
 */
public class ChessGameState extends GameState {
    // Debugging tag used by the Android logger.
    private static final String TAG = "ChessGameState";

    // these variables define the game state
    private int _mode;
    private int _turn;

    // these variables define the game objects
    private ChessSquare[][] _chessboard;
    private ChessTimer _whiteTimer;
    private ChessTimer _blackTimer;

    /**
     * ChessGameState constructor
     * <p>
     * This constructor initializes the game state.
     *
     * @param mode      The game mode. (0 = player, 1 = ai)
     */
    public ChessGameState(int mode) {
        _mode = mode;
        _turn = 0;

        _chessboard = new ChessSquare[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    // if the sum of the x and y coordinates is even, the square is white
                    this._chessboard[i][j] = new ChessSquare(Color.WHITE);
                } else {
                    // if the sum of the x and y coordinates is odd, the square is black
                    this._chessboard[i][j] = new ChessSquare(Color.BLACK);
                }
            }
        }

        // set up the board with the initial white pieces
        this._chessboard[0][0].setPiece(new Rook(Color.WHITE));
        this._chessboard[0][1].setPiece(new Knight(Color.WHITE));
        this._chessboard[0][2].setPiece(new Bishop(Color.WHITE));
        this._chessboard[0][3].setPiece(new Queen(Color.WHITE));
        this._chessboard[0][4].setPiece(new King(Color.WHITE));
        this._chessboard[0][5].setPiece(new Bishop(Color.WHITE));
        this._chessboard[0][6].setPiece(new Knight(Color.WHITE));
        this._chessboard[0][7].setPiece(new Rook(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            this._chessboard[1][i].setPiece(new Pawn(Color.WHITE));
        }

        // set up the board with the initial black pieces
        this._chessboard[7][0].setPiece(new Rook(Color.BLACK));
        this._chessboard[7][1].setPiece(new Knight(Color.BLACK));
        this._chessboard[7][2].setPiece(new Bishop(Color.BLACK));
        this._chessboard[7][3].setPiece(new Queen(Color.BLACK));
        this._chessboard[7][4].setPiece(new King(Color.BLACK));
        this._chessboard[7][5].setPiece(new Bishop(Color.BLACK));
        this._chessboard[7][6].setPiece(new Knight(Color.BLACK));
        this._chessboard[7][7].setPiece(new Rook(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            this._chessboard[6][i].setPiece(new Pawn(Color.BLACK));
        }

        // todo: add timer for black and white in player v player mode
    }

    /**
     * ChessGameState copy constructor
     * <p>
     * This constructor initializes the game state with a copy of another game.
     *
     * @param other     The game state to copy.
     */
    public ChessGameState(ChessGameState other) {
        _mode = other.getMode();
        _turn = other.getTurn();

        _chessboard = other.getChessboard();
        _whiteTimer = other.getWhiteTimer();
        _blackTimer = other.getBlackTimer();

        super.numSetupTurns = other.numSetupTurns;
        super.currentSetupTurn = other.currentSetupTurn;
    }

    /**
     * nextTurn
     * <p>
     * This method increments the turn.
     */
    public void nextTurn() {
        if (_turn == 0) {
            _turn = 1;
        } else {
            _turn = 0;
        }
    }

    // todo: error check move action
    // todo: add functionality for capturing pieces
    // todo: integrate with piece getMoves function
    /**
     * moveTo
     * <p>
     * This method moves a piece from one square to another.
     *
     * @param action    The move action to perform.
     */
    public void moveTo(MoveAction action) {
        int x1 = action.getStartX();
        int y1 = action.getStartY();
        int x2 = action.getEndX();
        int y2 = action.getEndY();

        _chessboard[x2][y2].setPiece(_chessboard[x1][y1].getPiece());
        _chessboard[x1][y1].setPiece(null);
    }

    /**
     * getMode
     * <p>
     * This method returns the game mode.
     *
     * @return          The game mode.
     */
    public int getMode() {
        return _mode;
    }

    /**
     * getTurn
     * <p>
     * This method returns the current turn.
     *
     * @return          The current turn.
     */
    public int getTurn() {
        return _turn;
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
     * getWhiteTimer
     * <p>
     * This method returns the white timer.
     *
     * @return          The white timer.
     */
    public ChessTimer getWhiteTimer() {
        return _whiteTimer;
    }

    /**
     * getBlackTimer
     * <p>
     * This method returns the black timer.
     *
     * @return          The black timer.
     */
    public ChessTimer getBlackTimer() {
        return _blackTimer;
    }
}
