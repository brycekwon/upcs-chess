package com.cs301.chessapp.gamestate;

import com.cs301.chessapp.gameframework.infoMessage.GameState;
import com.cs301.chessapp.gamestate.chessboard.Board;

/**
 * MainGameState
 * <p>
 * This class is the main game state for the chess game. It contains information
 * on the board, the current turn, and the game mode. It is a subclass of
 * GameState. It is serializable so that it can be sent to other devices.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class MainGameState extends GameState {
    private final int _gamemode;
    private int _gameturn;

    private final boolean _timerVisible;

    private final Board _gameboard;

    /**
     * MainGameState constructor
     * <p>
     * This constructor initializes the gamemode, gameturn, and gameboard. It
     * also initializes the timer to be visible if the gamemode is does not
     * involve an AI.
     *
     * @param mode      The mode of the game.
     *                      0 = Player vs Player
     *                      1 = Player vs AI
     *                      2 = AI vs AI
     */
    public MainGameState(int mode) {
        _gamemode = mode;
        _gameturn = 0;

        _timerVisible = _gamemode == 0;

        _gameboard = new Board();
    }

    /**
     * MainGameState copy constructor
     * <p>
     * This constructor creates a copy of a MainGameState.
     *
     * @param other     The MainGameState to copy.
     */
    public MainGameState(MainGameState other) {
        _gamemode = other.getGamemode();
        _gameturn = other.getGameturn();

        _timerVisible = other.getTimerVisible();

        _gameboard = other.getGameboard();
    }

    /**
     * nextTurn
     * <p>
     * This method changes the turn to the next player.
     */
    public void nextTurn() {
        if (_gameturn == 0) {
            _gameturn = 1;
        } else {
            _gameturn = 0;
        }
    }

    /**
     * getGameboard
     * <p>
     * This method returns the current gameboard state.
     *
     * @return      The current gameboard state.
     */
    public Board getGameboard() {
        return _gameboard;
    }

    /**
     * getGamemode
     * <p>
     * This method returns the current gamemode.
     *
     * @return      The current gamemode.
     */
    public int getGamemode() {
        return _gamemode;
    }

    /**
     * getGameturn
     * <p>
     * This method returns the current gameturn.
     *
     * @return      The current gameturn.
     */
    public int getGameturn() {
        return _gameturn;
    }

    /**
     * getTimerVisible
     * <p>
     * This method returns whether the timer is visible.
     *
     * @return      True if the timer is visible, false otherwise.
     */
    public boolean getTimerVisible() {
        return _timerVisible;
    }

    /**
     * toString
     * <p>
     * This method returns a string representation of the game state.
     *
     * @return      A string representation of the game state.
     */
    @Override
    public String toString() {
        return "MainGameState {" +
                "gamemode=" + _gamemode +
                ", gameturn=" + _gameturn +
                ", timerVisible=" + _timerVisible +
                "}\n\n" + _gameboard.toString();
    }
}
