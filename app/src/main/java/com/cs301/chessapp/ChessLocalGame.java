package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.pieces.Piece;
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
 * @version March 26, 2023
 */
public class ChessLocalGame extends LocalGame {
    // Debugging and logging tools
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
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(new ChessGameState((ChessGameState) state));
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == ((ChessGameState) state).getTurn();
    }

    @Override
    protected boolean makeMove(GameAction action) {
        ChessGameState gameState = (ChessGameState) this.state;
        ChessMoveAction chessMoveAction = (ChessMoveAction) action;

        if (gameState.getChessboard()[chessMoveAction.getMove().getStartX()][chessMoveAction.getMove().getStartY()].getPiece().isValidMove(chessMoveAction.getMove().getStartX(), chessMoveAction.getMove().getStartY(), chessMoveAction.getMove().getEndX(), chessMoveAction.getMove().getEndY(), gameState.getChessboard())) {
            ChessSquare fromSquare = gameState.getChessboard()[chessMoveAction.getMove().getStartX()][chessMoveAction.getMove().getStartY()];
            Piece piece = fromSquare.getPiece();

            // get the square to move to
            ChessSquare toSquare = gameState.getChessboard()[chessMoveAction.getMove().getEndX()][chessMoveAction.getMove().getEndY()];

            // move the piece
            toSquare.setPiece(piece);
            fromSquare.setPiece(null);

            // increment the turn
            gameState.nextTurn();
        }
        return true;
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }
}
