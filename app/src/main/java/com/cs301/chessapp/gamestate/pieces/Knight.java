package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

/**
 * Knight
 * <p>
 * This class represents a knight piece in a game of chess. The knight can move
 * in an L shape. It can jump over pieces. It can capture an enemy piece on the
 * same square. It cannot place itself on a square occupied by a friendly piece.
 * It cannot place its own king in check. It is worth 3 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class Knight extends Piece {
    private static final String TAG = "PieceKnight";

    /**
     * Knight constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public Knight(int player) {
        super(player);

        this._value = 3;
        this._name = "Knight";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the knight.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param gamestate     The board that the piece is on.
     * @return              The list of valid moves.
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
