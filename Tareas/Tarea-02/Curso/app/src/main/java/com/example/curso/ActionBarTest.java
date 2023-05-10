package com.example.curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

public class ActionBarTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_test);
    }
    /**
     *
     * @param menu The options menu in which you place your items.
     *
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.drawer,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id ==  R.id.registrer){
            Intent intent =  new Intent(this, Register.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.login){
            Intent intent =  new Intent(this, Login.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.menu){
            Intent intent =  new Intent(this, Comanda.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.cart){
            Intent intent =  new Intent(this, Confirmacion.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.main){
            Intent intent =  new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}