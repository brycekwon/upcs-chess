package com.cs301.chessapp.gameframework.utilities.Checkmate;

import com.cs301.chessapp.gamestate.chessboard.ChessBoard;
import com.cs301.chessapp.gamestate.chessboard.ChessSquare;
import com.cs301.chessapp.gamestate.chessboard.MoveAction;
import com.cs301.chessapp.gamestate.pieces.*;

import java.util.ArrayList;
import java.util.Iterator;


public class Checkmate {
//check if current player's king is being attacked
    int _player = 0; //0 or 1 to tell which player it is
    boolean inCheck = false; // true if king is in check
    private int kingX; // position of king x
    private int kingY; // position of king y
    ChessSquare[][] board; //board state

    Piece k;
    public Checkmate(int player, ChessSquare[][] boardstate){
        _player = player;
        inCheck = false;
        this.board = boardstate;
    }


    //set the king's piece of the player and updates the king's position
    public void setKing(int player){
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getPiece().getPlayer() == player){
                    if(board[i][j].getPiece().getValue() == 100){
                        kingX = i;
                        kingY = j;
                        return;
                    }
                }
            }
        }
    }

    //returns the player's king's position
    public int getKingX(){return kingX;}
    public int getKingY(){return kingY;}


    //returns the king's valid moves
    public ArrayList<MoveAction> getKingMoves(){
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getPiece().getValue() == 100){
                    k = board[i][j].getPiece();
                    return k.getMoves(i, j, board);
                }
            }
        }
        return null;
    }

    //gets the valid moves of each piece;
    public ArrayList<MoveAction> getPieceMoves(Piece p) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j].getPiece().getValue() == p.getValue()) {
                        return p.getMoves(i,j,board);
                    }
                }
            }
        return null;
    }

    //get all player's pieces and its position of the opposite
    public ArrayList<Piece> getOpponentPieces(int player){
        if(player == 0) {
            _player = 1;
        }
        else{
            _player = 0;
        }

        ArrayList<Piece> oppositePiece = new ArrayList<Piece>();
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getPiece().getPlayer() == _player){
                    oppositePiece.add(board[i][j].getPiece());
                }
            }
        }
        return oppositePiece;
    }


    //compares one position vs all the possible moves from the other side
    boolean checkCMP(int x, int y, ArrayList<MoveAction> list){
        for(int i = 0; i < list.size(); i++){//iterates through the arraylist for each valid move
            int a;
            int b;
            a = list.get(i).getEndX();//indexing the x component of the valid move in the array list
            b = list.get(i).getEndY();//indexing the y component

            if(x == a && y == b){//check if the current position equals
                return true;
            }
        }
        return false;
    }

    //returns all valid moves after comparing
   public ArrayList<MoveAction> validMoveCMP(int x, int y, ArrayList<MoveAction> kingMove, ArrayList<MoveAction> check){
        ArrayList<MoveAction> blocks = new ArrayList<MoveAction>();//indexes the possible moves the king can take

       //index for the king's possible move
        int a;
        int b;

        for (int i = 0 ; i < kingMove.size(); i ++){
            a = kingMove.get(i).getEndX();
            b = kingMove.get(i).getEndY();
            if(checkCMP(a, b, check) != true) {//if checkCMP is false, valid move for the king to move
                blocks.add(new MoveAction(x, a, y, b));
            }
        }
        if(blocks.isEmpty()){
            return null;
        }
        return blocks;
   }
   //algorithm for checkmate
   //check if King is in check

}
