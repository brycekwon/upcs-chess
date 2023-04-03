package com.cs301.chessapp.gamestate.players;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.IllegalMoveInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.views.ChessPerspectiveWhite;

public class ChessHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {
    private static final String TAG = "ChessHumanPlayer";

    private ChessPerspectiveWhite view;
    private int layoutId;

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public ChessHumanPlayer(String name, int layoutId) {
        super(name);
        this.layoutId = layoutId;
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {
    }

    @Override
    public void setAsGui(GameMainActivity activity) {
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
