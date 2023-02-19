package com.example.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseSave extends SQLiteOpenHelper {
    public static final String SaveScore_TABLE = "SaveScore";
    public static final String COLUMN_id = "id";
    public static final String COLUMN_Ten = "Ten";
    public static final String COLUMN_Mssv  = "Mssv";
    public static final String COLUMN_Muc = "Muc";

    public DatabaseSave(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "tracnghiem.db", null ,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlStatement = "CREATE TABLE IF NOT EXISTS " + SaveScore_TABLE + " (" + COLUMN_id + " INTEGER PRIMARY KEY AUTOINCREMENT , " + COLUMN_Ten + " TEXT , "
                +COLUMN_Mssv + " TEXT , " + COLUMN_Muc + " TEXT)";
        db.execSQL(sqlStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
