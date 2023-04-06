package com.cs301.chessapp.gamestate.utilities;

import com.cs301.chessapp.gameframework.actionMessage.GameAction;
import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

public class ChessMoveAction extends GameAction {
    private static final String TAG = "ChessMoveAction";

    private PieceMove move;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public ChessMoveAction(GamePlayer player, PieceMove move) {
        super(player);
        this.move = move;
    }

    public PieceMove getMove() {
        return move;
    }
}
