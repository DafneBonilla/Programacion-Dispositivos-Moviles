package com.example.curso.SQLModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.curso.AdminSQL;
import com.example.curso.SQLClasses.Usuario;

/**
 * Clase para controlar a conexion a la base de datos, así como el CRUD Usuario.
 * Nota: La conexión con la base se mantiene abierta pues al cerrarse, en algun metodo,
 * este arroja la exception:
 * 'java.lang.IllegalStateException: Cannot perform this operation because the connection pool has been closed.'
 * @author Erick
 * @version 1.0
 */
public class ModeloUsuario {
    private final String db_name = "administer", table_user_name="usuario";
    private final int db_version = 1;
    private AdminSQL admin;
    private SQLiteDatabase db;
    /* Puede agregar mas queries */
    private final String query_get_user = "SELECT codigo, nombre, correo, contrasena, direccion FROM usuario WHERE (correo = ? and contrasena = ?);";
    private final String query_get_user_id = "SELECT codigo, nombre, correo, contrasena, direccion FROM usuario WHERE (codigo = ?);";

    //private final String query_update_user_adress = "UPDATE usuario SET direccion = ? WHERE (codigo = ?);";

    /**
     * Metodo contructor de clase.
     * @param context Es el estado de la aplicación donde se requiere el objeto.
     */
    public ModeloUsuario(Context context){
        this.admin = new AdminSQL(context, this.db_name,null, this.db_version);
        this.db = this.admin.getWritableDatabase();
    }

    /**
     * Metodo para insertar un nuevo registro de usuario en la base de datos.
     * Nota: Retorna true si se inserto correctamente el registro, false en otro caso.
     * @param name nombre del usuario.
     * @param email correo del usuario.
     * @param password contraseña del usuario.
     * @return boolean
     */
    public Usuario insert(String name, String email, String password){
        try {
            ContentValues regist = new ContentValues();
            regist.put("nombre", name);
            regist.put("correo", email);
            regist.put("contrasena", password);
            this.db.insert("usuario", null, regist);
            Usuario user = this.select(email, password);
            if (user != null){
                return user;
            }
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
        }catch (Exception e){
            System.out.println("ERROR en INSERT: "+e);
            return null;
        }
        return null;
    }

    /**
     * Metodo para obtener el registro del usuario referido con los parametros.
     * Nota: Retorna la informacion del registro como un objeto de la clase Usuarios, null
     * en otro caso.
     * @param email correo del usuario.
     * @param password contraseña del usuario.
     * @return Usuario
     */
    public Usuario select(String email, String password){
        try {
            Cursor row = this.db.rawQuery(this.query_get_user, new String[]{email, password});
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if (row.moveToFirst()) {
                Usuario user = this.build_user(row);
                return user;
            } else {
                return null;
            }
        }catch (Exception e){
            System.out.println("ERROR en SELECT: "+e);
            return null;
        }
    }

    /**
     * Metodo para obtener el registro del usuario referido con el parametro.
     * Nota: Retorna la informacion del registro como un objeto de la clase Usuarios, null
     * en otro caso.
     * @param id codigo del usuario.
     * @return Usuario
     */
    public Usuario select(int id){
        try {
            Cursor row = db.rawQuery(this.query_get_user_id, new String[]{String.valueOf(id)});
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if (row.moveToFirst()) {
                Usuario user = this.build_user(row);
                return user;
            } else {
                return null;
            }
        }catch (Exception e){
            System.out.println("ERROR en SELECT: "+e);
            return null;
        }
    }

    /**
     * Metodo para eliminar el registro del usuario referido con el parametro.
     * Nota: Retorna true si la eliminacion es correcta, false en otro caso.
     * @param id codigo del usuario.
     * @return boolean
     */
    public boolean delete(int id){
        try {
            int deleted_rows = this.db.delete(this.table_user_name, "codigo=" + id, null);
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if (deleted_rows == 1) return true;
            else return false;
        }catch (Exception e){
            System.out.println("ERROR en DELETE: "+e);
            return false;
        }
    }

    /**
     * Metodo para actualizar el registro de un usuario.
     * Nota: Retorna true si la actualizacion es valida, false en otro caso.
     * @param id codigo del usuario.
     * @param name nueva nombre del usuario.
     * @param email nueva correo del usuario.
     * @param password nueva contraseña del usuario.
     * @return boolean
     */
    public boolean update(int id, String name, String email, String password, String adress){
        try {
            ContentValues regist = new ContentValues();
            regist.put("nombre", name);
            regist.put("correo", email);
            regist.put("contrasena", password);
            regist.put("direccion", adress);
            int updated_rows = this.db.update(this.table_user_name, regist, "codigo=" + id, null);
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if(updated_rows==1) return true;
            else return false;
        }catch (Exception e){
            System.out.println("ERROR en UPDATE: "+e);
            return false;
        }
    }

    /**
     * Metodo para actualizar el registro de un usuario.
     * Nota: Retorna true si la actualizacion es valida, false en otro caso.
     * @param user objeto usuario a ser acutalizado.
     * @return boolean
     */
    public boolean update(Usuario user){
        try {
            ContentValues regist = new ContentValues();
            regist.put("nombre", user.getNombre());
            regist.put("correo", user.getCorreo());
            regist.put("contrasena", user.getContrasena());
            regist.put("direccion", user.getDireccion());
            int updated_rows = this.db.update(this.table_user_name, regist, "codigo=" + user.getId(), null);
            //this.db.close(); Esta linea provoca una excepcion (java.lang.IllegalStateException)
            if(updated_rows==1) return true;
            else return false;
        }catch (Exception e){
            System.out.println("ERROR en UPDATE: "+e);
            return false;
        }
    }




    /**
     * Metodo para eliminar todos los registros de la tabla Usuario.
     * Nota: Retorna true si la eliminacion es exitosa, false en otro caso.
     * @return boolean
     */
    public boolean drop_from(){
        try{
            this.db.execSQL("DELETE FROM usuario;");
            Cursor cursor = db.query(this.table_user_name,new String[]{"codigo"}, "codigo>0"
                                    ,null,null,null,null,null);
            if(cursor.getCount()==0){
                return true;
            }
        }catch (Exception e){
            System.out.println("ERROR en DROP_FROM "+ e);
            return false;
        }
        return false;
    }

    /**
     * Metodo que dado un cursor construye un objeto Usuario.
     * Nota: Retorna unicamente un objeto Usuario inicializado.
     * @param row Es el cursor recuperado de la tabla.
     * @return Usuario
     */
    public Usuario build_user(Cursor row){
        int id_user = Integer.parseInt(row.getString(0));
        String name_user = row.getString(1);
        String email_user = row.getString(2);
        String password_user = row.getString(3);
        String adress_user = row.getString(4);
        return new Usuario(id_user, name_user, email_user, password_user, adress_user);
    }
}