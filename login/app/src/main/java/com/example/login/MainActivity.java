package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button btnDangNhap,Quit,btnDangky;
    EditText edtEmail, edtPassword, edtTK, edtMK;
    FirebaseAuth mAuthencation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuthencation = FirebaseAuth.getInstance();
        Anhxa();

        btnDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DangKy.class);
                startActivity(intent);
            }
        });

        btnDangNhap=(Button)findViewById(R.id.buttonDangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });

        Quit = (Button) findViewById(R.id.BtnBack);
        Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void DangNhap(){
        String email = edtTK.getText().toString();
        String pass = edtMK.getText().toString();
        mAuthencation.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this,"Đăng nhập thành công", LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Trangchu.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this,"Đăng nhập Thất bại", LENGTH_SHORT).show();
                        }



                        // ...
                    }
                });
    }


    private void Anhxa() {
        btnDangNhap = (Button) findViewById(R.id.buttonDangNhap);
        edtTK =(EditText)findViewById(R.id.editTextTaiKhoan);
        edtMK =(EditText)findViewById(R.id.editTextMatkhau);
        btnDangky=(Button)findViewById(R.id.BtnDangKy);

    }
}