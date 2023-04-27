package com.cs301.chessapp;

import com.cs301.chessapp.gameframework.LocalGame;
import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessTile;
import com.cs301.chessapp.gamestate.pieces.King;
import com.cs301.chessapp.gamestate.pieces.Queen;
import com.cs301.chessapp.gamestate.pieces.Rook;
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

        int x = -1;
        for (GamePlayer p : players) {
            if (p instanceof ChessHumanPlayer) {
                x = p.getPlayerTurn() == ChessGameState.PLAYER_1 ? ChessGameState.PLAYER_2 : ChessGameState.PLAYER_1;
            }
        }

        for (GamePlayer p : players) {
            if (p instanceof ChessComputerSmart) {
                ((ChessComputerSmart) p).setPlayerTurn(x);
            } else if (p instanceof ChessComputerNormal) {
                ((ChessComputerNormal) p).setPlayerTurn(x);
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
        int currTurn = ((ChessGameState) state).getTurn();

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
        ChessGameState gamestate = (ChessGameState) state;
        ChessMove moveAction = (ChessMove) action;

        ChessTile from = gamestate.getTile(moveAction.getStartRow(), moveAction.getStartCol());
        ChessTile to = gamestate.getTile(moveAction.getEndRow(), moveAction.getEndCol());

        if (from.getPiece() == null) {
            return true;
        }

        else if (from.getPiece().getName().equals("Pawn")) {
            if (from.getPiece().getPlayerId() == ChessGameState.PLAYER_1 && moveAction.getEndRow() == 0) {
                to.setPiece(new Queen(ChessGameState.PLAYER_1));
                from.setPiece(null);

                gamestate.nextTurn();
                return true;
            } else if (from.getPiece().getPlayerId() == ChessGameState.PLAYER_2 && moveAction.getEndRow() == 7) {
                to.setPiece(new Queen(ChessGameState.PLAYER_2));
                from.setPiece(null);

                gamestate.nextTurn();
                return true;
            }
        }

        // castling 4->6 7->5
        else if (to.getPiece() != null && (from.getPiece().getName().equals("King") && to.getPiece().getName().equals("Rook"))) {
            //4->6 7->5
            if (to.getCol() == 7) {
                gamestate.getTile(from.getRow(), 6).setPiece(new King(from.getPiece().getPlayerId()));
                gamestate.getTile(from.getRow(), 5).setPiece(new Rook(to.getPiece().getPlayerId()));
                from.setPiece(null);
                to.setPiece(null);

                gamestate.nextTurn();
                return true;
            }
            // 4->2 0->3
            else if (to.getCol() == 0) {
                gamestate.getTile(from.getRow(), 2).setPiece(new Rook(to.getPiece().getPlayerId()));
                gamestate.getTile(from.getRow(), 3).setPiece(new King(from.getPiece().getPlayerId()));
                from.setPiece(null);
                to.setPiece(null);

                gamestate.nextTurn();
                return true;
            }
        }

        to.setPiece(from.getPiece());
        from.setPiece(null);

        gamestate.nextTurn();

        return true;
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
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (((ChessGameState) state).getPiece(row, col) != null && ((ChessGameState) state).getPiece(row, col).getPlayerId() == ((ChessGameState) state).getTurn()) {
                    if (((ChessGameState) state).getPiece(row, col).getName().equals("King")) {
                        return null;
                    }
                }
            }
        }

        return "uh oh game over! ";
    }
}
