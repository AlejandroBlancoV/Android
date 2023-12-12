package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if(getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {

            TextView textview = (TextView) findViewById(R.id.n1);
            TextView textview2 = (TextView) findViewById(R.id.n2);

            Intent intent = getIntent();
            String text = intent.getStringExtra(Intent.EXTRA_TEXT).toString();

            String[] numeros = text.split(",");
            textview.setText(numeros[0]+" ");
            textview2.setText(numeros[1]+" ");
        }
    }

    public void Calcular(View view) {
        TextView textView1 = findViewById(R.id.n1);
        TextView textView2 = findViewById(R.id.n2);

        double num1 = Double.parseDouble(textView1.getText().toString())*30.48;
        double num2 = Double.parseDouble(textView2.getText().toString())*2.54;

        double resultado = num1 + num2;

        ((TextView) findViewById(R.id.resultado)).setText(String.valueOf(resultado));
    }


    public void volver(View view) {

        double n = Double.parseDouble(((TextView) findViewById(R.id.resultado)).getText().toString());
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.REQUEST_RESULT, n);
        setResult(RESULT_OK, returnIntent);
        finish();

    }


}