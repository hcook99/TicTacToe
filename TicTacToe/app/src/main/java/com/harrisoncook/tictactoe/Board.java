package com.harrisoncook.tictactoe;

import android.graphics.Color;
import java.util.Arrays;

/**
 * Board class is used to house an array that can be used
 * to check for winner and add clicks in MainActivity to a board
 */

public class Board {
    public char[] board = new char[9];
    public char player;
    public int turn;
    public int moveCount;
    /**
     * Constructor initializes board to array of space char
     * also sets turn to 1 and move count to 0
     * */
    public Board() {
        turn = 1;
        moveCount=0;
        Arrays.fill(board,' ');
    }
    /**
     * setGamePiece adds a char based on the turn to the array at the clicked position
     * @param boardPosition int for location at which the button was hit
     * @return the char placed at that position
     * */
    public char setGamePiece(int boardPosition){
        moveCount++;
        if(turn==1){
            player='X';
            turn++;
        }
        else{
            player='O';
            turn=1;
        }
        board[boardPosition]=player;
        return player;
    }
    /**
     * checkIfWon checks if either player has won and if they have returns true
     * @return boolean value of if player won*/
    public boolean checkIfWon(){
        if(board[0]==player&&board[1]==player&&board[2]==player){
            return true;
        }
        else if(board[3]==player&&board[4]==player&&board[5]==player){
            return true;
        }
        else if(board[6]==player&&board[7]==player&&board[8]==player){
            return true;
        }
        else if(board[0]==player&&board[3]==player&&board[6]==player){
            return true;
        }
        else if(board[1]==player&&board[4]==player&&board[7]==player){
            return true;
        }
        else if(board[2]==player&&board[5]==player&&board[8]==player){
            return true;
        }
        else if(board[0]==player&&board[4]==player&&board[8]==player){
            return true;
        }
        else if(board[2]==player&&board[4]==player&&board[6]==player){
            return true;
        }

        return false;
    }
    /**
     * getColorCode is used to make X's blue and O's red in MainActivity
     * @return int value of blue or red*/
    public int getColorCode(){
        if(player=='X'){
            return Color.BLUE;
        }
        else{
             return Color.RED;
        }
    }
    /**
     * checkForTie checks if there is a tie
     * @return boolean if there is a tie returns true else false*/
    public boolean checkForTie(){
        if(moveCount==9){
            return true;
        }
        return false;
    }
    /**
     * getWinner returns the player symbol that won the game
     * @return the char representing player symbol*/
    public char getWinner(){
        return player;
    }
    /**
     * compMove is used if single player game and returns a random spot on the board that hasn't been taken
     * @return int for position on board*/
    public int compMove() {
        int random;
        do{
            random = (int)(Math.random()*9);
        }while(board[random]!=' ');
        return random;
    }
}
