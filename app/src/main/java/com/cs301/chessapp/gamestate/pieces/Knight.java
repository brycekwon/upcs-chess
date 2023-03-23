package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.Board;
import com.cs301.chessapp.gamestate.chessboard.Move;

/**
 * Knight
 * <p>
 * This class represents a knight piece in a game of chess. The knight can move
 * in an L shape. It can jump over pieces. It can capture an enemy piece on the
 * same square. It cannot place itself on a square occupied by a friendly piece.
 * It cannot place its own king in check. It is worth 3 points.
 *
 * @author Bryce Kwon
 * @version March 17, 2023
 */
public class Knight extends Piece {

    /**
     * Knight constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * knight to 3. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Knight(int player) {
        super(player);
        this._value = 3;
        this._type = "KNIGH";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the knight.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<Move> getMoves(int x, int y, Board board) {
        ArrayList<Move> valid = new ArrayList<>();

        // Check all possible L-shaped moves
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                // Check if move is valid
                if (Math.abs(i) + Math.abs(j) == 3) {
                    // Check if move is on the board
                    if (isValid(x + i, y + j)) {
                        // Check if move is to an empty space or an enemy piece
                        valid.add(new Move(x, x + i, y, y + j));
                    }
                }
            }
        }

        return valid;
    }
}
