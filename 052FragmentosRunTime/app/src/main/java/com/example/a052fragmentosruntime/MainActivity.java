package com.example.a052fragmentosruntime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
FrameLayout frameLayout;
Button button;

FragmentOne miFragmentoUno;
FragmentDos miFragmentoDos;

int showingFragment = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.botoncito);
        button.setOnClickListener(v -> cambiaFragmento(v));
    }

    public void cambiaFragmento(View view){
    FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(showingFragment==1){
            miFragmentoDos= new FragmentDos();
            fragmentTransaction.replace(R.id.contenedorcito, miFragmentoDos);
            showingFragment=2;
        }else{
            miFragmentoUno= new FragmentOne();
            fragmentTransaction.replace(R.id.contenedorcito, miFragmentoUno);
            showingFragment=1;
        }
        fragmentTransaction.commit();

    }
}