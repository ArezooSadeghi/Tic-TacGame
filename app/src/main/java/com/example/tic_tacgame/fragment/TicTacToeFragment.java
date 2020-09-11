package com.example.tic_tacgame.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.tic_tacgame.R;
import com.google.android.material.snackbar.Snackbar;

public class TicTacToeFragment extends Fragment implements View.OnClickListener {

    private Button[][] mButtons = new Button[3][3];
    private String[][] mTextOfButtons = new String[3][3];
    private boolean mIsPlayerOneClicked = true;
    private int mNumberOfMoves = 0;
    private static final String MTEXTOFBUTTONS = "ArrayOfTextOfButtons";
    private static final String MNUMBEROFMOVES = "Numberofmoves";
    private static final String M_ISPLAYER_ONE_CLICKED = "mIsplayerOneClicked";

    public TicTacToeFragment() {
    }

    public static TicTacToeFragment newInstance() {
        Bundle args = new Bundle();
        TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
        ticTacToeFragment.setArguments(args);
        return ticTacToeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mTextOfButtons = (String[][]) savedInstanceState.getSerializable(MTEXTOFBUTTONS);
            mIsPlayerOneClicked = savedInstanceState.getBoolean(M_ISPLAYER_ONE_CLICKED);
            mNumberOfMoves = savedInstanceState.getInt(MNUMBEROFMOVES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
        findViews(view);
        setListeners();
        loadState();
        return view;
    }

    public void setListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setOnClickListener(this);
            }
        }
    }

    private void loadState() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText(mTextOfButtons[i][j]);
            }
        }
        if (checkForWin()) {
            resetBoard();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MTEXTOFBUTTONS, mTextOfButtons);
        outState.putInt(MNUMBEROFMOVES, mNumberOfMoves);
        outState.putBoolean(M_ISPLAYER_ONE_CLICKED, mIsPlayerOneClicked);
    }

    private void findViews(View view) {
        mButtons[0][0] = view.findViewById(R.id.btn_00);
        mButtons[0][1] = view.findViewById(R.id.btn_01);
        mButtons[0][2] = view.findViewById(R.id.btn_02);
        mButtons[1][0] = view.findViewById(R.id.btn_10);
        mButtons[1][1] = view.findViewById(R.id.btn_11);
        mButtons[1][2] = view.findViewById(R.id.btn_12);
        mButtons[2][0] = view.findViewById(R.id.btn_20);
        mButtons[2][1] = view.findViewById(R.id.btn_21);
        mButtons[2][2] = view.findViewById(R.id.btn_22);
    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (mIsPlayerOneClicked) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }
        mNumberOfMoves++;

        if (checkForWin()) {
            if (mIsPlayerOneClicked) {
                playerOneWins();
            } else {
                playerTwoWins();
            }
        } else if (mNumberOfMoves == 9) {
            draw();
        } else {
            mIsPlayerOneClicked = !mIsPlayerOneClicked;
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mTextOfButtons[i][j] = mButtons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if ((mTextOfButtons[i][0].equals(mTextOfButtons[i][1]) && (mTextOfButtons[i][0]
                    .equals(mTextOfButtons[i][2]) && !mTextOfButtons[i][0].equals("")))) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if ((mTextOfButtons[0][i].equals(mTextOfButtons[1][i]) && (mTextOfButtons[0][i]
                    .equals(mTextOfButtons[2][i]) && !mTextOfButtons[0][i].equals("")))) {
                return true;
            }
        }
        if ((mTextOfButtons[0][0].equals(mTextOfButtons[1][1]) && (mTextOfButtons[0][0]
                .equals(mTextOfButtons[2][2]) && !mTextOfButtons[0][0].equals("")))) {
            return true;
        }
        if ((mTextOfButtons[0][2].equals(mTextOfButtons[1][1]) && (mTextOfButtons[0][2]
                .equals(mTextOfButtons[2][0]) && !mTextOfButtons[0][2].equals("")))) {
            return true;
        }
        return false;
    }

    private void playerOneWins() {
        Snackbar snackbar = Snackbar.make(getView(), "Player One Wins!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    private void playerTwoWins() {
        Snackbar snackbar = Snackbar.make(getView(), "Player Two Wins!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    private void draw() {
        Snackbar snackbar = Snackbar.make(getView(), "Draw!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    private void customSnackBar(Snackbar snackbar) {
        View view = snackbar.getView();
        view.setBackgroundColor(Color.parseColor("#696969"));
        snackbar.show();
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText("");
            }
        }
        mNumberOfMoves = 0;
        mIsPlayerOneClicked = true;
    }
}