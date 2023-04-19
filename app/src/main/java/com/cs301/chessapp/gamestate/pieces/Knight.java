package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Knight
 *
 * This class represents a knight piece in a game of chess. The knight can move
 * in an L shape. It can jump over pieces. It can capture an enemy piece on the
 * same square. It cannot place itself on a square occupied by a friendly piece.
 * It is worth 3 points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Knight extends Piece {

    /**
     * Knight constructor
     *
     * This constructor initializes a knight with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
     */
    public Knight(int player) {
        super(player, 3, "Knight");
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the knight.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables hold the new piece location
        int newRow;
        int newCol;

        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3) {
                    if (hasValidBounds(_row + i, _col + j)) {
                        newRow = _row + i;
                        newCol = _col + j;

                        // the tile is empty
                        if (gamestate.getPiece(newRow, newCol) == null) {
                            validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                        }

                        // the tile has a capturable piece
                        else if (gamestate.getPiece(newRow, newCol).getPlayer() != this._player) {
                            validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                        }
                    }
                }
            }
        }

        return validMoves;
    }
}
