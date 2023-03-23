package com.example.chessapp.gamestate.chessboard;

import android.graphics.Color;
import com.example.chessapp.gamestate.pieces.*;

/**
 * Board
 * <p>
 * This class represents the chess board. It contains a 2D array of Square
 * objects, which represent individual tiles on the board. The board is 8x8,
 * with each square accessible by its x and y coordinates. The top left corner
 * is (0,0), and the bottom right corner is (7,7). The board is initialized
 * with all squares empty (unoccupied).
 *
 * @author Bryce Kwon
 * @version March 17, 2023
 */
public class Board {
    private final Square[][] _gameboard;

    /**
     * Board constructor
     * <p>
     * This constructor initializes the board with all squares empty. It
     * creates a 2D array of Square objects, and then iterates through the
     * array, initializing each square.
     */
    public Board() {
        this._gameboard = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    this._gameboard[i][j] = new Square(Color.WHITE);
                } else {
                    this._gameboard[i][j] = new Square(Color.BLACK);
                }
            }
        }

        // set up the board with the initial white pieces
        this._gameboard[0][0].setPiece(new Rook(Color.WHITE));
        this._gameboard[0][1].setPiece(new Knight(Color.WHITE));
        this._gameboard[0][2].setPiece(new Bishop(Color.WHITE));
        this._gameboard[0][3].setPiece(new Queen(Color.WHITE));
        this._gameboard[0][4].setPiece(new King(Color.WHITE));
        this._gameboard[0][5].setPiece(new Bishop(Color.WHITE));
        this._gameboard[0][6].setPiece(new Knight(Color.WHITE));
        this._gameboard[0][7].setPiece(new Rook(Color.WHITE));
        for (int i = 0; i < 8; i++) {
            this._gameboard[1][i].setPiece(new Pawn(Color.WHITE));
        }

        // set up the board with the initial black pieces
        this._gameboard[7][0].setPiece(new Rook(Color.BLACK));
        this._gameboard[7][1].setPiece(new Knight(Color.BLACK));
        this._gameboard[7][2].setPiece(new Bishop(Color.BLACK));
        this._gameboard[7][3].setPiece(new Queen(Color.BLACK));
        this._gameboard[7][4].setPiece(new King(Color.BLACK));
        this._gameboard[7][5].setPiece(new Bishop(Color.BLACK));
        this._gameboard[7][6].setPiece(new Knight(Color.BLACK));
        this._gameboard[7][7].setPiece(new Rook(Color.BLACK));
        for (int i = 0; i < 8; i++) {
            this._gameboard[6][i].setPiece(new Pawn(Color.BLACK));
        }
    }

    /**
     * moveTo
     * <p>
     * This method moves a piece from one square to another. It takes in a
     * Move object, which contains the x and y coordinates of the starting
     * square and the x and y coordinates of the ending square. It then
     * moves the piece from the starting square to the ending square.
     *
     * @param position      the Move object containing the starting and ending
     */
    public void moveTo(Move position) {
        Piece mover = this._gameboard[position.getStartX()][position.getStartY()].getPiece();
        this._gameboard[position.getEndX()][position.getEndY()].setPiece(mover);
        this._gameboard[position.getStartX()][position.getStartY()].setPiece(null);
    }

    /**
     * promote
     * <p>
     * This method promotes a pawn to another piece. It takes in the x and y
     * coordinates of the pawn, and the piece to promote it to. It then
     * replaces the pawn with the new piece.
     *
     * @param x         x coordinate of the pawn
     * @param y         y coordinate of the pawn
     * @param newPiece  the piece to promote the pawn to
     */
    public void promote(int x, int y, Piece newPiece) {
        this._gameboard[x][y].setPiece(newPiece);
    }

    /**
     * isOccupied
     * <p>
     * This method determines if a square is occupied by a piece.
     *
     * @param x     x coordinate of the square
     * @param y     y coordinate of the square
     * @return      true if the square is occupied, false otherwise
     */
    public boolean isOccupied(int x, int y) {
        return this._gameboard[x][y].getPiece() != null;
    }

    /**
     * getPiece
     * <p>
     * This method returns the current piece on the square.
     *
     * @param x     x coordinate of the square
     * @param y     y coordinate of the square
     * @return      the piece on the square
     */
    public Piece getPiece(int x, int y) {
        return this._gameboard[x][y].getPiece();
    }

    /**
     * getBoard
     * <p>
     * This method returns the current state of the gameboard.
     *
     * @return      the current state of the gameboard
     */
    public Square[][] getBoard() {
        return this._gameboard;
    }

    /**
     * toString
     * <p>
     * This method returns a string representation of the board.
     *
     * @return      a string representation of the board
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this._gameboard[i][j].getPiece() == null) {
                    sb.append("null " + "[" + i + "x" + j + "]" + " ");
                } else {
                    sb.append(this._gameboard[i][j].getPiece().toString()).append("[" + i + "x" + j + "]" + " ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
