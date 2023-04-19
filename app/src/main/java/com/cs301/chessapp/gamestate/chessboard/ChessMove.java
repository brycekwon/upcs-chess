package com.cs301.chessapp.gamestate.chessboard;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;

/**
 * ChessMove class
 *
 * This class is used to represent a move in the game of chess. It contains the
 * starting and ending positions of the piece that is being moved.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessMove extends GameAction {

    // these variables contain the starting position of the piece
    private final int _row1;
    private final int _col1;

    // these variables contain the ending position of the piece
    private final int _row2;
    private final int _col2;

    public ChessMove(GamePlayer player, int row1, int col1, int row2, int col2) {
        super(player);

        this._row1 = row1;
        this._col1 = col1;
        this._row2 = row2;
        this._col2 = col2;
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
     * getEndCol
     * <p>
     * This method returns the y coordinate of the ending position.
     *
     * @return      y coordinate of ending position
     */
    public int getEndCol() {
        return _col2;
    }
}
