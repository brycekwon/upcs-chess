package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Pawn class
 *
 * This class represents a pawn piece in a game of chess. The pawn can move
 * one square forward. If it is in its starting position, it can move two
 * squares forward. It can capture an enemy piece on the square diagonally in
 * front of it.
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
     * This constructor initializes a pawn with a player.
     *
     * @param playerId      the player the piece belongs to
     */
    public Pawn(int playerId) {
        super(playerId, "Pawn");

    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the pawn.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // check moves from the white player's perspective
        if (_playerId == ChessGameState.PLAYER_1) {

            if (hasValidBounds(_row - 1, _col)) {

                // checked tile is empty
                if (gamestate.getPiece(_row - 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col));
                }

                // can move 2 forward from starting position
                if (_row == 6 && gamestate.getPiece(_row - 2, _col) == null && gamestate.getPiece(_row - 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 2, _col));
                }
            }

            // checked tile has a capturable piece
            if (hasValidBounds(_row - 1, _col - 1) && gamestate.getPiece(_row - 1, _col - 1) != null) {
                if (gamestate.getPiece(_row - 1, _col - 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col - 1));
                }
            }

            // checked tile has a capturable piece
            if (hasValidBounds(_row - 1, _col + 1) && gamestate.getPiece(_row - 1, _col + 1) != null) {
                if (gamestate.getPiece(_row - 1, _col + 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col + 1));
                }
            }
        }

        // check moves from the black player's perspective
        else if (_playerId == ChessGameState.PLAYER_2) {

            if (hasValidBounds(_row + 1, _col)) {

                // checked tile is empty
                if (gamestate.getPiece(_row + 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col));
                }

                // can move 2 forward from starting position
                if (_row == 1 && gamestate.getPiece(_row + 2, _col) == null && gamestate.getPiece(_row + 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 2, _col));
                }
            }


            // checked tile has a capturable piece
            if (hasValidBounds(_row + 1, _col - 1) && gamestate.getPiece(_row + 1, _col - 1) != null) {
                if (gamestate.getPiece(_row + 1, _col - 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col - 1));
                }
            }

            // checked tile has a capturable piece
            if (hasValidBounds(_row + 1, _col + 1) && gamestate.getPiece(_row + 1, _col + 1) != null) {
                if (gamestate.getPiece(_row + 1, _col + 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col + 1));
                }
            }
        }

        return validMoves;
    }
}
