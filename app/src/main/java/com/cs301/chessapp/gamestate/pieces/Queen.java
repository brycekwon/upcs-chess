package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Queen
 * <p>
 * This class represents a queen piece in a game of chess. The queen can move
 * any number of squares in any direction. It cannot jump over other pieces.
 * It can capture an enemy piece on any square in any direction. It cannot
 * place itself on a square occupied by a friendly piece. It cannot place its
 * own king in check. It is worth 7 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Queen extends Piece{
    private static final String TAG = "PieceQueen";

    /**
     * Queen constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public Queen(int player) {
        super(player);
        this._value = 9;
        this._name = "Queen";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the queen.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param gamestate     The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        // check all directions left
        for (int i = 1; i < 8; i++) {
            if (col - i >= 0) {
                if (gamestate.getPiece(row, col - i) == null) {
                    valid.add(new PieceMove(row, col, row, col - i));
                } else if (gamestate.getPiece(row, col - i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions right
        for (int i = 1; i < 8; i++) {
            if (col + i < 8) {
                if (gamestate.getPiece(row, col + i) == null) {
                    valid.add(new PieceMove(row, col, row, col + i));
                } else if (gamestate.getPiece(row, col + i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0) {
                if (gamestate.getPiece(row - i, col) == null) {
                    valid.add(new PieceMove(row, col, row - i, col));
                } else if (gamestate.getPiece(row - i, col).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up
        for (int i = 1; i < 8; i++) {
            if (row + i < 8) {
                if (gamestate.getPiece(row + i, col) == null) {
                    valid.add(new PieceMove(row, col, row + i, col));
                } else if (gamestate.getPiece(row + i, col).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + i, col));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up-left
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col - i >= 0) {
                if (gamestate.getPiece(row + i, col - i) == null) {
                    valid.add(new PieceMove(row, col, row + i, col - i));
                } else if (gamestate.getPiece(row + i, col - i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + i, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions up-right
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col + i < 8) {
                if (gamestate.getPiece(row + i, col + i) == null) {
                    valid.add(new PieceMove(row, col, row + i, col + i));
                } else if (gamestate.getPiece(row + i, col + i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row + i, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down-left
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (gamestate.getPiece(row - i, col - i) == null) {
                    valid.add(new PieceMove(row, col, row - i, col - i));
                } else if (gamestate.getPiece(row - i, col - i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - i, col - i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check all directions down-right
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col + i < 8) {
                if (gamestate.getPiece(row - i, col + i) == null) {
                    valid.add(new PieceMove(row, col, row - i, col + i));
                } else if (gamestate.getPiece(row - i, col + i).getPlayer() != _player) {
                    valid.add(new PieceMove(row, col, row - i, col + i));
                    break;
                } else {
                    break;
                }
            }
        }

        return valid;
    }
}
