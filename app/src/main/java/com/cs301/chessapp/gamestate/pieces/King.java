package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.checkmate.Check;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * King
 *
 * This class represents a king piece in a game of chess. The king can move
 * one square in any direction. It cannot jump over other pieces. It can
 * capture an enemy piece on the same square. It cannot place itself on a square
 * occupied by a friendly piece. It is worth an infinite amount of points.
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
     * This constructor initializes a king with a player and corresponding
     * value.
     *
     * @param player        the player the piece belongs to
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

//        Check checker = new Check(gamestate);
//                        for (int i = -1; i <= 1; i++) {
//                            for (int j = -1; j <= 1; j++) {
//                                if (hasValidBounds(row + i, col + j)) {
//                                    if (gamestate.getPiece(row + i, col + j) == null) {
//                                        if (false == checker.checked(row + i, col + j, gamestate)) {
//                                            validMoves.add(new PieceMove(row, col, row + i, col + j));
//                                            Log.d("King move", "king valid move checker");
//                                        }
//                                    } else if (gamestate.getPiece(row + i, col + j).getPlayer() != _player) {
//                                        if (false == checker.checked(row + i, col + j, gamestate)) {
//                                            validMoves.add(new PieceMove(row, col, row + i, col + j));
//                                            Log.d("King move", "king valid move checker");
//                                        }
//                                    }
//                                }
//                            }
//                        }


        // Check all squares around the king
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
