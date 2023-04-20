package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Rook
 *
 * This class represents a rook piece in a game of chess. The rook can move any
 * number of squares horizontally or vertically. It cannot jump over other
 * pieces. It can capture an enemy piece on the same square. It cannot place
 * itself on a square occupied by a friendly piece. It is worth 5 points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Rook extends Piece {

    /**
     * Rook constructor
     *
     * This constructor initializes a rook with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Rook(int player) {
        super(player);

        this._value = 5;
        this._name = "Rook";
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the rook.
     *
     * @param row           the row of the piece
     * @param col           the col of the piece
     * @param gamestate     the current gamestate
     * @return              a list of valid moves
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
