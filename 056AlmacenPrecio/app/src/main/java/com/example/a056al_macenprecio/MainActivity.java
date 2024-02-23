package com.example.a056al_macenprecio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String NAME="name";
    private EditText mEditTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView)findViewById(R.id.leer);
        SharedPreferences sharedPreferences= getPreferences(MODE_PRIVATE);
        String name=sharedPreferences.getString(NAME,null);
        if(name!=null){
            textView.setText("Hola "+name);
        }
        else{
            textView.setText("Bienvenido de vuelta NONAME");
        }

        mEditTextName=(EditText)findViewById(R.id.escribir);
        Button button = (Button)findViewById(R.id.guardar);
        button.setOnClickListener(view -> saveName(view));

    }

    private void saveName(View view){
        SharedPreferences.Editor editor=getPreferences(MODE_PRIVATE).edit();
        editor.putString(NAME,mEditTextName.getText().toString());
        editor.commit();
    }
}