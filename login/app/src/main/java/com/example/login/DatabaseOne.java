package com.example.login;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOne extends SQLiteOpenHelper {
    public static final String data_TABLE = "data";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_Question= "Question";
    public static final String COLUMN_AnswerA = "AnswerA";
    public static final String COLUMN_AnswerB = "AnswerB";
    public static final String COLUMN_AnswerC = "AnswerC";
    public static final String COLUMN_AnswerD = "AnswerD";
    public static final String COLUMN_Answer = "Answer";
    public static final String COLUMN_Image = "Image";
    public static final String COLUMN_Muc = "Muc";
    public DatabaseOne(@Nullable Context context) {
        super(context, "tracnghiem.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStatement = "CREATE TABLE IF NOT EXISTS " + data_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_Question + " TEXT , "
                +COLUMN_AnswerA + " TEXT , " + COLUMN_AnswerB + " TEXT , " + COLUMN_AnswerC + " TEXT , " + COLUMN_AnswerD + " TEXT , " + COLUMN_Answer + " TEXT, "
                +COLUMN_Muc+" TEXT ,"+COLUMN_Image+"TEXT)";
        db.execSQL(sqlStatement); //THỰC THI CÂU LỆNH SQL

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Lay cau hoi cho vao list
    public List<Question> getQuestion(String Muc) {
        List<Question> returnQ = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase(); // doc du lieu
        String sqlQuerry = "SELECT * FROM "+ data_TABLE + " WHERE Muc = "+"'"+Muc+"'"+" ORDER BY random() LIMIT 10";
        Cursor cursor = database.rawQuery(sqlQuerry, null);

        if (cursor.moveToFirst()) {
            do {
                int ID = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String Question = cursor.getString(cursor.getColumnIndex(COLUMN_Question));
                String AnswerA = cursor.getString(cursor.getColumnIndex(COLUMN_AnswerA));
                String AnswerB = cursor.getString(cursor.getColumnIndex(COLUMN_AnswerB));
                String AnswerC = cursor.getString(cursor.getColumnIndex(COLUMN_AnswerC));
                String AnswerD = cursor.getString(cursor.getColumnIndex(COLUMN_AnswerD));
                String Answer = cursor.getString(cursor.getColumnIndex(COLUMN_Answer));
                String Traloi = cursor.getString(cursor.getColumnIndex(COLUMN_Muc));
                String Image = cursor.getString(cursor.getColumnIndex(COLUMN_Image));


                Question question = new Question(ID,Question,AnswerA,AnswerB,AnswerC,AnswerD,Answer,Traloi,Image);
//                question.setID(ID);
//                question.setQuestion(Question);
//                question.setAnswerA(AnswerA);
//                question.setAnswerB(AnswerB);
//                question.setAnswerC(AnswerC);
//                question.setAnswerD(AnswerD);
//                question.setAnswer(Answer);
//                question.setTraloi(Traloi);
//                question.setImage(Image);
                returnQ.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return  returnQ;
    }
}
