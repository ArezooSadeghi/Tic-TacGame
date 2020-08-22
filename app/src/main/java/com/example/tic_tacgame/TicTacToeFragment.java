package com.example.tic_tacgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class TicTacToeFragment extends Fragment implements View.OnClickListener {
   private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;

    private boolean player1True = true;

    private int roundCount;

    private int player1Points;
    private int player2Points;


    public TicTacToeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);

        findViews(view);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);

        return view;


    }

    private void findViews(View view) {
       mButton1 = view.findViewById(R.id.btn_1);
       mButton2 = view.findViewById(R.id.btn_2);
       mButton3 = view.findViewById(R.id.btn_3);
       mButton4 = view.findViewById(R.id.btn_4);
       mButton5 = view.findViewById(R.id.btn_5);
       mButton6 = view.findViewById(R.id.btn_6);
       mButton7 = view.findViewById(R.id.btn_7);
       mButton8 = view.findViewById(R.id.btn_8);
       mButton9 = view.findViewById(R.id.btn_9);
    }

    @Override
    public void onClick(View view) {
       if (!((Button) view).getText().toString().equals("")) {
           return;
       }
       if (player1True) {
           ((Button) view).setText("X");
       }else {
           ((Button) view).setText("O");
       }
       roundCount++;

       if (checkForWin()) {
           if (player1True) {
               player1Wins();
           }else {
               player2Wins();
           }
       } else if (roundCount == 9) {
           draw();
       }else {
           player1True = !player1True;
       }

    }
    private boolean checkForWin() {
        String[][] field = new String[3][3];
        field[0][0] = mButton1.getText().toString();
        field[0][1] = mButton2.getText().toString();
        field[0][2] = mButton3.getText().toString();
        field[1][0] = mButton4.getText().toString();
        field[1][1] = mButton5.getText().toString();
        field[1][2] = mButton6.getText().toString();
        field[2][0] = mButton7.getText().toString();
        field[2][1] = mButton8.getText().toString();
        field[2][2] = mButton9.getText().toString();

        for (int i = 0; i < 3; i++) {
            if ((field[i][0].equals(field[i][1]) && (field[i][0].equals(field[i][2]) && !field[i][0].equals("")))) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if ((field[0][i].equals(field[1][i]) && (field[0][i].equals(field[2][i]) && !field[0][i].equals("")))) {
                return true;
            }
        }
        if ((field[0][0].equals(field[1][1]) && (field[0][0].equals(field[2][2]) && !field[0][0].equals("")))) {
            return true;
        }
        if ((field[0][2].equals(field[1][1]) && (field[0][2].equals(field[2][0]) && !field[0][2].equals("")))) {
            return true;
        }

        return false;

    }
    private void player1Wins() {
        player1Points++;
        Toast.makeText(getActivity(), "player 1 wins !!!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void player2Wins() {
        player2Points++;
        Toast.makeText(getActivity(), "player 2 wins !!!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void draw() {
        Toast.makeText(getActivity(), "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    private void updatePointsText() {}

    private void resetBoard() {
        mButton1.setText("");
        mButton2.setText("");
        mButton3.setText("");
        mButton4.setText("");
        mButton5.setText("");
        mButton6.setText("");
        mButton7.setText("");
        mButton8.setText("");
        mButton9.setText("");
        roundCount = 0;
        player1True = true;
    }
}