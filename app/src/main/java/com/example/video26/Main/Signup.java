package com.example.video26.Main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpproject.R;

public class Signup extends AppCompatActivity {

    EditText name, family, username, password, phone, verification;
    Button action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        viewSetup();


    }

    private void viewSetup() {
        name = findViewById(R.id.edt_FirstName);
        family = findViewById(R.id.edt_Last_Name);
        username = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        phone = findViewById(R.id.edt_phoneNumber);
        verification = findViewById(R.id.edt_code);
        action = findViewById(R.id.btn_SendCode);
    }
}