package com.example.a060ficherosraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editTextRaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextRaw= findViewById(R.id.editTextText);
        Button button= findViewById(R.id.leer);
        button.setOnClickListener(view -> abreFichero(view));



    }

    private void abreFichero(View view) {
        editTextRaw.setText(getText(this.getResources().openRawResource(R.raw.mitexto)));
    }

    private String getText(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;

                while ((newLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(newLine + "\n");
                }

                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

}