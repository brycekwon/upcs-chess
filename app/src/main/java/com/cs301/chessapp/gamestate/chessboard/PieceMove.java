package com.cs301.chessapp.gamestate.chessboard;


/**
 * MoveAction
 * <p>
 * This class represents a move in a chess game. It contains the x and y
 * coordinates of the starting and ending positions of the piece that is being
 * moved. The coordinates are immutable after the object is created.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class PieceMove {
    private static final String TAG = "PieceMove";

    private final int _row1;
    private final int _col1;
    private final int _row2;
    private final int _col2;

    /**
     * PieceMove constructor
     * <p>
     * This constructor creates an object that contains the starting and ending
     * positions of a piece. The coordinates are immutable after the object is
     * created.
     *
     * @param row1        row of starting position
     * @param col1        col of starting position
     * @param row2        row of ending position
     * @param col2        col of ending position
     */
    public PieceMove(int row1, int col1, int row2, int col2) {
        this._row1 = row1;
        this._col1 = col1;
        this._row2 = row2;
        this._col2 = col2;
    }

    /**
     * getStart1
     * <p>
     * This method returns the x coordinate of the starting position.
     *
     * @return      x coordinate of starting position
     */
    public int getStartRow() {
        return _row1;
    }

    /**
     * getEndX
     * <p>
     * This method returns the x coordinate of the ending position.
     *
     * @return      x coordinate of ending position
     */
    public int getEndRow() {
        return _row2;
    }

    /**
     * getStartY
     * <p>
     * This method returns the y coordinate of the starting position.
     *
     * @return      y coordinate of starting position
     */
    public int getStartCol() {
        return _col1;
    }

    /**
     * getEndY
     * <p>
     * This method returns the y coordinate of the ending position.
     *
     * @return      y coordinate of ending position
     */
    public int getEndCol() {
        return _col2;
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
