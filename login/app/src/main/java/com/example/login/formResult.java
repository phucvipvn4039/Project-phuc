package com.example.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class formResult extends AppCompatActivity {
    Button Back,Savescore,Playagain;
    TextView KQ;
    ArrayList<Question> L = new ArrayList<>();

    int pos = 0;//vị trí câu hỏi trong danh sách
    int kq = 0; //lưu số câu trả lời đúng

    ScoreController controller;

    MediaPlayer SoundBackground = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);
        SoundBackground = MediaPlayer.create(formResult.this, R.raw.winner);
        SoundBackground.start();

        final Intent intent = getIntent();
        L = (ArrayList<Question>) intent.getExtras().getSerializable("Questions");
        KQ = (TextView) findViewById(R.id.TxtKQ);
        Savescore = (Button) findViewById(R.id.BtnLuuDiem);
        Playagain = (Button) findViewById(R.id.Btnplayagain);
        Back = (Button) findViewById(R.id.BtnBack);

        controller = new ScoreController(formResult.this);

        Intent callintent = getIntent();
        Bundle packageFromCaller = callintent.getBundleExtra("MyPackage");
        KQ.setText(packageFromCaller.getInt("KQ") + "/" + packageFromCaller.getInt("Socau"));

        Savescore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(formResult.this);
                LayoutInflater inflater = formResult.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.activity_savescore,null);
                builder.setView(view);

                final EditText Name = (EditText) view.findViewById(R.id.edtHoTen);
                final TextView Score= (TextView) view.findViewById(R.id.tvScore);
                final EditText Room = (EditText) view.findViewById(R.id.edtEmail);

                Score.setText(packageFromCaller.getInt("KQ") + "/" + packageFromCaller.getInt("Socau"));
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = Name.getText().toString();
                        String score = Score.getText().toString();
                        String room = Room.getText().toString();

                        controller.insertScore(name,score,room);
                        Toast.makeText(formResult.this,"Lưu điểm thành công!", Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog Ad = builder.create();
                Ad.show();
            }
        });

        Playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formResult.this, formQuiz.class);
                intent.putExtra("Muc","De");
                startActivity(intent);
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(formResult.this, Trangchu.class);
                startActivity(intent);
            }
        });
    }




}