package com.example.coursehomeworkthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import static com.example.coursehomeworkthree.UserRecyclerViewAdapter.USER_DATA_EXTRA;

public class MainActivity extends AppCompatActivity implements UserRecyclerViewAdapter.UserClickListener {

    RecyclerView usersRecyclerView;
    UserRecyclerViewAdapter userRecyclerViewAdapter;
    ArrayList<UserClass> users;
    Gson gson = new Gson();
    public static final String MY_PREFS = "myprefs";
    public static final String MY_ARRAY = "myarray";
    public static final String LOG_TAG = "myLog";
    public static final String DB_NAME = "database";
    public static final int DB_VERSION = 2;
    MyDatabase myDB = MyApp.getInstance().getDatabase();
    UserDao userDao = myDB.userDao();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = getData();
        usersRecyclerView = findViewById(R.id.usersRecyclerView);
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(this);
        userRecyclerViewAdapter.setUsers(users);
        usersRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        usersRecyclerView.setAdapter(userRecyclerViewAdapter);
        String saved_array = gson.toJson(users);
        saveArray(saved_array);
        deleteData();
        saveData();
        showData();

    }

    private void deleteData(){
        userDao.deleteAll();
    }


    private void saveData(){
        for(UserClass user:users){
            userDao.insert(user);
        }
    }

    private void showData(){
        List<UserClass> usersFromDB = userDao.getAll();
        for(UserClass user:usersFromDB){
            Log.d(LOG_TAG, "ID = " + user.getId() +
                    ", name = " + user.getUsername() +
                    ", email = " + user.getEmail() +
                    ", date of birth = " + user.getDateOfBirth() +
                    ", img url = " + user.getImg_url());
        }
    }

    private ArrayList<UserClass> getData(){
        ArrayList<UserClass> data = new ArrayList<>();
        data.add(new UserClass("https://i.pinimg.com/originals/7e/34/fc/7e34fc3ce65d1891d3af004795b34462.jpg",
                "?????????? ???????????? ??????????????????????????","13.06.1992", "gogog@mail.ru"));
        data.add(new UserClass("https://bigpicture.ru/wp-content/uploads/2014/10/idealman11.jpg",
                "???????????? ???????? ??????????????????","13.06.1993", "alalla@mail.ru"));
        data.add(new UserClass("https://mensby.com/wp-content/uploads/2019/06/chto-delaet-lico-muzhchiny-privlekatelnym-kak-stat-privlekatelnee-02.jpg",
                "?????????????? ?????????? ????????????????????","13.06.1990", "kokoko@mail.ru"));
        data.add(new UserClass("https://bigpicture.ru/wp-content/uploads/2014/10/idealman04.jpg",
                "???????????????? ???????????????? ??????????????????","13.06.1996", "fasfaf@mail.ru"));
        data.add(new UserClass("https://i.pinimg.com/564x/f6/44/e8/f644e8c005bc379402a8cca745217832.jpg",
                "?????????????? ?????????????? ????????????????","13.06.1998", "momoom@mail.ru"));
        data.add(new UserClass("https://www.firestock.ru/download/s/pk7e29ij2549wak/fotolia_39580439_l.jpg",
                "???????????? ???????? ????????????????????","13.06.1982", "nanan@mail.ru"));
        data.add(new UserClass("https://www.firestock.ru/download/s/k7wsyrkmqpuoh0l/photodune-3384761.png",
                "???????????? ???????????? ????????????????","13.06.2000", "poppoop@mail.ru"));
        return data;

    }

    private void saveArray(String saved_arr){
        SharedPreferences sharedPreferences = this.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(MY_ARRAY);
        editor.putString(MY_ARRAY, saved_arr);
        editor.apply();
        Log.d("SharedPrefs", sharedPreferences.getString(MY_ARRAY, ""));
    }

    @Override
    public void onUserClick(View v, int position) {
        Intent user_intent = new Intent(this,UserActivity.class);
        user_intent.putExtra(USER_DATA_EXTRA, userRecyclerViewAdapter.getUsers().get(position));
        startActivity(user_intent);
    }

    @Override
    public void onDeleteClick(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(this.getString(R.string.user_delete));
        builder.setMessage(this.getString(R.string.sure_delete));
        builder.setPositiveButton(this.getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userRecyclerViewAdapter.removeUser(position);
                saveArray(gson.toJson(userRecyclerViewAdapter.getUsers()));
            }
        }).setNegativeButton(this.getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog
                = builder.create();
        dialog.show();
    }
}