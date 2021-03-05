package com.example.coursehomeworkone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helpers.IntentDataClass;

public class EditActivity extends AppCompatActivity {

    EditText nameEditText,surnameEditText,patronymicEditText, dateOfBirthEditText, emailEditText;
    Button saveBtn;


    public static final String OLD_VALUES = "oldValues";
    public static final String NEW_VALUES = "newValues";
    public static final String ERROR_MSG = "errorMsg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();

        Intent receivedIntent = getIntent();
        setViewsEditText(receivedIntent);

        saveBtn.setOnClickListener(view -> {
            if(nameEditText.getText().toString().isEmpty() || surnameEditText.getText().toString().isEmpty() || patronymicEditText.getText().toString().isEmpty()
            || dateOfBirthEditText.getText().toString().isEmpty() || emailEditText.getText().toString().isEmpty()){
                Toast.makeText(this, R.string.fillAllFields, Toast.LENGTH_SHORT).show();
            }else{
                Intent returnIntent;
                try {
                    returnIntent = getReturnIntent();
                }catch (Exception e){
                    returnIntent = new Intent(this, MainActivity.class);
                    returnIntent.putExtra(ERROR_MSG, getString(R.string.errorHappened) + e.getMessage());
                    setResult(RESULT_CANCELED,returnIntent);
                    finish();
                }
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });
    }


    private void setViewsEditText(Intent data){
        IntentDataClass receivedData = data.getParcelableExtra(OLD_VALUES);
        String nameFromIntent =  receivedData.getName();
        String surnameFromIntent = receivedData.getSurname();
        String patronymicFromIntent = receivedData.getPatronymic();
        String dateOfBirthFromIntent = receivedData.getDateOfBirth();
        String emailFromIntent = receivedData.getEmail();
        nameEditText.setText(nameFromIntent);
        surnameEditText.setText(surnameFromIntent);
        patronymicEditText.setText(patronymicFromIntent);
        dateOfBirthEditText.setText(dateOfBirthFromIntent);
        emailEditText.setText(emailFromIntent);
    }

    private Intent getReturnIntent(){
        Intent returnIntent = new Intent(this, MainActivity.class);
        IntentDataClass editedData = new IntentDataClass();
        editedData.setName(nameEditText.getText().toString());
        editedData.setSurname(surnameEditText.getText().toString());
        editedData.setPatronymic(patronymicEditText.getText().toString());
        editedData.setDateOfBirth(dateOfBirthEditText.getText().toString());
        editedData.setEmail(emailEditText.getText().toString());
        returnIntent.putExtra(NEW_VALUES, editedData);
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