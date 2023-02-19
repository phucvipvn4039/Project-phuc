package com.example.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Savescore extends AppCompatActivity {
    private SQLiteDatabase db;
    private EditText editName, editPhone;
    private Button Back;

    private ListView lvUser;
    private ArrayAdapter<ScoreAttributes> adapter;
    private ArrayList<ScoreAttributes> scoreAttributes = new ArrayList<>();

    int idUpdate = -1;
    int HighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_score);

        initData();
        Back = (Button) findViewById(R.id.BtnThoat);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Savescore.this, Trangchu.class);
                startActivity(intent);
            }
        });

        lvUser = findViewById(R.id.lvUser);
        adapter = new ArrayAdapter<ScoreAttributes>(this,0,scoreAttributes){
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_list_score, null);

                TextView tvName = convertView.findViewById(R.id.tvNameStudent);
                TextView tvPhone = convertView.findViewById(R.id.tvScore);

                ScoreAttributes SA = scoreAttributes.get(position);
                tvName.setText(SA.getName());
                tvPhone.setText(SA.getScore());

                return  convertView;
            }
        };
        lvUser.setAdapter(adapter);
        loadData();

    }

    private void loadData() {
        scoreAttributes.clear();

        String sql = "SELECT * FROM tbscore";
        Cursor cursor = db.rawQuery(sql,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);

            ScoreAttributes sa = new ScoreAttributes();
            sa.setId(id);
            sa.setName(name);
            sa.setScore(phone);

            scoreAttributes.add(sa);

            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();
    }

    private void initData() {
        db = openOrCreateDatabase("tracnghiem.db", MODE_PRIVATE,null);

        String sql = "CREATE TABLE IF NOT EXISTS tbscore (id integer primary key autoincrement, name text, phone text)";
        db.execSQL(sql);
    }

    private void showInfo(int position) {
        ScoreAttributes sa = scoreAttributes.get(position);
        editName.setText(sa.getName());
        editPhone.setText(sa.getScore());

        idUpdate = sa.getId();
    }

    private void insertRow() {
        String name = editName.getText().toString();
        String phone = editPhone.getText().toString();
        String sql = "INSERT INTO tbscore (name, phone) VALUES ('" + name + "','" + phone + "')";
        db.execSQL(sql);
    }

    private void updateRow(){
        String name = editName.getText().toString();
        String phone = editPhone.getText().toString();
        String sql = "UPDATE tbscore SET name = '" + name + "', phone = '" + phone + "' WHERE id = " + idUpdate;
        db.execSQL(sql);
    }

    private void deleteUser(int position){
        int id = scoreAttributes.get(position).getId();
        String sql = "DELETE FROM tbscore WHERE id = " + id;
        db.execSQL(sql);
    }
}