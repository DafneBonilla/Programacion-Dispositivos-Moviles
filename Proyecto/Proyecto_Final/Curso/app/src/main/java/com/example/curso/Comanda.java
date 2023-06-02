package com.example.curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.curso.SQLClasses.Usuario;

public class Comanda extends AppCompatActivity {
    private Usuario user;
    private Button ordenar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.print_user();
        this.ordenar = (Button) findViewById(R.id.button);
    }

    public void redirectConfirma(View v){
        if (this.user == null){
            Toast.makeText(this, "No se puede procesar una orden sin un usuario. Inicia sesión o regístrate para continuar", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, Confirmacion.class);
            startActivity(intent);
        }
    }

    /**
     * Metodo que recupera el objeto usuario del intent.
     * Nota: Retorna true si se recupero un usuario valido, false en otro caso.
     * @return boolean.
     */
    public boolean catch_user(){
        this.user = (Usuario) getIntent().getSerializableExtra("user");
        if (this.user != null)
            return true;
        return false;
    }

    /**
     * Metodo para mostrar un Toast sobre el estado del usuario.
     */
    public void print_user(){
        if(this.catch_user()) {
            Toast.makeText(this, "Se recibió la información de:" + this.user.getNombre(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "No se recibió información de un usuario" , Toast.LENGTH_LONG).show();
        }
    }
}