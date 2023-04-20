package com.cs301.chessapp.gamestate.pieces;

import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.checkmate.Check;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * King class
 *
 * This class represents a king in the game of chess. The king can move one
 * square in any direction. It is worth an infinite amount of points.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class King extends Piece {

    /**
     * King constructor
     *
     * This constructor initializes a bishop with a player.
     *
     * @param player        the player who owns the king
     */
    public King(int player) {
        super(player, Integer.MAX_VALUE, "King");
    }

    /**
     * getMoves
     *
     * This method returns all valid moves for the king.
     *
     * @param gamestate     the current gamestate
     * @param player        the player making the move
     * @return              a list of valid moves
     */
    @Override
    public ArrayList<ChessMove> getMoves(ChessGameState gamestate, GamePlayer player) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        /*
         * UNSTABLE VERSION OF KING MOVEMENTS
         *
         * CHECKMATE IMPLEMENTED
         */
//        Check checker = new Check(gamestate, player);
//        for (int i = -1; i <= 1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                if (hasValidBounds(_row + i, _col + j)) {
//                    if (gamestate.getPiece(_row + i, _col + j) == null) {
//                        if (!checker.checked(_row + i, _col + j, gamestate)) {
//                            validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
//                        }
//                    } else if (gamestate.getPiece(_row + i, _col + j).getPlayer() != _player) {
//                        if (!checker.checked(_row + i, _col + j, gamestate)) {
//                            validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
//                        }
//                    }
//                }
//            }
//        }

        /*
         * STABLE VERSION OF KING MOVEMENTS
         *
         * NO CHECKMATE IMPLEMENTED
         */
        for (int i = -1; i <= 1; i++) {
            for (int j = - 1; j <= 1; j++) {
                if (hasValidBounds(_row + i, _col + j)) {
                    if (gamestate.getPiece(_row + i, _col + j) == null) {
                        validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
                    } else if (gamestate.getPiece(_row + i, _col + j).getPlayer() != _player) {
                        validMoves.add(new ChessMove(player, _row, _col, _row + i, _col + j));
                    }
                }
            }
        }

        return validMoves;
    }
}
