 package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class choseNumberQuiz extends AppCompatActivity {
    public static int cauhoi;
    EditText Numberquestions ;
    Button Back, Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_number_quiz);
        Back = (Button) findViewById(R.id.BtnBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Numberquestions = (EditText) findViewById(R.id.Edtsocau);
        Numberquestions.addTextChangedListener(numberTextWathcer);

        Next = (Button) findViewById(R.id.BtnNext);
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cauhoi = Integer.parseInt(Numberquestions.getText().toString());

                if (cauhoi < 5 || cauhoi > 25) {
                    Numberquestions.setError("Vui lòng nhập số câu hỏi! (5 - 10 - 15 -20");
                    Numberquestions.requestFocus();
                    return;
                }

                if (cauhoi == 5) {
                    Intent intent = new Intent(choseNumberQuiz.this, Level.class);
                    startActivity(intent);
                    finish();
                }

                if (cauhoi == 10) {
                    Intent intent = new Intent(choseNumberQuiz.this, Level.class);
                    startActivity(intent);
                    finish();
                }

                if (cauhoi == 15) {
                    Intent intent = new Intent(choseNumberQuiz.this,Level.class);
                    startActivity(intent);
                    finish();
                }


            }
        });
    }

    private TextWatcher numberTextWathcer = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String chooseNumberInput = Numberquestions.getText().toString().trim();
            Next.setEnabled(!chooseNumberInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}