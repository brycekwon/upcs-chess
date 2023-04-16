package com.cs301.chessapp.gamestate.chessboard;

import static org.junit.Assert.*;

import org.junit.Test;

public class PieceMoveTest {

    @Test
    public void getStartRow() {
        PieceMove move = new PieceMove(1, 1, 2, 2);
        assertEquals(1, move.getStartRow());
    }

    @Test
    public void getStartCol() {
        PieceMove move = new PieceMove(1, 1, 2, 2);
        assertEquals(1, move.getStartCol());
    }

    @Test
    public void getEndRow() {
        PieceMove move = new PieceMove(1, 1, 2, 2);
        assertEquals(2, move.getEndRow());
    }

    @Test
    public void getEndCol() {
        PieceMove move = new PieceMove(1, 1, 2, 2);
        assertEquals(2, move.getEndCol());
    }
}
