package com.example.curso.SQLModel;

import android.widget.Spinner;

public class Pizza {
    private String usuario;
    private int sumaTotalPrecios;

    public Pizza(String usuario, int sumaTotalPrecios) {
        this.usuario = usuario;
        this.sumaTotalPrecios = sumaTotalPrecios;
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getSumaTotalPrecios() {
        return sumaTotalPrecios;
    }

    public void setSumaTotalPrecios(int sumaTotalPrecios) {
        this.sumaTotalPrecios = sumaTotalPrecios;
    }
}
