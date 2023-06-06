package com.example.curso;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Button;
import android.content.Intent;

import com.example.curso.SQLClasses.ComandaSQL;
import com.example.curso.SQLClasses.Usuario;
import com.example.curso.SQLModel.ModeloComanda;

import android.support.v7.app.AppCompatActivity;

public class Comanda extends AppCompatActivity {
    private Usuario user;
    private ComandaSQL comandaSQL;
    private ModeloComanda modeloComanda;
    private Button ordenar;
    private Spinner spinnerPizzaItaliana, spinnerPizzaSalami, spinnerPizzaVegetariana;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        spinnerPizzaItaliana = findViewById(R.id.cantidad_PizzaItaliana);
        spinnerPizzaSalami = findViewById(R.id.cantidad_PizzaSalami);
        spinnerPizzaVegetariana = findViewById(R.id.cantidad_PizzaVegetariana);

        this.print_user();
        this.ordenar = (Button) findViewById(R.id.button);
    }

    /**
     * Método que da función al botón ordenar.
     * @param v vista del botón.
     */
    public void redirectConfirma(View v){
        if (this.user == null){
            Toast.makeText(this, "No se puede procesar una orden sin un usuario. Inicia sesión o regístrate para continuar", Toast.LENGTH_LONG).show();
        } else {
            if (ordenValida()) {
                this.modeloComanda = new ModeloComanda(this);
                String desComanda = concatenaComanda();
                this.comandaSQL = this.modeloComanda.insert(this.user.getId(),desComanda,calcularSumaTotalPrecios());

                //Toast.makeText(this, "extra: " + this.comandaSQL.getIdComanda(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,desComanda,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Confirmacion.class);
                intent.putExtra("codigo", this.user.getId());
                intent.putExtra("orden", this.comandaSQL.getIdComanda());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Su órden esta vacía. Por favor agregue alguna pizza a la órden.", Toast.LENGTH_LONG).show();
            }

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
         //   Toast.makeText(this, "Se recibió la información de:" + this.user.getNombre(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "No se recibió información de un usuario" , Toast.LENGTH_LONG).show();
        }
    }

    private boolean ordenValida(){
        int cantidadPizzaItaliana = Integer.parseInt(spinnerPizzaItaliana.getSelectedItem().toString());
        int cantidadPizzaSalami = Integer.parseInt(spinnerPizzaSalami.getSelectedItem().toString());
        int cantidadPizzaVegetariana = Integer.parseInt(spinnerPizzaVegetariana.getSelectedItem().toString());
        return  (cantidadPizzaVegetariana + cantidadPizzaSalami + cantidadPizzaItaliana) != 0;
    }

    private String concatenaComanda(){
        String s = "";
        int cantidadPizzaItaliana = Integer.parseInt(spinnerPizzaItaliana.getSelectedItem().toString());
        int cantidadPizzaSalami = Integer.parseInt(spinnerPizzaSalami.getSelectedItem().toString());
        int cantidadPizzaVegetariana = Integer.parseInt(spinnerPizzaVegetariana.getSelectedItem().toString());
        if (cantidadPizzaItaliana > 0)
            s+= spinnerPizzaItaliana.getSelectedItem().toString() + " Pizza Italiana $" + String.valueOf(cantidadPizzaItaliana * 250) + ",\n";
        if (cantidadPizzaSalami > 0)
            s+= spinnerPizzaSalami.getSelectedItem().toString() + " Pizza Salami $" + String.valueOf(cantidadPizzaSalami * 300) + ",\n";
        if (cantidadPizzaVegetariana > 0)
            s+= spinnerPizzaVegetariana.getSelectedItem().toString() + " Pizza Vegetariana $" + String.valueOf(cantidadPizzaVegetariana * 350) + "." ;

        return s;
    }

    private int calcularSumaTotalPrecios() {
        int cantidadPizzaItaliana = Integer.parseInt(spinnerPizzaItaliana.getSelectedItem().toString());
        int cantidadPizzaSalami = Integer.parseInt(spinnerPizzaSalami.getSelectedItem().toString());
        int cantidadPizzaVegetariana = Integer.parseInt(spinnerPizzaVegetariana.getSelectedItem().toString());
        int precioPizzaItaliana = 250;
        int precioPizzaSalami = 300;
        int precioPizzaVegetariana = 350;
        int sumaTotalPrecios = (cantidadPizzaItaliana * precioPizzaItaliana)
                             + (cantidadPizzaSalami * precioPizzaSalami)
                             + (cantidadPizzaVegetariana * precioPizzaVegetariana);
        return sumaTotalPrecios;
    }
}