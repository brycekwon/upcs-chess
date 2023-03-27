package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

/**
 * Bishop
 * <p>
 * This class represents a knight piece in a game of chess. The bishop can move
 * any number of squares diagonally. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It cannot place its own king in check. It is
 * worth 3 points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Bishop extends Piece {
    private static final String TAG = "Bishop";

    /**
     * Bishop constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * bishop to 3. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Bishop(int player) {
        super(player);
        this._value = 3;
        this._type = "BISHO";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the bishop.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board) {
        ArrayList<MoveAction> valid = new ArrayList<>();

        // searching for moves up right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y+i)) {
                // if square is occupied by another piece
                if (board.isOccupied(x+i, y+i)) {
                    valid.add(new MoveAction(x, x+i, y, y+i));
                    break;
                }
                // if square is empty
                else {
                    valid.add(new MoveAction(x, x+i, y, y+i));
                }
            }
        }

        // searching for moves up left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y+i)) {
                // if square is occupied by another piece
                if (board.isOccupied(x-i, y+i)) {
                    valid.add(new MoveAction(x, x-i, y, y+i));
                    break;
                }
                // if square is empty
                else {
                    valid.add(new MoveAction(x, x-i, y, y+i));
                }
            }
        }

        // searching for moves down right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y-i)) {
                // if square is occupied by another piece
                if (board.isOccupied(x+i, y-i)) {
                    valid.add(new MoveAction(x, x+i, y, y-i));
                    break;
                }
                // if square is empty
                else {
                    valid.add(new MoveAction(x, x+i, y, y-i));
                }
            }
        }

        // searching for moves down left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y-i)) {
                // if square is occupied by another piece
                if (board.isOccupied(x-i, y-i)) {
                    valid.add(new MoveAction(x, x-i, y, y-i));
                    break;
                }
                // if square is empty
                else {
                    valid.add(new MoveAction(x, x-i, y, y-i));
                }
            }
        }

        return valid;
    }
}
