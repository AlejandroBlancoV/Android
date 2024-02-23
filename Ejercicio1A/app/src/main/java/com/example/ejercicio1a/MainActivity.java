package com.example.ejercicio1a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtTitulo, txtDirector,txtPais,txtGenero,txtAno;
    ListView listaPelis;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = (EditText) findViewById(R.id.txtTitulo);
        txtDirector = (EditText) findViewById(R.id.txtDirector);
        txtPais = (EditText) findViewById(R.id.txtPais);
        txtGenero = (EditText) findViewById(R.id.txtGenero);
        txtAno = (EditText) findViewById(R.id.txtAno);
        listaPelis = (ListView) findViewById(R.id.listaDiscos);

        db = openOrCreateDatabase("MisPelis", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS misPelis(Grupo VARCHAR, Disco VARCHAR);");

        Listar();
    }

    public void Añadir(View v) {
        db.execSQL("INSERT INTO MisDiscos VALUES ('" +
                txtTitulo.getText().toString() + "', '" +
                txtDirector.getText().toString() + "') "+
                txtPais.getText().toString() + "', '" +
                txtGenero.getText().toString() + "') "+
                txtAno.getText().toString() + "', '");

        Toast.makeText(this, "Se añadió el disco " +
                        txtDirector.getText().toString(), Toast.LENGTH_LONG)
                .show();

        Listar();
    }
    public void Borrar(View v) {
        try {
            db.execSQL("DELETE FROM MisDiscos WHERE Titulo = '" +
                    txtTitulo.getText().toString() + "' AND Director= '" +
                    txtDirector.getText().toString() + "'");

            Toast.makeText(this, "Se borró la peli " +
                    txtDirector.getText().toString(), Toast.LENGTH_LONG).show();
        } catch (SQLException s) {
            Toast.makeText(this, "Error al borrar!", Toast.LENGTH_LONG).show();
        }

        Listar();
    }

    public void Listar() {
        ArrayAdapter<String> adaptador;
        List<String> lista = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM MisPelis", null);

        if (c.getCount() == 0) {
            lista.add("No hay registros");
        } else {
            while (c.moveToNext()) {
                lista.add(c.getString(0) + "-" + c.getString(1));
            }
            adaptador = new ArrayAdapter<>(
                    getApplicationContext(), R.layout.lista_fila, lista);
            listaPelis.setAdapter(adaptador);
            c.close();
        }
    }



}