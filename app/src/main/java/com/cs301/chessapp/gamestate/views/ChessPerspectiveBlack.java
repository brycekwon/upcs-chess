package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.cs301.chessapp.gameframework.utilities.Logger;

import com.cs301.chessapp.gamestate.ChessGameState;

public class ChessPerspectiveBlack extends ChessPerspective {
    public ChessPerspectiveBlack(Context context) {
        super(context);
    }

    public ChessPerspectiveBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas g) {
        this.drawBoard(g);
        this.drawPieces(g);

        if (Logger.getDebugValue()) {
            this.drawCoors(g);
        }
    }

    private void drawCoors(Canvas g) {
        Paint paint = makePaint(Color.RED, 0);
        float leftEdge = BOARD_MARGIN + 15f;
        float topEdge = BOARD_MARGIN + 75f;

        for (int row = 7; row >= 0; row--) {
            for (int col = 7; col >= 0; col--) {
                g.drawText(row+":"+col, leftEdge + (col * TILE_LENGTH), topEdge + (row * TILE_LENGTH), paint);
            }
        }
    }

    // draw the board flipped for the black perspective
    private void drawBoard(Canvas g) {
        g.drawRect(BOARD_MARGIN, BOARD_MARGIN, BOARD_MARGIN + BOARD_LENGTH,
                BOARD_MARGIN + BOARD_LENGTH, makePaint(Color.BLACK, 5f));

        for (int row = 7; row >= 0; row--) {
            for (int col = 7; col >= 0; col--) {
                g.drawRect(BOARD_MARGIN + (row * TILE_LENGTH), BOARD_MARGIN + (col * TILE_LENGTH),
                        BOARD_MARGIN + ((row + 1) * TILE_LENGTH), BOARD_MARGIN + ((col + 1) * TILE_LENGTH),
                        makePaint(_gamestate.getTile(row, col).getColor(), 0));
            }
        }
    }

    // draw the pieces flipped for the black perspective
    private void drawPieces(Canvas g) {
        Paint paint = makePaint(Color.BLACK, 0f);
        Bitmap piece;

        for (int row = 7; row >= 0; row--) {
            for (int col = 7; col >= 0; col--) {
                if (_gamestate.getPiece(row, col) == null) {
                    continue;
                }

                float leftEdge = BOARD_MARGIN + (col * TILE_LENGTH);
                float topEdge = BOARD_MARGIN + (row * TILE_LENGTH);

                switch (_gamestate.getPiece(row, col).getName()) {
                    case "King":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_KING : B_KING;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Queen":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_QUEEN : B_QUEEN;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Bishop":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_BISHOP : B_BISHOP;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Knight":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_KNIGHT : B_KNIGHT;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Rook":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_ROOK : B_ROOK;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Pawn":
                        piece = _gamestate.getPiece(row, col).getPlayer() == ChessGameState.PLAYER_1 ? W_PAWN : B_PAWN;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
