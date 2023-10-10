package com.example.a015persistenciadatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String KEY_COUNTER="Contador";
    static final String KEY_NAME="Nombre";
    private int miContador=0;
    TextView textView;
    EditText editText;
    String texto="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CODIGO PARA RECUPERAR UN VALOR DE UN FICHERO DE PREFERENCIAS
      //  SharedPreferences settings= getPreferences(MODE_PRIVATE);
        SharedPreferences mias= getSharedPreferences("MIFICHERO",MODE_PRIVATE);
        int defaultCounter=0;
        miContador=mias.getInt(KEY_COUNTER,defaultCounter);
        String defaultText="";
        texto=mias.getString(KEY_NAME,defaultText);
        editText= findViewById(R.id.caja);
        editText.setText(texto);
        textView= findViewById(R.id.resultado);
        textView.setText("Contador: "+Integer.toString(miContador));
    }
    public void contador(View view){
        miContador++;
        TextView textView= findViewById(R.id.resultado);
        textView.setText("Contador: "+ Integer.toString(miContador));
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNTER,miContador);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        miContador=savedInstanceState.getInt(KEY_COUNTER);
        TextView textView= findViewById(R.id.resultado);
        textView.setText("Contador: "+ Integer.toString(miContador));
    }

    //GUARDADO DE PREFERENCIAS
@Override
public void onPause(){
    super.onPause();
   // SharedPreferences settings= getPreferences(MODE_PRIVATE);
    SharedPreferences mispreferencias= getSharedPreferences("MIFICHERO", MODE_PRIVATE);
    SharedPreferences.Editor editor= mispreferencias.edit();
    editor.putInt(KEY_COUNTER,miContador);
     editText= findViewById(R.id.caja);
     texto=editText.getText().toString();
     editor.putString(KEY_NAME,texto);
    editor.commit();
    }
}