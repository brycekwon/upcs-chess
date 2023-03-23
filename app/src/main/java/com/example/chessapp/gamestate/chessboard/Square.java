package com.example.chessapp.gamestate.chessboard;

import com.example.chessapp.gamestate.pieces.Piece;

/**
 * Square
 * <p>
 * This class represents a single tile on the chess board. It contains
 * information on if the square is occupied.
 * 
 * @author Bryce Kwon
 * @version March 17, 2023
 */
public class Square {
    private Piece _piece;
    private int _color;

    /**
     * Square constructor
     * <p>
     * This constructor initializes the square with a piece and a color.
     * 
     * @param color     the color of the square
     */
    public Square(int color) {
        this._piece = null;
        this._color = color;
    }

    /**
     * getPiece
     * <p>
     * This method returns the piece on the square.
     * 
     * @return      the piece on the square
     */
    public Piece getPiece() {
        return _piece;
    }

    /**
     * setPiece
     * <p>
     * This method sets the piece on the square.
     * 
     * @param piece     the piece to be set
     */
    public void setPiece(Piece piece) {
        _piece = piece;
    }

    /**
     * removePiece
     * <p>
     * This method removes the piece from the square.
     */
    public void removePiece() {
        _piece = null;
    }
    
    /**
     * getColor
     * <p>
     * This method returns the color of the square.
     * 
     * @return      the color of the square
     */
    public int getColor() {
        return _color;
    }
}