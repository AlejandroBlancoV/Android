package com.example.a033gridbotones;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;

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
            b.setBackgroundColor(rgb(255,255,255));
        }
    }

        @SuppressLint("ResourceType")
        public void añadeHijos(){
            GridLayout g= (GridLayout) findViewById(R.id.rejilla);
            Button b;
            for(int i=0; i<17;i++){
                b= new Button(this);
                b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                b.setText("btn "+i);
                b.setId(View.generateViewId());
                b.setOnClickListener(this);
                g.addView(b,i);
            }
            b= new Button(this);
            b.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            b.setText("SET");
            b.setId(18);
            b.setOnClickListener(this);
            g.addView(b);
        }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        Button b= (Button) view;
        if(view.getClass().getSimpleName().equals("Button") && b.getId()!=18){
            Random r1 = new Random();
            Random r2 = new Random();
            Random r3 = new Random();
            b.setBackgroundColor(rgb(r1.nextInt(255),r2.nextInt(255),r3.nextInt(255)));
        }
        else {
            recorrer();
        }

    }
}
