package com.example.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class TestHard extends Activity {
    TextView Cauhoi, Ketqua;
    Button Answer;
    EditText editAnswer;
    ImageView iv_flag;
    private int pos = 0;//vị trí câu hỏi trong danh sách
    private int kq = 0; //lưu số câu trả lời đúng
    public ArrayList<Question> L = new ArrayList(); //chứa câu hỏi
    String Muc;
    int HighScore = 0;
    MediaPlayer SoundBackground = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hard);

        Intent intent = getIntent();
        Muc = intent.getStringExtra("Muc");

        SoundBackground = MediaPlayer.create(TestHard.this, R.raw.wakawaka);
        SoundBackground.start();

        Cauhoi = (TextView) findViewById(R.id.TxtCauhoi);
        Ketqua = (TextView) findViewById(R.id.TxtKetqua);
        iv_flag = (ImageView) findViewById(R.id.Ivimage);
        Answer = (Button) findViewById(R.id.BtnTraloi);
        editAnswer = (EditText) findViewById(R.id.edtAnswer);

        LoadHighScore();
        ReadData(Muc);
        Display(pos);

        Answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (L.get(pos).getAnswer().equalsIgnoreCase(editAnswer.getText().toString())) {
                    kq = kq +1;
                }
                pos++;
                //Nếu trả lời hết câu hỏi
                if (pos >= L.size()) {
                    Intent intent = new Intent(TestHard.this, formResult.class);
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
            Question question = L.get(index);
            Cauhoi.setText(question.Question);
            iv_flag.setImageResource(getResources().getIdentifier(getItem(pos).getImage() + "", "drawable", "com.example.login"));
            Ketqua.setText("Câu đúng: " + kq);

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

    public void ReadData(String muc) {
        Database database = new Database(this);
        List<Question> Q = database.getQuestion(muc);
        for (int i = 0; i < Q.size(); i++) {
            Question question = new Question();
            question.ID = Q.get(i).ID;
            question.Question = Q.get(i).Question;
            question.Answer = Q.get(i).Answer;
            question.Image= Q.get(i).getImage();
            L.add(question);
        }

    }

//        r = new Random();
//
//        Ivimage = (ImageView) findViewById(R.id.Ivimage);
//        Answer = (Button) findViewById(R.id.BtnTraloi);
//        edtAnswer = (EditText) findViewById(R.id.edtAnswer);
//
//        list = new ArrayList<>();
//        for (int  i = 0; i < new DatabaseKho().answers.length; i++ ) {
//            list.add(new StateModel(new DatabaseKho().answers[i], new DatabaseKho().player[i]));
//            Collections.shuffle(list);
//        }
//        Ivimage.setImageResource(list.get(turn).getImage());
//
//        Answer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (edtAnswer.getText().toString().equalsIgnoreCase(list.get(turn).getName())) {
//                    Toast.makeText(TestHard.this,"Right",Toast.LENGTH_SHORT).show();
//                    rightAnswer +=1;
//                } else {
//                    Toast.makeText(TestHard.this,"Wrong",Toast.LENGTH_SHORT).show();
//                }
//                turn += 1;
//
//                if (turn == list.size()) {
//                    getResult();
//                }
//                Ivimage.setImageResource(list.get(turn).getImage());
//                edtAnswer.setText("");
//            }
//        });
//    }
//
//    private void getResult() {
//        Intent intent = new Intent(getApplicationContext(), Result.class);
//        intent.putExtra("rightAnswer",rightAnswer);
//        startActivity(intent);
}