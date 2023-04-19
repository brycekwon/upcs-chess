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

        // Check all squares to the right of the piece
        for (int i = _col + 1; i < 8; i++) {
            if (gamestate.getPiece(_row, i) == null) {
                validMoves.add(new ChessMove(player, _row, _col, _row, i));
            } else if (gamestate.getPiece(_row, i).getPlayer() != this.getPlayer()) {
                validMoves.add(new ChessMove(player, _row, _col, _row, i));
                break;
            } else {
                break;
            }
        }

        // Check all squares to the left of the piece
        for (int i = _col - 1; i >= 0; i--) {
            if (gamestate.getPiece(_row, i) == null) {
                validMoves.add(new ChessMove(player, _row, _col, _row, i));
            } else if (gamestate.getPiece(_row, i).getPlayer() != this.getPlayer()) {
                validMoves.add(new ChessMove(player, _row, _col, _row, i));
                break;
            } else {
                break;
            }
        }

        // Check all squares above the piece
        for (int i = _row - 1; i >= 0; i--) {
            if (gamestate.getPiece(i, _col) == null) {
                validMoves.add(new ChessMove(player, _row, _col, i, _col));
            } else if (gamestate.getPiece(i, _col).getPlayer() != this.getPlayer()) {
                validMoves.add(new ChessMove(player, _row, _col, i, _col));
                break;
            } else {
                break;
            }
        }

        // Check all squares below the piece
        for (int i = _row + 1; i < 8; i++) {
            if (gamestate.getPiece(i, _col) == null) {
                validMoves.add(new ChessMove(player, _row, _col, i, _col));
            } else if (gamestate.getPiece(i, _col).getPlayer() != this.getPlayer()) {
                validMoves.add(new ChessMove(player, _row, _col, i, _col));
                break;
            } else {
                break;
            }
        }

        return validMoves;
    }
}
