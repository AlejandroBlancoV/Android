package com.example.ejercicio3;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g = (GridLayout) findViewById(R.id.rejilla);
        añadeHijos();
        //recorrer();
    }

    //Sirve para resetear los botones a color blanco
    public void recorrer() {
        View v;
        GridLayout g = (GridLayout) findViewById(R.id.rejilla);
        for (int i = 0; i < g.getChildCount(); i++) {
            v = g.getChildAt(i);
            Button b= (Button)v;
            Random r= new Random();
            int n= r.nextInt(48)+1;
            b.setText("btn "+n);
        }
    }

    @SuppressLint("ResourceType")
    public void añadeHijos(){
        GridLayout g= (GridLayout) findViewById(R.id.rejilla);
        Button b;
        for(int i=0; i<19;i++){
            b= new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            Random r= new Random();
            int n= r.nextInt(48)+1;
            b.setText("btn "+n);
            b.setId(View.generateViewId());
            b.setOnClickListener(this);
            g.addView(b,i);
        }
        b= new Button(this);
        b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        b.setText("SET");
        b.setId(20);
        b.setOnClickListener(this);
        g.addView(b);
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        Button b= (Button) view;
        if(view.getClass().getSimpleName().equals("Button") && b.getId()!=20){

            b.setText("RR");
        }
        else {
            recorrer();
        }

    }
}