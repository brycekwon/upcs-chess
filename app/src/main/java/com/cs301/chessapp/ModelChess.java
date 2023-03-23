package com.cs301.chessapp;


import com.cs301.chessapp.gamestate.chessboard.Board;
import com.cs301.chessapp.gamestate.utilities.ChessTimer;

public class ModelChess {
    private String player1Name;
    private String player2Name;
    private ChessTimer timer;
    private Board board;

    public ModelChess(){
        this.player1Name = "Player UNO";
        this.player2Name ="Player Dos";
        this.timer = new ChessTimer();
        this.board = new Board();
    }

    public void setPlayer1Name(String name){
        this.player1Name = name;
    }
    public void setPlayer2Name(String name){
        this.player2Name = name;
    }
    public String getPlayer1Name(){return this.player1Name;}
    public String getPlayer2Name(){return this.player2Name;}




}
