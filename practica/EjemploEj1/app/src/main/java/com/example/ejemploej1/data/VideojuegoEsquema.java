package com.example.ejemploej1.data;

import android.provider.BaseColumns;

public class VideojuegoEsquema {
    public abstract  class VideojuegoEntry implements BaseColumns {
        public static final String TABLE_NAME = "videojuego";

        public static final String TITULO = "titulo";
        public static final String DESARROLLADORA = "desarrolladora";
        public static final String GENERO = "genero";
        public static final String ANHO = "anho";
        public static final String PUNTUACION = "puntuacion";
    }
}
