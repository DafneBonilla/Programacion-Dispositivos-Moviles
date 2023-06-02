package com.example.curso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ActionBarTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drawer);
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
        if(id ==  R.id.login_actionBar){
            Intent intent =  new Intent(this, Login.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.register_actionBar){
            Intent intent =  new Intent(this, Register.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.menu){
            Intent intent =  new Intent(this, Comanda.class);
            startActivity(intent);
            return true;
        }
        if(id ==  R.id.privacy){
            Intent intent =  new Intent(this, Privacy.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}