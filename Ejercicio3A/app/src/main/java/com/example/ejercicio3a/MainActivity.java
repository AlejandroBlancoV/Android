package com.example.ejercicio3a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
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

    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lstContactos);
        listView.setOnItemLongClickListener(this);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy
                .Builder().permitNetwork().build());
    }

    @SuppressLint("Range")

    public void Buscar(View v){
        EditText txtNombre= (EditText)findViewById(R.id.txtContacto);

        String proyeccion[]={
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.HAS_PHONE_NUMBER,
                ContactsContract.Contacts.PHOTO_ID
        };
        String filtro=ContactsContract.Contacts.DISPLAY_NAME + " like ?";
        String args_filtro[]={txtNombre.getText().toString()+"%"};


        List<String> lista_contactos=new ArrayList<String>();
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                proyeccion, filtro, args_filtro, null);
        if (cur.getCount() > 0) {
            while (cur.moveToNext()) {
                @SuppressLint("Range") String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                @SuppressLint("Range") String name = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cur.getString(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    lista_contactos.add(name);
                }
            }
        }
        cur.close();

        ListView l=(ListView)findViewById(R.id.lstContactos);
        l.setAdapter(new ArrayAdapter<String>(this,R.layout.fila_lista,lista_contactos));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        String nombreContacto = textView.getText().toString();

        String[] proyeccion = {ContactsContract.Contacts._ID};
        String filtro = ContactsContract.Contacts.DISPLAY_NAME + "=?";
        String[] args_filtro = {nombreContacto};

        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(
                ContactsContract.Contacts.CONTENT_URI,
                proyeccion,
                filtro,
                args_filtro,
                null
        );

        if (cur != null && cur.getCount() > 0) {
            cur.moveToFirst();
            @SuppressLint("Range") String identificador = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));


            cur.close();
            return true;
        }
        Search(view, nombreContacto);
        return false;
    }
    public void Search(View view, String nombreContacto){
        try{
            String resultado = resultadoGoogle(nombreContacto);
            Toast.makeText(this, nombreContacto + " -- " + resultado, Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

            Toast.makeText(this,"Error al conectar!!!\n", Toast.LENGTH_LONG).show();
        }
    }

    String resultadoGoogle(String palabras) throws Exception{

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
            Toast.makeText(this,"Error al conectar!!!\n", Toast.LENGTH_LONG).show();

        }
        conexion.disconnect();
        return devuelve;
    }

}