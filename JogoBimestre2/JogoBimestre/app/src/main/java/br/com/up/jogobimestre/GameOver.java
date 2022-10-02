package br.com.up.jogobimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    Button mRestarButton;
    TextView tScore,tBest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        mRestarButton = findViewById(R.id.btnRestart);
        int scoreCount = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("myStoragePreferences", 0);
        int scoreBest = pref.getInt("scoreBest", 0);
        SharedPreferences.Editor edit = pref.edit();
        if (scoreCount > scoreBest){
            scoreBest = scoreCount;
            edit.putInt("scoreBest", scoreBest);
            edit.apply();
        }


        mRestarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(GameOver.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
        tScore = findViewById(R.id.scoreDisplay);
        tBest = findViewById(R.id.BestDisplay);
        tScore.setText(""+scoreCount);
        tBest.setText(""+scoreBest);

    }
}