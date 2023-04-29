package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Piece class
 * <p>
 * This abstract class represents a piece in the game of chess. It contains the
 * player that the piece belongs and corresponding color. It is not meant to be
 * instantiated. It is a superclass of all pieces.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public abstract class Piece {

    // these variables specify information about the piece
    protected final int _playerId;
    protected final String _name;

    // these variables contain information about the piece location
    protected int _row;
    protected int _col;

    /**
     * Piece default constructor
     * <p>
     * This constructor initializes a piece assigned to a player.
     *
     * @param playerId      the player the piece belongs to
     */
    public Piece(int playerId, String name) {
        // initialize variables
        this._playerId = playerId;
        this._name = name;
    }

    /**
     * getMoves
     * <p>
     * This method calculates all valid moves for the piece at its current
     * position on the chessboard. It is an abstract method and is meant to be
     * implemented by the subclass.
     *
     * @param gamestate     current state of the game
     * @param player        player assigned to this piece
     * @return              valid moves for the piece
     */
    public abstract ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player);


    /**
     * getChecks
     * <p>
     * This methods calculates all checkable moves for the piece at its
     * current position on the chessboard. This method is used to determine
     * whether the piece is putting the opposing player's king in check. It
     * is an abstract method and is meant to be implemented by the subclass.
     *
     * @param gamestate     current state of the game
     * @return              checkable moves for the piece
     */
    public abstract ArrayList<ChessMove> getChecks(ChessGameState gamestate);

    /**
     * isValidMove
     * <p>
     * This method checks if a provided move is valid by checking if the move
     * is in the list of valid moves.
     *
     * @param move          chess move to validate
     * @param gamestate     current state of the game
     * @return              true if valid, false otherwise
     */
    public boolean isValidMove(ChessMove move, ChessGameState gamestate, GamePlayer player) {
        // calculate valid moves for the piece
        ArrayList<ChessMove> validMoves = getMoves(gamestate, player);

        // check if the move is in the list of valid moves
        for (ChessMove validMove : validMoves) {
            if (move.getStartRow() == validMove.getStartRow() && move.getStartCol() == validMove.getStartCol() &&
                    move.getEndRow() == validMove.getEndRow() && move.getEndCol() == validMove.getEndCol()) {
                return true;
            }
        }
        return false;
    }

    /**
     * hasValidBounds
     * <p>
     * This method checks if the provided row and column are within the bounds
     * of the chessboard.
     *
     * @param row       row to check
     * @param col       column to check
     * @return          true if within bounds, false otherwise
     */
    protected boolean hasValidBounds(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    /**
     * setRow
     * <p>
     * This method sets the row of the piece.
     *
     * @param row       the row to set
     */
    public void setRow(int row) {
        _row = row;
    }

    /**
     * setCol
     * <p>
     * This method sets the column of the piece.
     *
     * @param col       the column to set
     */
    public void setCol(int col) {
        _col = col;
    }

    /**
     * getPlayer
     * <p>
     * This method returns the player that the piece belongs to. The player is
     * determined by the constructor and cannot be changed.
     *
     * @return      the player the piece belongs to
     */
    public int getPlayerId() {
        return _playerId;
    }

    /**
     * getName
     * <p>
     * This method returns the name of the piece. The value is determined by
     * the subclass and cannot be changed.
     *
     * @return      the name of the piece
     */
    public String getName() {
        return _name;
    }
}
