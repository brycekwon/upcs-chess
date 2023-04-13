package com.cs301.chessapp.gamestate.checkmate;

import android.util.Log;

import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.pieces.Piece;

import java.util.ArrayList;
import java.util.Iterator;

public class Check {
    int _player;
    String checkState;
    boolean inCheck;
    Checkmate checker;
    int kingX;
    int kingY;
    ArrayList<Piece> opponentPieces;
    ArrayList<PieceMove> attackMove;

    public Check(ChessGameState board) {

        _player = board.getTurn();
        checker = new Checkmate(_player, board);
        //checker.setKing(_player);
        kingX = checker.getKingX();
        kingY = checker.getKingY();
        checkState = "No Check";
        //check if king is in check
        //get all the opponents pieces
        //get all the pieces' valid move
        //compare each pieces' valid move
    }

    public boolean checked(int row, int col, ChessGameState gamestate) {

        //2.check for all possible attack paths
        // check all directions left
        for (int i = 1; i < 8; i++) {
            if (col - i >= 0) {
                if (gamestate.getPiece(row, col - i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row, col - i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row, col - i).getMoves(row, col-i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the left");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions right
        for(int i = 1; i < 8; i++) {
            if (col + i < 8) {
                if (gamestate.getPiece(row, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row, col + i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row, col + i).getMoves(row, col+i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the right");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions down
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0) {
                if (gamestate.getPiece(row-i, col) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row-i, col).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row-i, col).getMoves(row-i, col, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the bottom");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions up
        for (int i = 1; i < 8; i++) {
            if (row + i < 8) {
                if (gamestate.getPiece(row + i, col) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row + i, col).getMoves(row + i, col, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the top");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions up-left
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col - i >= 0) {
                if (gamestate.getPiece(row + i, col - i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col - i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row + i, col - i).getMoves(row + i, col-i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the up - left");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions up-right
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col + i < 8) {
                if (gamestate.getPiece(row + i, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col + i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row + i, col + i).getMoves(row + i, col+i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the up - right");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions down-left
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (gamestate.getPiece(row - i, col - i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - i, col - i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row - i, col - i).getMoves(row - i, col-i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the down-left");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        // check all directions down-right
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col + i < 8) {
                if (gamestate.getPiece(row - i, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - i, col + i).getPlayer() != _player) {//checks if the piece is an opponent piece
                        attackMove = gamestate.getPiece(row - i, col + i).getMoves(row - i, col + i, gamestate);
                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the down-right");
                            return true;
                        }
                    }
                    else{
                        Log.d("No Check", "King safe");

                    }
                }
            }
        }

        //check for knights
        for (int i = -2; i <= 2; i++) {
            for (int j = -2; j <= 2; j++) {
                if (Math.abs(i) + Math.abs(j) == 3) {
                    if (row + i >= 0 && row + i < 8 && col + j >= 0 && col + j < 8) {
                        if (gamestate.getPiece(row + i, col + i) != null) {//checks if there's a piece
                            if (gamestate.getPiece(row + i, col + i).getPlayer() != _player) {//checks if the piece is an opponent piece
                                attackMove = gamestate.getPiece(row + i, col + i).getMoves(row + i, col+i, gamestate);
                                if(checker.checkCMP(row, col, attackMove)){//is attacking
                                    Log.d("Check", "King in check from the knight");
                                    return true;
                                }
                            }
                            else{
                                Log.d("No Check", "King safe");

                            }
                        }
                    }
                }
            }
        }

        //3. determine the piece in path
        //4. if black check its move
        //5. stop if it's a white piece

        return false;
    }
}



