package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.cs301.chessapp.gameframework.utilities.FlashSurfaceView;
import com.cs301.chessapp.gamestate.ChessGameState;

public class ChessPerspectiveWhite extends FlashSurfaceView {
    private static final String TAG = "ChessPerspectiveWhite";

    // these constants define the dimensions of the board
    private static final float BOARD_LENGTH = 900f;
    private static final float BOARD_MARGIN = 50f;
    private static final float BOARD_STROKE = 5f;
    private static final float TILE_LENGTH = BOARD_LENGTH / 8;
    private static final float TILE_MARGIN = BOARD_MARGIN + BOARD_STROKE / 2;

    private ChessGameState _gameState;

    public ChessPerspectiveWhite(Context context) {
        super(context);
        setWillNotDraw(false);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));
        setMinimumHeight((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    public ChessPerspectiveWhite(Context context, AttributeSet attrs) {
        super(context, attrs);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));
        setMinimumHeight((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    // draw the chess board
    public void onDraw(Canvas g) {
        // draw the board
        g.drawRect(BOARD_MARGIN, BOARD_MARGIN, BOARD_LENGTH + BOARD_MARGIN, BOARD_LENGTH + BOARD_MARGIN, getPaint(Color.BLACK, BOARD_STROKE));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    // if the sum of the x and y coordinates is even, the square is white
                    g.drawRect(TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, TILE_MARGIN + (i + 1) * TILE_LENGTH, TILE_MARGIN + (j + 1) * TILE_LENGTH, getPaint(Color.WHITE, 0));
                } else {
                    // if the sum of the x and y coordinates is odd, the square is black
                    g.drawRect(TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, TILE_MARGIN + (i + 1) * TILE_LENGTH, TILE_MARGIN + (j + 1) * TILE_LENGTH, getPaint(Color.BLACK, 0));
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
