package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrasi extends AppCompatActivity {
    DBHelper db;
    EditText username, password;
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        db = new DBHelper(this);
        username = findViewById(R.id.inputUser);
        password = findViewById(R.id.inputPassword);
        daftar = findViewById(R.id.btnReg);
        //register

        daftar.setOnClickListener(view -> {
            String strUsername = username.getText().toString();
            String strPassword = password.getText().toString();
            Boolean daftar = db.insertUser(strUsername, strPassword);
            if (daftar) {
                Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                Intent toLogin = new Intent(Registrasi.this, MainActivity.class);
                startActivity(toLogin);
                finish();
            }
        });

    }
}