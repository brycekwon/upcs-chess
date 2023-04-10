package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;

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
 * @version Spring 2023
 */
public class King extends Piece{
    private static final String TAG = "PieceKing";

    private boolean _canCastle;

    /**
     * King constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public King(int player) {
        super(player);

        this._value = 100;
        this._name = "King";
        this._canCastle = true;
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the king.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param board         The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<PieceMove>();

        // Check all squares around the king
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Check if the square is on the board
                if (hasValidBounds(row + i, col + j)) {
                    // Check if the square is occupied by a friendly piece
                    if (board[row + i][col + j].getPiece() == null || board[row + i][col + j].getPiece().getPlayer() != _player) {
                        // Check if the king is in check
                        if (!inCheck(row + i, col + j, board)) {
                            // Add the move to the list of valid moves
                            valid.add(new PieceMove(row, col, row + i, col + j));
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
     * @param row         The x coordinate of the king.
     * @param col         The y coordinate of the king.
     * @param board     The board that the king is on.
     * @return          True if the king is in check, false otherwise.
     */
    public boolean inCheck(int row, int col, ChessSquare[][] board) {
        // Check all squares around the king
        for (int i = - 1; i <= 1; i++) {
            for (int j = - 1; j <= 1; j++) {
                // Check if the square is on the board
                if (row + i >= 0 && row + i < 8 && col + j >= 0 && col + j < 8) {
                    // Check if the square is occupied by an enemy piece
                    if (board[row + i][col + j].getPiece() != null && board[row + i][col + j].getPiece().getPlayer() != _player) {
                        // Check if the piece can move to the king's square
                        if (board[row + i][col + j].getPiece().getMoves(row + i, col + j, board).contains(new PieceMove(row + i, col + j, row, col))) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
