package com.example.ihm.Controlador;

public class PlantaConstructor {

    public String id;
    public String nombre;
    public String temperatura, humedad, familia, reino, estado, habilitado;

    public PlantaConstructor(String id, String nombre, String temperatura, String humedad, String familia, String reino, String estado, String habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.familia = familia;
        this.reino = reino;
        this.estado = estado;
        this.habilitado = habilitado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
}
