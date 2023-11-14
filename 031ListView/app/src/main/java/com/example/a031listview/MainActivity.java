package com.example.a031listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.lista);

        @SuppressLint("ResourceType") ArrayAdapter adaptador= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,pueblaLista());

        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);
    }

    public static List<String> pueblaLista(){
        List<String> clubs= new ArrayList<>();
        clubs.add("Arenteiro");
        clubs.add("Depor");
        clubs.add("Lugo");
        clubs.add("Zelta B");
        clubs.add("Compos");
        clubs.add("Ponte");
        return clubs;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView textView= findViewById(R.id.seleccion);
        textView.setText(parent.getItemAtPosition(position).toString());
    }
}