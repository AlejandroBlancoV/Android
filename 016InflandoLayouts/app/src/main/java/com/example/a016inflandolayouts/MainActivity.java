package com.example.a016inflandolayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button izq, der;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        izq= findViewById(R.id.botonIzquierdo);
        izq.setOnClickListener(view -> clickIzquierdo(view));

    }

    public void clickIzquierdo(View view){
        setContentView(R.layout.activity_main2);
        der= findViewById(R.id.botonDerecho);
        der.setOnClickListener(v -> clickDerecho(view));

    }

    public void clickDerecho(View view){
    setContentView(R.layout.activity_main);
        izq= findViewById(R.id.botonIzquierdo);
        izq.setOnClickListener(v -> clickIzquierdo(view));
    }
}