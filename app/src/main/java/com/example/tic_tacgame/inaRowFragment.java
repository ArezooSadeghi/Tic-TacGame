package com.example.tic_tacgame;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class inaRowFragment extends Fragment implements View.OnClickListener {

    private Button[][] mButtons = new Button[5][5];

    private boolean mIsPlayerOneClicked = true;

    private int mNumberOfMoves = 0;

    private int[][] mColorOfButtons = new int[5][5];

    private static final String M_COLOR_OF_BUTTONS = "mColorOfButtons";
    private static final String M_NUMBER_OF_MOVES = "mNumberOfMoves";
    private static final String M_IS_PLAYER_ONE_CLICKED = "mIsPlayerOneClicked";

    public inaRowFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mNumberOfMoves = savedInstanceState.getInt(M_NUMBER_OF_MOVES);
            mIsPlayerOneClicked = savedInstanceState.getBoolean(M_IS_PLAYER_ONE_CLICKED);
            mColorOfButtons = (int[][]) savedInstanceState.getSerializable(M_COLOR_OF_BUTTONS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ina_row, container, false);

        findViews(view);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mButtons[i][j].setOnClickListener(this);
            }
        }

        loadState();
        return view;
    }

    private void loadState() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (mColorOfButtons[i][j] != 0) {
                    mButtons[i][j].setBackgroundColor(mColorOfButtons[i][j]);
                }
            }
        }
        if (checkForWin()) {
            resetBoard();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(M_COLOR_OF_BUTTONS, mColorOfButtons);
        outState.putInt(M_NUMBER_OF_MOVES, mNumberOfMoves);
        outState.putBoolean(M_IS_PLAYER_ONE_CLICKED, mIsPlayerOneClicked);
    }

    private void findViews(View view) {
        mButtons[0][0] = view.findViewById(R.id.btn_00);
        mButtons[0][1] = view.findViewById(R.id.btn_01);
        mButtons[0][2] = view.findViewById(R.id.btn_02);
        mButtons[0][3] = view.findViewById(R.id.btn_03);
        mButtons[0][4] = view.findViewById(R.id.btn_04);
        mButtons[1][0] = view.findViewById(R.id.btn_10);
        mButtons[1][1] = view.findViewById(R.id.btn_11);
        mButtons[1][2] = view.findViewById(R.id.btn_12);
        mButtons[1][3] = view.findViewById(R.id.btn_13);
        mButtons[1][4] = view.findViewById(R.id.btn_14);
        mButtons[2][0] = view.findViewById(R.id.btn_20);
        mButtons[2][1] = view.findViewById(R.id.btn_21);
        mButtons[2][2] = view.findViewById(R.id.btn_22);
        mButtons[2][3] = view.findViewById(R.id.btn_23);
        mButtons[2][4] = view.findViewById(R.id.btn_24);
        mButtons[3][0] = view.findViewById(R.id.btn_30);
        mButtons[3][1] = view.findViewById(R.id.btn_31);
        mButtons[3][2] = view.findViewById(R.id.btn_32);
        mButtons[3][3] = view.findViewById(R.id.btn_33);
        mButtons[3][4] = view.findViewById(R.id.btn_34);
        mButtons[4][0] = view.findViewById(R.id.btn_40);
        mButtons[4][1] = view.findViewById(R.id.btn_41);
        mButtons[4][2] = view.findViewById(R.id.btn_42);
        mButtons[4][3] = view.findViewById(R.id.btn_43);
        mButtons[4][4] = view.findViewById(R.id.btn_44);
    }

    @Override
    public void onClick(View view) {
        int color = ((ColorDrawable) ((Button) view).getBackground()).getColor();
        if (color != -4144960) {
            return;
        }
        if (mIsPlayerOneClicked) {
            ((Button) view).setBackgroundColor(Color.parseColor("#FF0000"));
        } else {
            ((Button) view).setBackgroundColor(Color.parseColor("#0000FF"));
        }
        mNumberOfMoves++;
        if (checkForWin()) {
            if (mIsPlayerOneClicked) {
                playerOneWins();
            } else {
                playerTwoWins();
            }
        } else if (mNumberOfMoves == 25) {
            draw();
        } else {
            mIsPlayerOneClicked = !mIsPlayerOneClicked;
        }

    }

    public boolean checkForWin() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mColorOfButtons[i][j] = ((ColorDrawable) mButtons[i][j].getBackground()).getColor();
            }
        }
        for (int i = 0; i < 5; i++) {
            if ((mColorOfButtons[i][0] == mColorOfButtons[i][1]) && (mColorOfButtons[i][1] == mColorOfButtons[i][2]) &&
                    (mColorOfButtons[i][2] == mColorOfButtons[i][3]) && (mColorOfButtons[i][0] != -4144960)) {
                return true;
            }
            if ((mColorOfButtons[i][1] == mColorOfButtons[i][2]) && (mColorOfButtons[i][2] == mColorOfButtons[i][3]) &&
                    (mColorOfButtons[i][3] == mColorOfButtons[i][4]) && (mColorOfButtons[i][1] != -4144960)) {
                return true;
            }
        }
        for (int i = 0; i < 5; i++) {
            if ((mColorOfButtons[0][i] == mColorOfButtons[1][i]) && (mColorOfButtons[1][i] == mColorOfButtons[2][i]) &&
                    (mColorOfButtons[2][i] == mColorOfButtons[3][i]) && (mColorOfButtons[0][i] != -4144960)) {
                return true;
            }
            if ((mColorOfButtons[1][i] == mColorOfButtons[2][i]) && (mColorOfButtons[2][i] == mColorOfButtons[3][i]) &&
                    (mColorOfButtons[3][i] == mColorOfButtons[4][i]) && (mColorOfButtons[1][i] != -4144960)) {
                return true;
            }
        }
        if ((mColorOfButtons[0][0] == mColorOfButtons[1][1]) && (mColorOfButtons[1][1] == mColorOfButtons[2][2]) &&
                (mColorOfButtons[2][2] == mColorOfButtons[3][3]) && (mColorOfButtons[0][0] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[1][1] == mColorOfButtons[2][2]) && (mColorOfButtons[2][2] == mColorOfButtons[3][3]) &&
                (mColorOfButtons[3][3] == mColorOfButtons[4][4]) && (mColorOfButtons[1][1] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[1][0] == mColorOfButtons[2][1]) && (mColorOfButtons[2][1] == mColorOfButtons[3][2]) &&
                (mColorOfButtons[3][2] == mColorOfButtons[4][3]) && (mColorOfButtons[1][0] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[0][1] == mColorOfButtons[1][2]) && (mColorOfButtons[1][2] == mColorOfButtons[2][3]) &&
                (mColorOfButtons[2][3] == mColorOfButtons[3][4]) && (mColorOfButtons[0][1] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[0][3] == mColorOfButtons[1][2]) && (mColorOfButtons[1][2] == mColorOfButtons[2][1]) &&
                (mColorOfButtons[2][1] == mColorOfButtons[3][0]) && (mColorOfButtons[0][3] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[1][4] == mColorOfButtons[2][3]) && (mColorOfButtons[2][3] == mColorOfButtons[3][2]) &&
                (mColorOfButtons[3][2] == mColorOfButtons[4][1]) && (mColorOfButtons[1][4] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[0][4] == mColorOfButtons[1][3]) && (mColorOfButtons[1][3] == mColorOfButtons[2][2]) &&
                (mColorOfButtons[2][2] == mColorOfButtons[3][1]) && (mColorOfButtons[0][4] != -4144960)) {
            return true;
        }
        if ((mColorOfButtons[1][3] == mColorOfButtons[2][2]) && (mColorOfButtons[2][2] == mColorOfButtons[3][1]) &&
                (mColorOfButtons[3][1] == mColorOfButtons[4][0]) && (mColorOfButtons[1][3] != -4144960)) {
            return true;
        }
        return false;
    }

    public void playerOneWins() {
        Snackbar snackbar = Snackbar.make(getView(), "Player One Wins!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    public void playerTwoWins() {
        Snackbar snackbar = Snackbar.make(getView(), "Player Two Wins!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    public void draw() {
        Snackbar snackbar = Snackbar.make(getView(), "Draw!!!", Snackbar.LENGTH_SHORT);
        customSnackBar(snackbar);
        resetBoard();
    }

    public void customSnackBar(Snackbar snackbar) {
        View view = snackbar.getView();
        view.setBackgroundColor(Color.parseColor("#696969"));
        snackbar.show();
    }

    public void resetBoard() {
        mIsPlayerOneClicked = true;
        mNumberOfMoves = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mButtons[i][j].setBackgroundColor(-4144960);
            }
        }
    }
}

