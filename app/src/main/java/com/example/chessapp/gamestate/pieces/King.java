package com.example.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.example.chessapp.gamestate.chessboard.Board;
import com.example.chessapp.gamestate.chessboard.Move;

/**
 * King
 * <p>
 * This class represents a king piece in a game of chess. The king can move
 * one square in any direction. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It cannot place itself in check. It is worth
 * an infinite amount of points.
 *
 * @author Marshall Zhang
 * @version March 17, 2023
 */
public class King extends Piece{

    /**
     * King constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * king to 100. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public King(int player) {
        super(player);
        this._value = 100;
        this._type = "KINGG";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the king.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<Move> getMoves(int x, int y, Board board) {
        ArrayList<Move> valid = new ArrayList<Move>();

            if(isValid(x, y+1)){//moves down
                if(board.isOccupied(x, y+1)) {
                    valid.add(new Move(x, x, y, y + 1));
                }
            }
            if(isValid(x, y-1)){//moves up
                if(board.isOccupied(x, y-1)) {
                    valid.add(new Move(x, x, y, y - 1));
                }
            }
            if(isValid(x+1,y)){//moves right
                if(board.isOccupied(x+1, y)) {
                    valid.add(new Move(x, x + 1, y, y));
                }
            }
            if(isValid(x-1,y)){//moves left
                if(board.isOccupied(x+1, y)) {
                    valid.add(new Move(x, x - 1, y, y));
                }
            }
            if(isValid(x, y+1)){//moves up and left
                if(board.isOccupied(x-1, y-1)) {
                    valid.add(new Move(x, x - 1, y, y - 1));
                }
            }
            if(isValid(x, y-1)){//moves up and right
                if(board.isOccupied(x+1, y-1)) {
                    valid.add(new Move(x, x + 1, y, y - 1));
                }
            }
            if(isValid(x+1,y)){//moves down and right
                if(board.isOccupied(x+1, y+1)) {
                    valid.add(new Move(x, x + 1, y, y + 1));
                }
            }
            if(isValid(x-1,y)){//moves down and left
                if(board.isOccupied(x-1, y+1)) {
                    valid.add(new Move(x, x - 1, y, y + 1));
                }
            }

        return valid;
    }
}
