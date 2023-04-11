package com.cs301.chessapp.gamestate.checkmate;

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
    ArrayList<PieceMove> kingMove;

    public Check(ChessGameState board) {
        _player = board.getTurn();
        checker.setKing(_player);
        kingX = checker.getKingX();
        kingY = checker.getKingY();
        checkState = "No Check";
        //check if king is in check
        //get all the opponents pieces
        //get all the pieces' valid move
        //compare each pieces' valid move
    }

    public String checked() {
        opponentPieces = checker.getOpponentPieces(_player);//collects all the opponents pieces
        Iterator<Piece> it = opponentPieces.iterator(); //iterator over arraylist
        int index = -1;
        while (it.hasNext()) {//while the arraylist has elements
            index++;
            //compare the king's current position versus all the opposite pieces
            if (checker.checkCMP(kingX, kingY, checker.getPieceMoves(opponentPieces.get(index)))) {
                inCheck = true;
                //checks if all king's valid moves are being attacked
                if (checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index))) == null) {
                    checkState = "Checkmate";
                    return checkState;
                } else {//returns king's valid moves
                    kingMove = checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index)));
                }

            } else {
                inCheck = false;
                if (checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index))) == null) {
                    checkState = "Stalemate";
                    return checkState;
                } else {
                    kingMove = checker.validMoveCMP(kingX, kingY, checker.getKingMoves(), checker.getPieceMoves(opponentPieces.get(index)));
                }

            }
        }
        return checkState;
    }
}



