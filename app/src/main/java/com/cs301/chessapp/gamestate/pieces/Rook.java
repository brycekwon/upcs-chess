package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

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
        super(player, 5, "Rook");
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the king.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        int newRow;
        int newCol;

        boolean blocked_1 = false;
        boolean blocked_2 = false;
        boolean blocked_3 = false;
        boolean blocked_4 = false;

        for (int i = 1; i < 8; i++) {
            if (hasValidBounds(_row, _col + i) && !blocked_1) {
                newRow = _row;
                newCol = _col + i;

                // the tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // the tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayer() != this._player) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_1 = true;
                }

                // the piece is surrounded by own pieces
                else {
                    blocked_1 = true;
                }
            }

            if (hasValidBounds(_row, _col - i) && !blocked_2) {
                newRow = _row;
                newCol = _col - i;

                // the tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // the tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayer() != this._player) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_2 = true;
                }

                // the piece is surrounded by own pieces
                else {
                    blocked_2 = true;
                }
            }

            if (hasValidBounds(_row + i, _col) && !blocked_3) {
                newRow = _row + i;
                newCol = _col;

                // the tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // the tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayer() != this._player) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_3 = true;
                }

                // the piece is surrounded by own pieces
                else {
                    blocked_3 = true;
                }
            }

            if (hasValidBounds(_row - i, _col) && !blocked_4) {
                newRow = _row - i;
                newCol = _col;

                // the tile is empty
                if (gamestate.getPiece(newRow, newCol) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                }

                // the tile has a capturable piece
                else if (gamestate.getPiece(newRow, newCol).getPlayer() != this._player) {
                    validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    blocked_4 = true;
                }

                // the piece is surrounded by own pieces
                else {
                    blocked_4 = true;
                }
            }
        }

        return validMoves;
    }
}
