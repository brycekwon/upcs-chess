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
    public static final float BOARD_LENGTH = 1400f;
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

    private void drawBoard(Canvas g) {
        g.drawRect(BOARD_MARGIN, BOARD_MARGIN, BOARD_MARGIN + BOARD_LENGTH,
                BOARD_MARGIN + BOARD_LENGTH, getPaint(Color.BLACK, BOARD_STROKE));

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
    }

    private void drawPieces(Canvas g) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (_gameState.getChessboard()[j][i].getPiece() != null) {
                    switch (_gameState.getChessboard()[j][i].getPiece().getName()) {
                        case "Bishop":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wBishop, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bBishop, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            break;
                        case "King":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wKing, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bKing, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            break;
                        case "Knight":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wKnight, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bKnight, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            break;
                        case "Pawn":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wPawn, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bPawn, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            break;
                        case "Queen":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wQueen, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bQueen, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            break;
                        case "Rook":
                            if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 0) {
                                g.drawBitmap(wRook, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
                            else if (_gameState.getChessboard()[j][i].getPiece().getPlayer() == 1) {
                                g.drawBitmap(bRook, TILE_MARGIN + i * TILE_LENGTH, TILE_MARGIN + j * TILE_LENGTH, null);
                            }
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

            paint.setColor(Color.BLUE);


        paint.setStrokeWidth(strokeWidth);
        paint.setTextSize(60);
        return paint;
    }

    // draw the chess board
    public void onDraw(Canvas g) {
        drawBoard(g);
        drawPieces(g);
    }

    public ChessGameState getGameState() {
        return this._gameState;
    }

    public void setGameState(ChessGameState gameState) {
        this._gameState = gameState;
    }
}
