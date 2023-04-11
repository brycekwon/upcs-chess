package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessComputerNormal extends GameComputerPlayer {
    private static final String TAG = "ChessNormalComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessComputerNormal(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof ChessGameState) {
            ChessGameState gamestate = (ChessGameState) info;

            // retrieve a random row and column
            int row;
            int col;
            do {
                row = (int) (Math.random() * 8);
                col = (int) (Math.random() * 8);
            } while (gamestate.getPiece(row, col) == null ||
                    gamestate.getPiece(row, col).getPlayer() == this.playerNum ||
                    gamestate.getPiece(row, col).getMoves(row, col, gamestate).size() < 1);

            // delay
            sleep(0.5);

            // send the action to the game
            int randomIndex = (int) (Math.random() * gamestate.getPiece(row, col).getMoves(row, col, gamestate).size());
            PieceMove move = gamestate.getPiece(row, col).getMoves(row, col, gamestate).get(randomIndex);
            game.sendAction(new ChessMoveAction(this, move));
        }
    }
}
