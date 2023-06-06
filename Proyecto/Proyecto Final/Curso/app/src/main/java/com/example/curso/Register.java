package com.example.curso;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
 * Actividad para layout 'activity_register'.
 */
public class Register extends AppCompatActivity {
    private EditText et_name, et_email, et_pass;
    private Button register;
    private ModeloUsuario model_user;
    private Intent i;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.et_name = (EditText) findViewById(R.id.txt_name);
        this.et_email = (EditText) findViewById(R.id.txt_email);
        this.et_pass = (EditText) findViewById(R.id.txt_password);
        this.register = (Button) findViewById(R.id.bt_continue_register);
        this.register.setOnClickListener(v -> register());
        textView=(TextView)findViewById(R.id.txt_iniciar_sesion_button);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Metodo para registrar a un usuario.
     */
    public void register(){
        this.model_user = new ModeloUsuario(this);
        System.out.println("Se limpio la base= "+this.model_user.drop_from());
        String name = this.et_name.getText().toString();
        String email = this.et_email.getText().toString();
        String pass = this.et_pass.getText().toString();
        if(this.verify_inputs(name,email,pass)){
            Usuario user = this.model_user.insert(name,email,pass);
            if(user != null){
                Toast.makeText(this,"¡Registro creado!", Toast.LENGTH_SHORT).show();
                this.redirect("user",user);
            }else{
                Toast.makeText(this,"Alerta: No pudo crear la cuenta.", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Alerta: La información ingresada es inválida.", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Metodo para redireccionar a otra activity, y enviarle un objeto Usuario.
     * @param name nombre del extra del intent.
     * @param user objeto usuario.
     */
    public void redirect(String name, Usuario user){
        this.i = new Intent(this, Comanda.class);
        this.i.putExtra(name, user);
        startActivity(this.i);
    }

    /**
     * Metodo para verificar la correctitud de los datos ingrados.
     * @param name nombre ingreasado.
     * @param email correo ingresado.
     * @param pass contraseña ingresada.
     * @return boolean.
     */
    public boolean verify_inputs(String name, String email, String pass){
        return !name.isEmpty() && (this.verify_email(email) && pass.length()>7);
    }

    /**
     * Metodo para verificar la estructura del correo.
     * No es necesario, solo es para dar realismo.
     * @param email correo ingresado.
     * @return boolean
     */
    public boolean verify_email(String email){
        return email.contains("@gmail.com") || email.contains("@ciencias.unam.mx");
    }
}