package com.example.a013operacionesaritmticas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView textView1;
TextView textView2;
Button sumar;
Integer resSuma=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView1.findViewById(R.id.num1);
        textView2.findViewById(R.id.num2);
        Bundle llegar =  getIntent().getExtras();
        String texto1= llegar.getString("n1");
        String texto2= llegar.getString("n2");
        textView1.setText(texto1);
        textView2.setText(texto2);
resSuma=Integer.parseInt(texto1)+Integer.parseInt(texto2);
        sumar= findViewById(R.id.boton2);
        sumar.setOnClickListener(view -> sumar(view));

    }

    public void sumar(View view){
        Intent returnIntent= new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT,String.valueOf(resSuma));
        setResult(RESULT_OK,returnIntent);
        finish();

    }
}