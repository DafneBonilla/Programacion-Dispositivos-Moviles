package com.example.curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.curso.SQLClasses.ComandaSQL;
import com.example.curso.SQLClasses.Usuario;
import com.example.curso.SQLModel.ModeloComanda;
import com.example.curso.SQLModel.ModeloUsuario;


/**
 * @author Erick
 * @author Daphne
 * @author Ricardo
 * Actividad para layout 'activity_register'.
 */
public class Confirmacion extends AppCompatActivity {

    private Usuario user;
    private ComandaSQL comandaSQL;

    private ModeloUsuario model_user;
    private ModeloComanda model_comanda;

    private EditText etDireccion;
    private TextView txtSumaryOrder, txtTotalArticulos, txtTotal, txtTotalValue, txtTip;
    private Button confirmar, btnTip1, btnTip2, btnTip3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        Bundle info = getIntent().getExtras();
        int idCodigo = info.getInt("codigo");
        int idComanda = info.getInt("orden");

        this.etDireccion = (EditText) findViewById(R.id.etxt_userinfo);
        etDireccion.setText(recuperaUsuario(idCodigo));

        this.txtSumaryOrder = (TextView) findViewById(R.id.txt_summaryOrder);
        recuperaComanda(idComanda);
        txtSumaryOrder.setText(comandaSQL.getComanda());

        this.confirmar = (Button) findViewById(R.id.button_Confirmar);
        this.confirmar.setOnClickListener(v -> confirmar());

        this.txtTotalArticulos = (TextView) findViewById(R.id.txt_itemTotalV);
        txtTotalArticulos.setText("MX$" + comandaSQL.getImporte() + ".00");

        this.txtTotal = (TextView) findViewById(R.id.txt_saved);
        txtTotal.setText("MX$" + comandaSQL.getImporte() + ".00");

        this.txtTotalValue = (TextView) findViewById(R.id.txt_totalValue);
        txtTotalValue.setText("MX$" + (comandaSQL.getImporte() + 48 ) + ".00");

        this.btnTip1 = (Button) findViewById(R.id.button_tip10);
        this.btnTip2 = (Button) findViewById(R.id.button_tip20);
        this.btnTip3 = (Button) findViewById(R.id.button_tip30);
        this.txtTip = (TextView) findViewById(R.id.etxt_tipA);

        btnTip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTip.setText("MX$10.00");
                txtTotalValue.setText("MX$" + (comandaSQL.getImporte() + 48 + 10 ) + ".00");
            }
        });

        btnTip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTip.setText("MX$20.00");
                txtTotalValue.setText("MX$" + (comandaSQL.getImporte() + 48 + 20 ) + ".00");
            }
        });

        btnTip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtTip.setText("MX$30.00");
                txtTotalValue.setText("MX$" + (comandaSQL.getImporte() + 48 + 30 ) + ".00");
            }
        });



    }

    public String recuperaUsuario(int id){
        String direccion = null;
        this.model_user = new ModeloUsuario(this);
        this.user = this.model_user.select(id);
        if(user != null){
            direccion = user.getDireccion();
        }else{
            Toast.makeText(this, "Alerta: No se encontró el usuario.", Toast.LENGTH_SHORT).show();
        }
        return direccion;
    }

    public void recuperaComanda(int id){
        this.model_comanda = new ModeloComanda(this);
        this.comandaSQL = this.model_comanda.select(id);
        if(comandaSQL == null){
            Toast.makeText(this, "Alerta: No se encontró el usuario.", Toast.LENGTH_SHORT).show();
        }
      //  Toast.makeText(this, this.comandaSQL.getComanda() + "-" + this.comandaSQL.getImporte(), Toast.LENGTH_LONG).show();
    }

    public void confirmar(){
        if (this.etDireccion.getText().toString().length()>10){
            this.model_user = new ModeloUsuario(this);
            this.user.setDireccion(this.etDireccion.getText().toString());
            this.model_user.update(this.user);

            Toast.makeText(this,"Muchas gracias por tu compra, " + user.getNombre() + ". \nEl repartidor estará en unos minutos en tu domicilio.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActionBarTest.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Ingrese una dirección valida de entrega", Toast.LENGTH_LONG).show();
        }

    }
}