package com.example.coursehomeworkthree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import static com.example.coursehomeworkthree.UserRecyclerViewAdapter.USER_DATA_EXTRA;

public class MainActivity extends AppCompatActivity implements UserRecyclerViewAdapter.UserClickListener {

    RecyclerView usersRecyclerView;
    UserRecyclerViewAdapter userRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersRecyclerView = findViewById(R.id.usersRecyclerView);
        userRecyclerViewAdapter = new UserRecyclerViewAdapter(this);
        userRecyclerViewAdapter.setUsers(getData());
        usersRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        usersRecyclerView.setAdapter(userRecyclerViewAdapter);
    }


    private ArrayList<UserClass> getData(){
        ArrayList<UserClass> data = new ArrayList<>();
        data.add(new UserClass("https://i.pinimg.com/originals/7e/34/fc/7e34fc3ce65d1891d3af004795b34462.jpg",
                "Орлов Сергей Александрович","13.06.1992", "gogog@mail.ru"));
        data.add(new UserClass("https://bigpicture.ru/wp-content/uploads/2014/10/idealman11.jpg",
                "Иванов Олег Сергеевич","13.06.1993", "alalla@mail.ru"));
        data.add(new UserClass("https://mensby.com/wp-content/uploads/2019/06/chto-delaet-lico-muzhchiny-privlekatelnym-kak-stat-privlekatelnee-02.jpg",
                "Сидоров Игнат Русланович","13.06.1990", "kokoko@mail.ru"));
        data.add(new UserClass("https://bigpicture.ru/wp-content/uploads/2014/10/idealman04.jpg",
                "Алексеев Афанасий Мамедович","13.06.1996", "fasfaf@mail.ru"));
        data.add(new UserClass("https://i.pinimg.com/564x/f6/44/e8/f644e8c005bc379402a8cca745217832.jpg",
                "Симонов Евгений Олегович","13.06.1998", "momoom@mail.ru"));
        data.add(new UserClass("https://www.firestock.ru/download/s/pk7e29ij2549wak/fotolia_39580439_l.jpg",
                "Пиняев Иван Михаилович","13.06.1982", "nanan@mail.ru"));
        data.add(new UserClass("https://www.firestock.ru/download/s/k7wsyrkmqpuoh0l/photodune-3384761.png",
                "Онегин Андрей Иванович","13.06.2000", "poppoop@mail.ru"));
        return data;

    }

    @Override
    public void onUserClick(View v, int position) {
        Intent user_intent = new Intent(this,UserActivity.class);
        user_intent.putExtra(USER_DATA_EXTRA, getData().get(position));
        startActivity(user_intent);
    }
}