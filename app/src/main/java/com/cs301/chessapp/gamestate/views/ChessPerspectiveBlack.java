package com.cs301.chessapp.gamestate.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceView;

public class ChessPerspectiveBlack extends SurfaceView {

    Paint borderPaint = new Paint();

    Paint blackSquarePaint = new Paint();
    Paint whiteSquarePaint = new Paint();

    public ChessPerspectiveBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        borderPaint.setColor(Color.BLACK);
        borderPaint.setStrokeWidth(4);
        //paint for the border of the board

        blackSquarePaint.setColor(Color.BLACK);
        blackSquarePaint.setStyle(Paint.Style.FILL);

        whiteSquarePaint.setColor(Color.WHITE);
        whiteSquarePaint.setStyle(Paint.Style.FILL);
        //paint for the squares
    }

    int boardSize = 200;


    public void onDraw(Canvas canvas) {
        int canvasHeight = canvas.getHeight();
        int canvasWidth = canvas.getWidth();

        int left = (canvasWidth - boardSize) / 2;
        int top = (canvasHeight - boardSize) / 2;
        int right = left + boardSize;
        int bottom = top + boardSize;
        //positions of square, centered inside screen

        canvas.drawRect(left, top, right, bottom, borderPaint);
        //draw centered square

        //double for loop to draw squares
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (i == 0 || i % 2 == 0) {

                    if (j == 0 || j % 2 == 0) {
                    canvas.drawRect(left + (j * boardSize / 8), top + (i * boardSize / 8), left + (j + 1) * (boardSize / 8), top + (i + 1) * (boardSize / 8), blackSquarePaint);
                    }   else if (j == 1 || j % 2 == 1) {
                    canvas.drawRect(left + (j * boardSize / 8), top + (i * boardSize / 8), left + (j + 1) * (boardSize / 8), top + (i + 1) * (boardSize / 8), whiteSquarePaint);
                    }
                    /** if row is even, draw alternating black and white squares
                     * starting with white
                     */
                }
                else if (i == 1 || i % 2 == 1) {

                    if (j == 0 || j % 2 == 0) {
                        canvas.drawRect(left + (j * boardSize / 8), top + (i * boardSize / 8), left + (j + 1) * (boardSize / 8), top + (i + 1) * (boardSize / 8),whiteSquarePaint);
                    }   else if (j == 1 || j % 2 == 1) {
                        canvas.drawRect(left + (j * boardSize / 8), top + (i * boardSize / 8), left + (j + 1) * (boardSize / 8), top + (i + 1) * (boardSize / 8), blackSquarePaint);
                    }
                    /** if row is odd, draw alternating black and white squares
                     * starting with black
                     */
                }
            }
        }
    }
}
