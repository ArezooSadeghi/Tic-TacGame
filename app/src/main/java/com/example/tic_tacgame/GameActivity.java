package com.example.tic_tacgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {
    private Button mButtonTicTacToe, mButton4InARow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setTitle("Game");

        findViews();

        setListeners();

    }

    private void setListeners() {
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FragmentManager fragmentManager = getSupportFragmentManager();
               TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
               fragmentManager.beginTransaction().add(R.id.fragment_container, ticTacToeFragment).commit();
            }
        });

        mButton4InARow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                inaRowFragment inaRowFragment = new inaRowFragment();
                fragmentManager.beginTransaction().add(R.id.fragment_container, inaRowFragment).commit();
            }
        });
    }

    private void findViews() {
        mButtonTicTacToe = findViewById(R.id.btn_tictactoe);
        mButton4InARow = findViewById(R.id.btn_4inarow);
    }
}