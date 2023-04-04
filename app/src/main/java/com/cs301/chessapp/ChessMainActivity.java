package com.cs301.chessapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.gameConfiguration.GameConfig;
import com.cs301.chessapp.gameframework.gameConfiguration.GamePlayerType;
import com.cs301.chessapp.gameframework.infoMessage.GameState;
import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.players.ChessHumanPlayer;
import com.cs301.chessapp.gamestate.views.ChessPerspectiveWhite;

import java.util.ArrayList;

public class ChessMainActivity extends GameMainActivity {
    private static final String TAG = "ChessMainActivity";
    private static final int PORT_NUMBER = 5213;

    @Override
    public GameConfig createDefaultConfig() {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        playerTypes.add(new GamePlayerType("Local Human Player 1") {
            public GamePlayer createPlayer(String name) {
                ChessHumanPlayer gamePlayer = new ChessHumanPlayer(name, R.layout.activity_main);
                return gamePlayer;
            }
        });

        // todo: add 2nd local player
        // todo: add remote player
        // todo: add computer player normal
        // todo: add computer player smart
        GameConfig defaultConfig = new GameConfig(playerTypes, 1, 2, "Chess", PORT_NUMBER);
        defaultConfig.addPlayer("Human 1", 0);

        return defaultConfig;
    }

    @Override
    public LocalGame createLocalGame(GameState gameState) {
        return new ChessLocalGame();
    }
}
