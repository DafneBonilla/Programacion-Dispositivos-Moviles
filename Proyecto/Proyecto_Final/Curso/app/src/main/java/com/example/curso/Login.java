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
 * Actividad para layout 'activity_login'.
 */
public class Login extends AppCompatActivity {

    private EditText email, password;
    private Button login;
    private ModeloUsuario model_user;
    private Intent i;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.email = (EditText) findViewById(R.id.txt_email_login);
        this.password = (EditText) findViewById(R.id.txt_password_login);
        this.login = (Button) findViewById(R.id.bt_login_start);
        this.login.setOnClickListener(v -> login());
        textView=(TextView)findViewById(R.id.txt_registrarse_button);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Metodo para inciar sesion.
     */
    public void login() {
        this.model_user = new ModeloUsuario(this);
        String e = this.email.getText().toString().trim();
        String p = this.password.getText().toString().trim();
        if (this.verify_inputs(e,p)) {
            Usuario user = this.model_user.select(e,p);
            if(user != null){
                Toast.makeText(this, user.getNombre()+" ha iniciado sesión.", Toast.LENGTH_SHORT).show();
                int id = user.getId();
                //System.out.println("Se actualizo el registro="+this.model_user.update(id,"Pepe","nuevo@gmail.com", "123456789"));
                this.redirect("user", user);
                //System.out.println("Se elimino correctamente= "+this.model_user.delete(user.getId()));
            }else{
                Toast.makeText(this, "Alerta: No se encontró el usuario.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Alerta: La información ingresada es inválida.", Toast.LENGTH_SHORT).show();
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
     * @param email correo ingresado.
     * @param pass contraseña ingresada.
     * @return boolean.
     */
    public boolean verify_inputs(String email, String pass){
        return (this.verify_email(email) && pass.length()>7);
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