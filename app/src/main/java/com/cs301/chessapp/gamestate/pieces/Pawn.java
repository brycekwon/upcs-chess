package com.cs301.chessapp.gamestate.pieces;

import android.graphics.Color;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Pawn
 * <p>
 * This class represents a pawn piece in a game of chess. The pawn can move
 * one square forward. If it is in its starting position, it can move two
 * squares forward. It cannot jump over other pieces. It can capture an enemy
 * piece on the square diagonally in front of it. It cannot place itself on a
 * square occupied by a friendly piece. It cannot place its own king in check.
 * It is worth 1 point.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Pawn extends Piece {
    private static final String TAG = "PiecePawn";

    /**
     * Pawn constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * pawn to 1. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Pawn(int player) {
        super(player);
        this._value = 1;
        this._type = "Pawn";

    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the pawn.
     *
     * @param row         The x coordinate of the piece.
     * @param col         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<PieceMove>();

        if (this._player == Color.WHITE) {
            // check if pawn can move forward
            if (row + 1 < 8 && board[row + 1][col].getPiece() == null) {
                valid.add(new PieceMove(row, col, row + 1, col));
            }
            // check if pawn can move forward two spaces
            if (row == 1 && board[row + 1][col].getPiece() == null && board[row + 2][col].getPiece() == null) {
                valid.add(new PieceMove(row, col, row + 2, col));
            }
            // check if pawn can capture a piece diagonally
            if (row + 1 < 8 && col + 1 < 8 && board[row + 1][col + 1].getPiece() != null && board[row + 1][col + 1].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(row, col, row + 1, col + 1));
            }
            // check if pawn can capture a piece diagonally
            if (row + 1 < 8 && col - 1 >= 0 && board[row + 1][col - 1].getPiece() != null && board[row + 1][col - 1].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(row, col, row + 1, col - 1));
            }
        } else {
            // check if pawn can move forward
            if (row - 1 >= 0 && board[row - 1][col].getPiece() == null) {
                valid.add(new PieceMove(row, col, row - 1, col));
            }
            // check if pawn can move forward two spaces
            if (row == 6 && board[row - 1][col].getPiece() == null && board[row - 2][col].getPiece() == null) {
                valid.add(new PieceMove(row, col, row - 2, col));
            }
            // check if pawn can capture a piece diagonally
            if (row - 1 >= 0 && col + 1 < 8 && board[row - 1][col + 1].getPiece() != null && board[row - 1][col + 1].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(row, col, row - 1, col + 1));
            }
        }

        // check if pawn can capture a piece diagonally
        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1].getPiece() != null && board[row - 1][col - 1].getPiece().getPlayer() != this._player) {
            valid.add(new PieceMove(row, col, row - 1, col - 1));
        }

        return valid;
    }
}
