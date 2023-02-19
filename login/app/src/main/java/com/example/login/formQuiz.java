package com.example.login;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class formQuiz extends AppCompatActivity {
    private TextView Cauhoi, Ketqua, timer;
    private RadioGroup RG;
    private Button BT, Checkanswer;
    private RadioButton A, B, C, D;
    ImageView iv_flag;
    private int pos = 0;//vị trí câu hỏi trong danh sách
    private int kq = 0; //lưu số câu trả lời đúng
    public ArrayList<Question> L = new ArrayList(); //chứa câu hỏi
    int HighScore = 0;
    String Muc;
    public int checkanser = 0;
    CounterClass Timer;
    int totalTimer;
    MediaPlayer SoundBackground = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_quiz);

        Intent intent = getIntent();
        Muc = intent.getStringExtra("Muc");

        SoundBackground = MediaPlayer.create(formQuiz.this, R.raw.wakawaka);
        SoundBackground.start();

        Cauhoi = (TextView) findViewById(R.id.TxtCauhoi);
        Ketqua = (TextView) findViewById(R.id.TxtKetqua);
        timer = (TextView) findViewById(R.id.tvTimer);
        iv_flag = (ImageView) findViewById(R.id.Ivimage);
        RG = (RadioGroup) findViewById(R.id.RadioGroupTraloi);
        BT = (Button) findViewById(R.id.BtnTraloi);
        A = (RadioButton) findViewById(R.id.RdbA);
        B = (RadioButton) findViewById(R.id.RdbB);
        C = (RadioButton) findViewById(R.id.RdbC);
        D = (RadioButton) findViewById(R.id.RdbD);
        Checkanswer = (Button) findViewById(R.id.tvKiemTra);




        //Thoi gian dem ngươc
        totalTimer = 1;
        Timer = new CounterClass(totalTimer * 30 * 1000, 1000);

        LoadHighScore();
        ReadData(Muc);
        Display(pos);
        findViewByID();

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Timer.start();

        Checkanswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkanswer();
            }
        });

        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idCheck = RG.getCheckedRadioButtonId();
                switch (idCheck) {
                    case R.id.RdbA:
                        //Nếu đáp án là câu A thì cộng kq lên 1
                        if (L.get(pos).Answer.compareTo("A") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbB:
                        //Nếu đáp án là câu B thì cộng kq lên 1
                        if (L.get(pos).Answer.compareTo("B") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbC:
                        //Nếu đáp án là câu C thì cộng kq lên 1
                        if (L.get(pos).Answer.compareTo("C") == 0) kq = kq + 1;
                        break;
                    case R.id.RdbD:
                        //Nếu đáp án là câu D thì cộng kq lên 1
                        if (L.get(pos).Answer.compareTo("D") == 0) kq = kq + 1;
                        break;
                }
                pos++;
                //Nếu trả lời hết câu hỏi
                if (pos >= L.size()) {
                    Intent intent = new Intent(formQuiz.this, formResult.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("KQ", kq);
                    bundle.putInt("Socau", pos);
                    intent.putExtra("MyPackage", bundle);
                    startActivity(intent);
                    if (kq > HighScore) {
                        HighScore = kq;
                        SaveHighScore();
                    }
                    SoundBackground.stop();
                    finish();
                } else Display(pos); //Hiển thị câu tiếp theo
            }
        });
    }


    void Display(int index) {
        try {
            Question question = L.get(index);
            Cauhoi.setText(question.Question);
            A.setText(question.AnswerA);
            B.setText(question.AnswerB);
            C.setText(question.AnswerC);
            D.setText(question.AnswerD);

            iv_flag.setImageResource(getResources().getIdentifier(getItem(pos).getImage() + "", "drawable", "com.example.login"));
            Ketqua.setText("Câu đúng: " + kq);
            RG.clearCheck();

        } catch (Exception e) {
            String msg = "Không có câu hỏi!";
            Cauhoi.setText(msg);
            A.setVisibility(View.GONE);
            B.setVisibility(View.GONE);
            C.setVisibility(View.GONE);
            D.setVisibility(View.GONE);
            Toast.makeText(this, "Error occur", Toast.LENGTH_SHORT).show();
            Log.d("xxx", "Loi ne:" + e.getMessage());
        }
        if (checkanser !=0) {
            A.setClickable(false);
            B.setClickable(false);
            C.setClickable(false);
            D.setClickable(false);
        }
        RG.setOnCheckedChangeListener((group, checkedId) -> {
            getItem(pos).ChoiceId = checkedId;
            getItem(pos).setTraloi(getChoiceFromID(checkedId));
        });
    }

    public String getChoiceFromID(int ID) {
        if (ID == R.id.RdbA) {
            return "A";
        } else if (ID == R.id.RdbB) {
            return "B";
        } else if (ID == R.id.RdbC){
            return "C";
        } else if (ID == R.id.RdbD) {
            return "D";
        } else return "";
    }

    public void ReadData(String muc) {
        Database database = new Database(this);
        List<Question> Q = database.getQuestion(muc);
        for (int i = 0; i < Q.size(); i++) {
            Question question = new Question();
            question.ID = Q.get(i).ID;
            question.Question = Q.get(i).Question;
            question.AnswerA = Q.get(i).AnswerA;
            question.AnswerB = Q.get(i).AnswerB;
            question.AnswerC = Q.get(i).AnswerC;
            question.AnswerD = Q.get(i ).AnswerD;
            question.Answer = Q.get(i).Answer;
            question.Image= Q.get(i).getImage();
            L.add(question);
        }

    }

    public Question getItem(int pos) {
        return L.get(pos);
    }

    void LoadHighScore(){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        if (sharedPreferences !=null){
            HighScore = sharedPreferences.getInt("H",0);
        }
    }
    void SaveHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("H", HighScore);
        editor.apply();
    }


    public void findViewByID(){
        Cauhoi =  findViewById(R.id.TxtCauhoi);
        Ketqua =  findViewById(R.id.TxtKetqua);
        iv_flag =  findViewById(R.id.Ivimage);
        RG =  findViewById(R.id.RadioGroupTraloi);
        BT =  findViewById(R.id.BtnTraloi);
        A =  findViewById(R.id.RdbA);
        B =  findViewById(R.id.RdbB);
        C =  findViewById(R.id.RdbC);
        D =  findViewById(R.id.RdbD);
    }

    public class CounterClass extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String countTime = String.format("%02d:%02d", java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));
            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
            timer.setText(countTime);
        }

        //het thoi gian
        @Override
        public void onFinish() {
            timer.setText("00:00");
            Intent intent = new Intent(formQuiz.this,formResult.class);
            Bundle bundle = new Bundle();
            bundle.putInt("KQ",kq);
            bundle.putInt("Socau", L.size());
            intent.putExtra("MyPackage",bundle);
            startActivity(intent);
            finish();
        }


    }

    public void checkanswer(){
        final Dialog dialog = new Dialog(formQuiz.this);
        dialog.setContentView(R.layout.activity_checkanswer);
        dialog.setTitle("Danh sach cac cau tra loi:");

        Checkanswer checkanswer = new Checkanswer(L,formQuiz.this);
        GridView gridView = (GridView) dialog.findViewById(R.id.checkanswer);
        gridView.setAdapter(checkanswer);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });

        Button finsish,close;
        finsish = (Button) dialog.findViewById(R.id.btnclose);
        close = (Button) dialog.findViewById(R.id.btnFinish);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        finsish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(formQuiz.this,formResult.class);
                Bundle bundle = new Bundle();
                bundle.putInt("KQ",kq);
                bundle.putInt("Socau", pos);
                intent.putExtra("MyPackage",bundle);
                startActivity(intent);
                if (kq > HighScore) {
                    HighScore = kq;
                    SaveHighScore();
                    finish();
                }
            }
        });
        dialog.show();
    }


        

}


