package com.cs301.chessapp.gamestate.utilities;

import com.cs301.chessapp.gameframework.utilities.GameTimer;
import com.cs301.chessapp.gameframework.utilities.Tickable;

public class ChessTimer extends GameTimer {
    private static final String TAG = "ChessTimer";

    public ChessTimer(Tickable target) {
        super(target);
    }

    public void setInterval(int interval) {
        super.setInterval(interval);
    }

    public void start() {
        super.start();
    }

    /**
     * Stops the timer.
     *
     */
    public void stop() {
        super.stop();
    }
}
