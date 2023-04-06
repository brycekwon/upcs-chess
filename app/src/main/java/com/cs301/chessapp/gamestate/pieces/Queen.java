package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;

/**
 * Queen
 * <p>
 * This class represents a queen piece in a game of chess. The queen can move
 * any number of squares in any direction. It cannot jump over other pieces.
 * It can capture an enemy piece on any square in any direction. It cannot
 * place itself on a square occupied by a friendly piece. It cannot place its
 * own king in check. It is worth 7 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Queen extends Piece{
    private static final String TAG = "PieceQueen";

    /**
     * Queen constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * queen to 7. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Queen(int player) {
        super(player);
        this._value = 9;
        this._name = "Queen";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the queen.
     *
     * @param row         The x coordinate of the piece.
     * @param col         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // check all directions
        for (int i = 1; i < 8; i++) {
            // check up
            if (col - i >= 0) {
                if (board[row][col - i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row, col - i));
                } else if (board[row][col - i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check down
            if (col + i < 8) {
                if (board[row][col + i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row, col + i));
                } else if (board[row][col + i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check left
            if (row - i >= 0) {
                if (board[row - i][col].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row - i, col));
                } else if (board[row - i][col].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row - i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check right
            if (row + i < 8) {
                if (board[row + i][col].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row + i, col));
                } else if (board[row + i][col].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row + i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check up-left
            if (row - i >= 0 && col - i >= 0) {
                if (board[row - i][col - i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row - i, col - i));
                } else if (board[row - i][col - i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row - i, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check up-right
            if (row + i < 8 && col - i >= 0) {
                if (board[row + i][col - i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row + i, col - i));
                } else if (board[row + i][col - i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row + i, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check down-left
            if (row - i >= 0 && col + i < 8) {
                if (board[row - i][col + i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row - i, col + i));
                } else if (board[row - i][col + i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row - i, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 8; i++) {
            // check down-right
            if (row + i < 8 && col + i < 8) {
                if (board[row + i][col + i].getPiece() == null) {
                    valid.add(new PieceMove(row, col, row + i, col + i));
                } else if (board[row + i][col + i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(row, col, row + i, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        return valid;
    }
}
