package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;

import com.cs301.chessapp.gameframework.utilities.FlashSurfaceView;
import com.cs301.chessapp.gamestate.ChessGameState;

public class ChessPerspectiveWhite extends FlashSurfaceView {
    private static final String TAG = "ChessPerspectiveWhite";

    // these constants define the dimensions of the board
    public static final float BOARD_LENGTH = 900f;
    public static final float BOARD_MARGIN = 50f;
    public static final float BOARD_STROKE = 5f;
    public static final float TILE_LENGTH = BOARD_LENGTH / 8;
    public static final float TILE_MARGIN = BOARD_MARGIN + BOARD_STROKE / 2;

    private ChessGameState _gameState;

    public ChessPerspectiveWhite(Context context) {
        super(context);
        init();

        this._gameState = new ChessGameState();
    }

    public ChessPerspectiveWhite(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        this._gameState = new ChessGameState();
    }

    private void init() {
        setWillNotDraw(false);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));
        setMinimumHeight((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    // draw the chess board
    public void onDraw(Canvas g) {
        // todo: draw board bigger and centered
        // draw the board
        g.drawRect(BOARD_MARGIN, BOARD_MARGIN, BOARD_MARGIN + BOARD_LENGTH,
                BOARD_MARGIN + BOARD_LENGTH, getPaint(Color.BLACK, BOARD_STROKE));

        // draw the tiles
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g.drawRect(TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH,
                            TILE_MARGIN + (i + 1) * TILE_LENGTH, TILE_MARGIN + (j + 1) * TILE_LENGTH,
                            getPaint(_gameState.getChessboard()[j][i].getColor(), 0));
                } else {
                    g.drawRect(TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH,
                            TILE_MARGIN + (i + 1) * TILE_LENGTH, TILE_MARGIN + (j + 1) * TILE_LENGTH,
                            getPaint(_gameState.getChessboard()[j][i].getColor(), 0));
                }
            }
        }

        // todo: draw the pieces as images
        // draw the pieces as text characters (for now)
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (_gameState.getChessboard()[j][i].getPiece() != null) {
                    switch (_gameState.getChessboard()[j][i].getPiece().getType()) {
                        case "Bishop":
//                            Path draw = _gameState.getChessboard()[j][i].getPiece().getDraw(TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2, TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2);
//                            g.drawPath(draw, getPaint(Color.RED, 10));

                            g.drawText("B", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        case "King":
                            g.drawText("K", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        case "Knight":
                            g.drawText("N", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        case "Pawn":
                            g.drawText("P", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        case "Queen":
                            g.drawText("Q", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        case "Rook":
                            g.drawText("R", TILE_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                    TILE_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                    getPaint(Color.RED, 10));
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private Paint getPaint(int color, float strokeWidth) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        return paint;
    }
}
