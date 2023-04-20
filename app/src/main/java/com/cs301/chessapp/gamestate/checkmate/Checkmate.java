package com.cs301.chessapp.gamestate.checkmate;

import com.cs301.chessapp.gameframework.players.GamePlayer;
import com.cs301.chessapp.gamestate.ChessGameState;
import com.cs301.chessapp.gamestate.chessboard.ChessMove;
import com.cs301.chessapp.gamestate.pieces.*;

import java.util.ArrayList;


public class Checkmate {
//check if current player's king is being attacked
    int _player = 0; //0 or 1 to tell which player it is
    GamePlayer gamePlayer;
    boolean inCheck = false; // true if king is in check
    private int kingX; // position of king x
    private int kingY; // position of king y
    ChessGameState gamestate; //board state

    Piece k;
    public Checkmate(int player, ChessGameState boardstate, GamePlayer gamePlayer) {
        _player = player;
        inCheck = false;
        this.gamestate = boardstate;
        this.gamePlayer = gamePlayer;
    }


    //set the king's piece of the player and updates the king's position
    public void setKing(int player){
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                if(gamestate.getPiece(i, j).getPlayer() == player && (gamestate.getPiece(i, j).getValue() == 100)){
                        kingX = i;
                        kingY = j;
                        return;
                }
            }
        }
    }

    //returns the player's king's position
    public int getKingX(){return kingX;}
    public int getKingY(){return kingY;}


    //returns the king's valid moves
    public ArrayList<ChessMove> getKingMoves(){
        for(int i = 0; i < 8; i ++){
            for(int j = 0; j < 8; j++){
                if(gamestate.getPiece(i, j).getValue() == 100){
                    k = gamestate.getPiece(i, j);
                    return k.getMoves(gamestate, gamePlayer);
                }
            }
        }
        return null;
    }

    //gets the valid moves of each piece;
    public ArrayList<ChessMove> getPieceMoves(Piece p) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (gamestate.getPiece(i, j).getValue() == p.getValue()) {
                        return p.getMoves(gamestate, gamePlayer);
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
                if(gamestate.getPiece(i, j).getPlayer() == _player){
                    oppositePiece.add(gamestate.getPiece(i, j));
                }
            }
        }
        return oppositePiece;
    }


    //compares one position vs all the possible moves from the other side
    boolean checkCMP(int x, int y, ArrayList<ChessMove> list){
        for(int i = 0; i < list.size(); i++){//iterates through the arraylist for each valid move
            int a;
            int b;
            a = list.get(i).getEndRow();//indexing the x component of the valid move in the array list
            b = list.get(i).getEndCol();//indexing the y component

            if(a == x && b == y){//check if the current position equals
                return true;
            }
        }
        return false;
    }

    //returns all valid moves after comparing
   public ArrayList<ChessMove> validMoveCMP(int x, int y, ArrayList<ChessMove> kingMove){
        ArrayList<ChessMove> blocks = new ArrayList<ChessMove>();//indexes the possible moves the king can take
        Check checker = new Check(gamestate, gamePlayer);
       //index for the king's possible move
        int a;
        int b;

        for (int i = 0 ; i < kingMove.size(); i ++){
            for(int j = 0; j < kingMove.size(); j++) {
                a = kingMove.get(i).getEndRow();
                b = kingMove.get(j).getEndCol();
                if (!checker.checked(a,b,gamestate)) {//if checkCMP is false, valid move for the king to move
                    blocks.add(new ChessMove(gamePlayer, x, a, y, b));
                }
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
