package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScoreController {
    private Database dbHelper;

    public ScoreController(Context context) {
        dbHelper = new Database(context);
    }

    public void insertScore(String name, String score, String room) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("room", room);
        db.insert("tbscore",null,values);
        db.close();
    }

    //Lay danh sach
    public Cursor getScore() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor  cursor = db.query("tbscore",  //ten bang
                null, //danh sach cot
                null,  // dieu kien
                null, // doi so dieu kien
                null,  // bieu thuc groupby
                null,  // bieu thuc having
                "_id DESC", //bieu thuc orderby
                null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
}
