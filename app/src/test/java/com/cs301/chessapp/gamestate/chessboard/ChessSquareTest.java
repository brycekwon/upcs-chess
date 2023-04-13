package com.cs301.chessapp.gamestate.chessboard;

import static org.junit.Assert.*;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.pieces.Piece;

import org.junit.Test;

import java.util.ArrayList;

public class ChessSquareTest {

    @Test
    public void setPiece() {
        Piece piece = new Piece(1) {
            @Override
            public ArrayList<PieceMove> getMoves(int row, int col, ChessGameState gamestate) {
                return null;
            }
        };
    }

    @Test
    public void getPiece() {
    }

    @Test
    public void getColor() {
    }
}