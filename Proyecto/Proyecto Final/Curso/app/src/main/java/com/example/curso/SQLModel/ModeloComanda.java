package com.example.curso.SQLModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.curso.AdminSQL;
import com.example.curso.SQLClasses.ComandaSQL;

public class ModeloComanda {

    private final String db_name = "administer", table_comanda_name="comanda";
    private final int db_version = 1;
    private AdminSQL admin;
    private SQLiteDatabase db;
    /* Puede agregar mas queries */
    private final String query_get_comanda_id = "SELECT codigo, usuario, comanda, total FROM comanda WHERE (codigo = ?);";
    private final String query_get_ultimaComanda = "SELECT max(codigo) FROM comanda WHERE (usuario = ?);";




    /**
     * Metodo contructor de clase.
     * @param context Es el estado de la aplicación donde se requiere el objeto.
     */
    public ModeloComanda(Context context){
        this.admin = new AdminSQL(context, this.db_name,null, this.db_version);
        this.db = this.admin.getWritableDatabase();
    }

    /**
     * Metodo para insertar un nuevo registro de comanda en la base de datos.
     * Nota: Retorna true si se inserto correctamente el registro, false en otro caso.
     * @param usuario id del usuario.
     * @param descComanda descripcion de la comanda.
     * @param total monto total de la comanda
     * @return boolean
     */
    public ComandaSQL insert(int usuario, String descComanda, int total){
        try {
            ContentValues regist = new ContentValues();
            regist.put("usuario", usuario);
            regist.put("comanda", descComanda);
            regist.put("total", total);
            this.db.insert("comanda", null, regist);
            ComandaSQL comandaSQL = this.select(this.selectLast(usuario));
            if (comandaSQL != null){
                return comandaSQL;
            }
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
        }catch (Exception e){
            System.out.println("ERROR en INSERT: "+e);
            return null;
        }
        return null;
    }

    /**
     * Metodo para obtener el registro de la comanda referida con los parametros.
     * Nota: Retorna la informacion del registro como un objeto de la clase Comanda, null
     * en otro caso.
     * @param id identificador de lac omanda.
     * @return Comanda
     */
    public ComandaSQL select(int id){
        try {
            Cursor row = this.db.rawQuery(this.query_get_comanda_id, new String[]{String.valueOf(id)});
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if (row.moveToFirst()) {
                ComandaSQL comandaSQL = this.build_comanda(row);
                return comandaSQL;
            } else {
                return null;
            }
        }catch (Exception e){
            System.out.println("ERROR en SELECT: "+e);
            return null;
        }
    }

    /**
     * Metodo para obtener la última comanda registrada de un usuario particular.
     * Nota: Retorna la informacion del registro como un objeto de la clase Comanda, null
     * en otro caso.
     * @param idusuario identificador del usuario.
     * @return Comanda
     */
    public int selectLast(int idusuario){
        try {
            Cursor row = this.db.rawQuery(this.query_get_ultimaComanda, new String[]{String.valueOf(idusuario)});
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if (row.moveToFirst()) {
                int idComanda = Integer.parseInt(row.getString(0));
                return idComanda;

            } else {
                return -1;
            }
        }catch (Exception e){
            System.out.println("ERROR en SELECT: "+e);
            return -1;
        }
    }

    /**
     * Metodo que dado un cursor construye un objeto Comanda.
     * Nota: Retorna unicamente un objeto Comanda inicializado.
     * @param row Es el cursor recuperado de la tabla.
     * @return Comanda
     */
    public ComandaSQL build_comanda(Cursor row){
        int idComanda = Integer.parseInt(row.getString(0));
        int idUser = Integer.parseInt(row.getString(1));
        String comanda = row.getString(2);
        int total = Integer.parseInt(row.getString(3));
        return new ComandaSQL(idComanda, idUser, comanda, total);
    }


}
