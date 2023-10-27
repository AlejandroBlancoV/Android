package com.example.a023recyclerdelete;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Datos> list= Datos.poblarDatos();
       /* list.add("China");
        list.add("France");
        list.add("Germany");
        list.add("India");
        list.add("Russia");
        list.add("United Kingdom");
        list.add("United States");
        list.add("China");
        list.add("France");
        list.add("Germany");
        list.add("India");
        list.add("Russia");
        list.add("United Kingdom");
        list.add("United States");
        list.add("China");
        list.add("France");
        list.add("Germany");
        list.add("India");
        list.add("Russia");
        list.add("United Kingdom");
        list.add("United States");
        list.add("China");
        list.add("France");
        list.add("Germany");
        list.add("India");
        list.add("Russia");
        list.add("United Kingdom");
        list.add("United States");*/
       // @SuppressLint({"MissingInflatedId","LocalSuppress"})
        RecyclerView recyclerView= findViewById(R.id.reciclaje);
        recyclerView.setHasFixedSize(true);


        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        MiAdaptador miAdaptador= new MiAdaptador(list);
        recyclerView.setAdapter(miAdaptador);

       Button button=findViewById(R.id.boton);
        button.setOnClickListener(view -> miAdaptador.añadir());

    }


}