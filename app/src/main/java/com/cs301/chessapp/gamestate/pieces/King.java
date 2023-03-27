package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

/**
 * King
 * <p>
 * This class represents a king piece in a game of chess. The king can move
 * one square in any direction. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It cannot place itself in check. It is worth
 * an infinite amount of points.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class King extends Piece{
    private static final String TAG = "King";

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
    public ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board) {
        ArrayList<MoveAction> valid = new ArrayList<MoveAction>();

            if(isValid(x, y+1)){//moves down
                if(board.isOccupied(x, y+1)) {
                    valid.add(new MoveAction(x, x, y, y + 1));
                }
            }
            if(isValid(x, y-1)){//moves up
                if(board.isOccupied(x, y-1)) {
                    valid.add(new MoveAction(x, x, y, y - 1));
                }
            }
            if(isValid(x+1,y)){//moves right
                if(board.isOccupied(x+1, y)) {
                    valid.add(new MoveAction(x, x + 1, y, y));
                }
            }
            if(isValid(x-1,y)){//moves left
                if(board.isOccupied(x+1, y)) {
                    valid.add(new MoveAction(x, x - 1, y, y));
                }
            }
            if(isValid(x, y+1)){//moves up and left
                if(board.isOccupied(x-1, y-1)) {
                    valid.add(new MoveAction(x, x - 1, y, y - 1));
                }
            }
            if(isValid(x, y-1)){//moves up and right
                if(board.isOccupied(x+1, y-1)) {
                    valid.add(new MoveAction(x, x + 1, y, y - 1));
                }
            }
            if(isValid(x+1,y)){//moves down and right
                if(board.isOccupied(x+1, y+1)) {
                    valid.add(new MoveAction(x, x + 1, y, y + 1));
                }
            }
            if(isValid(x-1,y)){//moves down and left
                if(board.isOccupied(x-1, y+1)) {
                    valid.add(new MoveAction(x, x - 1, y, y + 1));
                }
            }

        return valid;
    }
}
