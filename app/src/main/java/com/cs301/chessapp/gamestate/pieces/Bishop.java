package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

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
    private static final String TAG = "PieceBishop";

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
        this._type = "Bishop";
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
    public ArrayList<PieceMove> getMoves(int x, int y, ChessSquare[][] board) {
        ArrayList<PieceMove> valid = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            // search for all moves up right
            if (isValid(x+i, y+i)) {

                // check if a piece is blocking the path
                if (board[x+i][y+i] != null) {

                    // if the piece is an enemy piece
                    if (board[x+i][y+i].getPiece().getPlayer() != this._player) {
                        valid.add(new PieceMove(x, y, x+i, y+i));
                    }

                    // if the piece is a friendly piece
                    break;
                }

                // if the square is empty
                else {
                    valid.add(new PieceMove(x, y, x+i, y+i));
                }

            }

            // search for all moves up left
            if (isValid(x-i, y+i)) {

                // check if a piece is blocking the path
                if (board[x-i][y+i] != null) {

                    // if the piece is an enemy piece
                    if (board[x-i][y+i].getPiece().getPlayer() != this._player) {
                        valid.add(new PieceMove(x, y, x-i, y+i));
                    }

                    // if the piece is a friendly piece
                    break;
                }

                // if the square is empty
                else {
                    valid.add(new PieceMove(x, y, x-i, y+i));
                }

            }

            // search for all moves down right
            if (isValid(x+i, y-i)) {

                // check if a piece is blocking the path
                if (board[x+i][y-i] != null) {

                    // if the piece is an enemy piece
                    if (board[x+i][y-i].getPiece().getPlayer() != this._player) {
                        valid.add(new PieceMove(x, y, x+i, y-i));
                    }

                    // if the piece is a friendly piece
                    break;
                }

                // if the square is empty
                else {
                    valid.add(new PieceMove(x, y, x+i, y-i));
                }

            }

            // search for all moves down left
            if (isValid(x-i, y-i)) {

                // check if a piece is blocking the path
                if (board[x-i][y-i] != null) {

                    // if the piece is an enemy piece
                    if (board[x-i][y-i].getPiece().getPlayer() != this._player) {
                        valid.add(new PieceMove(x, y, x-i, y-i));
                    }

                    // if the piece is a friendly piece
                    break;
                }

                // if the square is empty
                else {
                    valid.add(new PieceMove(x, y, x-i, y-i));
                }

            }
        }

        // return the list of valid moves
        return valid;
    }
}
