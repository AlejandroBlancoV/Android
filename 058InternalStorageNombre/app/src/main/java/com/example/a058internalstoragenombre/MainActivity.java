package com.example.a058internalstoragenombre;

import static android.provider.Telephony.Mms.Part.FILENAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    String FILENAME = "";

    EditText mEditText;
    EditText nomFich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        nomFich = findViewById(R.id.fich);
        Button buttonWrite = findViewById(R.id.buttonWrite);
        buttonWrite.setOnClickListener(view -> writeFile(view));
        Button buttonRead = findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(view -> readFile(view));

    }

    public void writeFile(View view) {
        try {
            FILENAME=nomFich.getText().toString()+".txt";
            FileOutputStream fileOutputStream = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            fileOutputStream.write(mEditText.getText().toString().getBytes());
            fileOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile(View view) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FILENAME=nomFich.getText().toString()+".txt";
            
            InputStream inputStream = openFileInput(FILENAME);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        mEditText.setText(stringBuilder);
    }
}