package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gamestate.ChessGameState;

public abstract class ChessPerspective extends SurfaceView {
    public static final float BOARD_LENGTH = 900f;
    public static final float BOARD_MARGIN = 50f;
    public static final float TILE_LENGTH = BOARD_LENGTH / 8;

    protected final Bitmap W_KING = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wking), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap W_QUEEN = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wqueen), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap W_BISHOP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wbishop), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap W_KNIGHT = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wknight), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap W_ROOK = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wrook), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap W_PAWN = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wpawn), (int)TILE_LENGTH, (int)TILE_LENGTH, false);

    protected final Bitmap B_KING = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bking), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap B_QUEEN = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bqueen), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap B_BISHOP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bbishop), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap B_KNIGHT = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bknight), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap B_ROOK = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.brook), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    protected final Bitmap B_PAWN = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bpawn), (int)TILE_LENGTH, (int)TILE_LENGTH, false);

    protected ChessGameState _gamestate;

    public ChessPerspective(Context context) {
        super(context);
        this.init();

        this._gamestate = new ChessGameState();
    }

    public ChessPerspective(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();

        this._gamestate = new ChessGameState();
    }

    private void init() {
        // allow the view to draw itself
        setWillNotDraw(false);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));
        setMinimumHeight((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    public abstract void onDraw(Canvas g);

    protected void drawCoors(Canvas g) {
        Paint paint = makePaint(Color.RED, 0);
        float leftEdge = BOARD_MARGIN + 15f;
        float topEdge = BOARD_MARGIN + 75f;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g.drawText(row+":"+col, leftEdge + (col * TILE_LENGTH), topEdge + (row * TILE_LENGTH), paint);
            }
        }
    }

    protected Paint makePaint(int color, float stroke) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(stroke);

        return paint;
    }

    public void setGameState(ChessGameState gameState) {
        _gamestate = gameState;
    }

    public ChessGameState getGameState() {
        return _gamestate;
    }
}
