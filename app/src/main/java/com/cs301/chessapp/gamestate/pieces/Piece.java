package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Piece
 *
 * This abstract class represents a piece in the game of chess. It contains the
 * player that the piece belongs and corresponding color, as well as the value
 * of the piece.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public abstract class Piece {

    // these variables contain information about the piece
    protected final int _player;
    protected int _value;

    // these variables contain information for the surface view
    protected String _name;

    /**
     * Piece constructor
     *
     * This constructor initializes a piece with a player. The value of each
     * piece is determined by the subclass.
     *
     * @param player        the player the piece belongs to
     */
    public Piece(int player) {
        this._player = player;
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the piece. It is an abstract
     * method and is meant to be implemented by the subclass.
     *
     * @param row           the row of the piece
     * @param col           the col of the piece
     * @param gamestate     the current gamestate
     * @return              a list of valid moves
     */
    public abstract ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate);

    /**
     * isValidMove
     *
     * This method checks if a provided move is valid by checking if the move
     * is in the list of valid moves.
     *
     * @param move          the move to validate
     * @param gamestate     the current gamestate
     * @return              true if the move is valid, false otherwise
     */
    public boolean isValidMove(PieceMove move, ChessGameState gamestate) {
        ArrayList<PieceMove> validMoves = this.getMoves(move.getStartRow(), move.getStartCol(), gamestate);

        for (PieceMove validMove : validMoves) {
            if (move.getStartRow() == validMove.getStartRow() && move.getStartCol() == validMove.getStartCol() &&
                    move.getEndRow() == validMove.getEndRow() && move.getEndCol() == validMove.getEndCol()) {
                return true;
            }
        }

        return false;
    }

    /**
     * hasValidBounds
     *
     * This method checks if the provided row and column are within the bounds
     * of the chessboard.
     *
     * @param row       the row to check
     * @param col       the column to check
     * @return          true if within bounds, false otherwise
     */
    protected boolean hasValidBounds(int row, int col) {
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    /**
     * getPlayer
     *
     * This method returns the player that the piece belongs to. The player is
     * determined by the constructor and cannot be changed.
     *
     * @return      the player the piece belongs to
     */
    public int getPlayer() {
        return _player;
    }

    /**
     * getValue
     *
     * This method returns the value of the piece. The value is determined by
     * the subclass and cannot be changed.
     *
     * @return      the value of the piece
     */
    public int getValue() {
        return _value;
    }

    /**
     * getName
     *
     * This method returns the name of the piece. The value is determined by
     * the subclass and cannot be changed.
     *
     * @return      the name of the piece
     */
    public String getName() {
        return _name;
    }
}
