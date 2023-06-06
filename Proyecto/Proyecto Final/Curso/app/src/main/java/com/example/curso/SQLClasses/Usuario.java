package com.example.curso.SQLClasses;

import java.io.Serializable;

/**
 * Clase que modela un Usuario de aplicacion.
 * Nota: Se pueden agregar atributos si lo requiere.
 * @author Erick
 * @author Daphne
 * @author Ricardo
 * @version 1.0
 */
public class Usuario implements Serializable {
    private String nombre, correo, contrasena, direccion;
    private int id;

    /**
     * Metodo constructor de clase.
     * @param id codigo del usuario.
     * @param nombre nombre del usuario.
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     * @param direccion direccion del usuario.
     */
    public Usuario(int id, String nombre, String correo, String contrasena, String direccion) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.id = id;
    }

    /**
     * Constructor de clase.
     * @param id codigo del usuario.
     * @param nombre nombre del usuario.
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     */
    public Usuario(int id, String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.id = id;
    }

    /**
     * Constructor de clase.
     * @param nombre nombre del usuario.
     * @param correo correo del usuario.
     * @param contrasena contraseña del usuario.
     */
    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    /**
     * Metodo get de atributo nombre.
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo set para atributo nombre.
     * @param nombre nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get de atributo correo.
     * @return String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo set para atributo correo.
     * @param correo correo del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo get de atributo contrasena.
     * @return String
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Metodo set para atributo contrasena.
     * @param contrasena contrasena del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Metodo get de atributo direccion.
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo set para atributo direccion.
     * @param direccion direccion del usuario.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo get de atributo id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo set para atributo id.
     * @param id codigo del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para imprimir el estado de un objeto usuario.
     * @return String
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", id=" + id +
                '}';
    }
}
