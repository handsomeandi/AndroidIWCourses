package com.example.coursehomeworkthree;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import static com.example.coursehomeworkthree.MainActivity.DB_VERSION;

@Database(entities = {UserClass.class}, version = DB_VERSION)
public abstract class MyDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
