package com.example.coursehomeworkthree;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  DBHelper extends SQLiteOpenHelper {

    public static final String NAME_COL = "name";
    public static final String EMAIL_COL = "email";
    public static final String IMG_COL = "img_url";
    public static final String BIRTH_COL = "birthday";

    public DBHelper(Context context){
        super(context,"myDB", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users ("
                + "id integer primary key autoincrement,"
                + NAME_COL+ " text,"
                + EMAIL_COL + " text,"
                + IMG_COL + " text,"
                + BIRTH_COL + " text" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
