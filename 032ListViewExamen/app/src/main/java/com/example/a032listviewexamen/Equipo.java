package com.example.a032listviewexamen;

public class Equipo {
    //atributos a cargar en elemento
    private int imagen;
    private String nombre;
    private String ciudad;
    private String pais;
    private String año;

    //constructor
    public Equipo(int imagen, String nombre , String ciudad, String pais , String año){
        this.imagen = imagen;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.año = año;

    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public String getAño() {
        return año;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAño(String año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "imagen=" + imagen +
                ", nombre ='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", año='" + año + '\'' +
                '}';
    }
}
