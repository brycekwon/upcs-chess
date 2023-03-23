package com.example.chessapp;

import android.view.MotionEvent;
import android.view.View;

public class ViewChess implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {


        v.invalidate();
        return false;
    }
}
