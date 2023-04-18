package com.cs301.chessapp;


import android.util.Log;
import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.pieces.Queen;
import com.cs301.chessapp.gamestate.players.ChessComputerNormal;
import com.cs301.chessapp.gamestate.players.ChessComputerSmart;
import com.cs301.chessapp.gamestate.players.ChessHumanPlayer;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

/**
 * ChessLocalGame
 *
 * This class is the local game for chess. It is responsible for handling the
 * game logic and updating the game state. It is also responsible for sending
 * the updated game state to the players.
 *
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version Spring 2023
 */
public class ChessLocalGame extends LocalGame {
    private static final String TAG = "ChessLocalGame";

    public ChessLocalGame() {
        super();
        super.state = new ChessGameState();
    }

    public ChessLocalGame(ChessGameState gameState) {
        super();
        super.state = new ChessGameState(gameState);
    }

    @Override
    public void start(GamePlayer[] players) {
        super.start(players);

        int x = -1;
        for (GamePlayer p : players) {
            if (p instanceof ChessHumanPlayer) {
                x = p.getTurn() == ChessGameState.PLAYER_1 ? ChessGameState.PLAYER_2 : ChessGameState.PLAYER_1;
            }
        }

        for (GamePlayer p : players) {
            if (p instanceof ChessComputerSmart) {
                ((ChessComputerSmart) p).setTurn(x);
            } else if (p instanceof ChessComputerNormal) {
                ((ChessComputerNormal) p).setTurn(x);
            }
        }
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        Log.d(TAG, "sendUpdatedStateTo: " + p);
        p.sendInfo(new ChessGameState((ChessGameState) state));
    }

    @Override
    protected boolean canMove(int playerIdx) {
        int currPlayer = this.players[playerIdx].getTurn();
        int currTurn = ((ChessGameState) state).getTurn();

        return currPlayer == currTurn;
    }

    @Override
    protected boolean makeMove(GameAction action) {
        ChessGameState gamestate = (ChessGameState) state;
        ChessMoveAction moveAction = (ChessMoveAction) action;

        ChessSquare from = gamestate.getTile(moveAction.getStartRow(), moveAction.getStartCol());
        ChessSquare to = gamestate.getTile(moveAction.getEndRow(), moveAction.getEndCol());

        if (from.getPiece() == null) {
            return true;
        }

        if (from.getPiece().getName().equals("Pawn")) {
            if (from.getPiece().getPlayer() == ChessGameState.PLAYER_1 && moveAction.getEndRow() == 0) {
                to.setPiece(new Queen(ChessGameState.PLAYER_1));
                from.setPiece(null);
                gamestate.nextTurn();
                return true;
            } else if (from.getPiece().getPlayer() == ChessGameState.PLAYER_2 && moveAction.getEndRow() == 7) {
                to.setPiece(new Queen(ChessGameState.PLAYER_2));
                from.setPiece(null);
                gamestate.nextTurn();
                return true;
            }
        }

        to.setPiece(from.getPiece());
        from.setPiece(null);

        gamestate.nextTurn();

        return true;
    }

    @Override
    protected String checkIfGameOver() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (((ChessGameState) state).getPiece(row, col) != null && ((ChessGameState) state).getPiece(row, col).getPlayer() == ((ChessGameState) state).getTurn()) {
                    if (((ChessGameState) state).getPiece(row, col).getName().equals("King")) {
                        return null;
                    }
                }
            }
        }

        return "uh oh game over! ";
    }
}
