package com.harrisoncook.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;

/**
 * MainActivity Class has the game inside of it is used to house the buttons on the board
 * and calls board class to check if a person won and stores the click in board too*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Button btn5;
    public Button btn6;
    public Button btn7;
    public Button btn8;
    public Button btn9;
    public Button reset;
    public TextView winner;
    public Board board;
    public String gameType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        board=new Board();
        Intent intent = getIntent();
        gameType = intent.getStringExtra("GameType");
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);
        reset = findViewById(R.id.button_reset);
        winner = findViewById(R.id.winner_output);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        reset.setOnClickListener(this);


    }
    @Override
    public void onClick(View view){
        int idView = view.getId();
        String letterToPlace;

        if(idView == btn1.getId()){

            letterToPlace=String.valueOf(board.setGamePiece(0));
            btn1.setTextColor(board.getColorCode());
            btn1.setText(letterToPlace);
            btn1.setEnabled(false);

        }
        else if(idView==btn2.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(1));
            btn2.setTextColor(board.getColorCode());
            btn2.setText(letterToPlace);
            btn2.setEnabled(false);


        }
        else if(idView==btn3.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(2));
            btn3.setTextColor(board.getColorCode());
            btn3.setText(letterToPlace);
            btn3.setEnabled(false);

        }
        else if(idView==btn4.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(3));
            btn4.setTextColor(board.getColorCode());
            btn4.setText(letterToPlace);
            btn4.setEnabled(false);

        }
        else if(idView==btn5.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(4));
            btn5.setTextColor(board.getColorCode());
            btn5.setText(letterToPlace);
            btn5.setEnabled(false);

        }
        else if(idView==btn6.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(5));
            btn6.setTextColor(board.getColorCode());
            btn6.setText(letterToPlace);
            btn6.setEnabled(false);


        }
        else if(idView==btn7.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(6));
            btn7.setTextColor(board.getColorCode());
            btn7.setText(letterToPlace);
            btn7.setEnabled(false);

        }
        else if(idView==btn8.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(7));
            btn8.setTextColor(board.getColorCode());
            btn8.setText(letterToPlace);
            btn8.setEnabled(false);

        }
        else if(idView==btn9.getId()){
            letterToPlace=String.valueOf(board.setGamePiece(8));
            btn9.setTextColor(board.getColorCode());
            btn9.setText(letterToPlace);
            btn9.setEnabled(false);

        }

        if(gameType.equals("SinglePlayer")){
            if(board.moveCount!=9) {
                if(!checkWin()) {
                    int move = board.compMove();
                    setButtonForAi(move);
                }
            }
        }

        checkWin();
        if(idView==reset.getId()){
            resetBoard();
        }


    }
    /**
     * checkWin is used to determine whether a player has won or tied
     * @return bollena true if a win or a tie has happened*/
    public boolean checkWin(){
        if(board.checkIfWon()) {
            winner.setText("Winner: " + String.valueOf(board.getWinner()));
            disableAllButReset();
            return true;
        }
        else if(board.checkForTie()){
            winner.setText("Tie");
            disableAllButReset();
            return true;
        }
        return false;
    }
    /**
     * resetBoard is used to reset the board for a new game*/
    public void resetBoard(){
        board=new Board();
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        winner.setText("");
    }
    /**
     * disableAllButReset is used to disable all the buttons but reset after a player has won*/
    public void disableAllButReset(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
    /**
     * setButtonForAi sets the butoon text and disables it from the move randomly picked by ai in board
     * @param spot place where ai picked to move*/
    public void setButtonForAi(int spot){
        String letterToPlace;
        letterToPlace = String.valueOf(board.setGamePiece(spot));
        if(spot == 0){
            btn1.setTextColor(board.getColorCode());
            btn1.setText(letterToPlace);
            btn1.setEnabled(false);
        }
        else if(spot == 1){
            btn2.setTextColor(board.getColorCode());
            btn2.setText(letterToPlace);
            btn2.setEnabled(false);
        }
        else if(spot == 2){
            btn3.setTextColor(board.getColorCode());
            btn3.setText(letterToPlace);
            btn3.setEnabled(false);
        }
        else if(spot == 3){
            btn4.setTextColor(board.getColorCode());
            btn4.setText(letterToPlace);
            btn4.setEnabled(false);
        }
        else if(spot == 4){
            btn5.setTextColor(board.getColorCode());
            btn5.setText(letterToPlace);
            btn5.setEnabled(false);
        }
        else if(spot == 5){
            btn6.setTextColor(board.getColorCode());
            btn6.setText(letterToPlace);
            btn6.setEnabled(false);

        }
        else if(spot == 6){
            btn7.setTextColor(board.getColorCode());
            btn7.setText(letterToPlace);
            btn7.setEnabled(false);
        }
        else if(spot == 7){
            btn8.setTextColor(board.getColorCode());
            btn8.setText(letterToPlace);
            btn8.setEnabled(false);
        }
        else if(spot == 8){
            btn9.setTextColor(board.getColorCode());
            btn9.setText(letterToPlace);
            btn9.setEnabled(false);
        }

    }


}
