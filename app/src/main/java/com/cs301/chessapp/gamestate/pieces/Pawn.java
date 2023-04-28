package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Pawn class
 * <p>
 * This class represents a pawn in the game of chess. The pawn can move
 * one square forward. If it is in its starting position, it can move two
 * squares forward. It captures pieces diagonally forward. It is a subclass
 * of Piece.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Pawn extends Piece {

    /**
     * Pawn default constructor
     * <p>
     * This constructor initializes a pawn assigned to a player.
     *
     * @param playerId      player assigned to this piece
     */
    public Pawn(int playerId) {
        // invoke superclass constructor
        super(playerId, "Pawn");
    }

    /**
     * getMoves
     * <p>
     * This method calculates all valid moves for the pawn at its current
     * position on the chessboard.
     *
     * @param gamestate     current state of the game
     * @param player        player assigned to this piece
     * @return              valid moves for the pawn
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        // initialize an empty list of valid moves
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // traverse through moves from the white player's perspective
        if (_playerId == ChessGameState.PLAYER_1) {

            // current tile is empty
            if (hasValidBounds(_row - 1, _col) && gamestate.getPiece(_row - 1, _col) == null) {
                validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col));
            }

            // can move 2 forward from starting position
            if (_row == 6) {
                if (gamestate.getPiece(_row - 2, _col) == null && gamestate.getPiece(_row - 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 2, _col));
                }
            }

            // current tile has a capturable piece
            if (hasValidBounds(_row - 1, _col - 1) && gamestate.getPiece(_row - 1, _col - 1) != null) {
                if (gamestate.getPiece(_row - 1, _col - 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col - 1));
                }
            }

            // current tile has a capturable piece
            if (hasValidBounds(_row - 1, _col + 1) && gamestate.getPiece(_row - 1, _col + 1) != null) {
                if (gamestate.getPiece(_row - 1, _col + 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - 1, _col + 1));
                }
            }
        }

        // traverse through moves from the black player's perspective
        else if (_playerId == ChessGameState.PLAYER_2) {

            if (hasValidBounds(_row + 1, _col) && gamestate.getPiece(_row + 1, _col) == null) {
                validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col));
            }

            // can move 2 forward from starting position
            if (_row == 1) {
                if (gamestate.getPiece(_row + 2, _col) == null && gamestate.getPiece(_row + 1, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 2, _col));
                }
            }

            // current tile has a capturable piece
            if (hasValidBounds(_row + 1, _col - 1) && gamestate.getPiece(_row + 1, _col - 1) != null) {
                if (gamestate.getPiece(_row + 1, _col - 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col - 1));
                }
            }

            // current tile has a capturable piece
            if (hasValidBounds(_row + 1, _col + 1) && gamestate.getPiece(_row + 1, _col + 1) != null) {
                if (gamestate.getPiece(_row + 1, _col + 1).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + 1, _col + 1));
                }
            }
        }

        // return the list of valid moves
        return validMoves;
    }

    /**
     * getChecks
     * <p>
     * This methods calculates all checkable moves for the pawn at its
     * current position on the chessboard. This method is used to determine
     * whether the pawn is putting the opposing player's king in check.
     *
     * @param gamestate     current state of the game
     * @return              checkable moves for the pawn
     */
    @Override
    public ArrayList<ChessMove> getChecks(ChessGameState gamestate) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // check moves from the white player's perspective
        if (_playerId == ChessGameState.PLAYER_1) {

//            // current tile is empty
//            if (hasValidBounds(_row - 1, _col) && gamestate.getPiece(_row - 1, _col) == null) {
//                validMoves.add(new ChessMove(null, _row, _col, _row - 1, _col));
//            }
//
//            // can move 2 forward from starting position
//            if (_row == 6) {
//                if (gamestate.getPiece(_row - 2, _col) == null && gamestate.getPiece(_row - 1, _col) == null) {
//                    validMoves.add(new ChessMove(null, _row, _col, _row - 2, _col));
//                }
//            }

            // checked tile has a capturable piece
            if (hasValidBounds(_row - 1, _col - 1)) {
                validMoves.add(new ChessMove(null, _row, _col, _row - 1, _col - 1));
            }

            // checked tile has a capturable piece
            if (hasValidBounds(_row - 1, _col + 1)) {
                validMoves.add(new ChessMove(null, _row, _col, _row - 1, _col + 1));
            }
        }

        // check moves from the black player's perspective
        else if (_playerId == ChessGameState.PLAYER_2) {

//            if (hasValidBounds(_row + 1, _col) && gamestate.getPiece(_row + 1, _col) == null) {
//                validMoves.add(new ChessMove(null, _row, _col, _row + 1, _col));
//            }
//
//            // can move 2 forward from starting position
//            if (_row == 1) {
//                if (gamestate.getPiece(_row + 2, _col) == null && gamestate.getPiece(_row + 1, _col) == null) {
//                    validMoves.add(new ChessMove(null, _row, _col, _row + 2, _col));
//                }
//            }

            // current tile has a capturable piece
            if (hasValidBounds(_row + 1, _col - 1)) {
                validMoves.add(new ChessMove(null, _row, _col, _row + 1, _col - 1));
            }

            // current tile has a capturable piece
            if (hasValidBounds(_row + 1, _col + 1)) {
                validMoves.add(new ChessMove(null, _row, _col, _row + 1, _col + 1));
            }
        }

        // return the list of valid moves
        return validMoves;
    }
}
