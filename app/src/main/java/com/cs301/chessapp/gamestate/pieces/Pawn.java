package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Pawn
 *
 * This class represents a pawn piece in a game of chess. The pawn can move
 * one square forward. If it is in its starting position, it can move two
 * squares forward. It cannot jump over other pieces. It can capture an enemy
 * piece on the square diagonally in front of it. It cannot place itself on a
 * square occupied by a friendly piece. It is worth 1 point.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Pawn extends Piece {

    /**
     * Pawn constructor
     *
     * This constructor initializes a pawn with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Pawn(int player) {
        super(player, 1, "Pawn");

    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the pawn.
     *
     * @param row           the row of the piece
     * @param col           the col of the piece
     * @param gamestate     the current gamestate
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(int row, int col, ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        if (_player == ChessGameState.PLAYER_1) {
            // can move forward
            if (row - 1 >= 0 && gamestate.getPiece(row - 1, col) == null) {
                validMoves.add(new ChessMove(player, row, col, row - 1, col));

                // can move 2 forward
                if (row == 6 && gamestate.getPiece(row - 2, col) == null) {
                    validMoves.add(new ChessMove(player, row, col, row - 2, col));
                }
            }

            // can capture diagonally left
            if (hasValidBounds(row - 1, col - 1)) {
                if (gamestate.getPiece(row - 1, col - 1) != null && gamestate.getPiece(row - 1, col - 1).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, row, col, row - 1, col - 1));
                }
            }

            // can capture diagonally right
            if (hasValidBounds(row - 1, col + 1)) {
                if (gamestate.getPiece(row - 1, col + 1) != null && gamestate.getPiece(row - 1, col + 1).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, row, col, row - 1, col + 1));
                }
            }
        } else if (_player == ChessGameState.PLAYER_2) {
            // can move forward
            if (row + 1 < 8 && gamestate.getPiece(row + 1, col) == null) {
                validMoves.add(new ChessMove(player, row, col, row + 1, col));

                // can move 2 forward
                if (row == 1 && gamestate.getPiece(row + 2, col) == null) {
                    validMoves.add(new ChessMove(player, row, col, row + 2, col));
                }
            }

            // can capture diagonally left
            if (hasValidBounds(row + 1, col - 1)) {
                if (gamestate.getPiece(row + 1, col - 1) != null && gamestate.getPiece(row + 1, col - 1).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, row, col, row + 1, col - 1));
                }
            }

            // can capture diagonally right
            if (hasValidBounds(row + 1, col + 1)) {
                if (gamestate.getPiece(row + 1, col + 1) != null && gamestate.getPiece(row + 1, col + 1).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, row, col, row + 1, col + 1));
                }
            }
        }

        return validMoves;
    }
}
