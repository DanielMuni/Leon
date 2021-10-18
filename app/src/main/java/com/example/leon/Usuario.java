package com.example.leon;

public class Usuario {
    private static int puntuacionMaxima = 2147483000;

    private int id;
    private String nombre;
    private int puntuacion;
    private String imagenSrc;

    public Usuario(int id, String nombre, int puntuacion, String imagenSrc){
        this.setId(id);
        this.setNombre(nombre);
        this.setPuntuacion(puntuacion);
        this.setImagen(imagenSrc);
    }

    public Usuario(String nombre, int puntuacion){
        this.setNombre(nombre);
        this.setPuntuacion(puntuacion);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }

    public String getImagenSrc(){
        return imagenSrc;
    }

    public void setImagen(String imagenSrc){
        this.imagenSrc = imagenSrc;
    }

    public void aumentarPuntacion(int puntosExtras){
        if (this.puntuacion <= puntuacionMaxima)
            this.setPuntuacion(this.getPuntuacion() + puntosExtras);
    }
}
