package com.example.coursehomeworkthree;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<UserClass> getAll();


    @Insert
    void insert(UserClass user);

    @Query("DELETE FROM users")
    void deleteAll();
}
