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

        // Check all squares to the right of the piece
        for (int i = col + 1; i < 8; i++) {
            if (gamestate.getPiece(row, i) == null) {
                valid.add(new PieceMove(row, col, row, i));
            } else if (gamestate.getPiece(row, i).getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row, i));
                break;
            } else {
                break;
            }
        }

        // Check all squares to the left of the piece
        for (int i = col - 1; i >= 0; i--) {
            if (gamestate.getPiece(row, i) == null) {
                valid.add(new PieceMove(row, col, row, i));
            } else if (gamestate.getPiece(row, i).getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, row, i));
                break;
            } else {
                break;
            }
        }

        // Check all squares above the piece
        for (int i = row - 1; i >= 0; i--) {
            if (gamestate.getPiece(i, col) == null) {
                valid.add(new PieceMove(row, col, i, col));
            } else if (gamestate.getPiece(i, col).getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, i, col));
                break;
            } else {
                break;
            }
        }

        // Check all squares below the piece
        for (int i = row + 1; i < 8; i++) {
            if (gamestate.getPiece(i, col) == null) {
                valid.add(new PieceMove(row, col, i, col));
            } else if (gamestate.getPiece(i, col).getPlayer() != this.getPlayer()) {
                valid.add(new PieceMove(row, col, i, col));
                break;
            } else {
                break;
            }
        }

        return valid;
    }
}
