package com.example.marcadora1y2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;
    private TextView txtGanador;

    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    private RelativeLayout RL_Equipo_1;
    private  RelativeLayout RL_Equipo_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);
        txtGanador = findViewById(R.id.txGanador);

        RL_Equipo_1 = findViewById(R.id.RL_Equipo_1);
        RL_Equipo_2 = findViewById(R.id.RL_Equipo_2);

        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void decreaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.decreaseTeam1:
              //  mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }

        cambiaColorResultado();
    }

    public void increaseScore(View view) {
        int viewID = view.getId();
        switch (viewID) {
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }

        cambiaColorResultado();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }

    public void cambiaColorResultado(){
        if (mScore1 > mScore2){
            RL_Equipo_1.setBackgroundColor(getResources().getColor(R.color.green));
            RL_Equipo_2.setBackgroundColor(getResources().getColor(R.color.red));

            txtGanador.setText("Ganador: Equipo 1");

        }else if(mScore1 < mScore2){
            RL_Equipo_2.setBackgroundColor(getResources().getColor(R.color.green));
            RL_Equipo_1.setBackgroundColor(getResources().getColor(R.color.red));

            txtGanador.setText("Ganador: Equipo 2");

        }else {
            RL_Equipo_1.setBackgroundColor(getResources().getColor(R.color.yellow));
            RL_Equipo_2.setBackgroundColor(getResources().getColor(R.color.yellow));

            txtGanador.setText("Ganador: Empate..!");

        }
    }

}