package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessTile class
 *
 * This class represents a tile on the chess board. It contains information on
 * its color and occupying piece. It also contains an internal reference to
 * its position on the chessboard.
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

    // this variable specifies the current piece on the tile
    private Piece _piece;

    /**
     * ChessSquare constructor
     *
     * This constructor initializes an empty square.
     *
     * @param color     the color of the tile
     * @param row       row on the chessboard
     * @param col       column on the chessboard
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
        this._color = other.getColor();
        this._row = other.getRow();
        this._col = other.getCol();
    }

    /**
     * setPiece
     *
     * This method sets a piece on the tile and updates the piece's position.
     *
     * @param piece     the piece to place on the tile
     */
    public void setPiece(Piece piece) {
        if (piece != null) {
            piece.setRow(_row);
            piece.setCol(_col);
        }

        _piece = piece;
    }

    /**
     * getPiece
     *
     * This method returns the piece on the tile.
     *
     * @return      the piece on the tile
     */
    public Piece getPiece() {
        return _piece;
    }

    /**
     * getColor
     *
     * This method returns the color of the tile.
     *
     * @return      the color of the tile
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
     * This method returns the column of the tile.
     *
     * @return      the column of the tile
     */
    public int getCol() {
        return _col;
    }
}
