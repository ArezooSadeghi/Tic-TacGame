package com.example.tic_tacgame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class TicTacToeFragment extends Fragment {
    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;

    private Button mButton10;

    private int[][] matrix = new int[3][3];

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

        setListeners();

        return view;


    }

    private Button[] myButtons = {mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9};

    private void setListeners() {
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matrix[0][0] = 1;
                mButton1.setText("×");
                mButton1.setEnabled(false);
                Random random = new Random();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });

        mButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo
            }
        });
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
}