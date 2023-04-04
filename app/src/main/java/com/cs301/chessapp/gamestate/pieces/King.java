package com.cs301.chessapp.gamestate.pieces;

import android.graphics.Path;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * King
 * <p>
 * This class represents a king piece in a game of chess. The king can move
 * one square in any direction. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It cannot place itself in check. It is worth
 * an infinite amount of points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class King extends Piece{
    private static final String TAG = "PieceKing";

    private boolean _canCastle;

    /**
     * King constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * king to 100. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public King(int player) {
        super(player);

        this._value = 100;
        this._type = "King";
        this._canCastle = true;
    }



    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the king.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<PieceMove>();

        // Check all squares around the king
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Check if the square is on the board
                if (isValid(x + i, y + j)) {
                    // Check if the square is occupied by a friendly piece
                    if (board[x + i][y + j].getPiece() == null || board[x + i][y + j].getPiece().getPlayer() != this._player) {
                        // Check if the king is in check
                        if (!inCheck(x + i, y + j, board)) {
                            // Add the move to the list of valid moves
                            valid.add(new PieceMove(x, y, x + i, y + j));
                        }
                    }
                }
            }
        }

        return valid;
    }

    /**
     * inCheck
     * <p>
     * This method checks if the king is in check.
     *
     * @param x         The x coordinate of the king.
     * @param y         The y coordinate of the king.
     * @param board     The board that the king is on.
     * @return          True if the king is in check, false otherwise.
     */
    public boolean inCheck(int x, int y, ChessSquare[][] board) {
        // Check all squares around the king
        for (int i = - 1; i <= 1; i++) {
            for (int j = - 1; j <= 1; j++) {
                // Check if the square is on the board
                if (x + i >= 0 && x + i < 8 && y + j >= 0 && y + j < 8) {
                    // Check if the square is occupied by an enemy piece
                    if (board[x + i][y + j].getPiece() != null && board[x + i][y + j].getPiece().getPlayer() != this._player) {
                        // Check if the piece can move to the king's square
                        if (board[x + i][y + j].getPiece().getMoves(x + i, y + j, board).contains(new PieceMove(x + i, y + j, x, y))) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
