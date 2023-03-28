package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

/**
 * Pawn
 * <p>
 * This class represents a pawn piece in a game of chess. The pawn can move
 * one square forward. If it is in its starting position, it can move two
 * squares forward. It cannot jump over other pieces. It can capture an enemy
 * piece on the square diagonally in front of it. It cannot place itself on a
 * square occupied by a friendly piece. It cannot place its own king in check.
 * It is worth 1 point.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Pawn extends Piece {
    private static final String TAG = "Piece-Pawn";

    /**
     * Pawn constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * pawn to 1. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Pawn(int player) {
        super(player);
        this._value = 1;
        this._type = "Pawn";

    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the pawn.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board) {
        ArrayList<MoveAction> valid = new ArrayList<MoveAction>();

        //white piece... bottom of the board
        if(this._player == 0 ) {
            if (y == 6) {//checks if it is starting position
                if(board.isOccupied(x, y-1) == false) {
                    valid.add(new MoveAction(x, x, y, y - 1));
                    if (board.isOccupied(x, y-2) == false) {
                        valid.add(new MoveAction(x, x, y, y - 2));
                    }
                }
            }
            //else if(y == 0){
            //}
            else {
                if (isValid(x, y - 1)) {
                    if(board.isOccupied(x,y-1)) {
                        valid.add(new MoveAction(x, x, y, y - 1));
                    }
                }
            }
        }

        //black pieces... top of the board
        else {
            if (y == 1) {
                if(board.isOccupied(x, y-1) == false) {
                    valid.add(new MoveAction(x, x, y, y + 1));
                    if (board.isOccupied(x, y-2) == false) {
                        valid.add(new MoveAction(x, x, y, y + 2));
                    }
                }
            }
            else{
                if (isValid(x, y + 1)) {
                    if(board.isOccupied(x, y+1)== false) {
                        valid.add(new MoveAction(x, x, y, y + 1));
                    }
                }
            }
        }

    return valid;
    }


}
