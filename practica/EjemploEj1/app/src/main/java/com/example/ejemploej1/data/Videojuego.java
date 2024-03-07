package com.example.ejemploej1.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;

public class Videojuego {

    String id;
    String titulo;
    String desarrolladora;
    String genero;
    String anho;
    String puntuacion;


    public Videojuego(String id, String titulo, String desarrolladora, String genero, String anho, String puntuacion) {
        this.id = id;
        this.titulo = titulo;
        this.desarrolladora = desarrolladora;
        this.genero = genero;
        this.anho = anho;
        this.puntuacion = puntuacion;
    }

    @SuppressLint("Range")
    public Videojuego(Cursor cursor){
        id = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry._ID));
        titulo = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry.TITULO));
        desarrolladora = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry.DESARROLLADORA));
        genero = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry.GENERO));
        anho = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry.ANHO));
        puntuacion = cursor.getString(cursor.getColumnIndex(VideojuegoEsquema.VideojuegoEntry.PUNTUACION));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(VideojuegoEsquema.VideojuegoEntry._ID, id);
        values.put(VideojuegoEsquema.VideojuegoEntry.TITULO, titulo);
        values.put(VideojuegoEsquema.VideojuegoEntry.DESARROLLADORA, desarrolladora);
        values.put(VideojuegoEsquema.VideojuegoEntry.GENERO, genero);
        values.put(VideojuegoEsquema.VideojuegoEntry.ANHO, anho);
        values.put(VideojuegoEsquema.VideojuegoEntry.PUNTUACION, puntuacion);
        return values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }
}
