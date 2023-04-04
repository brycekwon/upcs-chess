package com.cs301.chessapp.gamestate.pieces;

import android.graphics.Path;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

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
        this._type = "Queen";
    }

    public Path getDraw(float x, float y) {
        return new Path();
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the queen.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // Check all squares in the same row.
        for (int i = 0; i < 8; i++) {
            if (i != x) {
                if (board[i][y].getPiece() == null) {
                    valid.add(new PieceMove(x, y, i, y));
                } else if (board[i][y].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(x, y, i, y));
                }
            }
        }

        // Check all squares in the same column.
        for (int i = 0; i < 8; i++) {
            if (i != y) {
                if (board[x][i].getPiece() == null) {
                    valid.add(new PieceMove(x, y, x, i));
                } else if (board[x][i].getPiece().getPlayer() != this.getPlayer()) {
                    valid.add(new PieceMove(x, y, x, i));
                }
            }
        }

        // Check all squares in the same diagonal.
        for (int i = 0; i < 8; i++) {
            if (i != x && i != y) {
                if (x + i < 8 && y + i < 8) {
                    if (board[x + i][y + i].getPiece() == null) {
                        valid.add(new PieceMove(x, y, x + i, y + i));
                    } else if (board[x + i][y + i].getPiece().getPlayer() != this.getPlayer()) {
                        valid.add(new PieceMove(x, y, x + i, y + i));
                    }
                }
                if (x - i >= 0 && y - i >= 0) {
                    if (board[x - i][y - i].getPiece() == null) {
                        valid.add(new PieceMove(x, y, x - i, y - i));
                    } else if (board[x - i][y - i].getPiece().getPlayer() != this.getPlayer()) {
                        valid.add(new PieceMove(x, y, x - i, y - i));
                    }
                }
                if (x + i < 8 && y - i >= 0) {
                    if (board[x + i][y - i].getPiece() == null) {
                        valid.add(new PieceMove(x, y, x + i, y - i));
                    } else if (board[x + i][y - i].getPiece().getPlayer() != this.getPlayer()) {
                        valid.add(new PieceMove(x, y, x + i, y - i));
                    }
                }
                if (x - i >= 0 && y + i < 8) {
                    if (board[x - i][y + i].getPiece() == null) {
                        valid.add(new PieceMove(x, y, x - i, y + i));
                    } else if (board[x - i][y + i].getPiece().getPlayer() != this.getPlayer()) {
                        valid.add(new PieceMove(x, y, x - i, y + i));
                    }
                }
            }
        }

        return valid;
    }
}
