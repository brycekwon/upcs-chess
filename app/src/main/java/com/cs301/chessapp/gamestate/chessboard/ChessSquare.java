package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessSquare
 * <p>
 * This class represents a single tile on the chess board. It contains
 * information on if the square is occupied and the color of the square.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class ChessSquare {
    private static final String TAG = "ChessSquare";

    private final int _color;
    private Piece _piece;

    /**
     * ChessSquare constructor
     * <p>
     * This constructor initializes a square with a piece.
     *
     * @param color     The color of the square.
     * @param piece     The piece on the square.
     */
    public ChessSquare(int color, Piece piece) {
        _color = color;
        _piece = piece;
    }

    /**
     * ChessSquare constructor
     * <p>
     * This constructor initializes an empty square.
     *
     * @param color     The color of the square.
     */
    public ChessSquare(int color) {
        this(color, null);
    }

    /**
     * ChessSquare copy constructor
     * <p>
     * This constructor initializes a copy of another square.
     *
     * @param other    The square to copy.
     */
    public ChessSquare(ChessSquare other) {
        this(other.getColor(), other.getPiece());
    }

    /**
     * setPiece
     * <p>
     * This method sets the piece on the square.
     *
     * @param piece     The piece to set on the square.
     */
    public void setPiece(Piece piece) {
        _piece = piece;
    }

    /**
     * getPiece
     * <p>
     * This method returns the piece on the square.
     *
     * @return          The piece on the square.
     */
    public Piece getPiece() {
        return _piece;
    }

    /**
     * getColor
     * <p>
     * This method returns the color of the square.
     *
     * @return          The color of the square.
     */
    public int getColor() {
        return _color;
    }

    /**
     * toString
     * <p>
     * This method returns a string representation of the square.
     *
     * @return      A string representation of the square.
     */
    @Override
    public String toString() {
        return "ChessSquare { " +
                "_piece=" + _piece +
                ", _color=" + _color +
                " }";
    }
}
