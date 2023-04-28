package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessTile class
 * <p>
 * This class represents a tile on the chessboard. It contains information
 * about its color and occupying piece. Each tile also contains an internal
 * reference to its location on the board. Once initialized, the tile structure
 * cannot be changed. Only its occupying piece can be updated.
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
     * ChessSquare default constructor
     * <p>
     * This constructor initializes an empty square.
     *
     * @param color     color of the chess tile
     * @param row       row of the chessboard
     * @param col       column of the chessboard
     */
    public ChessTile(int color, int row, int col) {
        // initialize variables
        this._color = color;
        this._row = row;
        this._col = col;
        this._piece = null;
    }

    /**
     * ChessSquare copy constructor
     * <p>
     * This constructor initializes a copy of another square.
     *
     * @param other     chess tile to copy
     */
    public ChessTile(ChessTile other) {
        // pass arguments to default constructor
        this(other.getColor(), other.getRow(), other.getCol());
    }

    /**
     * setPiece
     * <p>
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
     * <p>
     * This method returns the current piece on the tile.
     *
     * @return      chess tile's occupying piece
     */
    public Piece getPiece() {
        return _piece;
    }

    /**
     * getColor
     * <p>
     * This method returns the color of the tile.
     *
     * @return      color of the chess tile
     */
    public int getColor() {
        return _color;
    }

    /**
     * getRow
     * <p>
     * This method returns the row of the tile on the chessboard.
     *
     * @return      row of the chessboard
     */
    public int getRow() {
        return _row;
    }

    /**
     * getCol
     * <p>
     * This method returns the column of the tile on the chessboard.
     *
     * @return      column of the chessboard
     */
    public int getCol() {
        return _col;
    }
}
