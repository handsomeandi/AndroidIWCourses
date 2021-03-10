package com.example.coursehomeworktwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            FragmentManager fragManager = getSupportFragmentManager();
            FragmentTransaction fragTrans = fragManager.beginTransaction();
            MyFragment myFrag = MyFragment.newInstance();
            fragTrans.add(R.id.frameLay, myFrag);
            fragTrans.commit();
        }
    }
}