package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

public class ChessNormalComputer extends GameComputerPlayer {
    private static final String TAG = "ChessNormalComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessNormalComputer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) {
            return;
        }

        ChessGameState gamestate = (ChessGameState) info;

        sleep(1);

        int x = (int) (Math.random() * 8);
        int y = (int) (Math.random() * 8);

        while (gamestate.getTile(x, y).getPiece() == null ||
                (gamestate.getTile(x, y).getPiece().getPlayer() == 1 ||
                (gamestate.getTile(x, y).getPiece().getMoves(x, y, gamestate.getChessboard()).size() < 1))) {
            x = (int) (Math.random() * 8);
            y = (int) (Math.random() * 8);
        }

        PieceMove moveX1 = (gamestate.getTile(x, y).getPiece().getMoves(x, y, (gamestate.getChessboard())).get((int) (Math.random() * (gamestate.getTile(x, y)).getPiece().getMoves(x, y, (gamestate.getChessboard())).size())));

        game.sendAction(new ChessMoveAction(this, moveX1));
    }
}
