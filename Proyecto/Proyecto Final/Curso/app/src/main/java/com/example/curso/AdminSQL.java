package com.example.curso;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQL extends SQLiteOpenHelper{

    /**
     * Constructor de clase
     * @param context 'Estado' de la aplicación al momento de crear el objeto.
     * @param name Nombre de la base de datos.
     * @param factory Es un puntero a una fila de datos.
     * @param version version de la base de datos.
     */
    public AdminSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Metodo para crear la tabla usuario en la base de datos.
     * Nota: Se pueden añadir más tablas
     * @param db Es la base de datos sobre la cual se crearan las entidades.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Podemos añadir más atributos
        db.execSQL("create table usuario(codigo INTEGER PRIMARY KEY AUTOINCREMENT, nombre text, correo text, contrasena text, direccion text)");
        db.execSQL("create table comanda(codigo INTEGER PRIMARY KEY AUTOINCREMENT, usuario INTEGER, comanda text, total INTEGER)");


    }

    /**
     * Metodo para modificar las tablas de la base de datos, similar a 'alter'.
     * @param db Base de datos.
     * @param oldVersion Última version de la base o anterior.
     * @param newVersion Nueva version de la base.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table comanda");
        db.execSQL("drop table usuario");
        onCreate(db);
    }
}
