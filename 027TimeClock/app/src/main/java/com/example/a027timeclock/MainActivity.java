package com.example.a027timeclock;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;

public class MainActivity extends AppCompatActivity{
TextClock textClock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock=findViewById(R.id.reloj);
        textClock.setOnClickListener(v -> pillaHora());
        @SuppressLint({"MissingInflatedId","LocalSuppress"}) Button tonton= findViewById(R.id.boton);
        tonton.setOnClickListener(view -> tokecito());
    }

    public void pillaHora(){
        TextView textView= findViewById(R.id.hora);
        textView.setText(textClock.getText().toString());
    }

    public void tokecito(){
        EditText editText= findViewById(R.id.pon);
        String pon= editText.getText().toString();
        //Toast.makeText(this,"VER FORMATO DE HORA"+pon,Toast.LENGTH_LONG).show();
        textClock.setText(pon);
    }
}