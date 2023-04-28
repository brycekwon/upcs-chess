package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * Knight class
 * <p>
 * This class represents a knight in the game of chess. The knight can move
 * in any direction in an L shape. The knight can jump over pieces. It
 * captures pieces by moving to their square. It is a subclass of Piece.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class Knight extends Piece {

    /**
     * Knight default constructor
     * <p>
     * This constructor initializes a knight assigned to a player.
     *
     * @param playerId      player assigned to this piece
     */
    public Knight(int playerId) {
        // invoke superclass constructor
        super(playerId, "Knight");
    }

    /**
     * getMoves
     * <p>
     * This method calculates all valid moves for the knight at its current
     * position on the chessboard.
     *
     * @param gamestate     current state of the game
     * @param player        player assigned to this piece
     * @return              valid moves for the knight
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        // initialize an empty list of valid moves
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // these variables specify the new piece location
        int newRow;
        int newCol;
        Piece newPiece;

        // traverse through all L-shaped moves
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3 && hasValidBounds(_row + i, _col + j)) {
                    newRow = _row + i;
                    newCol = _col + j;
                    newPiece = gamestate.getPiece(newRow, newCol);

                    // current tile is empty (valid move)
                    if (newPiece == null) {
                        validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    }

                    // current tile has a capturable piece (valid move)
                    else if (newPiece.getPlayerId() != _playerId) {
                        validMoves.add(new ChessMove(player, _row, _col, newRow, newCol));
                    }
                }
            }
        }

        // return the list of valid moves
        return validMoves;
    }

    /**
     * getChecks
     * <p>
     * This methods calculates all checkable moves for the knight at its
     * current position on the chessboard. This method is used to determine
     * whether the knight is putting the opposing player's king in check.
     *
     * @param gamestate     current state of the game
     * @return              checkable moves for the knight
     */
    @Override
    public ArrayList<ChessMove> getChecks(ChessGameState gamestate) {
        // initialize an empty list of valid moves
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        // traverse through all L-shaped moves
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
            	if (Math.abs(i) + Math.abs(j) == 3 && hasValidBounds(_row + i, _col + j)) {
                    validMoves.add(new ChessMove(null, _row, _col, _row + i, _col + j));
                }
            }
        }

        // return the list of valid moves
        return validMoves;
    }
}
