package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Highscore extends AppCompatActivity {
    TextView Txt1;
    Button Back;
    int HighScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        Txt1 = (TextView)findViewById(R.id.TxtHighscore);
        Back = (Button) findViewById(R.id.BtnBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        LoadHighScore();
        Txt1.setText(""+ HighScore);




    }

    void LoadHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {
            HighScore = sharedPreferences.getInt("H", 0);
        }
    }
}