package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.pieces.Piece;

import java.util.ArrayList;

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
            ChessGameState gamestate = (ChessGameState) game.getGameState();

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

            // select a random piece on the board
            int row;
            int col;
            ArrayList<ChessMove> availMoves = null;
            do {
                row = (int) (Math.random() * 8);
                col = (int) (Math.random() * 8);
                Piece currPiece = gamestate.getPiece(row, col);
                if (currPiece != null && currPiece.getPlayerId() == _playerTurn) {
                    availMoves = gamestate.getPiece(row, col).getMoves(gamestate, this);
                }
            } while (availMoves == null || availMoves.isEmpty());

            int randIdx = (int) (Math.random() * availMoves.size());
            ChessMove move = availMoves.get(randIdx);

            sleep(3);

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
