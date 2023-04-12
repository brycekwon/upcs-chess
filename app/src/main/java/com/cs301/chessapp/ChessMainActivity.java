package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.gameConfiguration.GameConfig;
import com.cs301.chessapp.gameframework.gameConfiguration.GamePlayerType;
import com.cs301.chessapp.gameframework.infoMessage.GameState;
import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.players.ChessHumanPlayer;
import com.cs301.chessapp.gamestate.players.ChessComputerNormal;
import com.cs301.chessapp.gamestate.players.ChessComputerSmart;

import java.util.ArrayList;

public class ChessMainActivity extends GameMainActivity {
    private static final String TAG = "ChessMainActivity";

    private static final int PORT_NUMBER = 5213;

    /**
     * createDefaultConfig
     * <p>
     * Creates a default configuration for a game of chess. This is used when
     * the app is first installed, and also when the user selects "Reset Game"
     * from the menu. This method should create a new GameConfig object and
     * return it. It should also create the default players (e.g., human,
     * computer, etc.) and add them to the GameConfig object.
     *
     * @return      a new GameConfig object
     */
    @Override
    public GameConfig createDefaultConfig() {
        ArrayList<GamePlayerType> playerTypes = new ArrayList<>();

        playerTypes.add(new GamePlayerType("Human Player: White") {
            public GamePlayer createPlayer(String name) {
                return new ChessHumanPlayer(name, R.layout.activity_main);
            }
        });

        playerTypes.add(new GamePlayerType("Computer Player: Normal") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ChessComputerNormal(name);
            }
        });

        playerTypes.add(new GamePlayerType("Computer Player: Smart") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ChessComputerSmart(name);
            }
        });

        // Create a game configuration class for Chess
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 2, "Chess", PORT_NUMBER);
        defaultConfig.addPlayer("Player 1", 0);
        defaultConfig.addPlayer("Player 2", 1);

        return defaultConfig;
    }

    /**
     * createLocalGame
     *
     * Creates a local game. This method should create a new LocalGame object
     * and return it.
     * @param gameState     The desired gameState to start at
     *
     * @return      a new LocalGame object
     */
    @Override
    public LocalGame createLocalGame(GameState gameState) {
        if (gameState == null) {
            return new ChessLocalGame();
        } else {
            return new ChessLocalGame((ChessGameState) gameState);
        }
    }
}
