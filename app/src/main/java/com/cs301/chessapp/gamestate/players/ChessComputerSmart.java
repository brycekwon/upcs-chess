package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;

/**
 * ChessComputerSmart class
 *
 * This class represents a computer player in the game of chess. It contains
 * information about the player and functionality for smart intelligence. This
 * player calculates a random move from the list of possible moves. If there is
 * a capture move, it will choose that move.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessComputerSmart extends GameComputerPlayer {

    // this variable contains information about the player
    private int _playerTurn;

    /**
     * ChessComputerSmart constructor
     *
     * This constructor initializes a chess computer player with a name and
     * turn order.
     *
     * @param name      the player name
     */
    public ChessComputerSmart(String name) {
        super(name);
    }


/**
     * receiveInfo
     *
     * This method receives information from the game and handles it. It
     * calculates a move and sends it back to the game.
     *
     * @param info      the information received from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof ChessGameState) {
            ChessGameState gamestate = (ChessGameState) info;

            // check for any capturable pieces
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    if (gamestate.getPiece(row, col) == null) {
                        continue;
                    } else if (gamestate.getPiece(row, col).getPlayerId() != _playerTurn) {
                        continue;
                    }

                    // randomly select a capturable move
                    for (ChessMove move : gamestate.getPiece(row, col).getMoves(gamestate, this)) {
                        if (gamestate.getPiece(move.getEndRow(), move.getEndCol()) != null && gamestate.getPiece(move.getEndRow(), move.getEndCol()).getPlayerId() != _playerTurn) {
                            game.sendAction(move);
                            return;
                        }
                    }

                }
            }

            int row;
            int col;
            do {
                row = (int) (Math.random() * 8);
                col = (int) (Math.random() * 8);
            } while (gamestate.getPiece(row, col) == null ||
                     gamestate.getPiece(row, col).getPlayerId() != _playerTurn ||
                     gamestate.getPiece(row, col).getMoves(gamestate, this).size() < 1);

            int index = (int) (Math.random() * gamestate.getPiece(row, col).getMoves(gamestate, this).size());
            ChessMove move = gamestate.getPiece(row, col).getMoves(gamestate, this).get(index);

            // sleep to allow the user to see the move
            sleep(0.5);

            // send the move to the game
            game.sendAction(move);
        }
    }

    /**
     * setPlayerTurn
     *
     * This method sets the player turn.
     *
     * @param playerTurn        the player turn
     */
    public void setPlayerTurn(int playerTurn) {
        _playerTurn = playerTurn;
    }

    /**
     * getPlayerTurn
     *
     * This method returns the player turn.
     *
     * @return      the player turn
     */
    public int getPlayerTurn() {
        return _playerTurn;
    }
}
