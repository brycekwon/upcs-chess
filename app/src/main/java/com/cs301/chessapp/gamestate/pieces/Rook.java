package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
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
 * @version Spring 2023
 */
public class Rook extends Piece {
    private static final String TAG = "PieceRook";

    private boolean _canCastle;

    /**
     * Rook constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public Rook(int player) {
        super(player);

        this._value = 5;
        this._name = "Rook";
        this._canCastle = true;
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the rook.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param gamestate     The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // check all squares to the right
        for (int i = 1; i < 8; i++) {
            if (row + i < 8) {
                if (gamestate.getPiece(row + i, col) == null) {
                    valid.add(new PieceMove(row, col, row + i, col));
                } else if (gamestate.getPiece(row + i, col).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all squares to the left
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0) {
                if (gamestate.getPiece(row - i, col) == null) {
                    valid.add(new PieceMove(row, col, row - i, col));
                } else if (gamestate.getPiece(row - i, col).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all squares above
        for (int i = 1; i < 8; i++) {
            if (col + i < 8) {
                if (gamestate.getPiece(row, col + i) == null) {
                    valid.add(new PieceMove(row, col, row, col + i));
                } else if (gamestate.getPiece(row, col + i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all squares below
        for (int i = 1; i < 8; i++) {
            if (col - i >= 0) {
                if (gamestate.getPiece(row, col - i) == null) {
                    valid.add(new PieceMove(row, col, row, col - i));
                } else if (gamestate.getPiece(row, col - i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        return valid;
    }
}
