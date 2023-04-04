package com.cs301.chessapp.gamestate.pieces;

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
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<PieceMove>();

        // Check if the pawn is in its starting position
        if (this._player == 1 && y == 1) {
            // Check if the pawn can move two squares forward
            if (board[x][y + 2].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, y + 2));
            }
        } else if (this._player == 2 && y == 6) {
            // Check if the pawn can move two squares forward
            if (board[x][y - 2].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, y - 2));
            }
        }

        // Check if the pawn can move one square forward
        if (this._player == 1 && y < 7) {
            // Check if the square is empty
            if (board[x][y + 1].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, y + 1));
            }
        } else if (this._player == 2 && y > 0) {
            // Check if the square is empty
            if (board[x][y - 1].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, y - 1));
            }
        }

        // Check if the pawn can capture an enemy piece
        if (this._player == 1 && y < 7) {
            // Check if the square is occupied by an enemy piece
            if (x > 0 && board[x - 1][y + 1].getPiece() != null && board[x - 1][y + 1].getPiece().getPlayer() == 2) {
                valid.add(new PieceMove(x, y, x - 1, y + 1));
            }
            if (x < 7 && board[x + 1][y + 1].getPiece() != null && board[x + 1][y + 1].getPiece().getPlayer() == 2) {
                valid.add(new PieceMove(x, y, x + 1, y + 1));
            }
        } else if (this._player == 2 && y > 0) {
            // Check if the square is occupied by an enemy piece
            if (x > 0 && board[x - 1][y - 1].getPiece() != null && board[x - 1][y - 1].getPiece().getPlayer() == 1) {
                valid.add(new PieceMove(x, y, x - 1, y - 1));
            }
            if (x < 7 && board[x + 1][y - 1].getPiece() != null && board[x + 1][y - 1].getPiece().getPlayer() == 1) {
                valid.add(new PieceMove(x, y, x + 1, y - 1));
            }
        }

        return valid;
    }
}
