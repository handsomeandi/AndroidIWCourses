package com.example.coursehomeworkone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final int EDIT_ACTIVITY_CODE = 1;

    TextView nameView,surnameView,patronymicView,dateOfBirthView, emailView;
    Button editBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        editBtn.setOnClickListener(view -> {
            startActivityForResult(new Intent(this, EditActivity.class), EDIT_ACTIVITY_CODE);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EDIT_ACTIVITY_CODE ){
            if(resultCode == RESULT_OK){
                setViewsText(data);
            }else if(resultCode == RESULT_CANCELED){
                if(data != null) {
                    Toast.makeText(MainActivity.this, data.getStringExtra("errorMsg"), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void setViewsText(Intent data){
        String nameFromIntent =  data.getStringExtra("name");
        String surnameFromIntent = data.getStringExtra("surname");
        String patronymicFromIntent = data.getStringExtra("patronymic");
        String dateOfBirthFromIntent = data.getStringExtra("dateOfBirth");
        String emailFromIntent = data.getStringExtra("email");
        nameView.setText(nameFromIntent);
        surnameView.setText(surnameFromIntent);
        patronymicView.setText(patronymicFromIntent);
        dateOfBirthView.setText(dateOfBirthFromIntent);
        emailView.setText(emailFromIntent);
    }

    private void initViews(){
        editBtn = findViewById(R.id.editBtn);
        nameView = findViewById(R.id.nameText);
        surnameView = findViewById(R.id.surnameText);
        patronymicView = findViewById(R.id.patronymicText);
        dateOfBirthView = findViewById(R.id.dateOfBirthText);
        emailView = findViewById(R.id.emailText);

    }
}