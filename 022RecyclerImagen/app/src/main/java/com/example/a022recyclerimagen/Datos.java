package com.example.a022recyclerimagen;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Datos {
    String nombre;
    String descripcion;
    String imagen;

    public Datos(String n, String d, String i){
        this.nombre=n;
        this.descripcion=d;
        this.imagen=i;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public static List<Datos> poblarDatos(Context applicationContext){
        List<Datos>lista= new ArrayList<>();
        String nom;
        for(int i=1;i<=16;i++) {
          nom  = "avatar_"+String.valueOf(i)+".xml";
            Datos datos= new Datos("Pais "+i,"Descripcion "+i, applicationContext.getPackageName());
            lista.add(datos);
        }
        return lista;
    }

}
