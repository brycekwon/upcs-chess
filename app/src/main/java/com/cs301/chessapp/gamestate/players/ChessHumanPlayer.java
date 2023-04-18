package com.cs301.chessapp.gamestate.players;


import android.view.View;
import android.view.MotionEvent;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.pieces.Piece;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;
import com.cs301.chessapp.gamestate.views.ChessPerspective;

public class ChessHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {
    private static final String TAG = "ChessHumanPlayer";

    private int turn;

    private final float boardLeft = ChessPerspective.BOARD_MARGIN;
    private final float boardRight = ChessPerspective.BOARD_MARGIN + ChessPerspective.BOARD_LENGTH;
    private final float boardTop = ChessPerspective.BOARD_MARGIN;
    private final float boardBottom = ChessPerspective.BOARD_MARGIN + ChessPerspective.BOARD_LENGTH;

    private ChessPerspective surfaceView;
    private final int layoutId;
    private final int viewId;

    private Piece selectedPiece;
    private int selectedRow;
    private int selectedCol;

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public ChessHumanPlayer(String name, int turn,  int layoutId, int viewId) {
        super(name);

        this.layoutId = layoutId;
        this.viewId = viewId;
        this.turn = turn;
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {
        if (info instanceof ChessGameState) {
            ChessGameState state = (ChessGameState) info;

            surfaceView.setGameState(state);
            surfaceView.invalidate();
        }
    }

    @Override
    public void setAsGui(GameMainActivity activity) {
        activity.setContentView(layoutId);

        surfaceView = activity.findViewById(viewId);
        surfaceView.setOnTouchListener(this);
    }

    /**
     * onTouch
     * This method is called when the user touches the screen. It is used to
     * determine the location of the touch and then pass that information to
     * the game.
     *
     * @param view          the view that was touched
     * @param motionEvent   the MotionEvent object that contains the information
     * @return              true if the touch was handled, false otherwise
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // do not track sliding movements
        if (motionEvent.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        }

        // get the location of the touch and ensure it is on the board
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < boardLeft || x > boardRight || y < boardTop || y > boardBottom) {
            return true;
        }

        // determine the row and column of the touch
        int row = -1;
        int col = -1;

        if (this.turn == ChessGameState.PLAYER_1) {
            row = (int) ((y - boardTop) / ChessPerspective.TILE_LENGTH);
            col = (int) ((x - boardLeft) / ChessPerspective.TILE_LENGTH);
        } else if (this.turn == ChessGameState.PLAYER_2) {
            row = 7 - (int) ((y - boardTop) / ChessPerspective.TILE_LENGTH);
            col = 7 - (int) ((x - boardLeft) / ChessPerspective.TILE_LENGTH);
        }

        Piece touchedPiece = surfaceView.getGameState().getPiece(row, col);

        Logger.debugLog(TAG, "Player " + (this.turn + 1) + ": touched " + touchedPiece);

        // selecting a new piece
        if (touchedPiece != null && selectedPiece == null) {
            // do nothing if trying to select opponent piece
            if (touchedPiece.getPlayer() != this.turn) {
                return true;
            }

            // save newly selected piece into memory
            selectedPiece = touchedPiece;
            selectedRow = row;
            selectedCol = col;

            Logger.debugLog(TAG, "Player " + (this.turn + 1) + ": selected " + selectedPiece + " [" + selectedRow + ", " + selectedCol + "]");
        }

        // selecting another one of own piece
        else if (touchedPiece != null && selectedPiece.getPlayer() == touchedPiece.getPlayer()) {
            selectedPiece = touchedPiece;
            selectedRow = row;
            selectedCol = col;

            Logger.debugLog(TAG, "Player " + (this.turn + 1) + ": selected " + selectedPiece + " [" + selectedRow + ", " + selectedCol + "]");
        }

        // otherwise
        else {
            // if no piece is currently selected do nothing
            if (selectedPiece == null) {
                return true;
            }

            // attempt to move selected piece into selected location
            PieceMove move = new PieceMove(selectedRow, selectedCol, row, col);
            if (selectedPiece.isValidMove(move, surfaceView.getGameState())) {
                game.sendAction(new ChessMoveAction(this, move));

                Logger.debugLog(TAG, "Player " + (this.turn + 1) + ": moved " + selectedPiece + " from [" + selectedRow + ", " + selectedCol + "]" + " to [" + row + ", " + col + "]");
            }
        }

        return true;
    }

    public int getTurn() {
        return this.turn;
    }

    /**
     * toString
     *
     */
    @Override
    public String toString() {
        return "ChessHumanPlayer { " +
                "name= " + this.name + ", " +
                "turn= " + this.turn +
                " }";
    }
}
