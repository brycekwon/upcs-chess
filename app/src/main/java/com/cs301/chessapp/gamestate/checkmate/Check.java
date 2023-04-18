package com.cs301.chessapp.gamestate.checkmate;

import android.util.Log;
import android.widget.Toast;


import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.PieceMove;
import com.cs301.chessapp.gamestate.pieces.King;
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
    ArrayList<PieceMove> kingMove;
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
        inCheck = false;
        //2.check for all possible attack paths
        // check all directions left
        for (int i = 1; i < 8; i++) {
            if (col - i >= 0) {
                if (gamestate.getPiece(row, col - i) != null) {//checks if there's a piece or out of bounds
                    if (gamestate.getPiece(row, col - i).getPlayer() != _player && !(gamestate.getPiece(row, col - i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row, col - i).getName().equals("Queen") || gamestate.getPiece(row, col - i).getName().equals("Rook")) {
//                            attackMove = gamestate.getPiece(row, col - i).getMoves(row, col - i, gamestate);
//                            if (true == checker.checkCMP(row, col, attackMove)) {//is attacking
                                Log.d("Check", "King in check from the left");
                                inCheck = true;
                                break;
                            }
                    }
                    else{
                        Log.d("No Check - left", "King safe");
                            break;
                    }
                }
            }
        }

        // check all directions right
        for(int i = 1; i < 8; i++) {
            if (col + i < 8) {
                if (gamestate.getPiece(row, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row, col + i).getPlayer() != _player && !(gamestate.getPiece(row, col + i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row, col + i).getName().equals("Queen") || gamestate.getPiece(row, col + i).getName().equals("Rook")) {
//                            attackMove = gamestate.getPiece(row, col + i).getMoves(row, col+i, gamestate);
//                            if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                                Log.d("Check", "King in check from the right");
                                inCheck = true;
                                break;

                        }
                    }
                    else{
                        Log.d("No Check - right", "King safe");
                            break;
                    }
                }
            }
        }

        // check all directions up
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0) {
                if (gamestate.getPiece(row-i, col) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row-i, col).getPlayer() != _player && !(gamestate.getPiece(row - i, col).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row - i, col).getName().equals("Queen") || gamestate.getPiece(row - i, col).getName().equals("Rook")) {
//                        attackMove = gamestate.getPiece(row-i, col).getMoves(row-i, col, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the top");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - top", "King safe");
                            break;
                    }
                }
            }
        }

        // check all directions bottom
        for (int i = 1; i < 8; i++) {
            if (row + i < 8) {
                if (gamestate.getPiece(row + i, col) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col).getPlayer() != _player && !(gamestate.getPiece(row + i, col).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row + i, col).getName().equals("Queen") || gamestate.getPiece(row + i, col).getName().equals("Rook")) {
//                        attackMove = gamestate.getPiece(row + i, col).getMoves(row + i, col, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the bottom");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - bottom", "King safe");
                        break;
                    }
                }
            }
        }

        // check all directions down-left
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col - i >= 0) {
                if (gamestate.getPiece(row + i, col - i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col - i).getPlayer() != _player && !(gamestate.getPiece(row + i, col - i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row + i, col - i).getName().equals("Queen") || gamestate.getPiece(row + i, col - i).getName().equals("Bishop")) {
//                        attackMove = gamestate.getPiece(row + i, col - i).getMoves(row + i, col-i, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the down-left");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - down-left", "King safe");
                            break;
                    }
                }
            }
        }

        // check all directions down-right
        for (int i = 1; i < 8; i++) {
            if (row + i < 8 && col + i < 8) {
                if (gamestate.getPiece(row + i, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + i, col + i).getPlayer() != _player && !(gamestate.getPiece(row + i, col + i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row + i, col + i).getName().equals("Queen") || gamestate.getPiece(row + i, col + i).getName().equals("Bishop")) {
//                        attackMove = gamestate.getPiece(row + i, col + i).getMoves(row + i, col+i, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the down right");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - down-right", "King safe");
                            break;
                    }
                }
            }
        }

        // check all directions up-left
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (gamestate.getPiece(row - i, col - i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - i, col - i).getPlayer() != _player && !(gamestate.getPiece(row - i, col - i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row - i, col - i).getName().equals("Queen") || gamestate.getPiece(row - i, col - i).getName().equals("Bishop")) {
//                        attackMove = gamestate.getPiece(row - i, col - i).getMoves(row - i, col-i, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the up-left");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - up-left", "King safe");
                        break;
                    }
                }
            }
        }

        // check all directions up-right
        for (int i = 1; i < 8; i++) {
            if (row - i >= 0 && col + i < 8) {
                if (gamestate.getPiece(row - i, col + i) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - i, col + i).getPlayer() != _player && !(gamestate.getPiece(row - i, col + i).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if(gamestate.getPiece(row - i, col + i).getName().equals("Queen") || gamestate.getPiece(row - i, col + i).getName().equals("Bishop")) {
//                        attackMove = gamestate.getPiece(row - i, col + i).getMoves(row - i, col + i, gamestate);
//                        if(true == checker.checkCMP(row, col, attackMove)){//is attacking
                            Log.d("Check", "King in check from the up-right");
                            inCheck = true;
                            break;
                        }
                    }
                    else{
                        Log.d("No Check - up-right", "King safe");
                            break;
                    }
                }
            }
        }

        //check for pawns
        if(this._player == 1){
            if(row - 1 >= 0 && col + 1 < 8) {
                if (gamestate.getPiece(row - 1, col + 1) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - 1, col + 1).getPlayer() != _player && !(gamestate.getPiece(row - 1, col + 1).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if (gamestate.getPiece(row - 1, col + 1).getName().equals("Pawn")) {
                            Log.d("Check", "White King in check from pawn right");
                            inCheck = true;
                        }
                    }
                }
            }
            else if(row - 1 >= 0 && col - 1 < 8){
                if (gamestate.getPiece(row - 1, col - 1) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row - 1, col - 1).getPlayer() != _player && !(gamestate.getPiece(row - 1, col - 1).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if (gamestate.getPiece(row - 1, col - 1).getName().equals("Pawn")) {
                            Log.d("Check", "White King in check from pawn left");
                            inCheck = true;
                        }
                    }
                }
            }
        }
        else{
            if(row + 1 <= 7 && col + 1 < 8) {
                if (gamestate.getPiece(row + 1, col + 1) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + 1, col + 1).getPlayer() != _player && !(gamestate.getPiece(row + 1, col + 1).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if (gamestate.getPiece(row + 1, col + 1).getName().equals("Pawn")) {
                            Log.d("Check", "Black King in check from pawn right");
                            inCheck = true;
                        }
                    }
                }
            }
            else if(row + 1 <= 7 && col - 1 < 8){
                if (gamestate.getPiece(row + 1, col - 1) != null) {//checks if there's a piece
                    if (gamestate.getPiece(row + 1, col - 1).getPlayer() != _player && !(gamestate.getPiece(row + 1, col - 1).getName().equals("King"))) {//checks if the piece is an opponent piece
                        if (gamestate.getPiece(row + 1, col - 1).getName().equals("Pawn")) {
                            Log.d("Check", "Black King in check from pawn left");
                            inCheck = true;
                        }
                    }
                }
            }
        }

        //check for rooks


        //check for knights
        if(this._player == 1){
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (Math.abs(i) + Math.abs(j) == 3 && (row + i >= 0 && row + i < 8 && col + j >= 0 && col + j < 8) && (gamestate.getPiece(row + i, col + j) != null) && (gamestate.getPiece(row + i, col + j).getPlayer() != _player && !(gamestate.getPiece(row + i, col + j).getName().equals("King"))) && (gamestate.getPiece(row + i, col + j).getName().equals("Knight"))) {
                        Log.d("Check", "White King in check from the knight");
                        inCheck = true;
                        break;
                    }
                }
            }
        }
        else{
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (Math.abs(i) + Math.abs(j) == 3 && (row + i >= 0 && row + i < 8 && col + j >= 0 && col + j < 8) && (gamestate.getPiece(row + i, col + j) != null) && (gamestate.getPiece(row + i, col + j).getPlayer() != _player && !(gamestate.getPiece(row + i, col + j).getName().equals("King"))) && (gamestate.getPiece(row + i, col + j).getName().equals("Knight"))) {
                        Log.d("Check", "Black King in check from the knight");
                        inCheck = true;
                        break;
                    }
                }
            }
        }

        return inCheck;

        //3. determine the piece in path
        //4. if black check its move
        //5. stop if it's a white piece

    }

    public ArrayList<PieceMove> getAttackMove(){return attackMove;}
    public ArrayList<PieceMove> safeKing (int row, int col, ChessGameState gamestate){
        King k = new King(this._player);
        kingMove = k.getMoves(row, col, gamestate);
        checker.validMoveCMP(row, col, kingMove);
        return checker.validMoveCMP(row, col, kingMove);
    }
}
