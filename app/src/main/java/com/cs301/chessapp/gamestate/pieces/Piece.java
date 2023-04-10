package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import android.graphics.Color;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Piece
 * <p>
 * This abstract class represents a piece in a game of chess. It contains the
 * player that the piece belongs and corresponding color, as well as the value
 * of the piece.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public abstract class Piece {

    // these variables contain information about the piece
    protected final int _player;
    protected int _value;

    // these variables contain information for the surface view
    protected final int _color;
    protected String _name;

    /**
     * Piece constructor
     * <p>
     * This constructor initializes the player and color of the piece. The color
     * is determined by the player. Player 0 is white, and player 1 is black. The
     * value of the piece is determined by the subclass.
     *
     * @param player    The player that the piece belongs to.
     */
    public Piece(int player) {
        this._player = player;
        this._color = player == 0 ? Color.BLUE : Color.RED;
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all the possible moves that a piece
     * can make. It is an abstract method, and is implemented by the subclass.
     *
     * @param row         The x coordinate of the piece.
     * @param col         The y coordinate of the piece.
     * @param gamestate   The board that the piece is on.
     * @return            ArrayList of all possible moves
     */
    public abstract ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate);

    /**
     * isValidMove
     * <p>
     * This method checks if a provided move is valid by checking if the move
     * is in the list of valid moves.
     *
     * @param move          The move to check.
     * @param gamestate     The board that the piece is on.
     * @return              True if the move is valid, false otherwise.
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
     * <p>
     * This method checks if the x and y coordinates are within the bounds of
     * the chessboard.
     *
     * @param x     The x coordinate to check.
     * @param y     The y coordinate to check.
     * @return      True if the x and y coordinate is valid, false otherwise.
     */
    public boolean hasValidBounds(int x, int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

    /**
     * getPlayer
     * <p>
     * This method returns the player that the piece belongs to. The player is
     * determined by the constructor and cannot be changed.
     *
     * @return  The player that the piece belongs to.
     */
    public int getPlayer() {
        return _player;
    }

    /**
     * getColor
     * <p>
     * This method returns the color of the piece. The color is determined by
     * the constructor and cannot be changed.
     *
     * @return  The color of the piece.
     */
    public int getColor() {
        return _color;
    }

    /**
     * getValue
     * <p>
     * This method returns the value of the piece. The value is determined by
     * the subclass and cannot be changed.
     *
     * @return  The value of the piece.
     */
    public int getValue() {
        return _value;
    }

    /**
     * getName
     * <p>
     * This method returns the name of the piece. The value is determined by
     * the subclass and cannot be changed.
     *
     * @return  The name of the piece.
     */
    public String getName() {
        return _name;
    }

    /**
     * toString
     * <p>
     * This method returns a string representation of the board.
     *
     * @return  The string representation of the piece.
     */
    @Override
    public String toString() {
        return _name + " { _player=" + _player +
                ", _color=" + _color +
                ", _value=" + _value +
                " }";
    }
}
