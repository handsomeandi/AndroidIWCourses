package com.example.coursehomeworkthree;

import android.app.Application;

import androidx.room.Room;

import static com.example.coursehomeworkthree.MainActivity.DB_NAME;

public class MyApp extends Application {
    public static MyApp instance;
    MyDatabase myDatabase;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        myDatabase = Room.databaseBuilder(this, MyDatabase.class, DB_NAME).allowMainThreadQueries().fallbackToDestructiveMigration()
                .build();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public MyDatabase getDatabase() {
        return myDatabase;
    }
}
