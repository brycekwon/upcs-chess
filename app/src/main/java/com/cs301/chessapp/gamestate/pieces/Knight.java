package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Knight
 *
 * This class represents a knight piece in a game of chess. The knight can move
 * in an L shape. It can jump over pieces. It can capture an enemy piece on the
 * same square. It cannot place itself on a square occupied by a friendly piece.
 * It is worth 3 points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Knight extends Piece {

    /**
     * Knight constructor
     *
     * This constructor initializes a knight with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Knight(int player) {
        super(player);

        this._value = 3;
        this._name = "Knight";
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the knight.
     *
     * @param row           the row of the piece
     * @param col           the col of the piece
     * @param gamestate     the current gamestate
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3) {
                    if (row + i >= 0 && row + i < 8 && col + j >= 0 && col + j < 8) {
                        if (gamestate.getPiece(row + i, col + j) == null) {
                            valid.add(new PieceMove(row, col, row + i, col + j));
                        } else if (gamestate.getPiece(row + i, col + j).getPlayer() != _player) {
                            valid.add(new PieceMove(row, col, row + i, col + j));
                        }
                    }
                }
            }
        }

        return valid;
    }
}
