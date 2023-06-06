package com.example.curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login, register;

   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.login = (Button) findViewById(R.id.button_login);
        this.register = (Button) findViewById(R.id.button_register);
    }

    public void redirectLogin(View v){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void redirectRegister(View v){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}