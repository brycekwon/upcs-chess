package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Bishop
 *
 * This class represents a knight piece in a game of chess. The bishop can move
 * any number of squares diagonally. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It is worth 3 points.
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
     * This constructor initializes a bishop with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Bishop(int player) {
        super(player, 3, "Bishop");
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the bishop.
     *
     * @param row           the row of the piece
     * @param col           the col of the piece
     * @param gamestate     the current gamestate
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(int row, int col, ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // check all moves up left
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col - i < 0) {
                break;
            } else if (gamestate.getPiece(row - i, col - i) == null) {
                validMoves.add(new ChessMove(player, row, col, row - i, col - i));
            } else if (gamestate.getPiece(row - i, col - i).getPlayer() != _player) {
                validMoves.add(new ChessMove(player, row, col, row - i, col - i));
                break;
            } else {
                break;
            }
        }

        // check all moves up right
        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col - i < 0) {
                break;
            } else if (gamestate.getPiece(row + i, col - i) == null) {
                validMoves.add(new ChessMove(player, row, col, row + i, col - i));
            } else if (gamestate.getPiece(row + i, col - i).getPlayer() != _player) {
                validMoves.add(new ChessMove(player, row, col, row + i, col - i));
                break;
            } else {
                break;
            }
        }

        // check all moves down left
        for (int i = 1; i < 8; i++) {
            if (row - i < 0 || col + i > 7) {
                break;
            } else if (gamestate.getPiece(row - i, col + i) == null) {
                validMoves.add(new ChessMove(player, row, col, row - i, col + i));
            } else if (gamestate.getPiece(row - i, col + i).getPlayer() != _player) {
                validMoves.add(new ChessMove(player, row, col, row - i, col + i));
                break;
            } else {
                break;
            }
        }

        // check all moves down right
        for (int i = 1; i < 8; i++) {
            if (row + i > 7 || col + i > 7) {
                break;
            } else if (gamestate.getPiece(row + i, col + i) == null) {
                validMoves.add(new ChessMove(player, row, col, row + i, col + i));
            } else if (gamestate.getPiece(row + i, col + i).getPlayer() != _player) {
                validMoves.add(new ChessMove(player, row, col, row + i, col + i));
                break;
            } else {
                break;
            }
        }

        return validMoves;
    }
}
