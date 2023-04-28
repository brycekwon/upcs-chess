package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Queen class
 * <p>
 * This class represents a queen in the game of chess. The queen can move
 * any number of squares in any direction. It cannot jump over other pieces.
 * It captures pieces by moving to their square. It is a subclass of Piece.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Queen extends Piece {

    /**
     * Queen default constructor
     * <p>
     * This constructor initializes a queen assigned to a player.
     *
     * @param playerId      player assigned to this piece
     */
    public Queen(int playerId) {
        // invoke superclass constructor
        super(playerId, "Queen");
    }

    /**
     * getMoves
     * <p>
     * This method calculates all valid moves for the queen at its current
     * position on the chessboard.
     *
     * @param gamestate     current state of the game
     * @param player        player assigned to this piece
     * @return              valid moves for the queen
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        // initialize an empty list of valid moves
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables specify the new piece location
        int newRow;
        int newCol;
        Piece newPiece;

        // these variables keep track of blocked paths
        boolean blocked_1 = false;
        boolean blocked_2 = false;
        boolean blocked_3 = false;
        boolean blocked_4 = false;
        boolean blocked_5 = false;
        boolean blocked_6 = false;
        boolean blocked_7 = false;
        boolean blocked_8 = false;

        // traverse the board in all directions
        for (int  i = 1; i < 8; i++) {
            if (!blocked_1 && hasValidBounds(_row, _col - i)) {
                newRow = _row;
                newCol = _col - i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_1 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_1 = true;
                }
            }

            if (!blocked_2 && hasValidBounds(_row, _col + i)) {
                newRow = _row;
                newCol = _col + i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_2 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_2 = true;
                }
            }

            if (!blocked_3 && hasValidBounds(_row - i, _col)) {
                newRow = _row - i;
                newCol = _col;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_3 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_3 = true;
                }
            }

            if (!blocked_4 && hasValidBounds(_row + i, _col)) {
                newRow = _row + i;
                newCol = _col;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_4 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_4 = true;
                }
            }

            if (!blocked_5 && hasValidBounds(_row - i, _col - i)) {
                newRow = _row - i;
                newCol = _col - i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_5 = true;
                }

                // checked tile has one of own pieces (invalid move)
                else {
                    blocked_5 = true;
                }
            }

            if (!blocked_6 && hasValidBounds(_row - i, _col + i)) {
                newRow = _row - i;
                newCol = _col + i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_6 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_6 = true;
                }
            }

            if (!blocked_7 && hasValidBounds(_row + i, _col - i)) {
                newRow = _row + i;
                newCol = _col - i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_7 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_7 = true;
                }
            }

            if (!blocked_8 && hasValidBounds(_row + i, _col + i)) {
                newRow = _row + i;
                newCol = _col + i;
                newPiece = gamestate.getPiece(newRow, newCol);

                // current tile is empty (valid move)
                if (newPiece == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // current tile has a capturable piece (last valid move)
                else if (newPiece.getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_8 = true;
                }

                // current tile has one of own pieces (invalid move)
                else {
                    blocked_8 = true;
                }
            }
        }

        // return the list of valid moves
        return validMoves;
    }

    /**
     * getChecks
     * <p>
     * This methods calculates all checkable moves for the queen at its
     * current position on the chessboard. This method is used to determine
     * whether the queen is putting the opposing player's king in check.
     *
     * @param gamestate     current state of the game
     * @return              checkable moves for the queen
     */
    @Override
    public ArrayList<ChessMove> getChecks(ChessGameState gamestate) {
        // initialize the list of valid moves
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables keep track of blocked paths
        boolean blocked_1 = false;
        boolean blocked_2 = false;
        boolean blocked_3 = false;
        boolean blocked_4 = false;
        boolean blocked_5 = false;
        boolean blocked_6 = false;
        boolean blocked_7 = false;
        boolean blocked_8 = false;

        // traverse the board in all directions
        for (int  i = 1; i < 8; i++) {
            if (!blocked_1 && hasValidBounds(_row, _col - i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row, _col - i));
                if (gamestate.getPiece(_row, _col - i) != null) {
                    blocked_1 = true;
                }
            }

            if (!blocked_2 && hasValidBounds(_row, _col + i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row, _col + i));
                if (gamestate.getPiece(_row, _col + i) != null) {
                    blocked_2 = true;
                }
            }

            if (!blocked_3 && hasValidBounds(_row - i, _col)) {
                validMoves.add(new ChessMove(null, _row, _col, _row - i, _col));
                if (gamestate.getPiece(_row - i, _col) != null) {
                    blocked_3 = true;
                }
            }

            if (!blocked_4 && hasValidBounds(_row + i, _col)) {
                validMoves.add(new ChessMove(null, _row, _col, _row + i, _col));
                if (gamestate.getPiece(_row + i, _col) != null) {
                    blocked_4 = true;
                }
            }

            if (!blocked_5 && hasValidBounds(_row - i, _col - i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row - i, _col - i));
                if (gamestate.getPiece(_row - i, _col - i) != null) {
                    blocked_5 = true;
                }
            }

            if (!blocked_6 && hasValidBounds(_row - i, _col + i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row - i, _col + i));
                if (gamestate.getPiece(_row - i, _col + i) != null) {
                    blocked_6 = true;
                }
            }

            if (!blocked_7 && hasValidBounds(_row + i, _col - i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row + i, _col - i));
                if (gamestate.getPiece(_row + i, _col - i) != null) {
                    blocked_7 = true;
                }
            }

            if (!blocked_8 && hasValidBounds(_row + i, _col + i)) {
                validMoves.add(new ChessMove(null, _row, _col, _row + i, _col + i));
                if (gamestate.getPiece(_row + i, _col + i) != null) {
                    blocked_8 = true;
                }
            }
        }

        // return the list of valid moves
        return validMoves;
    }
}
