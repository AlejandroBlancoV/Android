package com.example.a014salvarestado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
static final String KEY_CONTER="Contador";
private int miContador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void contador(View view){
        miContador++;
        TextView textView= findViewById(R.id.resultado);
        textView.setText("Contador: "+ Integer.toString(miContador));
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CONTER,miContador);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        miContador=savedInstanceState.getInt(KEY_CONTER);
        TextView textView= findViewById(R.id.resultado);
        textView.setText("Contador: "+ Integer.toString(miContador));
    }
}