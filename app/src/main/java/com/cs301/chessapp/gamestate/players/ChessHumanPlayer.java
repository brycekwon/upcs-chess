package com.cs301.chessapp.gamestate.players;

import android.view.MotionEvent;
import android.view.View;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;
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
        activity.setContentView(layoutId);

        view = (ChessPerspectiveWhite) activity.findViewById(R.id.chess_perspective_white);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
