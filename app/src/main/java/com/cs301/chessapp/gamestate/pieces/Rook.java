package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;

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
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class Rook extends Piece {
    private static final String TAG = "Piece-Rook";

    private boolean _canCastle;

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
        this._type = "Rook";
        this._canCastle = true;
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
    public ArrayList<MoveAction> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<MoveAction> valid = new ArrayList<>();

        // todo: consolidate this code into less for loops

        // check for moves up
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y+i)) {
                if (board[x][y+i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x, y+i));
                } else if (board[x][y+i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x, y+i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check for moves down
        for (int i = 0; i < 8; i++) {
            if (isValid(x, y-i)) {
                if (board[x][y-i].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x, y-i));
                } else if (board[x][y-i].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x, y-i));
                    break;
                } else {
                    break;
                }
            }
        }

        // check for moves right
        for (int i = 0; i < 8; i++) {
            if (isValid(x+i, y)) {
                if (board[x+i][y].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x+i, y));
                } else if (board[x+i][y].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x+i, y));
                    break;
                } else {
                    break;
                }
            }
        }

        // check for moves left
        for (int i = 0; i < 8; i++) {
            if (isValid(x-i, y)) {
                if (board[x-i][y].getPiece() == null) {
                    valid.add(new MoveAction(x, y, x-i, y));
                } else if (board[x-i][y].getPiece().getPlayer() != this._player) {
                    valid.add(new MoveAction(x, y, x-i, y));
                    break;
                } else {
                    break;
                }
            }
        }

        return valid;
    }
}
