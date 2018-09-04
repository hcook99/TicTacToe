package com.harrisoncook.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * MainScreenActivity class is used to create a
 * main screen with a single player and two player button
 * option*/
public class MainScreenActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonOnePlayer;
    Button buttonTwoPlayer;
    public String gameType;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        buttonOnePlayer = findViewById(R.id.single_player);
        buttonTwoPlayer = findViewById(R.id.two_player);
        buttonOnePlayer.setOnClickListener(this);
        buttonTwoPlayer.setOnClickListener(this);
    }
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == buttonOnePlayer.getId()) {
                gameType = "SinglePlayer";
            }
            else if(id==buttonTwoPlayer.getId()){
                gameType = "TwoPlayer";

            }
            Intent game = new Intent(MainScreenActivity.this, MainActivity.class);
            game.putExtra("GameType", gameType);
            startActivity(game);
        }
}
