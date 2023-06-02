package com.example.curso;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.curso.SQLClasses.Usuario;
import com.example.curso.SQLModel.ModeloUsuario;

/**
 * @author Erick
 * @author Daphne
 * @author Ricardo
 * Actividad para layout 'activity_login'.
 */
public class Privacy extends AppCompatActivity {

    private EditText email, password;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
    }
}