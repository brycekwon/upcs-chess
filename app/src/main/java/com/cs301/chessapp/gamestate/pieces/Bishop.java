package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Bishop class
 *
 * This class represents a knight in the game of chess. The bishop can move
 * any number of squares diagonally. It is worth 3 points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Bishop extends Piece {

    /**
     * Bishop constructor
     *
     * This constructor initializes a bishop with a player.
     *
     * @param player        the player who owns the bishop
     */
    public Bishop(int player) {
        super(player, "Bishop");
    }

    public Bishop(Bishop other) {
        super(other);
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the bishop.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables specify the new piece location
        int newRow;
        int newCol;

        // these variables keep track of blocked paths
        boolean blocked_1 = false;
        boolean blocked_2 = false;
        boolean blocked_3 = false;
        boolean blocked_4 = false;

        for (int i = 1; i < 8; i++) {
            if (!blocked_1 && hasValidBounds(_row - i, _col - i)) {
                newRow = _row - i;
                newCol = _col - i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_1 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_1 = true;
                }
            }

            if (!blocked_2 && hasValidBounds(_row + i, _col - i)) {
                newRow = _row + i;
                newCol = _col - i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_2 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_2 = true;
                }
            }

            if (!blocked_3 && hasValidBounds(_row - i, _col + i)) {
                newRow = _row - i;
                newCol = _col + i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_3 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_3 = true;
                }
            }

            if (!blocked_4 && hasValidBounds(_row + i, _col + i)) {
                newRow = _row + i;
                newCol = _col + i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_4 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_4 = true;
                }
            }
        }

        return validMoves;
    }

    public ArrayList<ChessMove> getChecks(ChessGameState gamestate) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables specify the new piece location
        int newRow;
        int newCol;

        // these variables keep track of blocked paths
        boolean blocked_1 = false;
        boolean blocked_2 = false;
        boolean blocked_3 = false;
        boolean blocked_4 = false;

        for (int i = 1; i < 8; i++) {
            if (!blocked_1 && hasValidBounds(_row - i, _col - i)) {
                newRow = _row - i;
                newCol = _col - i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_1 = true;
                }

                // checked tile has one of own pieces
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() == _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_1 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_1 = true;
                }
            }

            if (!blocked_2 && hasValidBounds(_row + i, _col - i)) {
                newRow = _row + i;
                newCol = _col - i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_2 = true;
                }

                // checked tile has one of own pieces
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() == _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_2 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_2 = true;
                }
            }

            if (!blocked_3 && hasValidBounds(_row - i, _col + i)) {
                newRow = _row - i;
                newCol = _col + i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_3 = true;
                }

                // checked tile has one of own pieces
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() == _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_3 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_3 = true;
                }
            }

            if (!blocked_4 && hasValidBounds(_row + i, _col + i)) {
                newRow = _row + i;
                newCol = _col + i;

                // checked tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                }

                // checked tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() != _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_4 = true;
                }

                // checked tile has one of own pieces
                else if (gamestate.getPiece(newRow, newCol).getPlayerId() == _playerId) {
                    validMoves.add(new ChessMove(_tempPlayer, _row, _col, newRow, newCol));
                    blocked_4 = true;
                }

                // checked tile has one of own pieces
                else {
                    blocked_4 = true;
                }
            }
        }

        return validMoves;
    }
}
