package com.example.a013operacionesaritmticas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static final String REQUEST_RESULT="REQUEST_RESULT";

EditText numero1;
EditText numero2;
Button boton;
TextView resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton= findViewById(R.id.boton);
        boton.setOnClickListener(view -> onClikSwitch(view));
    }
    public void onClikSwitch(View view ){
        numero1.findViewById(R.id.editTextNumber);
        String text= numero1.getText().toString();
        numero2.findViewById(R.id.editTextNumber2);
        String text2= numero2.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("n1",text);
        bundle.putString("n2",text2);

        Intent intent= new Intent(this, SecondActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK){
            resultado= findViewById(R.id.resultado);
            String texto = data.getStringExtra(REQUEST_RESULT);
            resultado.setText(texto);
        }

    }

}