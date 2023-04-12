package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gameframework.utilities.FlashSurfaceView;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.ChessGameState;

public class ChessPerspectiveWhite extends FlashSurfaceView {
    private static final String TAG = "ChessPerspectiveWhite";

    Bitmap bBishop = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bbishop), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap bKing = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bking), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap bKnight = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bknight), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap bPawn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bpawn), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap bRook = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.brook), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap bQueen = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.bqueen), (int)TILE_LENGTH, (int)TILE_LENGTH, false);

    Bitmap wBishop = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wbishop), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap wKing = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wking), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap wKnight = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wknight), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap wPawn = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wpawn), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap wRook = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wrook), (int)TILE_LENGTH, (int)TILE_LENGTH, false);
    Bitmap wQueen = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.wqueen), (int)TILE_LENGTH, (int)TILE_LENGTH, false);


    // these constants define the dimensions of the board
    public static final float BOARD_LENGTH = 900f;
    public static final float BOARD_MARGIN = 50f;
    public static final float BOARD_STROKE = 5f;
    public static final float TILE_LENGTH = BOARD_LENGTH / 8;
//    public static final float TILE_MARGIN = BOARD_MARGIN + BOARD_STROKE / 2;

    // the game state that this view is displaying
    private ChessGameState _gamestate;

    /**
     * ChessPerspectiveWhite constructor
     * <p>
     * This constructor is called when the view is created in code.
     *
     * @param context       the context in which the view is created
     */
    public ChessPerspectiveWhite(Context context) {
        super(context);
        this.init();

        this._gamestate = new ChessGameState();
    }

    /**
     * ChessPerspectiveWhite constructor
     * <p>
     * This constructor is called when the view is created in XML.
     *
     * @param context       the context in which the view is created
     * @param attrs         the attributes of the XML tag that is inflating the view
     */
    public ChessPerspectiveWhite(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

        this._gamestate = new ChessGameState();
    }

    /**
     * init
     * <p>
     * This method initializes the view. It is called by both constructors.
     */
    private void init() {
        // allow the view to draw itself
        setWillNotDraw(false);

        // establish the dimensions of the view
        setMinimumWidth((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));
        setMinimumHeight((int) (BOARD_LENGTH + 2 * BOARD_MARGIN));

        // establish the background color
        setBackgroundColor(Color.GREEN);
    }

    /**
     * onDraw
     * <p>
     * This method draws the view.
     *
     * @param g     the graphics context on which to draw
     */
    public void onDraw(Canvas g) {
        this.drawBoard(g);
        this.drawPieces(g);

        if (Logger.getDebugValue()) {
            this.drawCoors(g);
        }
    }

    private void drawCoors(Canvas g) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g.drawText(row+":"+col, BOARD_MARGIN + col * TILE_LENGTH + 15f, BOARD_MARGIN + row * TILE_LENGTH + 75f, getPaint(Color.RED, 0));
            }
        }
    }

    /**
     * drawBoard
     * <p>
     * This method draws the chessboard.
     *
     * @param g     the graphics context on which to draw
     */
    private void drawBoard(Canvas g) {

        g.drawRect(BOARD_MARGIN, BOARD_MARGIN, BOARD_MARGIN + BOARD_LENGTH,
                BOARD_MARGIN + BOARD_LENGTH, getPaint(Color.BLACK, BOARD_STROKE));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g.drawRect(BOARD_MARGIN + (row * TILE_LENGTH), BOARD_MARGIN + (col * TILE_LENGTH),
                        BOARD_MARGIN + ((row + 1) * TILE_LENGTH), BOARD_MARGIN + ((col + 1) * TILE_LENGTH),
                        getPaint(_gamestate.getTile(row, col).getColor(), 0));
            }
        }
    }

    /**
     * drawPieces
     * <p>
     * This method draws the pieces on the chessboard.
     *
     * @param g     the graphics context on which to draw
     */
    private void drawPieces(Canvas g) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (_gamestate.getPiece(row, col) == null) {
                    continue;
                }

                float topEdge = BOARD_MARGIN + (row * TILE_LENGTH);
                float leftEdge = BOARD_MARGIN + (col * TILE_LENGTH);
                Paint paint = getPaint(Color.BLACK, 0f);

                switch (_gamestate.getPiece(row, col).getName()) {
                    case "Pawn":
                        if (_gamestate.getPiece(row, col).getPlayer() == 0) {
                            g.drawBitmap(wPawn, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getPiece(row, col).getPlayer() == 1) {
                            g.drawBitmap(bPawn, leftEdge, topEdge, paint);
                        }
                        break;
                    case "Rook":
                        if (_gamestate.getPiece(row, col).getPlayer() == 0) {
                            g.drawBitmap(wRook, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getPiece(row, col).getPlayer() == 1) {
                            g.drawBitmap(bRook, leftEdge, topEdge, paint);
                        }
                        break;
                    case "Knight":
                        if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 0) {
                            g.drawBitmap(wKnight, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 1) {
                            g.drawBitmap(bKnight, leftEdge, topEdge, paint);
                        }
                        break;
                    case "Bishop":
                        if (_gamestate.getPiece(row, col).getPlayer() == 0) {
                            g.drawBitmap(wBishop, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getPiece(row, col).getPlayer() == 1) {
                            g.drawBitmap(bBishop, leftEdge, topEdge, paint);
                        }
                        break;
                    case "King":
                        if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 0) {
                            g.drawBitmap(wKing, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 1) {
                            g.drawBitmap(bKing, leftEdge, topEdge, paint);
                        }
                        break;
                    case "Queen":
                        if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 0) {
                            g.drawBitmap(wQueen, leftEdge, topEdge, paint);
                        }
                        else if (_gamestate.getBoard()[row][col].getPiece().getPlayer() == 1) {
                            g.drawBitmap(bQueen, leftEdge, topEdge, paint);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * getPaint
     * <p>
     * This method returns a Paint object with the specified color and stroke width.
     *
     * @param color         the color of the Paint object
     * @param strokeWidth   the stroke width of the Paint object
     * @return              the Paint object
     */
    private Paint getPaint(int color, float strokeWidth) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(strokeWidth);
        paint.setTextSize(60);

        return paint;
    }

    /**
     * setGameState
     * <p>
     * This method sets the game state.
     *
     * @param gameState     the game state
     */
    public void setGameState(ChessGameState gameState) {
        this._gamestate = gameState;
    }

    /**
     * getGameState
     * <p>
     * This method returns the game state.
     *
     * @return      the game state
     */
    public ChessGameState getGameState() {
        return this._gamestate;
    }
}
