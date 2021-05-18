package com.example.ihm;

public class flor_planta {
    private String nombre, temperatura, humedad, familia, reino, estado;
    private int imgEstado;

    public flor_planta() {
    }

    public flor_planta(String nombre, String temperatura, String humedad, String familia, String reino, String estado, int imgEstado) {
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.familia = familia;
        this.reino = reino;
        this.estado = estado;
        this.imgEstado = imgEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getImgEstado() {
        return imgEstado;
    }

    public void setImgEstado(int imgEstado) {
        this.imgEstado = imgEstado;
    }
}
