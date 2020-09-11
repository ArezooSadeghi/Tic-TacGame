package com.example.tic_tacgame.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.tic_tacgame.R;
import com.example.tic_tacgame.fragment.InaRowFragment;
import com.example.tic_tacgame.fragment.TicTacToeFragment;

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

    private void findViews() {
        mButtonTicTacToe = findViewById(R.id.btn_tictactoe);
        mButton4InARow = findViewById(R.id.btn_4inarow);
    }

    private void setListeners() {
        mButtonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                TicTacToeFragment ticTacToeFragment = TicTacToeFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, ticTacToeFragment).commit();
            }

        });

        mButton4InARow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                InaRowFragment inaRowFragment = InaRowFragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container, inaRowFragment).commit();
            }

        });
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        return intent;
    }
}