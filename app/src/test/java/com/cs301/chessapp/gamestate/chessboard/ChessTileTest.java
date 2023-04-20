package com.cs301.chessapp.gamestate.chessboard;

import static org.junit.Assert.*;

import com.cs301.chessapp.gamestate.pieces.Queen;

import org.junit.Test;

public class ChessTileTest {

    @Test
    public void setPiece() {
        ChessTile chessSquare = new ChessTile(0);

        assertNull(chessSquare.getPiece());

        chessSquare.setPiece(new Queen(0));
        assertEquals(Queen.class, chessSquare.getPiece().getClass());

        chessSquare.setPiece(null);
        assertNull(chessSquare.getPiece());

        ChessTile chessSquare2 = new ChessTile(0, new Queen(0));
        assertEquals(Queen.class, chessSquare2.getPiece().getClass());

        chessSquare2.setPiece(null);
        assertNull(chessSquare2.getPiece());
    }
}
