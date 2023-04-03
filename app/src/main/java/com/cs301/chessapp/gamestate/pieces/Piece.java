package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import android.graphics.Color;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

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
    protected int _player;      // 0 = white, 1 = black
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

        if (player == 0) {
            this._color = Color.WHITE;
        } else {
            this._color = Color.BLACK;
        }
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
    public abstract ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board);

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
     * toString
     * <p>
     * This method returns a string representation of the board.
     *
     * @return  The string representation of the piece.
     */
    @Override
    public String toString() {
        String side;
        if (_player == -1) {
            side = "w";
        } else if (_player == -16777216) {
            side = "b";
        } else {
            side = "u";
        }

//        return _type + " [player=" + side + ", value=" + _value + "]";
        return side + _type;
    }

    public String get_type(){return this._type;}
}
