package com.example.coursehomeworkone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import helpers.IntentDataClass;

public class MainActivity extends AppCompatActivity {


    public static final int EDIT_ACTIVITY_CODE = 1;
    public static final String OLD_VALUES = "oldValues";
    public static final String NEW_VALUES = "newValues";
    public static final String ERROR_MSG = "errorMsg";

    TextView nameView,surnameView,patronymicView,dateOfBirthView, emailView;
    Button editBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        editBtn.setOnClickListener(view -> {
            try {
                Intent IntentResult = getIntentForResult();
                startActivityForResult(IntentResult, EDIT_ACTIVITY_CODE);
            }catch (Exception e){
                Toast.makeText(this, R.string.errorHappened + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
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
                    Toast.makeText(MainActivity.this, data.getStringExtra(ERROR_MSG), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private Intent getIntentForResult(){
        Intent IntentResult = new Intent(this, EditActivity.class);
        IntentDataClass dataIntent = new IntentDataClass();
        dataIntent.setName(nameView.getText().toString());
        dataIntent.setSurname(surnameView.getText().toString());
        dataIntent.setPatronymic(patronymicView.getText().toString());
        dataIntent.setDateOfBirth(dateOfBirthView.getText().toString());
        dataIntent.setEmail(emailView.getText().toString());
        IntentResult.putExtra(OLD_VALUES, dataIntent);
        return IntentResult;
    }

    private void setViewsText(Intent data){
        IntentDataClass receivedData = data.getParcelableExtra(NEW_VALUES);
        String nameFromIntent =  receivedData.getName();
        String surnameFromIntent = receivedData.getSurname();
        String patronymicFromIntent = receivedData.getPatronymic();
        String dateOfBirthFromIntent = receivedData.getDateOfBirth();
        String emailFromIntent = receivedData.getEmail();
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