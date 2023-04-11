package com.cs301.chessapp.gamestate.players;


import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.infoMessage.NotYourTurnInfo;
import com.cs301.chessapp.gameframework.players.GameComputerPlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;

public class ChessComputerSmart extends GameComputerPlayer {
    private static final String TAG = "ChessSmartComputer";
    //The smart vibes; provides x and y cords for capturing pieces
    int xGetYa;
    int yGetYa;

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

        sleep(1);

        //pieces 0,0 - 2,7
        int x = (int)(Math.random()*8);
        int y = (int)(Math.random()*8);
        for(int i = 0; i < cgm.getBoard().length; i++) {
            for(int z = 0; z < cgm.getBoard()[i].length; z++) {
                ChessSquare square = cgm.getBoard()[i][z];
                try {
                    if (square.getPiece().getPlayer() == 0 && square.getPiece().hasValidBounds(x, y)) {
                        game.sendAction(new com.cs301.chessapp.gamestate.utilities.ChessMoveAction(this, new PieceMove(i, z, x, y)));
                    }
                }
                catch(NullPointerException ignored) {

                }
            }
        }
    }

    /**
     * TODO: Chris
     * @param chessGameState
     * @return capture
     */
    private static boolean capture(ChessGameState chessGameState, int x, int y) {
        ChessSquare cs = chessGameState.getTile(x,y);

        for(int i = 0; i < chessGameState.getBoard().length; i++) {
            for (int z = 0; z < chessGameState.getBoard()[i].length; z++) {
                ChessSquare square = chessGameState.getBoard()[i][z];
                try {
//                    if(cs.getPiece() )
                        chessGameState.getTile(x,y);
                }catch(NullPointerException npe) {

                }
            }
        }
        return false;
    }
}
