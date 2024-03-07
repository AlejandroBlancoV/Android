package com.example.ejemploej1.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VideojuegoDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Videojuegos.db";

    public VideojuegoDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + VideojuegoEsquema.VideojuegoEntry.TABLE_NAME + " ("
                + VideojuegoEsquema.VideojuegoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + VideojuegoEsquema.VideojuegoEntry.TITULO + " TEXT NOT NULL,"
                + VideojuegoEsquema.VideojuegoEntry.DESARROLLADORA + " TEXT NOT NULL,"
                + VideojuegoEsquema.VideojuegoEntry.GENERO + " TEXT NOT NULL,"
                + VideojuegoEsquema.VideojuegoEntry.ANHO + " TEXT NOT NULL,"
                +VideojuegoEsquema.VideojuegoEntry.PUNTUACION + " TEXT NOT NULL )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long guardaVideojuego(Videojuego videojuego){
        SQLiteDatabase db = getWritableDatabase();

        return db.insert(
                VideojuegoEsquema.VideojuegoEntry.TABLE_NAME,
                null,
                videojuego.toContentValues()
        );
    }

    public Cursor getAllVideojuegos(){
        return getReadableDatabase()
                .query(
                        VideojuegoEsquema.VideojuegoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );
    }

    public Cursor getVideojuegoById(String serieId) {
        Cursor c = getReadableDatabase().query(
                VideojuegoEsquema.VideojuegoEntry.TABLE_NAME,
                null,
                VideojuegoEsquema.VideojuegoEntry._ID + " LIKE ?",
                new String[]{serieId},
                null,
                null,
                null);
        return c;
    }

    public int deleteVideojuego(String videojuegoId){
        return getWritableDatabase().delete(
                VideojuegoEsquema.VideojuegoEntry.TABLE_NAME,
                VideojuegoEsquema.VideojuegoEntry._ID + " LIKE ?",
                new String[]{videojuegoId}
        );
    }

    public int updateVideojuego(Videojuego videojuego, String videojuegoId){
        return getWritableDatabase().update(
                VideojuegoEsquema.VideojuegoEntry.TABLE_NAME,
                videojuego.toContentValues(),
                VideojuegoEsquema.VideojuegoEntry._ID + " LIKE ?",
                new String[]{videojuegoId}
        );
    }
}
