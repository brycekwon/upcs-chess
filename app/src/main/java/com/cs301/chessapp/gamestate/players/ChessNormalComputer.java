package com.cs301.chessapp.gamestate.players;

import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;

public class ChessNormalComputer extends GameComputerPlayer {
    private static final String TAG = "ChessNormalComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessNormalComputer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {

    }
}
