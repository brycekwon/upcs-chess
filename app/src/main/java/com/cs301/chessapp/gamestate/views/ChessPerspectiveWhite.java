package com.cs301.chessapp.gamestate.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gameframework.utilities.Logger;

import com.cs301.chessapp.gamestate.ChessGameState;

/**
 * ChessPerspectiveWhite class
 *
 * This class is a child class of ChessPerspective. It is responsible for
 * displaying the board and pieces from the perspective of white.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessPerspectiveWhite extends ChessPerspective {
    private Paint pick = new Paint();

    /**
     * ChessPerspectiveWhite constructor
     *
     * This constructor initializes the surface view.
     *
     * @param context       the context of the application
     */
    public ChessPerspectiveWhite(Context context) {
        super(context);
    }

    /**
     * ChessPerspectiveWhite constructor
     *
     * This constructor initializes the surface view.
     *
     * @param context       the context of the application
     * @param attrs         the attributes of the view
     */
    public ChessPerspectiveWhite(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * onDraw
     *
     * This method draws the board and pieces on the canvas. It is called
     * automatically by the system.
     *
     * @param g     the canvas on which to draw
     */
    @Override
    public void onDraw(Canvas g) {
        // draw the board and pieces
        drawBoard(g);
        drawPieces(g);

        // draw chessboard coordinates if debug mode is on
        if (Logger.getDebugValue()) {
            drawCoors(g);
        }

        //Create and use new canvas and paint
        pick = makePaint(R.color.colorPrimary, 10f);

        //Finding the chess piece clicked and it's movable moves, and placing a graphic on each of the squares it can move to
        if(_gamestate.getTurn() == ChessGameState.PLAYER_1) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
//                    if() {
//
//                    }
                }
            }
        }
    }

    /**
     * drawCoors
     *
     * This method draws the chessboard coordinates.
     *
     * @param g     the canvas on which to draw
     */
    private void drawCoors(Canvas g) {
        Paint paint = makePaint(Color.RED, 0);
        float leftEdge = BOARD_MARGIN + 15f;
        float topEdge = BOARD_MARGIN + 75f;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g.drawText(row+":"+col, leftEdge + (col * TILE_LENGTH), topEdge + (row * TILE_LENGTH), paint);
            }
        }
    }

    /**
     * drawBoard
     *
     * This method draws the chessboard.
     *
     * @param g     the canvas on which to draw
     */
    private void drawBoard(Canvas g) {
        Paint paint = makePaint(Color.BLACK, 5f);
        g.drawRect(BOARD_LEFT, BOARD_TOP, BOARD_RIGHT, BOARD_BOTTOM, paint);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g.drawRect(BOARD_MARGIN + (row * TILE_LENGTH), BOARD_MARGIN + (col * TILE_LENGTH),
                        BOARD_MARGIN + ((row + 1) * TILE_LENGTH), BOARD_MARGIN + ((col + 1) * TILE_LENGTH),
                        makePaint(_gamestate.getTile(row, col).getColor(), 0));
            }
        }
    }

    /**
     * drawPieces
     *
     * This method draws the pieces on the board.
     *
     * @param g     the canvas on which to draw
     */
    private void drawPieces(Canvas g) {
        Paint paint = makePaint(Color.BLACK, 0f);
        Bitmap piece;

        float topEdge;
        float leftEdge;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (_gamestate.getPiece(row, col) == null) {
                    continue;
                }

                topEdge = BOARD_MARGIN + (row * TILE_LENGTH);
                leftEdge = BOARD_MARGIN + (col * TILE_LENGTH);

                switch (_gamestate.getPiece(row, col).getName()) {
                    case "King":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_KING : B_KING;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Queen":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_QUEEN : B_QUEEN;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Bishop":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_BISHOP : B_BISHOP;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Knight":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_KNIGHT : B_KNIGHT;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Rook":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_ROOK : B_ROOK;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    case "Pawn":
                        piece = _gamestate.getPiece(row, col).getPlayerId() == ChessGameState.PLAYER_1 ? W_PAWN : B_PAWN;
                        g.drawBitmap(piece, leftEdge, topEdge, paint);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
