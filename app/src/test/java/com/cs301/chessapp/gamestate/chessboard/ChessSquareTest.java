package com.cs301.chessapp.gamestate.chessboard;

import static org.junit.Assert.*;

import com.cs301.chessapp.gamestate.pieces.Queen;

import org.junit.Test;

public class ChessSquareTest {

    @Test
    public void setPiece() {
        ChessSquare chessSquare = new ChessSquare(0);

        assertNull(chessSquare.getPiece());

        chessSquare.setPiece(new Queen(0));
        assertEquals(Queen.class, chessSquare.getPiece().getClass());

        chessSquare.setPiece(null);
        assertNull(chessSquare.getPiece());

        ChessSquare chessSquare2 = new ChessSquare(0, new Queen(0));
        assertEquals(Queen.class, chessSquare2.getPiece().getClass());

        chessSquare2.setPiece(null);
        assertNull(chessSquare2.getPiece());
    }
}
