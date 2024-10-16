package com.example.video26.Main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpproject.R;

public class Login extends AppCompatActivity {

    TextView title, forgot_pass;
    EditText name, password;
    CheckBox checkBox;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        view_setup();

        forgot_pass.setVisibility(View.GONE);



    }

    private void view_setup() {
        title = findViewById(R.id.txt_title);
        forgot_pass = findViewById(R.id.txt_forgot_password);
        name = findViewById(R.id.edt_username);
        password = findViewById(R.id.edt_password);
        checkBox = findViewById(R.id.ch_remember);
        login = findViewById(R.id.btn_SendCode);
    }
}