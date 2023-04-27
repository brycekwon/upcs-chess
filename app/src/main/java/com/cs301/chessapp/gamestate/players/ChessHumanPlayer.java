package com.cs301.chessapp.gamestate.players;

import android.view.View;
import android.view.MotionEvent;

import com.cs301.chessapp.gameframework.GameMainActivity;
import com.cs301.chessapp.gameframework.infoMessage.GameInfo;
import com.cs301.chessapp.gameframework.players.GameHumanPlayer;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.pieces.Piece;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.views.ChessPerspective;

import java.util.ArrayList;

/**
 * ChessHumanPlayer class
 *
 * This class represents a human player in the game of chess. It contains
 * information about the player and the view that the player will use. It also
 * contains functionality to handle user input.
 *
 * @author Bryce Kwon
 * @author Christopher Yee
 * @author Magnus Graham
 * @author Marshall Zhang
 * @version Spring 2023
 */
public class ChessHumanPlayer extends GameHumanPlayer implements View.OnTouchListener {

    // these variables contain information about the view
    private ChessPerspective _surfaceView;
    private final int _viewId;
    private final int _layoutId;

    // this variable contains information about the player
    private final int _playerTurn;

    // these variables contain information about the current selected piece
    private Piece _selectedPiece;
    private ArrayList<ChessMove> _validMoves;
    private int _selectedRow;
    private int _selectedCol;

    /**
     * ChessHumanPlayer constructor
     *
     * This constructor initializes a chess human player with a name and turn
     * order. It also specified the layout and view that the player will use.
     *
     * @param name              the name of the player
     * @param playerTurn        the turn order of the player
     * @param layoutId          the layout ID of the player
     * @param viewId            the view ID of the player
     */
    public ChessHumanPlayer(String name, int playerTurn,  int layoutId, int viewId) {
        super(name);

        // set the view information
        this._viewId = viewId;
        this._layoutId = layoutId;

        // set the player information
        this._playerTurn = playerTurn;
    }

    /**
     * getTopView
     *
     * This method returns the top view of the player. This method is not used
     * in the game of chess.
     *
     * @return      null
     */
    @Override
    public View getTopView() {
        return null;
    }

    /**
     * receiveInfo
     *
     * This method receives information from the game and handles it. It
     * processes a new gamestate and updates the view.
     *
     * @param info      the information received from the game
     */
    @Override
    public void receiveInfo(GameInfo info) {
        if (info instanceof ChessGameState) {
            ChessGameState state = (ChessGameState) info;

            _surfaceView.setGameState(state);
            _surfaceView.invalidate();
        }
    }

    /**
     * setAsGui
     *
     * This method sets the GUI for the player.
     *
     * @param activity      the activity the GUI is being set in
     */
    @Override
    public void setAsGui(GameMainActivity activity) {
        activity.setContentView(_layoutId);

        _surfaceView = activity.findViewById(_viewId);
        _surfaceView.setOnTouchListener(this);
    }

    /**
     * onTouch
     *
     * This method handles touch input from the user. It determines the row and
     * column of the touch and processes the touch based on the gamestate.
     *
     * @param view              the view that was touched
     * @param motionEvent       the motion event that occurred
     * @return                  true if the touch was handled, false otherwise
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        // do not track sliding movements
        if (motionEvent.getAction() != MotionEvent.ACTION_DOWN) {
            return true;
        }

        // get the location of the touch and ensure it is on the board
        float xCoor = motionEvent.getX();
        float yCoor = motionEvent.getY();
        if (xCoor < ChessPerspective.BOARD_LEFT ||
            xCoor > ChessPerspective.BOARD_RIGHT ||
            yCoor < ChessPerspective.BOARD_TOP ||
            yCoor > ChessPerspective.BOARD_BOTTOM) {
            return true;
        }

        // determine the row and column of the touch
        int row = -1;
        int col = -1;

        // process the touch corresponding to the gamestate
        if (_playerTurn == ChessGameState.PLAYER_1) {
            row = (int) ((yCoor - ChessPerspective.BOARD_TOP) / ChessPerspective.TILE_LENGTH);
            col = (int) ((xCoor - ChessPerspective.BOARD_LEFT) / ChessPerspective.TILE_LENGTH);
        } else if (_playerTurn == ChessGameState.PLAYER_2) {
            row = 7 - (int) ((yCoor - ChessPerspective.BOARD_TOP) / ChessPerspective.TILE_LENGTH);
            col = 7 - (int) ((xCoor - ChessPerspective.BOARD_LEFT) / ChessPerspective.TILE_LENGTH);
        }

        // get the piece at the touched location
        Piece touchedPiece = _surfaceView.getGameState().getPiece(row, col);

        // selecting a new piece
        if (touchedPiece != null && _selectedPiece == null) {
            // do nothing if trying to select opponent piece
            if (touchedPiece.getPlayerId() != _playerTurn) {
                return true;
            }

            // save newly selected piece into memory
            _selectedPiece = touchedPiece;
            _selectedRow = row;
            _selectedCol = col;
            _validMoves = _selectedPiece.getMoves(_surfaceView.getGameState(), this);

            _surfaceView.setCurrPiece(_selectedPiece);
            _surfaceView.setPieceMoves(_validMoves);
            _surfaceView.invalidate();
        }

        else if (touchedPiece != null && (_selectedPiece.getName().equals("King") && touchedPiece.getName().equals("Rook"))) {
            // if no piece is currently selected do nothing
            if (_selectedPiece == null) {
                return true;
            }

            // attempt to move selected piece into selected location
            ChessMove move = new ChessMove(this, _selectedRow, _selectedCol, row, col);
            if (_selectedPiece.isValidMove(move, _surfaceView.getGameState(), this)) {
                game.sendAction(move);
                _surfaceView.setCurrPiece(null);
                _surfaceView.setPieceMoves(null);
                _surfaceView.invalidate();
            }
        }

        // selecting another one of own piece
        else if (touchedPiece != null && _selectedPiece.getPlayerId() == touchedPiece.getPlayerId()) {
            _selectedPiece = touchedPiece;
            _selectedRow = row;
            _selectedCol = col;
            _validMoves = _selectedPiece.getMoves(_surfaceView.getGameState(), this);

            _surfaceView.setCurrPiece(_selectedPiece);
            _surfaceView.setPieceMoves(_validMoves);
            _surfaceView.invalidate();
        }

        // otherwise
        else {
            // if no piece is currently selected do nothing
            if (_selectedPiece == null) {
                return true;
            }

            // attempt to move selected piece into selected location
            ChessMove move = new ChessMove(this, _selectedRow, _selectedCol, row, col);
            if (_selectedPiece.isValidMove(move, _surfaceView.getGameState(), this)) {
                game.sendAction(move);
                _surfaceView.setCurrPiece(null);
                _surfaceView.setPieceMoves(null);
                _surfaceView.invalidate();
            }
        }

        return true;
    }

    /**
     * getPlayerTurn
     *
     * This method returns the turn order of the player.
     *
     * @return      the turn order of the player
     */
    public int getPlayerTurn() {
        return _playerTurn;
    }
}
