package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

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
 * @version March 17, 2023
 */
public class Knight extends Piece {
    private static final String TAG = "Piece-Knight";

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
        this._type = "Knight";
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
    public ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board) {
        ArrayList<MoveAction> valid = new ArrayList<>();

        // Check all possible L-shaped moves
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                // Check if move is valid
                if (Math.abs(i) + Math.abs(j) == 3) {
                    // Check if move is on the board
                    if (isValid(x + i, y + j)) {
                        // Check if move is to an empty space or an enemy piece
                        valid.add(new MoveAction(x, x + i, y, y + j));
                    }
                }
            }
        }

        return valid;
    }
}
