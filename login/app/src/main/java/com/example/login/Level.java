package com.example.login;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Level extends AppCompatActivity {
    Button Easy, Medium, Difficult, Quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);



        Easy = (Button) findViewById(R.id.BtnDe);
        Easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this, formQuiz.class);
                intent.putExtra("Muc","De");
                startActivity(intent);
            }
        });
        Medium = (Button) findViewById(R.id.BtnTrungbinh);
        Medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this, formQuizNormal.class);
                intent.putExtra("Muc","TB");
                startActivity(intent);
            }
        });
        Difficult = (Button) findViewById(R.id.BtnKho);
        Difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level.this, TestHard.class);
                intent.putExtra("Muc","Kho");
                startActivity(intent);
            }
        });
        Quit = (Button) findViewById(R.id.BtThoat);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
