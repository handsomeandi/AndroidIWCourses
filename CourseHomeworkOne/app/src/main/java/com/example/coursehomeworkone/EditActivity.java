package com.example.coursehomeworkone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    EditText nameEditText,surnameEditText,patronymicEditText, dateOfBirthEditText, emailEditText;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();


        saveBtn.setOnClickListener(view -> {
            if(nameEditText.getText().toString().isEmpty() || surnameEditText.getText().toString().isEmpty() || patronymicEditText.getText().toString().isEmpty()
            || dateOfBirthEditText.getText().toString().isEmpty() || emailEditText.getText().toString().isEmpty()){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show();
            }else{
                Intent returnIntent;
                try {
                    returnIntent = getReturnIntent();
                }catch (Exception e){
                    returnIntent = new Intent(this, MainActivity.class);
                    returnIntent.putExtra("errorMsg", "Error happened: " + e.getMessage());
                    setResult(RESULT_CANCELED,returnIntent);
                    finish();
                }
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    private Intent getReturnIntent(){
        Intent returnIntent = new Intent(this, MainActivity.class);
        returnIntent.putExtra("name", nameEditText.getText().toString());
        returnIntent.putExtra("surname", surnameEditText.getText().toString());
        returnIntent.putExtra("patronymic", patronymicEditText.getText().toString());
        returnIntent.putExtra("dateOfBirth", dateOfBirthEditText.getText().toString());
        returnIntent.putExtra("email", emailEditText.getText().toString());
        return returnIntent;
    }

    private void initViews(){
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        patronymicEditText = findViewById(R.id.patronymicEditText);
        dateOfBirthEditText = findViewById(R.id.dateOfBirthEditText);
        emailEditText = findViewById(R.id.emailEditText);
        saveBtn = findViewById(R.id.saveBtn);
    }
}