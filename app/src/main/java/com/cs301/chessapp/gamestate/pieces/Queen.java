package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Queen
 *
 * This class represents a queen piece in a game of chess. The queen can move
 * any number of squares in any direction. It cannot jump over other pieces.
 * It can capture an enemy piece on any square in any direction. It cannot
 * place itself on a square occupied by a friendly piece. It is worth 7 points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Queen extends Piece {

    /**
     * Queen constructor
     *
     * This constructor initializes a queen with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Queen(int player) {
        super(player, 9, "Queen");
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the queen.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // check all directions left
        for (int i = 1; i < 8; i++) {
            if (_col - i >= 0) {
                if (gamestate.getPiece(_row, _col - i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row, _col - i));
                } else if (gamestate.getPiece(_row, _col - i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row, _col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions right
        for (int i = 1; i < 8; i++) {
            if (_col + i < 8) {
                if (gamestate.getPiece(_row, _col + i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row, _col + i));
                } else if (gamestate.getPiece(_row, _col + i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row, _col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down
        for (int i = 1; i < 8; i++) {
            if (_row - i >= 0) {
                if (gamestate.getPiece(_row - i, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col));
                } else if (gamestate.getPiece(_row - i, _col).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up
        for (int i = 1; i < 8; i++) {
            if (_row + i < 8) {
                if (gamestate.getPiece(_row + i, _col) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col));
                } else if (gamestate.getPiece(_row + i, _col).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up-left
        for (int i = 1; i < 8; i++) {
            if (_row + i < 8 && _col - i >= 0) {
                if (gamestate.getPiece(_row + i, _col - i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col - i));
                } else if (gamestate.getPiece(_row + i, _col - i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up-right
        for (int i = 1; i < 8; i++) {
            if (_row + i < 8 && _col + i < 8) {
                if (gamestate.getPiece(_row + i, _col + i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + i));
                } else if (gamestate.getPiece(_row + i, _col + i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down-left
        for (int i = 1; i < 8; i++) {
            if (_row - i >= 0 && _col - i >= 0) {
                if (gamestate.getPiece(_row - i, _col - i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col - i));
                } else if (gamestate.getPiece(_row - i, _col - i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down-right
        for (int i = 1; i < 8; i++) {
            if (_row - i >= 0 && _col + i < 8) {
                if (gamestate.getPiece(_row - i, _col + i) == null) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col + i));
                } else if (gamestate.getPiece(_row - i, _col + i).getPlayer() != _player) {
                    validMoves.add(new ChessMove(player, _row, _col, _row - i, _col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        return validMoves;
    }
}
