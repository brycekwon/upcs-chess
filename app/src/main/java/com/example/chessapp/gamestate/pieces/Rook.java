package com.example.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.example.chessapp.gamestate.chessboard.Board;
import com.example.chessapp.gamestate.chessboard.Move;

/**
 * Rook
 * <p>
 * This class represents a rook piece in a game of chess. The rook can move any
 * number of squares horizontally or vertically. It cannot jump over other
 * pieces. It can capture an enemy piece on the same square. It cannot place
 * itself on a square occupied by a friendly piece. It cannot place its own king
 * in check. It is worth 5 points.
 *
 * @author Bryce Kwon
 * @version March 17, 2023
 */
public class Rook extends Piece {

    /**
     * Rook constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * rook to t. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Rook(int player) {
        super(player);
        this._value = 5;
        this._type = "ROOOK";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the rook.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<Move> getMoves(int x, int y, Board board) {

        ArrayList<Move> valid = new ArrayList<>();

        // search for moves up
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y+i)) {
                // if the square is occupied
                if (board.isOccupied(x, y+i)) {
                    valid.add(new Move(x, x, y, y+i));
                    break;
                } else {
                    valid.add(new Move(x, x, y, y+i));
                }
            }
        }

        // search for moves down
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y-i)) {
                if (board.isOccupied(x, y-i)) {
                    valid.add(new Move(x, x, y, y-i));
                    break;
                } else {
                    valid.add(new Move(x, x, y, y-i));
                }
            }
        }

        // search for moves left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y)) {
                if (board.isOccupied(x-i, y)) {
                    valid.add(new Move(x, x-i, y, y));
                    break;
                } else {
                    valid.add(new Move(x, x-i, y, y));
                }
            }
        }

        // search for moves right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y)) {
                if (board.isOccupied(x+i, y)) {
                    valid.add(new Move(x, x+i, y, y));
                    break;
                } else {
                    valid.add(new Move(x, x+i, y, y));
                }
            }
        }

        return valid;
    }
}
