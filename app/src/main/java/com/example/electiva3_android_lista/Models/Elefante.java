package com.example.electiva3_android_lista.Models;

import java.io.Serializable;

public class Elefante implements Serializable {
    public Elefante(String nombre, String descripcion, String foto,String sexo, String origen) {
        Nombre = nombre;
        Descripcion = descripcion;
        Foto = foto;
        Sexo = sexo;
        Origen = origen;
    }

    public Elefante()
    {

    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public String getSexo() {
        return Sexo;
    }

    public String getorigen() {
        return Origen;
    }

    private String Nombre;
    private String Descripcion;
    private String Foto;

    private String Sexo;
    private String Origen;

}
