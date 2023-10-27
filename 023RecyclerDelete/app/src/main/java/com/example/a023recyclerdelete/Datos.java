package com.example.a023recyclerdelete;


import java.util.ArrayList;
import java.util.List;

public class Datos {
    String nombre;
    String descripcion;
    int imagen;

    public Datos(String n, String d, int i){
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

    public int getImagen() {
        return imagen;
    }

    public static List<Datos> poblarDatos(){
        List<Datos>lista= new ArrayList<>();

        for(int i=0;i<=16;i++) {
            int avatar= R.drawable.avatar_1;
            Datos datos= new Datos("Pais "+i,"Descripcion "+i, avatar+i);
    lista.add(datos);
        }
        return lista;
    }

}
