package com.cs301.chessapp.gamestate.players;


import android.util.Log;

import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;

import java.util.Random;

public class ChessComputerSmart extends GameComputerPlayer {
    private static final String TAG = "ChessSmartComputer";

    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public ChessComputerSmart(String name) {
        super(name);
    }

    /**
     * @param info the object representing the information from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof NotYourTurnInfo) {
            return;
        }
        ChessGameState cgm = (ChessGameState) info;

        //pieces 0,0 - 2,7
        Random r = new Random();
        int x = r.nextInt(8);
        int y = r.nextInt(8);
        for (int i = 0; i < cgm.getBoard().length; i++) {
            for (int z = 0; z < cgm.getBoard()[i].length; z++) {
                ChessSquare square = cgm.getBoard()[i][z];
                try {
                    if (square.getPiece().hasValidBounds(x, y) &&
                            !square.getPiece().getMoves(i, z, cgm).isEmpty() &&
                            square.getPiece().getPlayer() == this.playerNum &&
                            cgm.getPiece(i, z).getPlayer() != this.playerNum &&
                            cgm.getTurn() == this.playerNum) {
                        sleep(.5);

                            game.sendAction(new ChessMoveAction(this, new PieceMove(i, z, x, y)));
                    }
                } catch (NullPointerException ignored) {

                }
            }
        }
        while(cgm.getPiece(x, y) == null || cgm.getPiece(x, y).getPlayer() != this.playerNum || cgm.getPiece(x, y).getMoves(x, y, cgm).isEmpty()) {
            x = r.nextInt(8);
            y = r.nextInt(8);
        }

        PieceMove move;
        do {
            int randomIndex = (r.nextInt() * cgm.getPiece(x, y).getMoves(x, y, cgm).size());
            move = cgm.getPiece(x, y).getMoves(x, y, cgm).get(randomIndex);
        } while (cgm.getPiece(x, y).isValidMove(move, cgm));

        sleep(.5);
        game.sendAction(new ChessMoveAction(this, move));
    }
}
