package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
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
 * @version Spring 2023
 */
public class Pawn extends Piece {
    private static final String TAG = "PiecePawn";

    /**
     * Pawn constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public Pawn(int player) {
        super(player);
        this._value = 1;
        this._name = "Pawn";

    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the pawn.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param gamestate     The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        if (_player == ChessGameState.PLAYER_1) {
            // can move forward
            if (row - 1 >= 0 && gamestate.getPiece(row - 1, col) == null) {
                valid.add(new PieceMove(row, col, row - 1, col));

                // can move 2 forward
                if (row == 6 && gamestate.getPiece(row - 2, col) == null) {
                    valid.add(new PieceMove(row, col, row - 2, col));
                }
            }

            // can capture diagonally left
            if (hasValidBounds(row - 1, col - 1)) {
                if (gamestate.getPiece(row - 1, col - 1) != null && gamestate.getPiece(row - 1, col - 1).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - 1, col - 1));
                }
            }

            // can capture diagonally right
            if (hasValidBounds(row - 1, col + 1)) {
                if (gamestate.getPiece(row - 1, col + 1) != null && gamestate.getPiece(row - 1, col + 1).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - 1, col + 1));
                }
            }
        } else if (_player == ChessGameState.PLAYER_2) {
            // can move forward
            if (row + 1 < 8 && gamestate.getPiece(row + 1, col) == null) {
                valid.add(new PieceMove(row, col, row + 1, col));

                // can move 2 forward
                if (row == 2 && gamestate.getPiece(row + 2, col) == null) {
                    valid.add(new PieceMove(row, col, row + 2, col));
                }
            }

            // can capture diagonally left
            if (hasValidBounds(row + 1, col - 1)) {
                if (gamestate.getPiece(row + 1, col - 1) != null && gamestate.getPiece(row + 1, col - 1).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + 1, col - 1));
                }
            }

            // can capture diagonally right
            if (hasValidBounds(row + 1, col + 1)) {
                if (gamestate.getPiece(row + 1, col + 1) != null && gamestate.getPiece(row + 1, col + 1).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + 1, col + 1));
                }
            }
        }

        return valid;
    }
}
