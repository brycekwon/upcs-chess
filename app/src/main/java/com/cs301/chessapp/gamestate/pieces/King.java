package com.cs301.chessapp.gamestate.pieces;


import java.util.ArrayList;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.checkmate.Check;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

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
 * @version Spring 2023
 */
public class King extends Piece{
    private static final String TAG = "PieceKing";

    private boolean _canCastle;


    /**
     * King constructor
     * <p>
     * This constructor extends the Piece constructor and sets the value and
     * name of the piece.
     *
     * @param player        The player the piece belongs to.
     */
    public King(int player) {
        super(player);

        this._value = 100;
        this._name = "King";
        this._canCastle = true;
    }

    /**
     * getMoves
     * <p>
     * This method returns an ArrayList of all valid moves for the king.
     *
     * @param row           The current row of the piece.
     * @param col           The current col of the piece.
     * @param gamestate     The board that the piece is on.
     * @return              The list of valid moves.
     */
    @Override
    public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
        ArrayList<PieceMove> valid = new ArrayList<>();
        Check checker = new Check(gamestate);
        if(checker.checked(row, col, gamestate) == true){
            return null;
        }
        // Check all squares around the king
        for (int i = - 1; i <= 1; i++) {
            for (int j = - 1; j <= 1; j++) {
                if (hasValidBounds(row + i, col + j)) {
                    if (gamestate.getPiece(row + i, col + j) == null) {
                        valid.add(new PieceMove(row, col, row + i, col + j));
                    } else if (gamestate.getPiece(row + i, col + j).getPlayer() != _player) {
                        valid.add(new PieceMove(row, col, row + i, col + j));
                    }
                }
            }
        }

        return valid;
    }
}
