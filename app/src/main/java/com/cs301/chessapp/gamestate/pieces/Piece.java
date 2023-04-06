package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.Path;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
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
 * @version March 17, 2023
 */
public abstract class Piece {
    private static final String TAG = "Piece";

    protected String _type;
    protected int _player;
    protected int _color;
    protected int _value;

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
        this._color = player == 0 ? Color.WHITE : Color.BLACK;
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all the possible moves that a piece
     * can make. It is an abstract method, and is implemented by the subclass.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          ArrayList of all possible moves
     */
    public abstract ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board);

    /**
     * isValid
     * <p>
     * This method checks if the x and y coordinates are within the bounds of
     * the gameboard.
     *
     * @param x     The x coordinate to check.
     * @param y     The y coordinate to check.
     * @return      True if the x and y coordinate is valid, false otherwise.
     */
    public boolean isValid(int x, int y) {
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
        return this._player;
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
        return this._color;
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
        return this._value;
    }

    /**
     * getType
     * <p>
     * This method returns the type of the piece. The type is determined by
     * the subclass and cannot be changed.
     *
     * @return  The type of the piece.
     */
    public String getType() {
        return this._type;
    }

    public boolean isValidMove(int x, int y, int newX, int newY, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = this.getMoves(x, y, board);
        for (PieceMove move : valid) {
            if (move.getEndX() == newX && move.getEndY() == newY) {
                return true;
            }
        }
        return false;
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
        return _type.charAt(0) + "";
    }
}
