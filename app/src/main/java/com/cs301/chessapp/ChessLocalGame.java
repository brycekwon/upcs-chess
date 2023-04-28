package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.players.ChessComputerNormal;
import com.cs301.chessapp.gamestate.players.ChessComputerSmart;
import com.cs301.chessapp.gamestate.players.ChessHumanPlayer;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * ChessLocalGame class
 *
 * This class defines a local game for chess. It is responsible for handling
 * the game logic, updating the gamestate, and sending new information to the
 * necessary players.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessLocalGame extends LocalGame {

    /**
     * ChessLocalGame constructor
     *
     * This constructor initializes a new chess local game.
     */
    public ChessLocalGame() {
        super();
        super.state = new ChessGameState();
    }

    /**
     * ChessLocalGame constructor
     *
     * This constructor initializes a saved local game from a given gamestate.
     *
     * @param gameState     the gamestate to be loaded
     */
    public ChessLocalGame(ChessGameState gameState) {
        super();
        super.state = new ChessGameState(gameState);
    }

    /**
     * start
     *
     * This method starts the local game. The player number of the computer
     * is determined by the player number of the human player.
     *
     * @param players       the players in the game
     */
    @Override
    public void start(GamePlayer[] players) {
        super.start(players);

        int side = -1;
        for (GamePlayer p : players) {
            if (p instanceof ChessHumanPlayer) {
                side = p.getPlayerTurn() == ChessGameState.PLAYER_1 ? ChessGameState.PLAYER_2 : ChessGameState.PLAYER_1;
            }
        }

        for (GamePlayer p : players) {
            if (p instanceof ChessComputerNormal) {
                ((ChessComputerNormal) p).setPlayerTurn(side);
            } else if (p instanceof ChessComputerSmart) {
                ((ChessComputerSmart) p).setPlayerTurn(side);
            }
        }
    }

    /**
     * sendUpdatedStateTo
     *
     * This method sends the updated gamestate to the given player.
     *
     * @param player        the player to send the gamestate to
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer player) {
        player.sendInfo(new ChessGameState((ChessGameState) state));
    }

    /**
     * canMove
     *
     * This method checks if the given player can move.
     *
     * @param playerIdx     the index of the player
     * @return              true if the player can move, false otherwise
     */
    @Override
    protected boolean canMove(int playerIdx) {
        int currPlayer = this.players[playerIdx].getPlayerTurn();
        int currTurn = ((ChessGameState) state).getCurrTurn();

        return currPlayer == currTurn;
    }

    /**
     * makeMove
     *
     * This method makes a move for the given action. It checks if the move
     * is valid, and if so, it updates the gamestate.
     *
     * @param action        the action to be made
     * @return              true if the move was made, false otherwise
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof ChessMove) {
            return ((ChessGameState) state).movePiece((ChessMove) action);
        }
        return false;
    }

    /**
     * checkIfGameOver
     *
     * This method checks if the game is over.
     *
     * @return      null if the game is not over, a string otherwise
     */
    @Override
    protected String checkIfGameOver() {
        for (GamePlayer p : players) {
            if (p.checkmated()) {
                return "Player Checkmated";
            }
        }
        return null;
    }
}
