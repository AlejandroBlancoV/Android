package com.example.ejemploej1;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemploej1.data.Videojuego;
import com.example.ejemploej1.data.VideojuegoDBHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Videojuego> DatosVideojuego = new ArrayList<Videojuego>();
    EditText editTextTitulo, editTextDesarrolladora, editTextGenero, editTextAnho, editTextPuntuacion;
    Button botonModificar, botonBorrar, botonInsertar, botonListar;
    ListView listViewVideojuegos;
    VideojuegoDBHelper db;

    Videojuego _videojuego = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = new VideojuegoDBHelper(this);
        editTextTitulo = findViewById(R.id.titulo);
        editTextDesarrolladora = findViewById(R.id.desarrolladora);
        editTextGenero = findViewById(R.id.genero);
        editTextAnho = findViewById(R.id.anho);
        editTextPuntuacion = findViewById(R.id.puntuacion);
        listViewVideojuegos = findViewById(R.id.listView);

        botonInsertar = findViewById(R.id.botonInsertar);
        botonModificar = findViewById(R.id.botonModificar);
        botonBorrar = findViewById(R.id.botonBorrar);
        botonListar = findViewById(R.id.botonListar);

        botonInsertar.setOnClickListener(v -> insertar());
        botonModificar.setOnClickListener(v -> modificarVideojuego());
        botonBorrar.setOnClickListener(v -> eliminarVideojuego());
        botonListar.setOnClickListener(v -> listar());

        listViewVideojuegos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    _videojuego = DatosVideojuego.get(position);
                } catch (IndexOutOfBoundsException e) {
                    _videojuego = null;
                    Toast.makeText(MainActivity.this, "Error al seleccionar videojuego", Toast.LENGTH_SHORT).show();
                }
                if (_videojuego == null)
                    return;
                editTextTitulo.setText(_videojuego.getTitulo());
                editTextDesarrolladora.setText(_videojuego.getDesarrolladora());
                editTextGenero.setText(_videojuego.getGenero());
                editTextAnho.setText(_videojuego.getAnho());
                editTextPuntuacion.setText(_videojuego.getPuntuacion());
            }
        });
    }

    private void insertar() {
        Videojuego videojuego = new Videojuego(
                null,
                editTextTitulo.getText().toString(),
                editTextDesarrolladora.getText().toString(),
                editTextGenero.getText().toString(),
                editTextAnho.getText().toString(),
                editTextPuntuacion.getText().toString()
        );
        long id = db.guardaVideojuego(videojuego);
        if (id == -1) {
            Toast.makeText(this, "Error al insertar videojuego", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Videojuego insertado con id: " + id, Toast.LENGTH_SHORT).show();
        }
        listar();
    }

    private void modificarVideojuego() {
        if (db == null) {
            Toast.makeText(this, "Error al modificar videojuego", Toast.LENGTH_SHORT).show();
            return;
        }
        Videojuego videojuego= _videojuego;
        String id = videojuego.getId();
        Cursor c = db.getVideojuegoById(id);
        if (c.getCount() == 0) {
            Toast.makeText(this, "No se encontró el videojuego", Toast.LENGTH_SHORT).show();
            return;
        }
        Videojuego videojuegoModificado = new Videojuego(
                id,
                editTextTitulo.getText().toString(),
                editTextDesarrolladora.getText().toString(),
                editTextGenero.getText().toString(),
                editTextAnho.getText().toString(),
                editTextPuntuacion.getText().toString()
        );
        db.updateVideojuego(videojuegoModificado, id);
        _videojuego = null;
        Toast.makeText(this, "Videojuego modificado", Toast.LENGTH_SHORT).show();
        listar();


    }
    private void cargarLista() {
        DatosVideojuego.clear();
        List<Videojuego> lista = new ArrayList<Videojuego>();
        Cursor c = db.getAllVideojuegos();

        Videojuego videojuego = null;
        if (c.getCount() == 0)
            return;
        else {
            while (c.moveToNext()) {
                /*Toast.makeText(this, "id "+c.getString(0)+" series", Toast.LENGTH_SHORT).show();*/

                videojuego = new Videojuego(c.getString(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5));
                if (videojuego != null) {
                    lista.add(videojuego);
                }

            }
        }
        c.close();
        DatosVideojuego = lista;
    }

    private void listar() {
        cargarLista();
        ArrayAdapter<String> adaptador;
        List<String> lista = new ArrayList<>();

        for (Videojuego pelicula : DatosVideojuego) {
            lista.add(pelicula.getTitulo() + " - " + pelicula.getDesarrolladora() + " - " + pelicula.getGenero() + " - " + pelicula.getAnho() + " - " + pelicula.getPuntuacion());


        }

        adaptador = new ArrayAdapter<>(
                getApplicationContext(), R.layout.lista_fila, lista);
        listViewVideojuegos.setAdapter(adaptador);
    }

    private void eliminarVideojuego() {
        if (_videojuego == null) {
            Toast.makeText(this, "Selecciona un videojuego en la lista", Toast.LENGTH_SHORT).show();
            return;
        }
        Videojuego videojuego = _videojuego;
        String id = videojuego.getId();

        Cursor c = db.getVideojuegoById(id);
        if (c.getCount() == 0) {
            Toast.makeText(this, "No se encontro el videojuego " + videojuego.getTitulo(), Toast.LENGTH_SHORT).show();
            return;
        }
        db.deleteVideojuego(id);
        _videojuego = null;
        Toast.makeText(this, "Se borro el videojuego " + videojuego.getTitulo(), Toast.LENGTH_SHORT).show();
        listar();
    }


}