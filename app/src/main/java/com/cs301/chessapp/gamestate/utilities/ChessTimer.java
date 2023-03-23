package com.cs301.chessapp.gamestate.utilities;

import com.cs301.chessapp.gameframework.utilities.GameTimer;
import com.cs301.chessapp.gameframework.utilities.Tickable;

public class ChessTimer extends GameTimer {
    /**
     * Constructor for objects of class GameTimer
     *
     * @param target the object to "tick" when the timer goes off
     *               GameTimerAction sends
     */
    public ChessTimer(Tickable target) {
        super(target);
    }
}
