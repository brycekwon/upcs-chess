package com.cs301.chessapp.gamestate.chessboard;


/**
 * MoveAction
 *
 * This class represents a move in a chess game. It contains the row and col
 * of the starting and ending positions of the piece that is being moved. The
 * coordinates are immutable after the object is created.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class PieceMove {

    // these variables contain the starting position of the piece
    private final int _row1;
    private final int _col1;

    // these variables contain the ending position of the piece
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
     * getStartRow
     *
     * This method returns the row of the starting position.
     *
     * @return      row of starting position
     */
    public int getStartRow() {
        return _row1;
    }

    /**
     * getStartCol
     *
     * This method returns the column of the starting position.
     *
     * @return      column of starting position
     */
    public int getStartCol() {
        return _col1;
    }

    /**
     * getEndRow
     *
     * This method returns the row of the ending position.
     *
     * @return      row of ending position
     */
    public int getEndRow() {
        return _row2;
    }

    /**
     * getEndCol
     *
     * This method returns the column of the ending position.
     *
     * @return      column of ending position
     */
    public int getEndCol() {
        return _col2;
    }
}
