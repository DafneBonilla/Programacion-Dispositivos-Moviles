package com.example.curso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.curso.SQLClasses.Usuario;

public class Comanda extends AppCompatActivity {
    private Usuario user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        this.print_user();
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
            Toast.makeText(this, "Se recibio la información de:" + this.user.getNombre(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "No se recibio información de usuario" , Toast.LENGTH_LONG).show();
        }
    }
}