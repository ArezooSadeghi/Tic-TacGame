package com.example.tic_tacgame;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class inaRowFragment extends Fragment implements View.OnClickListener {

    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9, mButton10, mButton11,
    mButton12, mButton13, mButton14, mButton15, mButton16, mButton17, mButton18, mButton19, mButton20, mButton21, mButton22,
    mButton23, mButton24, mButton25;

    private boolean player1True = true;

    private int roundCount;

    private int player1Points;
    private int player2Points;


    public inaRowFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ina_row, container, false);

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
        mButton10.setOnClickListener(this);
        mButton11.setOnClickListener(this);
        mButton12.setOnClickListener(this);
        mButton13.setOnClickListener(this);
        mButton14.setOnClickListener(this);
        mButton15.setOnClickListener(this);
        mButton16.setOnClickListener(this);
        mButton17.setOnClickListener(this);
        mButton18.setOnClickListener(this);
        mButton19.setOnClickListener(this);
        mButton20.setOnClickListener(this);
        mButton21.setOnClickListener(this);
        mButton22.setOnClickListener(this);
        mButton23.setOnClickListener(this);
        mButton24.setOnClickListener(this);
        mButton25.setOnClickListener(this);

        return view;
    }
    public void findViews(View view) {
        mButton1 = view.findViewById(R.id.btn_1);
        mButton2 = view.findViewById(R.id.btn_2);
        mButton3 = view.findViewById(R.id.btn_3);
        mButton4 = view.findViewById(R.id.btn_4);
        mButton5 = view.findViewById(R.id.btn_5);
        mButton6 = view.findViewById(R.id.btn_6);
        mButton7 = view.findViewById(R.id.btn_7);
        mButton8 = view.findViewById(R.id.btn_8);
        mButton9 = view.findViewById(R.id.btn_9);
        mButton10 = view.findViewById(R.id.btn_10);
        mButton11 = view.findViewById(R.id.btn_11);
        mButton12 = view.findViewById(R.id.btn_12);
        mButton13 = view.findViewById(R.id.btn_13);
        mButton14 = view.findViewById(R.id.btn_14);
        mButton15 = view.findViewById(R.id.btn_15);
        mButton16 = view.findViewById(R.id.btn_16);
        mButton17 = view.findViewById(R.id.btn_17);
        mButton18 = view.findViewById(R.id.btn_18);
        mButton19 = view.findViewById(R.id.btn_19);
        mButton20 = view.findViewById(R.id.btn_20);
        mButton21 = view.findViewById(R.id.btn_21);
        mButton22 = view.findViewById(R.id.btn_22);
        mButton23 = view.findViewById(R.id.btn_23);
        mButton24 = view.findViewById(R.id.btn_24);
        mButton2 = view.findViewById(R.id.btn_25);
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1True) {
            ((Button) view).setTextColor(Color.WHITE);
        }else {
            ((Button) view).setTextColor(Color.BLACK);
        }
        roundCount++;

        /*if (checkForWin()) {
            if (player1True) {
                player1Wins();
            }else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        }else {
            player1True = !player1True;
        }*/


    }
    private boolean checkForWin() {
        String[][] colors = new String[3][3];
        colors[0][0] = String.valueOf(mButton1.getTextColors());
        colors[0][1] = String.valueOf(mButton2.getTextColors());
        colors[0][2] = String.valueOf(mButton3.getTextColors());
        colors[0][3] = String.valueOf(mButton4.getTextColors());
        colors[0][4] = String.valueOf(mButton5.getTextColors());
        colors[1][0] = String.valueOf(mButton6.getTextColors());
        colors[1][1] = String.valueOf(mButton7.getTextColors());
        colors[1][2] = String.valueOf(mButton8.getTextColors());
        colors[1][3] = String.valueOf(mButton9.getTextColors());
        colors[1][4] = String.valueOf(mButton10.getTextColors());
        colors[2][0] = String.valueOf(mButton11.getTextColors());
        colors[2][1] = String.valueOf(mButton12.getTextColors());
        colors[2][2] = String.valueOf(mButton13.getTextColors());
        colors[2][3] = String.valueOf(mButton14.getTextColors());
        colors[2][4] = String.valueOf(mButton15.getTextColors());
        colors[3][0] = String.valueOf(mButton16.getTextColors());
        colors[3][1] = String.valueOf(mButton17.getTextColors());
        colors[3][2] = String.valueOf(mButton18.getTextColors());
        colors[3][3] = String.valueOf(mButton19.getTextColors());
        colors[3][4] = String.valueOf(mButton20.getTextColors());
        colors[4][0] = String.valueOf(mButton21.getTextColors());
        colors[4][1] = String.valueOf(mButton22.getTextColors());
        colors[4][2] = String.valueOf(mButton23.getTextColors());
        colors[4][3] = String.valueOf(mButton24.getTextColors());
        colors[4][4] = String.valueOf(mButton25.getTextColors());


        for (int i = 0; i < 5; i++) {
            if ((colors[i][0].equals(colors[i][1]) && (colors[i][0].equals(colors[i][2]) && (colors[i][0].equals(colors[i][3])) && (colors[i][0].equals(colors[i][4])) &&!colors[i][0].equals("")))) {
                return true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if ((colors[0][i].equals(colors[1][i]) && (colors[0][i].equals(colors[2][i]) && (colors[0][i].equals(colors[3][i])) && (colors[0][i].equals(colors[4][i])) && !colors[0][i].equals("")))) {
                return true;
            }
        }
        if ((colors[0][0].equals(colors[1][1]) && (colors[0][0].equals(colors[2][2]) && (colors[0][0].equals(colors[3][3])) && (colors[0][0].equals(colors[4][4]))  &&!colors[0][0].equals("")))) {
            return true;
        }
        if ((colors[0][2].equals(colors[1][1]) && (colors[0][2].equals(colors[2][0]) && !colors[0][2].equals("")))) {
            return true;
        }

        return false;

    }
    private void resetBoard() {
        mButton1.setTextColor(Color.RED);
        mButton2.setTextColor(Color.RED);
        mButton3.setTextColor(Color.RED);
        mButton4.setTextColor(Color.RED);
        mButton5.setTextColor(Color.RED);
        mButton6.setTextColor(Color.RED);
        mButton7.setTextColor(Color.RED);
        mButton8.setTextColor(Color.RED);
        mButton9.setTextColor(Color.RED);
        mButton10.setTextColor(Color.RED);
        mButton11.setTextColor(Color.RED);
        mButton12.setTextColor(Color.RED);
        mButton13.setTextColor(Color.RED);
        mButton14.setTextColor(Color.RED);
        mButton15.setTextColor(Color.RED);
        mButton16.setTextColor(Color.RED);
        mButton17.setTextColor(Color.RED);
        mButton18.setTextColor(Color.RED);
        mButton19.setTextColor(Color.RED);
        mButton20.setTextColor(Color.RED);
        mButton21.setTextColor(Color.RED);
        mButton22.setTextColor(Color.RED);
        mButton23.setTextColor(Color.RED);
        mButton24.setTextColor(Color.RED);
        mButton25.setTextColor(Color.RED);
        roundCount = 0;
        player1True = true;
    }
}