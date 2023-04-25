package com.cs301.chessapp.gamestate.views;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.pieces.Piece;

/**
 * ChessPerspective class
 *
 * This class is the parent class of all chess perspectives. It is an abstract
 * class and is not meant to be instantiated. Each perspective is responsible
 * for displaying the board and pieces specified by the gamestate.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public abstract class ChessPerspective extends SurfaceView {

    // these constants define the dimensions of the board
    public static final float BOARD_LENGTH  = 900f;
    public static final float BOARD_MARGIN  = 50f;
    public static final float TILE_LENGTH   = BOARD_LENGTH / 8;

    // these constants define the location of the board
    public static final float BOARD_LEFT    = BOARD_MARGIN;
    public static final float BOARD_TOP     = BOARD_MARGIN;
    public static final float BOARD_RIGHT   = BOARD_LEFT + BOARD_LENGTH;
    public static final float BOARD_BOTTOM  = BOARD_TOP + BOARD_LENGTH;

    // these constants define the bitmaps of white pieces
    protected final Bitmap W_KING   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wking), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap W_QUEEN  = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wqueen), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap W_BISHOP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wbishop), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap W_KNIGHT = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wknight), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap W_ROOK   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wrook), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap W_PAWN   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wpawn), (int) TILE_LENGTH, (int) TILE_LENGTH, false);

    // these constants define the bitmaps of black pieces
    protected final Bitmap B_KING   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bking), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap B_QUEEN  = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bqueen), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap B_BISHOP = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bbishop), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap B_KNIGHT = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bknight), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap B_ROOK   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.brook), (int) TILE_LENGTH, (int) TILE_LENGTH, false);
    protected final Bitmap B_PAWN   = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bpawn), (int) TILE_LENGTH, (int) TILE_LENGTH, false);

    // the gamestate that this view is displaying
    protected ChessGameState _gamestate;
    protected Piece _currPiece;

    /**
     * ChessPerspective constructor
     *
     * This constructor initializes the surface view.
     *
     * @param context       the context of the application
     */
    public ChessPerspective(Context context) {
        super(context);
        this.init();

        this._gamestate = new ChessGameState();
    }

    /**
     * ChessPerspective constructor
     *
     * This constructor initializes the surface view.
     *
     * @param context       the context of the application
     * @param attrs         the attributes of the view
     */
    public ChessPerspective(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();

        this._gamestate = new ChessGameState();
    }

    /**
     * init
     *
     * This method initializes the settings of the surface view. It is called
     * by the constructors.
     */
    private void init() {
        // allow the view to draw itself
        setWillNotDraw(false);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + (2 * BOARD_MARGIN)));
        setMinimumHeight((int) (BOARD_LENGTH + (2 * BOARD_MARGIN)));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    /**
     * makePaint
     *
     * This method creates a paint object with a specified color and stroke.
     *
     * @param color         the color of the paint
     * @param stroke        the stroke width of the paint
     * @return              the paint object
     */
    protected Paint makePaint(int color, float stroke) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(stroke);
        paint.setTextSize(60);

        return paint;
    }

    /**
     * setCurrPiece
     *
     * This method sets the current selected piece
     *
     * @param piece     the piece selected
     */
    public void setCurrPiece(Piece piece) {
        _currPiece = piece;
    }

    /**
     * setGameState
     *
     * This method sets the gamestate the view is displaying.
     *
     * @param gamestate     the gamestate to display
     */
    public void setGameState(ChessGameState gamestate) {
        _gamestate = gamestate;
    }

    /**
     * getGameState
     *
     * This method returns the gamestate the view is displaying.
     *
     * @return      the gamestate being displayed
     */
    public ChessGameState getGameState() {
        return _gamestate;
    }
}
