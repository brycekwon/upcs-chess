package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

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
    private static final String TAG = "Piece-Queen";

    /**
     * Queen constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value of the
     * queen to 7. This value is determined by: https://www.officialgamerules.org/chess
     *
     * @param player        The player the piece belongs to.
     */
    public Queen(int player) {
        super(player);
        this._value = 7;
        this._type = "Queen";
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the queen.
     *
     * @param x         The x coordinate of the piece.
     * @param y         The y coordinate of the piece.
     * @param board     The board that the piece is on.
     * @return          An ArrayList of all valid moves.
     */
    @Override
    public ArrayList<MoveAction> getMoves(int x, int y, ChessBoard board) {
        ArrayList<MoveAction> valid = new ArrayList<>();

        //moves like a bishop
            // moves up right
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

            // moves up left
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

            // moves down right
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

            // moves down left
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

        //moves like a rook
            // move up
            for (int i = 0; i < 8; i++) {
                if (isValid(x, y+i)) {
                    // if the square is occupied
                    if (board.isOccupied(x, y+i)) {
                        valid.add(new MoveAction(x, x, y, y+i));
                        break;
                    } else {
                        valid.add(new MoveAction(x, x, y, y+i));
                    }
                }
            }

            // move down
            for (int i = 0; i < 8; i++) {
                if (isValid(x, y-i)) {
                    if (board.isOccupied(x, y-i)) {
                        valid.add(new MoveAction(x, x, y, y-i));
                        break;
                    } else {
                        valid.add(new MoveAction(x, x, y, y-i));
                    }
                }
            }

            // move left
            for (int i = 0; i < 8; i++) {
                if (isValid(x-i, y)) {
                    if (board.isOccupied(x-i, y)) {
                        valid.add(new MoveAction(x, x-i, y, y));
                        break;
                    } else {
                        valid.add(new MoveAction(x, x-i, y, y));
                    }
                }
            }

            // move right
            for (int i = 0; i < 8; i++) {
                if (isValid(x+i, y)) {
                    if (board.isOccupied(x+i, y)) {
                        valid.add(new MoveAction(x, x+i, y, y));
                        break;
                    } else {
                        valid.add(new MoveAction(x, x+i, y, y));
                    }
                }
            }
        return valid;
    }
}
