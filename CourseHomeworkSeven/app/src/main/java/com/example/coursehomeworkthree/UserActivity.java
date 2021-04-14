package com.example.coursehomeworkthree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity {

    TextView emailText, usernameText, dateOfBirth;
    ImageView userImage;
    public static final String USER_DATA_EXTRA = "user_data_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        emailText = findViewById(R.id.emailText);
        usernameText = findViewById(R.id.usernameText);
        dateOfBirth = findViewById(R.id.dateOfBirthText);
        userImage = findViewById(R.id.userImageView);

        Intent received_intent = getIntent();
        fillData(received_intent);

    }

    private void fillData(Intent received_intent){
        if(received_intent != null){
            UserClass received_data = received_intent.getParcelableExtra(USER_DATA_EXTRA);
            emailText.setText(received_data.getEmail());
            usernameText.setText(received_data.getUsername());
            dateOfBirth.setText(received_data.getDateOfBirth());
            Picasso.get().load(received_data.getImg_url()).into(userImage);
        }
    }
}