package com.example.curso.SQLClasses;

import java.io.Serializable;

/**
 * Clase que modela una comanda de aplicacion.
 * Nota: Se pueden agregar atributos si lo requiere.
 * @author Erick
 * @author Daphne
 * @author Ricardo
 * @version 1.0
 */

public class ComandaSQL implements Serializable{

    private String comanda;
    private int idComanda, idUsuario, importe;

    /**
     * Metodo constructor de clase.
     * @param idComanda codigo de la comanad.
     * @param idUsuario codigo del usuario.
     * @param comanda descripción de l comanda.
     * @param importe monto de la comanda.
     */
    public ComandaSQL(int idComanda, int idUsuario, String comanda, int importe) {
        this.idComanda = idComanda;
        this.idUsuario = idUsuario;
        this.comanda = comanda;
        this.importe = importe;
    }

    /**
     * Metodo get de atributo comanda.
     * @return String
     */
    public String getComanda() {
        return comanda;
    }

    /**
     * Metodo get de atributo idComanda.
     * @return int
     */
    public int getIdComanda() {
        return idComanda;
    }

    /**
     * Metodo get de atributo idUsuario.
     * @return int
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Metodo get de atributo importe.
     * @return int
     */
    public int getImporte() {
        return importe;
    }


    /**
     * Metodo set para atributo comanda.
     * @param comanda descripcion de la comanda.
     */
    public void setComanda(String comanda) {
        this.comanda = comanda;
    }

    /**
     * Metodo set para atributo comanda.
     * @param idComanda identificador de la comanda
     */
    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    /**
     * Metodo set para atributo comanda.
     * @param idUsuario identificador del usuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Metodo set para atributo comanda.
     * @param importe monto de la comanda
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id='" + idComanda + '\'' +
                ", user='" + idUsuario + '\'' +
                ", desc='" + comanda + '\'' +
                ", total='" + importe + '\'' +
                '}';
    }
}
