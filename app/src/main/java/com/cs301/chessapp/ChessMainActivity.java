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

/**
 * ChessMainActivity class
 *
 * This class is the main activity for the chess game. It creates a default
 * game configuration and a local game.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessMainActivity extends GameMainActivity {

    // the port number for network play
    private static final int PORT_NUMBER = 5213;

    /**
     * createDefaultConfig
     *
     * This method creates a default game configuration for the chess game. It
     * creates a list of player types and adds them to the game configuration.
     * It also specifies the number of players and the name of the game.
     *
     * @return      the default game configuration
     */
    @Override
    public GameConfig createDefaultConfig() {
        // list of player types to add to the game
        ArrayList<GamePlayerType> playerTypes = new ArrayList<>();

        // human player from the perspective of white
        playerTypes.add(new GamePlayerType("Human Player: White") {
            public GamePlayer createPlayer(String name) {
                return new ChessHumanPlayer(name, ChessGameState.PLAYER_1, R.layout.chess_perspective_white, R.id.whitePerspectiveBoard);
            }
        });

        // human player from the perspective of black
        playerTypes.add(new GamePlayerType("Human Player: Black") {
            public GamePlayer createPlayer(String name) {
                return new ChessHumanPlayer(name, ChessGameState.PLAYER_2, R.layout.chess_perspective_black, R.id.blackPerspectiveBoard);
            }
        });

        // computer player with normal intelligence
        playerTypes.add(new GamePlayerType("Computer Player: Normal") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ChessComputerNormal(name);
            }
        });

        // computer player with smart intelligence
        playerTypes.add(new GamePlayerType("Computer Player: Smart") {
            @Override
            public GamePlayer createPlayer(String name) {
                return new ChessComputerSmart(name);
            }
        });

        // create a default game setup
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 2, "Chess", PORT_NUMBER);
        defaultConfig.addPlayer("Player 1", 0);
        defaultConfig.addPlayer("Player 2", 2);

        return defaultConfig;
    }

    /**
     * createLocalGame
     *
     * This method creates a local game for the chess game. If not specified,
     * a new local game is created. Otherwise, the specified gamestate is
     * used to create a new local game.
     *
     * @param gamestate     the saved gamestate to copy
     * @return              the local game
     */
    @Override
    public LocalGame createLocalGame(GameState gamestate) {
        if (gamestate == null) {
            return new ChessLocalGame();
        } else {
            return new ChessLocalGame((ChessGameState) gamestate);
        }
    }
}
