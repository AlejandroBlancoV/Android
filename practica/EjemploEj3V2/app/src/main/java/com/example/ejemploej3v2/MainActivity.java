package com.example.ejemploej3v2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView listViewContactos;
    Spinner letraSpinner;
    String letraSeleccionada = null;
    String nombreUltimoContactoSeleccionado = null;
    TextView displayContactoSeleccionado;
    Button botonBuscar;
    TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewContactos = findViewById(R.id.lv_contactosLista);
        letraSpinner = findViewById(R.id.s_letraSpinner);

        String[] letras = {"Selecciona una letra", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        ArrayAdapter<String> letrasAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, letras);
        letraSpinner.setAdapter(letrasAdapter);

        letraSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String letra = letraSpinner.getSelectedItem().toString();
                letraSeleccionada = null;
                if (!letra.equals("Selecciona una letra")) {
                    letraSeleccionada = letra;
                    poblarListaContactos(letra);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Vaciar listview
                listViewContactos.setAdapter(null);
            }
        });

        listViewContactos.setOnItemLongClickListener(this);
        displayContactoSeleccionado = findViewById(R.id.tv_displaySeleccion);
        botonBuscar = findViewById(R.id.btn_buscar);
        botonBuscar.setOnClickListener(v->buscar());

        salida = findViewById(R.id.tv_resultados);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

    }

    private void poblarListaContactos(String letra) {
        // Uso de PROVIDER
        String[] proyeccion = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,
                ContactsContract.Contacts.PHOTO_ID
        };
        String filtro = ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String[] args_filtro = {letra + "%"};
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                proyeccion, filtro, args_filtro, null);

        List<String> lista_contactos = new ArrayList<>();
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                @SuppressLint("Range") String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                lista_contactos.add(name);
            }
            listViewContactos.setAdapter(new ArrayAdapter<>(this, R.layout.fila_lista, lista_contactos));
            cur.close();
        } else {
            // Vaciar listview
            listViewContactos.setAdapter(null);
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedContact = (String) parent.getItemAtPosition(position);
        nombreUltimoContactoSeleccionado = selectedContact;
        if(selectedContact == null){
            Toast.makeText(this, "Error al seleccionar contacto", Toast.LENGTH_SHORT).show();
            return false;
        }
        displayContactoSeleccionado.setText(selectedContact);
        Toast.makeText(this, "Seleccionado: "+selectedContact, Toast.LENGTH_SHORT).show();
        return true;
    }

    private void buscar(){
        if(nombreUltimoContactoSeleccionado == null){
            Toast.makeText(this, "Selecciona un contacto", Toast.LENGTH_SHORT).show();
            return;
        }
        try{
            String palabras = nombreUltimoContactoSeleccionado;
            salida.setText("BUSQUEDA DE: " + palabras + ": ");
            BuscarGoogle tareaBusqueda = new BuscarGoogle();
            tareaBusqueda.execute(palabras);
        }
        catch (Exception e){
            salida.append("Error al conectar!!!\n");
            Toast.makeText(this,"Error al conectar!!!\n", Toast.LENGTH_LONG).show();
        }


    }
    public String resultadoGoogle(String palabras) throws Exception{

        String pagina = "", devuelve = "";

        URL url = new URL("https://www.google.es/search?hl=en&q=\""
                + URLEncoder.encode(palabras,"UTF-8") + "\"");

        HttpURLConnection conexion = (HttpURLConnection)
                url.openConnection();

        //ESTAMOS INDICANDO EL BROWSER QUE VAMOS A UTILIZAR
        conexion.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0;"
                + "Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) "
                + "Chrome/88.0.4324.104 Safari/537.36");

        if (conexion.getResponseCode()==HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(conexion.getInputStream()));

            String linea = reader.readLine();
            while (linea!=null){
                pagina+=linea;
                linea=reader.readLine();
            }
            reader.close();

            int ini = pagina.indexOf("About");
            if (ini != -1){
                int fin = pagina.indexOf(" ", ini + 16);
                devuelve = pagina.substring(ini + 6, fin);
            } else {
                devuelve = "no encontrado";
            }
        } else {
            salida.append("Error: " + conexion.getResponseMessage() + "\n");
        }
        conexion.disconnect();
        return devuelve;
    }
    class BuscarGoogle extends AsyncTask<String, Void, String> {
        private ProgressDialog progreso;
        @Override
        protected void onPreExecute(){
            progreso = new ProgressDialog(MainActivity.this);
            progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progreso.setMessage("Accediendo a Google...");
            progreso.setCancelable(false);
            progreso.show();
        }
        @Override
        protected String doInBackground(String... palabras){
            try{
                return resultadoGoogle(palabras[0]);
            }
            catch (Exception e){
                cancel(true);
                Log.e("HTTP", e.getMessage(), e);
                return null;
            }
        }
        @Override
        protected void onPostExecute(String res){
            progreso.dismiss();
            salida.append(res + "\n");
        }
        @Override
        protected void onCancelled(){
            progreso.dismiss();
            salida.append("Error al conectarlo.\n");
        }
    }

}