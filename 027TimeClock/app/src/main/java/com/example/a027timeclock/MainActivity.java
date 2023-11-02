package com.example.a027timeclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity{
TextClock textClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textClock=findViewById(R.id.reloj);
        textClock.setOnClickListener(v -> pillaHora());
    }

    public void pillaHora(){
        TextView textView= findViewById(R.id.hora);
        textView.setText(textClock.getText().toString());
    }
}