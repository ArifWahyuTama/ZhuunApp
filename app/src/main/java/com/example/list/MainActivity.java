package com.example.list;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    EditText username, password;
    Button btnLogin, reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);
        username = (EditText) findViewById(R.id.inputUser);
        password = (EditText) findViewById(R.id.inputPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        reg = (Button) findViewById(R.id.Reg);


        btnLogin.setOnClickListener(view -> {
            String strUsername = username.getText().toString();
            String strPassword = password.getText().toString();
            boolean _login = db.checkLogin(strUsername, strPassword);
            if (_login) {
                boolean updateSession = db.upgradeSession("true", 1);
                if (updateSession) {
                    Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(MainActivity.this, Masuk.class);
                    startActivity(mainIntent);
                    finish();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Registrasi.class));
            }
        });
    }
}