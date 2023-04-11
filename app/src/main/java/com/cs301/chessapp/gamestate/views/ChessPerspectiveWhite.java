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

    // these constants define the dimensions of the chessboard
    public static final float BOARD_LENGTH = 900f;
    public static final float BOARD_MARGIN = 50f;
    public static final float TILE_LENGTH = BOARD_LENGTH / 8;
    public static final float STROKE = 5f;

    // the game state that this view is displaying
    private ChessGameState _gameState;

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

        this._gameState = new ChessGameState();
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
        this.init();

        this._gameState = new ChessGameState();
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
                BOARD_MARGIN + BOARD_LENGTH, getPaint(Color.BLACK, STROKE));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g.drawRect(BOARD_MARGIN + i * TILE_LENGTH, BOARD_MARGIN + j * TILE_LENGTH,
                            BOARD_MARGIN + (i + 1) * TILE_LENGTH, BOARD_MARGIN + (j + 1) * TILE_LENGTH,
                            getPaint(_gameState.getBoard()[j][i].getColor(), 0));
                } else {
                    g.drawRect(BOARD_MARGIN + i * TILE_LENGTH, BOARD_MARGIN + j * TILE_LENGTH,
                            BOARD_MARGIN + (i + 1) * TILE_LENGTH, BOARD_MARGIN + (j + 1) * TILE_LENGTH,
                            getPaint(_gameState.getBoard()[j][i].getColor(), 0));
                }
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (_gameState.getTile(j, i).getPiece() == null) {
                    continue;
                }

                switch (_gameState.getTile(j, i).getPiece().getName()) {
                    case "Bishop":
                        g.drawText("B", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
                        break;
                    case "King":
                        g.drawText("K", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
                        break;
                    case "Knight":
                        g.drawText("N", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
                        break;
                    case "Pawn":
                        g.drawText("P", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
                        break;
                    case "Queen":
                        g.drawText("Q", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
                        break;
                    case "Rook":
                        g.drawText("R", BOARD_MARGIN + i * TILE_LENGTH + TILE_LENGTH / 2,
                                BOARD_MARGIN + j * TILE_LENGTH + TILE_LENGTH / 2,
                                getPaint(_gameState.getTile(j, i).getPiece().getColor(), 10));
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
        this._gameState = gameState;
    }

    /**
     * getGameState
     * <p>
     * This method returns the game state.
     *
     * @return      the game state
     */
    public ChessGameState getGameState() {
        return this._gameState;
    }
}
