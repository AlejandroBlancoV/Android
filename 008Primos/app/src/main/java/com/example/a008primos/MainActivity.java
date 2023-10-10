package com.example.a008primos;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;
    Button mbutton;

    static final Integer[] primo = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89 , 97};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText=findViewById(R.id.numero);
        mTextView=findViewById(R.id.resultado);
        mbutton=findViewById(R.id.boton);

   /*     mbutton.setOnClickListener(view ->
                calculaPrimo(view)); */

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculaPrimo(view);
            }
        });
    }

    public void calculaPrimo(View view) {

        //recoger el numero de posicion
        Integer numero= Integer.parseInt(String.valueOf(mEditText.getText()));



        //setear el resultado
        if(numero<primo.length)
            mTextView.setText(primo[numero-1].toString());
        else
            mTextView.setText("no se puede obtener dicho nummero");

    }
}