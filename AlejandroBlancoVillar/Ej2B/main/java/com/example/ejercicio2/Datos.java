package com.example.ejercicio2;

import android.media.Image;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    String nombre;
    String capital;
    String poblacion;
    String superficie;
    int imagen;

    public Datos(String n, String c,String p, String s, int i){
        this.nombre=n;
        this.capital=c;
        this.poblacion=p;
        this.superficie=s;
        this.imagen=i;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getSuperficie() {
        return superficie;
    }

    public void setSuperficie(String superficie) {
        this.superficie = superficie;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public static List<Datos> poblarDatos(){
        List<Datos>lista= new ArrayList<>();
        Datos alemania= new Datos("Alemania","Berlin","84270625 hab","357375 km²",R.drawable.Alemania);
        Datos italia= new Datos("Italia","Roma","58870764 hab","301340 km²",R.drawable.Italia);
        Datos francia= new Datos("Francia","París","68042591 hab","675417 km²",R.drawable.Francia);
        Datos portugal= new Datos("Portugal","Lisboa","10352042 hab","92212 km²",R.drawable.Portugal);
        Datos grecia= new Datos("Grecia","Atenas","10432481 hab","131957 km²",R.drawable.Grecia);

        lista.add(alemania);
        lista.add(italia);
        lista.add(francia);
        lista.add(portugal);
        lista.add(grecia);

        return lista;
    }

}
