package com.example.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Trangchu extends AppCompatActivity {
    Button Test, Result, Highscore, Tutorial, Quit;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        Test = (Button) findViewById(R.id.BtnTest);
        Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, choseNumberQuiz.class);
                startActivity(intent);
                mediaPlayer = MediaPlayer.create(Trangchu.this, R.raw.gun);
                mediaPlayer.start();
            }
        });
        Result = (Button) findViewById(R.id.BtnKetQuaTest);
        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, Savescore.class);
                startActivity(intent);
                mediaPlayer = MediaPlayer.create(Trangchu.this, R.raw.gun);
                mediaPlayer.start();
            }
        });
        Highscore = (Button) findViewById(R.id.BtnHighScore);
        Highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this, Highscore.class);
                startActivity(intent);
                mediaPlayer = MediaPlayer.create(Trangchu.this, R.raw.gun);
                mediaPlayer.start();
            }
        });
        Tutorial = (Button) findViewById(R.id.BtnHuongDan);
        Tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Trangchu.this,Tutorial.class);
                startActivity(intent);
                mediaPlayer = MediaPlayer.create(Trangchu.this, R.raw.gun);
                mediaPlayer.start();
            }
        });
        Quit = (Button) findViewById(R.id.BtnThoat);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }

}

