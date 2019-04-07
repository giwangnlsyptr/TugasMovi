package com.example.movi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText etUsername, etPassword;
    Button bLogin;
    Boolean savelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.user);
        etPassword = findViewById(R.id.pass);
        bLogin = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences("username", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        savelogin=sharedPreferences.getBoolean("savelogin",true);
        if(savelogin==true) {
            Intent i = new Intent(MainActivity.this , SecondActivity.class);
            etUsername.setText(sharedPreferences.getString("username", null));
            etPassword.setText(sharedPreferences.getString("password", null));
            startActivity(i);
        }
    }
    public void login(){
        if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("12345")) {
            Toast.makeText(this, "username and password matched!", Toast.LENGTH_LONG).show();
            editor.putBoolean("savelogin",true);
            editor.putString("username", etUsername.getText().toString());
            editor.putString("password", etPassword.getText().toString());
            editor.commit();
            Intent i = new Intent(MainActivity.this , SecondActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "error", Toast.LENGTH_LONG).show();
        }
    }

}
