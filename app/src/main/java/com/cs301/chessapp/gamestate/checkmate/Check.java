package com.cs301.chessapp.gameframework.utilities.Checkmate;

import com.cs301.chessapp.gamestate.chessboard.MoveAction;
import com.cs301.chessapp.gamestate.pieces.Piece;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Check {
    int _player;
    boolean inCheck;
    Checkmate checker;
    int kingX;
    int kingY;
    ArrayList<Piece> opponentPieces;
    ArrayList<MoveAction> kingMove;

    public Check(int player){
        _player = player;
        checker.setKing(_player);
        kingX = checker.getKingX();
        kingY = checker.getKingY();

        //check if king is in check
            //get all the opponents pieces
            //get all the pieces' valid move
            //compare each pieces' valid move

        opponentPieces = checker.getOpponentPieces(_player);//collects all the opponents pieces
        Iterator it = opponentPieces.iterator(); //iterator over arraylist
        int index = -1;
        while(it.hasNext()){//while the arraylist has elements
            index ++;
            //compare the king's current position versus all the opposite pieces
            if(checker.checkCMP(kingX, kingY, checker.getPieceMoves(opponentPieces.get(index)))){
                inCheck = true;
                //checks if all king's valid moves are being attacked
                if(checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index))) == null){
                    System.out.println("Checkmate");
                }
                else{//returns king's valid moves
                    kingMove = checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index)));
                }

            }
            else{
                inCheck = false;
                if(checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index))) == null){
                    System.out.println("Stalemate");
                }
                else{
                    kingMove = checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index)));
                }

            }
        }


    }

}
