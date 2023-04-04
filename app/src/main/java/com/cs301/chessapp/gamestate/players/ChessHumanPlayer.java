package com.cs301.chessapp.gamestate.players;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.views.ChessPerspectiveWhite;

public class ChessHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {
    private static final String TAG = "ChessHumanPlayer";

    private ChessPerspectiveWhite surfaceView;
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

        surfaceView = activity.findViewById(R.id.chessPerspectiveWhite2);
        surfaceView.setOnTouchListener(this);
    }

    /**
     * onTouch
     * This method is called when the user touches the screen. It is used to
     * determine the location of the touch and then pass that information to
     * the game.
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        float x = motionEvent.getX();
        float y = motionEvent.getY();

        float boardLeft = ChessPerspectiveWhite.BOARD_MARGIN;
        float boardRight = ChessPerspectiveWhite.BOARD_MARGIN + ChessPerspectiveWhite.BOARD_LENGTH;
        float boardTop = ChessPerspectiveWhite.BOARD_MARGIN;
        float boardBottom = ChessPerspectiveWhite.BOARD_MARGIN + ChessPerspectiveWhite.BOARD_LENGTH;

        if (x < boardLeft || x > boardRight || y < boardTop || y > boardBottom) {
            return false;
        }

        int row = (int) ((y - boardTop) / ChessPerspectiveWhite.TILE_LENGTH);
        int col = (int) ((x - boardLeft) / ChessPerspectiveWhite.TILE_LENGTH);

        Log.d(TAG, "onTouch: " + row + ", " + col);

        return true;
    }

    /**
     * toString
     *
     */
    @Override
    public String toString() {
        return "ChessHumanPlayer{" +
                "surfaceView=" + surfaceView +
                ", layoutId=" + layoutId +
                '}';
    }
}
