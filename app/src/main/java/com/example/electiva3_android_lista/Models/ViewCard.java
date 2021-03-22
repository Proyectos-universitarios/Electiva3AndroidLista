package com.example.electiva3_android_lista.Models;

public class ViewCard {
    private String Foto;
    private String Titulo;
    private String Descripcion;

    public ViewCard(String foto, String titulo, String descripcion) {
        Foto = foto;
        Titulo = titulo;
        Descripcion = descripcion;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
