package com.cs301.chessapp.gamestate;

import static org.junit.Assert.*;

import org.junit.Test;

public class ChessGameStateTest {

    @Test
    public void nextTurn() {
        ChessGameState gamestate = new ChessGameState();

        assertEquals(0, gamestate.getTurn());
        gamestate.nextTurn();
        assertEquals(1, gamestate.getTurn());
        gamestate.nextTurn();
        assertEquals(0, gamestate.getTurn());
    }
}
