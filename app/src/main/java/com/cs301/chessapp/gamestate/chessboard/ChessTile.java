package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessTile class
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
    private final int _row;
    private final int _col;

    // this variable contains the piece on the tile
    private Piece _piece;

    /**
     * ChessSquare constructor
     *
     * This constructor initializes an empty square.
     *
     * @param color     The color of the square
     */
    public ChessTile(int color, int row, int col) {
        this._color = color;
        this._row = row;
        this._col = col;

        this._piece = null;
    }

    /**
     * ChessSquare copy constructor
     *
     * This constructor initializes a copy of another square.
     *
     * @param other     the square to copy
     */
    public ChessTile(ChessTile other) {
        this(other.getColor(), other.getRow(), other.getCol());
        this._piece = other.getPiece();
    }

    /**
     * setPiece
     *
     * This method sets a piece on the square.
     *
     * @param piece     the piece to set on the square
     */
    public void setPiece(Piece piece) {
        if (piece == null) {
            _piece = null;
            return;
        }

        _piece = piece;
        _piece.setRow(_row);
        _piece.setCol(_col);
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

    /**
     * getRow
     *
     * This method returns the row of the tile.
     *
     * @return      the row of the tile
     */
    public int getRow() {
        return _row;
    }

    /**
     * getCol
     *
     * This method returns the col of the tile.
     *
     * @return      the col of the tile
     */
    public int getCol() {
        return _col;
    }
}
