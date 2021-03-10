package com.example.coursehomeworktwo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import helpers.MyBroadcastListener;
import helpers.MyBroadcastReceiver;


public class MyFragment extends Fragment implements MyBroadcastListener {

    public static final String ACTION_TESTING = "action_testing";
    public static final String SERVICE_EXTRA = "serviceExtra";

    private MyBroadcastReceiver  myReceiver = new MyBroadcastReceiver(this);
    private IntentFilter myFilter = new IntentFilter(ACTION_TESTING);
    private Button changeTextBtn;
    private TextView testTv;

    public MyFragment() {
    }


    public static MyFragment newInstance() {
        return new MyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeTextBtn = view.findViewById(R.id.btnChangeText);
        testTv = view.findViewById(R.id.testText);
        changeTextBtn.setOnClickListener(fragView -> {
            Intent myIntent = new Intent(fragView.getContext(), MyService.class);
            myIntent.putExtra(SERVICE_EXTRA,getString(R.string.parsed_data));
            fragView.getContext().startService(myIntent);
        });
    }

    @Override
    public void updateUI(String text) {
        testTv.setText(text);
    }

    @Override
    public void onResume() {
        super.onResume();
        getContext().registerReceiver(myReceiver, myFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(myReceiver);
    }
}