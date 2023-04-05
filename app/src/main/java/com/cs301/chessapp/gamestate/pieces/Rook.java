package com.cs301.chessapp.gamestate.pieces;

import android.graphics.Path;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Rook
 * <p>
 * This class represents a rook piece in a game of chess. The rook can move any
 * number of squares horizontally or vertically. It cannot jump over other
 * pieces. It can capture an enemy piece on the same square. It cannot place
 * itself on a square occupied by a friendly piece. It cannot place its own king
 * in check. It is worth 5 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Rook extends Piece {
    private static final String TAG = "PieceRook";

    private boolean _canCastle;

    /**
     * Rook constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * rook to t. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Rook(int player) {
        super(player);
        this._value = 5;
        this._type = "Rook";
        this._canCastle = true;
    }

    public Path getDraw(float x, float y) {
        return new Path();
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the rook.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // check all squares to the right
        for (int i = x + 1; i < 8; i++) {
            // if the square is empty, add it to the list of valid moves
            if (board[i][y].getPiece() == null) {
                valid.add(new PieceMove(x, y, i, y));
            }
            // if the square is occupied by an enemy piece, add it to the list of valid moves
            else if (board[i][y].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(x, y, i, y));
                break;
            }
            // if the square is occupied by a friendly piece, stop checking
            else {
                break;
            }
        }

        // check all squares to the left
        for (int i = x - 1; i >= 0; i--) {
            // if the square is empty, add it to the list of valid moves
            if (board[i][y].getPiece() == null) {
                valid.add(new PieceMove(x, y, i, y));
            }
            // if the square is occupied by an enemy piece, add it to the list of valid moves
            else if (board[i][y].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(x, y, i, y));
                break;
            }
            // if the square is occupied by a friendly piece, stop checking
            else {
                break;
            }
        }

        // check all squares above
        for (int i = y + 1; i < 8; i++) {
            // if the square is empty, add it to the list of valid moves
            if (board[x][i].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, i));
            }
            // if the square is occupied by an enemy piece, add it to the list of valid moves
            else if (board[x][i].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(x, y, x, i));
                break;
            }
            // if the square is occupied by a friendly piece, stop checking
            else {
                break;
            }
        }

        // check all squares below
        for (int i = y - 1; i >= 0; i--) {
            // if the square is empty, add it to the list of valid moves
            if (board[x][i].getPiece() == null) {
                valid.add(new PieceMove(x, y, x, i));
            }
            // if the square is occupied by an enemy piece, add it to the list of valid moves
            else if (board[x][i].getPiece().getPlayer() != this._player) {
                valid.add(new PieceMove(x, y, x, i));
                break;
            }
            // if the square is occupied by a friendly piece, stop checking
            else {
                break;
            }
        }

        return valid;
    }
}
