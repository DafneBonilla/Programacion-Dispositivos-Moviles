package com.example.curso;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Interfaz de inicio */
        // setContentView(R.layout.activity_main);
        /* Interfaz para iniciar sesión */
        //setContentView(R.layout.activity_login);
        /* Interfaz de menú */
        setContentView(R.layout.activity_menu);
        /* Interfaz de recibo */
    }


}