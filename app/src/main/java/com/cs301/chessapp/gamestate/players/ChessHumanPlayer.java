package com.cs301.chessapp.gamestate.players;


import android.view.View;
import android.view.MotionEvent;

import com.cs301.chessapp.R;
import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;
import com.cs301.chessapp.gameframework.utilities.Logger;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.pieces.Piece;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.utilities.ChessMoveAction;
import com.cs301.chessapp.gamestate.views.ChessPerspectiveWhite;

public class ChessHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {
    private static final String TAG = "ChessHumanPlayer";

    private final float boardLeft = ChessPerspectiveWhite.BOARD_MARGIN;
    private final float boardRight = ChessPerspectiveWhite.BOARD_MARGIN + ChessPerspectiveWhite.BOARD_LENGTH;
    private final float boardTop = ChessPerspectiveWhite.BOARD_MARGIN;
    private final float boardBottom = ChessPerspectiveWhite.BOARD_MARGIN + ChessPerspectiveWhite.BOARD_LENGTH;

    private ChessPerspectiveWhite surfaceView;
    private final int layoutId;

    private Piece selectedPiece;
    private int selectedRow;
    private int selectedCol;

    /**
     * constructor
     *
     * @param name the name of the player
     */
    public ChessHumanPlayer(String name, int layoutId) {
        super(name);

        this.layoutId = layoutId;
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

        surfaceView = activity.findViewById(R.id.chessWhitePerspective);
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
        int row = (int) ((y - boardTop) / ChessPerspectiveWhite.TILE_LENGTH);
        int col = (int) ((x - boardLeft) / ChessPerspectiveWhite.TILE_LENGTH);
        Piece touchedPiece = surfaceView.getGameState().getPiece(row, col);

        // selecting a new piece
        if (touchedPiece != null && selectedPiece == null) {
            // do nothing if trying to select opponent piece
            if (touchedPiece.getPlayer() != this.playerNum) {
                return true;
            }

            // save newly selected piece into memory
            selectedPiece = touchedPiece;
            selectedRow = row;
            selectedCol = col;

            Logger.debugLog(TAG, "Player " + (this.playerNum + 1) + ": selected " + selectedPiece + " [" + selectedRow + ", " + selectedCol + "]");
        }

        // selecting another one of own piece
        else if (touchedPiece != null && selectedPiece.getPlayer() == touchedPiece.getPlayer()) {
            selectedPiece = touchedPiece;
            selectedRow = row;
            selectedCol = col;

            Logger.debugLog(TAG, "Player " + (this.playerNum + 1) + ": selected " + selectedPiece + " [" + selectedRow + ", " + selectedCol + "]");
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

                Logger.debugLog(TAG, "Player " + (this.playerNum + 1) + ": moved " + selectedPiece + " from [" + selectedRow + ", " + selectedCol + "]" + " to [" + row + ", " + col + "]");
            }
        }

        return true;
    }

    /**
     * toString
     *
     */
    @Override
    public String toString() {
        return "ChessHumanPlayer { " +
                "surfaceView=" + surfaceView +
                ", layoutId=" + layoutId +
                " }";
    }
}
