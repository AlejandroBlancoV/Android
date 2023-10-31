package com.example.a024radiogroup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
RadioGroup radioGroup;
CheckBox checkBox;
@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup= findViewById(R.id.pica);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> onCheckedChanged(group,checkedId));
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> onCheckedChanged(buttonView, isChecked));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //Toast.makeText(this, "Has Picado", Toast.LENGTH_SHORT).show();
        TextView t= findViewById(R.id.respuesta);
        if (R.id.boton1==checkedId){
            t.setText("El coruxo gana muxo muxo");
        } else if (R.id.boton2==checkedId) {
            t.setText("Rapido de Bouzas no gana para louzas");
        } else if (R.id.boton3==checkedId) {
            t.setText("Mouriño vete ya pedazo guarro");
        }
        else {
            t.setText("A mas dinero gastan menos ganan");
        }


    }

    public void onCheckedChanged(CompoundButton c, boolean b){
        TextView t= findViewById(R.id.respuesta);
        if(b)
            t.setText(t.getText().toString()+"\nTe gusta el futbol");
        else
            t.setText(t.getText().toString()+"\nTe gusta el futbol");

    }
}
