package com.cs301.chessapp.gamestate.utilities;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

public class ChessMoveAction extends GameAction {
    private static final String TAG = "ChessMoveAction";

    private final int _row1;
    private final int _col1;
    private final int _row2;
    private final int _col2;
    private final PieceMove _move;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public ChessMoveAction(GamePlayer player, PieceMove move) {
        super(player);

        this._row1 = move.getStartRow();
        this._col1 = move.getStartCol();
        this._row2 = move.getEndRow();
        this._col2 = move.getEndCol();
        this._move = move;
    }

    /**
     * getStartRow
     * <p>
     * This method returns the x coordinate of the starting position.
     *
     * @return      x coordinate of starting position
     */
    public int getStartRow() {
        return _row1;
    }

    /**
     * getEndRow
     * <p>
     * This method returns the x coordinate of the ending position.
     *
     * @return      x coordinate of ending position
     */
    public int getEndRow() {
        return _row2;
    }

    /**
     * getStartCol
     * <p>
     * This method returns the y coordinate of the starting position.
     *
     * @return      y coordinate of starting position
     */
    public int getStartCol() {
        return _col1;
    }

    /**
     * getEndCol
     * <p>
     * This method returns the y coordinate of the ending position.
     *
     * @return      y coordinate of ending position
     */
    public int getEndCol() {
        return _col2;
    }

    public PieceMove getMove() {
        return _move;
    }

    /**
     * toString
     * <p>
     * This method returns a string representation of the move.
     *
     * @return      string representation of the move
     */
    @Override
    public String toString() {
        return "MoveAction {" +
                "_row1=" + _row1 +
                ", _col1=" + _col1 +
                ", _row2=" + _row2 +
                ", _col2=" + _col2 +
                " }";
    }
}
