package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessTile
 *
 * This class represents a single tile on the chess board. It contains
 * information on if the square is occupied and the color of the square.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessTile {

    // these variables contain information about the tile
    private final int _color;
    private Piece _piece;

    /**
     * ChessSquare constructor
     *
     * This constructor initializes a square with a piece.
     *
     * @param color     the color of the square
     * @param piece     the piece on the square
     */
    public ChessTile(int color, Piece piece) {
        _color = color;
        _piece = piece;
    }

    /**
     * ChessSquare constructor
     *
     * This constructor initializes an empty square.
     *
     * @param color     The color of the square
     */
    public ChessTile(int color) {
        this(color, null);
    }

    /**
     * ChessSquare copy constructor
     *
     * This constructor initializes a copy of another square.
     *
     * @param other     the square to copy
     */
    public ChessTile(ChessTile other) {
        this(other.getColor(), other.getPiece());
    }

    /**
     * setPiece
     *
     * This method sets a piece on the square.
     *
     * @param piece     the piece to set on the square
     */
    public void setPiece(Piece piece) {
        _piece = piece;
    }

    /**
     * getPiece
     *
     * This method returns the piece on the square.
     *
     * @return      the piece on the square
     */
    public Piece getPiece() {
        return _piece;
    }

    /**
     * getColor
     *
     * This method returns the color of the square.
     *
     * @return      the color of the square
     */
    public int getColor() {
        return _color;
    }
}
